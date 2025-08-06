package GUI.modelos;

import entidades.HabilidadRequerida;
import entidades.Semana;
import entidades.Unidad;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class semanaComboModel extends AbstractListModel<String> implements ComboBoxModel<String> {

    private List<Semana> semana;
    private Semana seleccionado;

    public List<Semana> getSemana() {
        return semana;
    }

    public void setSemana(List<Semana> semana) {
        this.semana = semana;
    }

    public Semana getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Semana seleccionado) {
        this.seleccionado = seleccionado;
    }



    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.semana != null) {
            cantidad = this.semana.size();
        }
        return cantidad;
    }

    @Override
    public String getElementAt(int index) {
        return String.valueOf(this.semana.get(index).getNumeroSemana());
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if (anItem != null) {

            for (Semana semana : this.semana) {
                if ((String.valueOf(semana.getNumeroSemana())).equals(anItem.toString()) == true) {
                    this.seleccionado = semana;
                    return;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        String valor = "";
        if (this.seleccionado != null) {
            valor = String.valueOf(this.seleccionado.getNumeroSemana());
        }
        return valor;

    }
}
