package entidades;

import java.util.List;

public class Unidad {

    private String nombre;
    private String desempeño;
    private List<HabilidadRequerida> habilidadesRequeridas;

    public Unidad() {
    }

    public Unidad(String nombre, String desempeño, List<HabilidadRequerida> habilidadesRequeridas) {
        this.nombre = nombre;
        this.desempeño = desempeño;
        this.habilidadesRequeridas = habilidadesRequeridas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesempeño() {
        return desempeño;
    }

    public void setDesempeño(String desempeño) {
        this.desempeño = desempeño;
    }

    public List<HabilidadRequerida> getHabilidadesRequeridas() {
        return habilidadesRequeridas;
    }

    public void setHabilidadesRequeridas(List<HabilidadRequerida> habilidadesRequeridas) {
        this.habilidadesRequeridas = habilidadesRequeridas;
    }

    @Override
    public String toString() {
        return nombre; // Esto hace que el combo muestre el nombre, pero mantenga el objeto
    }

}
