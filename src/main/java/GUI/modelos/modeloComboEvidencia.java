package GUI.modelos;


import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class modeloComboEvidencia extends AbstractListModel<String> implements ComboBoxModel<String> {

    private List<String> nombres;
    private String seleccionado;

    public List<String> getNombres() {
        return nombres;
    }

    public void setNombres(List<String> nombres) {
        this.nombres = nombres;
        // Selecciona el primer elemento por defecto si existe
        if (nombres != null && !nombres.isEmpty()) {
            this.seleccionado = nombres.get(0);
        } else {
            this.seleccionado = null;
        }
        fireContentsChanged(this, 0, getSize() - 1); // Notifica cambios al combo
    }

    public String getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(String seleccionado) {
        this.seleccionado = seleccionado;
        fireContentsChanged(this, -1, -1); // Notifica cambio de selección
    }

    @Override
    public int getSize() {
        return (nombres != null) ? nombres.size() : 0;
    }

    @Override
    public String getElementAt(int index) {
        if (nombres != null && index >= 0 && index < nombres.size()) {
            return nombres.get(index);
        }
        return null;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof String && nombres != null) {
            String itemStr = (String) anItem;
            if (nombres.contains(itemStr)) {
                this.seleccionado = itemStr;
            } else {
                this.seleccionado = null;
            }
        } else {
            this.seleccionado = null;
        }
        fireContentsChanged(this, -1, -1); // Notifica cambio de selección
    }

    @Override
    public Object getSelectedItem() {
        return seleccionado;
    }
}



