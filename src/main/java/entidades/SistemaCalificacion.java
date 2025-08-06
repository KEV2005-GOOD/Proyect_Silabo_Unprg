/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.List;

/**
 *
 * @author renzo
 */
public class SistemaCalificacion {
    private List<EvaluacionesCalificadas>  evaluaciones;

    public List<EvaluacionesCalificadas> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<EvaluacionesCalificadas> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public SistemaCalificacion(List<EvaluacionesCalificadas> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }
    
    public String getFormulaPromedioFinal(){
        String formula="";
        for (EvaluacionesCalificadas evaluacione : evaluaciones) {
            formula+=evaluacione.getSiglasEvaluacion()+evaluacione.getPeso()+"%";
        }
        return formula;
    }
    
}
