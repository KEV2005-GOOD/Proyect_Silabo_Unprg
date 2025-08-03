package entidades;

import java.util.List;

public class Ciclo {

    private String Ciclo;
    private List<Curso> cursos;
    private boolean vigente;

    public Ciclo() {
    }

    public Ciclo(List<Curso> curos, String Ciclo, boolean vigente) {
        this.cursos = curos;
        this.Ciclo = Ciclo;
        this.vigente = vigente;
    }

    public String getCiclo() {
        return Ciclo;
    }

    public void setCiclo(String Ciclo) {
        this.Ciclo = Ciclo;
    }

    public List<Curso> getCuros() {
        return cursos;
    }

    public void setCuros(List<Curso> curos) {
        this.cursos = curos;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    
}
