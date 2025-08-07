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

public class TablaEvaluacionModel extends AbstractTableModel {

    private List<Unidad> unidad;
    private Unidad unidadSeleccinada;

    private final String[] columnas = {
        "Desempeño", "Habilidad", "Evidencia de Aprendizaje", "Instrumento de Evaluación"
    };

    private final List<Object[]> filas = new ArrayList<>();

    public List<Unidad> getUnidad() {
        return unidad;
    }

    public void setUnidad(List<Unidad> unidad) {
        this.unidad = unidad;
        this.unidadSeleccinada = null;
        cargarFilas();
        fireTableDataChanged();
    }

    public Unidad getUnidadSeleccinada() {
        return unidadSeleccinada;
    }

    public void setUnidadSeleccinada(Unidad unidadSeleccinada) {
        this.unidadSeleccinada = unidadSeleccinada;
        this.unidad = null;
        cargarFilas();
        fireTableDataChanged();
    }

    private void cargarFilas() {
        filas.clear();
        List<Unidad> fuente = unidadSeleccinada != null ? List.of(unidadSeleccinada) : unidad;
        if (fuente == null) {
            return;
        }

        for (Unidad u : fuente) {
            String desempeño = u.getDesempeño();

            for (HabilidadRequerida habilidad : u.getHabilidadesRequeridas()) {
                String nombreHabilidad = habilidad.getHabilidad();

                for (Semana semana : habilidad.getSemanas()) {
                    EvidenciaAprendizaje evidencia = semana.getEvidenciasAprendizaje();

                    if (evidencia != null && evidencia.getEvidencia() != null) {
                        filas.add(new Object[]{
                            desempeño,
                            nombreHabilidad,
                            evidencia.getTipoEvidencia() + "\n" + evidencia.getEvidencia(),
                            evidencia.getInstrumentoEvaluacion()
                        });

                        // Para simular agrupación visual
                        desempeño = "";
                        nombreHabilidad = "";
                    }
                }
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
        tabla.getColumnModel().getColumn(2).setCellRenderer(new RendererMultilinea()); // Evidencia
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
