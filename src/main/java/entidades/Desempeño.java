package entidades;

import java.util.List;

public class Desempeño {

    private String nombre;
    private String Desempeño;
    private Unidad unidad;

    public Desempeño() {
    }

    public Desempeño(String nombre, String Desempeño, Unidad unidad) {
        this.nombre = nombre;
        this.Desempeño = Desempeño;
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesempeño() {
        return Desempeño;
    }

    public void setDesempeño(String Desempeño) {
        this.Desempeño = Desempeño;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

}
