/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author renzo
 */
public class EvaluacionesCalificadas {
    private String nombreEvaluacion;
    private String siglasEvaluacion;
    private double peso;
    private String cronograma;

    public EvaluacionesCalificadas() {
    }

    public EvaluacionesCalificadas(String nombreEvaluacion, String siglasEvaluacion, double peso, String cronograma) {
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCronograma() {
        return cronograma;
    }

    public void setCronograma(String cronograma) {
        this.cronograma = cronograma;
    }
    
    
    
    
}
