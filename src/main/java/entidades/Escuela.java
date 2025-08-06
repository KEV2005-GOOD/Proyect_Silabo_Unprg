package entidades;

import java.util.ArrayList;
import java.util.List;

public class Escuela {

    private String nombre;
    private List<Ciclo> ciclo;
    private boolean vigente;

    public Escuela() {
    }

    public Escuela(List<Ciclo> ciclo, String nombre, boolean vigente) {
        this.ciclo = ciclo;
        this.nombre = nombre;
        this.vigente = vigente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ciclo> getCiclo() {
        return ciclo;
    }

    public void setCiclo(List<Ciclo> ciclo) {
        this.ciclo = ciclo;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    
}
