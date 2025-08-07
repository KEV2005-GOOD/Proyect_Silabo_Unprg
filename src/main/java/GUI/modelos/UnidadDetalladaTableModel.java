package GUI.modelos;

import entidades.Unidad;
import entidades.HabilidadRequerida;
import entidades.Semana;
import entidades.EvidenciaAprendizaje;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UnidadDetalladaTableModel extends AbstractTableModel {

    private Unidad unidad;

    private final String[] columnas = {
        "Desempeño", "Habilidad", "Semana", "Conocimiento", "Actividad", "Evidencia", "Instrumento"
    };

    private final List<Object[]> filas = new ArrayList<>();

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
        cargarFilas();
        fireTableDataChanged();
    }

    private void cargarFilas() {
        filas.clear();
        if (unidad == null || unidad.getHabilidadesRequeridas() == null) return;

        String desempeño = unidad.getDesempeño();

        for (HabilidadRequerida habilidad : unidad.getHabilidadesRequeridas()) {
            String nombreHabilidad = habilidad.getHabilidad();

            for (int i = 0; i < habilidad.getSemanas().size(); i++) {
                Semana semana = habilidad.getSemanas().get(i);
                EvidenciaAprendizaje evidencia = semana.getEvidenciasAprendizaje();

                filas.add(new Object[]{
                    desempeño,
                    nombreHabilidad,
                    semana.getNumeroSemana(),
                    semana.getConocimiento(),
                    semana.getActividadAprendizaje(),
                    evidencia != null ? evidencia.getTipoEvidencia() + ": " + evidencia.getEvidencia() : "",
                    evidencia != null ? evidencia.getInstrumentoEvaluacion() : ""
                });

                desempeño = "";
                nombreHabilidad = "";
            }
        }
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return filas.get(rowIndex)[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void configurarRenderers(JTable tabla) {
        tabla.setRowHeight(36);
        tabla.setFillsViewportHeight(true);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.getTableHeader().setReorderingAllowed(false);

        tabla.getColumnModel().getColumn(0).setCellRenderer(new RendererAgrupado(0)); // Desempeño
        tabla.getColumnModel().getColumn(1).setCellRenderer(new RendererAgrupado(1)); // Habilidad
        tabla.getColumnModel().getColumn(5).setCellRenderer(new RendererMultilinea()); // Evidencia
    }

    private static class RendererAgrupado extends DefaultTableCellRenderer {
        private final int columna;

        public RendererAgrupado(int columna) {
            this.columna = columna;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(SwingConstants.LEFT);

            if (column == columna) {
                Object actual = table.getValueAt(row, column);
                Object anterior = row > 0 ? table.getValueAt(row - 1, column) : null;

                if (actual != null && actual.equals(anterior)) {
                    setText("");
                    c.setBackground(new Color(245, 245, 245));
                } else {
                    setText(actual.toString());
                    c.setBackground(Color.WHITE);
                }
            } else {
                c.setBackground(Color.WHITE);
            }

            return c;
        }
    }

    private static class RendererMultilinea extends JTextArea implements TableCellRenderer {

        public RendererMultilinea() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setMargin(new Insets(4, 4, 4, 4));
            setFont(new Font("SansSerif", Font.PLAIN, 12));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            setText(value != null ? value.toString().replace("\n", "\n") : "");
            setBackground(isSelected ? table.getSelectionBackground() : Color.WHITE);
            setForeground(isSelected ? table.getSelectionForeground() : Color.BLACK);
            return this;
        }
    }
}