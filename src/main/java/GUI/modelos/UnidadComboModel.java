
package GUI.modelos;

import entidades.Unidad;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class UnidadComboModel extends AbstractListModel<String> implements ComboBoxModel<String> {

    private List<Unidad> unidad;
    private Unidad seleccionado;

    public List<Unidad> getUnidad() {
        return unidad;
    }

    public void setUnidad(List<Unidad> unidad) {
        this.unidad = unidad;
    }

    public Unidad getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Unidad seleccionado) {
        this.seleccionado = seleccionado;
    }

    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.unidad != null) {
            cantidad = this.unidad.size();
        }
        return cantidad;
    }

    @Override
    public String getElementAt(int index) {
        return this.unidad.get(index).getNombre();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if (anItem != null) {

            for (Unidad uni : this.unidad) {
                if (uni.getNombre().equals(anItem.toString()) == true) {
                    this.seleccionado = uni;
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
