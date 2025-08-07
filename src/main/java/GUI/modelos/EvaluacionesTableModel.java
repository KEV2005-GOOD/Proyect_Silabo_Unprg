package GUI.modelos;

import entidades.EvaluacionesCalificadas;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;

public class EvaluacionesTableModel extends AbstractTableModel {

    private List<EvaluacionesCalificadas> calificaciones;
    private final String[] columnas = {"Evaluación", "Siglas", "Peso", "Cronograma"};

    public void setCalificaciones(List<EvaluacionesCalificadas> calificaciones) {
        this.calificaciones = calificaciones;
        fireTableDataChanged();
    }

    public List<EvaluacionesCalificadas> getCalificaciones() {
        return calificaciones;
    }

    @Override
    public int getRowCount() {
        return calificaciones != null ? calificaciones.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (calificaciones == null || rowIndex < 0 || rowIndex >= calificaciones.size()) {
            return null;
        }

        EvaluacionesCalificadas eval = calificaciones.get(rowIndex);
        if (eval == null) {
            return null;
        }

        return switch (columnIndex) {
            case 0 ->
                eval.getNombreEvaluacion();
            case 1 ->
                eval.getSiglasEvaluacion();
            case 2 ->
                eval.getPeso();
            case 3 ->
                eval.getCronograma();
            default ->
                null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0, 1, 3 ->
                String.class;
            case 2 ->
                Integer.class;
            default ->
                Object.class;
        };
    }


    public void configurarTablaVisual(JTable tabla) {
        tabla.setRowHeight(28);
        tabla.setFillsViewportHeight(true);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.getTableHeader().setReorderingAllowed(false);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        tabla.getColumnModel().getColumn(1).setCellRenderer(centrado);
        tabla.getColumnModel().getColumn(2).setCellRenderer(new RendererPeso()); 
    }

  
    private static class RendererPeso extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(SwingConstants.CENTER);

            if (value instanceof Integer peso) {
                setText(peso + " %");
                c.setForeground(peso >= 50 ? new Color(0, 128, 0) : Color.RED);
            }

            return c;
        }
    }
}
