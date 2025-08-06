package entidades;

import java.util.List;

public class HabilidadRequerida {

    private String habilidad;
    private int cantidadSemanas;
    private List<Semana> semanas;

    public HabilidadRequerida() {
    }

    public HabilidadRequerida(String habilidad, int cantidadSemanas, List<Semana> semanas) {
        this.habilidad = habilidad;
        this.cantidadSemanas = cantidadSemanas;
        this.semanas = semanas;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public int getCantidadSemanas() {
        return cantidadSemanas;
    }

    public void setCantidadSemanas(int cantidadSemanas) {
        this.cantidadSemanas = cantidadSemanas;
    }

    public List<Semana> getSemanas() {
        return semanas;
    }

    public void setSemanas(List<Semana> semanas) {
        this.semanas = semanas;
    }

}
