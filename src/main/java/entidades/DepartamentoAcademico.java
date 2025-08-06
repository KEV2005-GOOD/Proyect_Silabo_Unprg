package entidades;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoAcademico {

    private String nombre;
    private List<Escuela> Escuelas;
    private boolean vigente;

    public DepartamentoAcademico() {
    }

    public DepartamentoAcademico(List<Escuela> Escuelas, String nombre, boolean vigente) {
        this.Escuelas = Escuelas;
        this.nombre = nombre;
        this.vigente = vigente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Escuela> getEscuelas() {
        return Escuelas;
    }

    public void setEscuelas(List<Escuela> Escuelas) {
        this.Escuelas = Escuelas;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

   

}
