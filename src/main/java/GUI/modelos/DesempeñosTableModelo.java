package GUI.modelos;

import entidades.Desempeño;
import entidades.Unidad;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;

public class DesempeñosTableModelo extends AbstractTableModel {

    private List<Desempeño> desempeño;
    private final String[] columnas = {"Desempeño", "Nombre las Unidad"};

    public List<Desempeño> getDesempeño() {
        return desempeño;
    }

    public void setDesempeño(List<Desempeño> desempeño) {
        this.desempeño = desempeño;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantidad = 0;

        if (this.desempeño != null) {
            cantidad = this.desempeño.size();
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

        if (this.desempeño != null) {
            switch (columnIndex) {
                case 0 ->
                    valor = this.desempeño.get(rowIndex).getDesempeño();
                case 1 ->
                    valor = this.desempeño.get(rowIndex).getUnidad().getNombre();
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

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override

    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (desempeño != null && rowIndex >= 0 && rowIndex < desempeño.size()) {
            Desempeño d = desempeño.get(rowIndex);

            if (columnIndex == 1 && value instanceof String) {
                String nuevoNombre = ((String) value).trim();

                if (!nuevoNombre.isEmpty()) {

                    if (d.getUnidad() == null) {
                        d.setUnidad(new Unidad());
                    }

                    d.getUnidad().setNombre(nuevoNombre);

                    fireTableCellUpdated(rowIndex, columnIndex);

                    System.out.println("Unidad actualizada en fila " + rowIndex + ": " + nuevoNombre);
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre de unidad no puede estar vacío.");
                }
            }
        }
    }

}
