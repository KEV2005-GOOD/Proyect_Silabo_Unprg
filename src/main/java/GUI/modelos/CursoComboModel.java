package GUI.modelos;

import entidades.Ciclo;
import entidades.Curso;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class CursoComboModel extends AbstractListModel<String> implements ComboBoxModel<String> {
    
        private List<Curso> Curso;
    private Curso seleccionado;

    public List<Curso> getCurso() {
        return Curso;
    }

    public void setCurso(List<Curso> Curso) {
        this.Curso = Curso;
    }

    public Curso getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Curso seleccionado) {
        this.seleccionado = seleccionado;
    }

 

    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.Curso != null) {
            cantidad = this.Curso.size();
        }
        return cantidad;
    }

    @Override
    public String getElementAt(int index) {
        return this.Curso.get(index).getNombre();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if (anItem != null) {

            for (Curso curso : this.Curso) {
                if (curso.getNombre().equals(anItem.toString()) == true) {
                    this.seleccionado = curso;
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
