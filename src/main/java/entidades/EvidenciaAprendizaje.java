package entidades;

public class EvidenciaAprendizaje {

    private String tipoEvidencia;
    private String evidencia;
    private String instrumentoEvaluacion;

    public EvidenciaAprendizaje() {
    }

    public EvidenciaAprendizaje(String nombre, String tipoEvidencia, String instrumentoEvaluacion) {
        this.evidencia = nombre;
        this.tipoEvidencia = tipoEvidencia;
        this.instrumentoEvaluacion = instrumentoEvaluacion;
    }

    public String getTipoEvidencia() {
        return tipoEvidencia;
    }

    public void setTipoEvidencia(String tipoEvidencia) {
        this.tipoEvidencia = tipoEvidencia;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    public String getInstrumentoEvaluacion() {
        return instrumentoEvaluacion;
    }

    public void setInstrumentoEvaluacion(String instrumentoEvaluacion) {
        this.instrumentoEvaluacion = instrumentoEvaluacion;
    }

}
