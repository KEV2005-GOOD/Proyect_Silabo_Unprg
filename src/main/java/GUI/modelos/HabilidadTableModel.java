package GUI.modelos;

import entidades.EvaluacionesCalificadas;
import entidades.HabilidadRequerida;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class HabilidadTableModel extends AbstractTableModel {

    private List<HabilidadRequerida> habilidadesReque;
    private final String[] columnas = {"Habilidades Requeridas", "Cantidad de Semanas"};

    public List<HabilidadRequerida> getHabilidadesReque() {
        return habilidadesReque;
    }

    public void setHabilidadesReque(List<HabilidadRequerida> habilidadesReque) {
        this.habilidadesReque = habilidadesReque;
        this.fireTableDataChanged();
    }



    @Override
    public int getRowCount() {
        int cantidad = 0;

        if (this.habilidadesReque != null) {
            cantidad = this.habilidadesReque.size();

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

        if (this.habilidadesReque != null) {
            switch (columnIndex) {
                case 0 ->
                    valor = this.habilidadesReque.get(rowIndex).getHabilidad();
                case 1 ->
                    valor = this.habilidadesReque.get(rowIndex).getCantidadSemanas();
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
                return java.lang.Integer.class;
        }
        return super.getColumnClass(columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}


