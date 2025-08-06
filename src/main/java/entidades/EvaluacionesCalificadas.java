package entidades;

public class EvaluacionesCalificadas {

    private String nombreEvaluacion;
    private String siglasEvaluacion;
    private int peso;
    private String cronograma;

    public EvaluacionesCalificadas() {
    }

    public EvaluacionesCalificadas(String nombreEvaluacion, String siglasEvaluacion, int peso, String cronograma) {
        this.nombreEvaluacion = nombreEvaluacion;
        this.siglasEvaluacion = siglasEvaluacion;
        this.peso = peso;
        this.cronograma = cronograma;
    }

    public String getNombreEvaluacion() {
        return nombreEvaluacion;
    }

    public void setNombreEvaluacion(String nombreEvaluacion) {
        this.nombreEvaluacion = nombreEvaluacion;
    }

    public String getSiglasEvaluacion() {
        return siglasEvaluacion;
    }

    public void setSiglasEvaluacion(String siglasEvaluacion) {
        this.siglasEvaluacion = siglasEvaluacion;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getCronograma() {
        return cronograma;
    }

    public void setCronograma(String cronograma) {
        this.cronograma = cronograma;
    }
}
