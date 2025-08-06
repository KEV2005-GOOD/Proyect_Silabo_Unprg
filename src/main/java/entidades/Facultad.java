package entidades;

import com.chm.converter.xml.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name= "facultades")
public class Facultad {

    private String nombre;
    private String abreviatura;
    private List<DepartamentoAcademico> departamentosAcademicos;
    private boolean vigente;

    public Facultad() {
    }

    public Facultad(List<DepartamentoAcademico> departamentosAcademicos, String nombre, String abreviatura, boolean vigente) {
        this.departamentosAcademicos = departamentosAcademicos;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.vigente = vigente;
    }

    public List<DepartamentoAcademico> getDepartamentosAcademicos() {
        return departamentosAcademicos;
    }

    public void setDepartamentosAcademicos(List<DepartamentoAcademico> departamentosAcademicos) {
        this.departamentosAcademicos = departamentosAcademicos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
}
