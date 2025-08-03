package GUI.modelos;

import entidades.DepartamentoAcademico;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class DepartamentoComboModel extends AbstractListModel<String> implements ComboBoxModel<String>  {

 private List<DepartamentoAcademico> departamento;
    private DepartamentoAcademico seleccionado;

    public List<DepartamentoAcademico> getDepartamento() {
        return departamento;
    }

    public void setDepartamento(List<DepartamentoAcademico> departamento) {
        this.departamento = departamento;
    }

    public DepartamentoAcademico getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(DepartamentoAcademico seleccionado) {
        this.seleccionado = seleccionado;
    }


    
    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.departamento != null) {
            cantidad = this.departamento.size();
        }
        return cantidad;
    }

    @Override
    public String getElementAt(int index) {
        return this.departamento.get(index).getNombre();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if (anItem != null) {

            for (DepartamentoAcademico facul : this.departamento) {
                if (facul.getNombre().equals(anItem.toString()) == true) {
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
            valor = this.seleccionado.getNombre();
        }
        return valor;

    }
}
