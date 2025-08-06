
package GUI.modelos;

import entidades.DepartamentoAcademico;
import entidades.Escuela;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class EscuelaComboModel extends AbstractListModel<String> implements ComboBoxModel<String> {
    
     private List<Escuela> escuela;
    private Escuela seleccionado;

    public List<Escuela> getEscuela() {
        return escuela;
    }

    public void setEscuela(List<Escuela> escuela) {
        this.escuela = escuela;
    }

    public Escuela getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Escuela seleccionado) {
        this.seleccionado = seleccionado;
    }



    
    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.escuela != null) {
            cantidad = this.escuela.size();
        }
        return cantidad;
    }

    @Override
    public String getElementAt(int index) {
        return this.escuela.get(index).getNombre();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if (anItem != null) {

            for (Escuela escu : this.escuela) {
                if (escu.getNombre().equals(anItem.toString()) == true) {
                    this.seleccionado = escu;
                    return;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        String valor = "";
        if (this.seleccionado != null) {
            valor = this.seleccionado.getNombre();
        }
        return valor;

    }
}
