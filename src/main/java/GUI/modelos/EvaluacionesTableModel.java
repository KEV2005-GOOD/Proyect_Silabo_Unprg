package GUI.modelos;

import entidades.Desempeño;
import entidades.EvaluacionesCalificadas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class EvaluacionesTableModel extends AbstractTableModel {

    private List<EvaluacionesCalificadas> calificaciones;
    private final String[] columnas = {"Evaluacion", "Siglas","Peso","Cronograma"};

    public List<EvaluacionesCalificadas> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<EvaluacionesCalificadas> calificaciones) {
        this.calificaciones = calificaciones;
        this.fireTableDataChanged();
    }



    @Override
    public int getRowCount() {
        int cantidad = 0;

        if (this.calificaciones != null) {
            cantidad = this.calificaciones.size();
            
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
        
        if (this.calificaciones != null) {
            switch (columnIndex) {
                case 0 ->
                    valor = this.calificaciones.get(rowIndex).getNombreEvaluacion();
                case 1 ->
                    valor = this.calificaciones.get(rowIndex).getSiglasEvaluacion();
                case 2->
                    valor=  this.calificaciones.get(rowIndex).getPeso();
                case 3-> 
                    valor=  this.calificaciones.get(rowIndex).getCronograma();
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
            case 2: 
                return java.lang.Double.class;
            case 3:
                return java.lang.String.class;
        }
        return super.getColumnClass(columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
}
