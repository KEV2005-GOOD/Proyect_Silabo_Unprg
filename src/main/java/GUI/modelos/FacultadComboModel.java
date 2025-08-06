
package GUI.modelos;

import entidades.Facultad;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ADMIN
 */
public class FacultadComboModel extends AbstractListModel<String> implements ComboBoxModel<String> {

private List<Facultad> facultad;
    private Facultad seleccionado;

    public List<Facultad> getFacultad() {
        return facultad;
    }

    public void setFacultad(List<Facultad> facultad) {
        this.facultad = facultad;
    }

    public Facultad getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Facultad seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.facultad != null) {
            cantidad = this.facultad.size();
        }
        return cantidad;
    }

    @Override
    public String getElementAt(int index) {
        return this.facultad.get(index).getAbreviatura();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if (anItem != null) {

            for (Facultad facul : this.facultad) {
                if (facul.getAbreviatura().equals(anItem.toString()) == true) {
                    this.seleccionado = facul;
                    return;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        String valor = "";
        if (this.seleccionado != null) {
            valor = this.seleccionado.getAbreviatura();
        }
        return valor;

    }

}
