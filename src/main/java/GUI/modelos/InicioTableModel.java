package GUI.modelos;

import entidades.Silabo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class InicioTableModel extends AbstractTableModel {

    private List<Silabo> silabo;
    private static final String[] columnas = {"Curso", "Fecha"};

    public List<Silabo> getSilabo() {
        return silabo;
    }

    public void setSilabo(List<Silabo> silabo) {
        this.silabo = silabo;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantidad = 0;

        if (this.silabo != null) {
            cantidad = this.silabo.size();
        }

        return cantidad;
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object valor = "";

        if (this.silabo != null) {
            switch (columnIndex) {
                case 0 ->
                    valor = this.silabo.get(rowIndex).getCurso().getNombre();
                case 1 ->
                    valor = this.silabo.get(rowIndex).getFechaInicio();
                default ->
                    throw new AssertionError();
            }
        }
        return valor;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return java.lang.String.class;

            case 1:
                return java.lang.String.class;
        }
        return super.getColumnClass(columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
