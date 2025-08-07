package entidades;

import java.util.Date;

public class Silabo {

    private Facultad facultad;
    private DepartamentoAcademico departamento;
    private Escuela escuela;
    private Curso curso;
    private Docente docente;
    private String Semanas;
    private Date FechaInicio;
    private Date FechaFin;
    private String MetodologiaEnseñanza;
    private String actividadesAuditorias;
    private String fuentesReferenciales;
    private String semestreAcademico;

    public Silabo() {
    }

    public Silabo(Facultad facultad, DepartamentoAcademico departamento, Escuela escuela, Curso curso, Docente docente, String Semanas, Date FechaInicio, Date FechaFin, String MetodologiaEnseñanza, String actividadesAuditorias, String fuentesReferenciales, String semestreAcademico) {
        this.facultad = facultad;
        this.departamento = departamento;
        this.escuela = escuela;
        this.curso = curso;
        this.docente = docente;
        this.Semanas = Semanas;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.MetodologiaEnseñanza = MetodologiaEnseñanza;
        this.actividadesAuditorias = actividadesAuditorias;
        this.fuentesReferenciales = fuentesReferenciales;
        this.semestreAcademico = semestreAcademico;
    }

    
    
    public String getSemestreAcademico() {
        return semestreAcademico;
    }

    public void setSemestreAcademico(String semestreAcademico) {
        this.semestreAcademico = semestreAcademico;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getSemanas() {
        return Semanas;
    }

    public void setSemanas(String Semanas) {
        this.Semanas = Semanas;
    }

    public String getMetodologiaEnseñanza() {
        return MetodologiaEnseñanza;
    }

    public void setMetodologiaEnseñanza(String MetodologiaEnseñanza) {
        this.MetodologiaEnseñanza = MetodologiaEnseñanza;
    }

    public String getActividadesAuditorias() {
        return actividadesAuditorias;
    }

    public void setActividadesAuditorias(String actividadesAuditorias) {
        this.actividadesAuditorias = actividadesAuditorias;
    }

    public String getFuentesReferenciales() {
        return fuentesReferenciales;
    }

    public void setFuentesReferenciales(String fuentesReferenciales) {
        this.fuentesReferenciales = fuentesReferenciales;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public DepartamentoAcademico getDepatamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoAcademico departamento) {
        this.departamento = departamento;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

}
