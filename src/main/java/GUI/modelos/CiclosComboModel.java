
package GUI.modelos;

import entidades.Ciclo;
import entidades.DepartamentoAcademico;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class CiclosComboModel extends AbstractListModel<String> implements ComboBoxModel<String>  {
    private List<Ciclo> ciclo;
    private Ciclo seleccionado;

    public List<Ciclo> getCiclo() {
        return ciclo;
    }

    public void setCiclo(List<Ciclo> ciclo) {
        this.ciclo = ciclo;
    }

    public Ciclo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Ciclo seleccionado) {
        this.seleccionado = seleccionado;
    }

    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.ciclo != null) {
            cantidad = this.ciclo.size();
        }
        return cantidad;
    }

    @Override
    public String getElementAt(int index) {
        return this.ciclo.get(index).getCiclo();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if (anItem != null) {

            for (Ciclo ciclo : this.ciclo) {
                if (ciclo.getCiclo().equals(anItem.toString()) == true) {
                    this.seleccionado = ciclo;
                    return;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        String valor = "";
        if (this.seleccionado != null) {
            valor = this.seleccionado.getCiclo();
        }
        return valor;

    }
}
