package Recursos;


import entidades.Ciclo;
import entidades.Curso;
import entidades.DepartamentoAcademico;
import entidades.Desempeño;
import entidades.Escuela;
import entidades.Facultad;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class VersionesHandler extends DefaultHandler {

    private Facultad facultad;
    private List<DepartamentoAcademico> departamentos = new ArrayList<>();
    private DepartamentoAcademico departamentoAuxiliar;
    private List<Escuela> escuelas = new ArrayList<>();
    private Escuela escuelaAuxiliar;
    private List<Ciclo> ciclos = new ArrayList<>();
    private Ciclo cicloAuxiliar;
    private List<Curso> cursos = new ArrayList<>();
    private Curso cursoAuxiliar;
    private List<Desempeño> desempeños = new ArrayList<>();
    private Desempeño desempeñoAuxiliar;
    private StringBuilder buffer = new StringBuilder();

 @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);

        switch (qName) {
            case "facultad":
                facultad = new Facultad();
                facultad.setVigente(Boolean.parseBoolean(attributes.getValue("vigente")));
                break;

            case "departamentoAcademico":
                departamentoAuxiliar = new DepartamentoAcademico();
                departamentoAuxiliar.setVigente(Boolean.parseBoolean(attributes.getValue("vigente")));
                break;

            case "escuela":
                escuelaAuxiliar = new Escuela();
                escuelaAuxiliar.setVigente(Boolean.parseBoolean(attributes.getValue("vigente")));
                break;

            case "ciclo":
                cicloAuxiliar = new Ciclo();
                cicloAuxiliar.setVigente(Boolean.parseBoolean(attributes.getValue("vigente")));
                break;

            case "curso":
                cursoAuxiliar = new Curso();
                cursoAuxiliar.setVigente(Boolean.parseBoolean(attributes.getValue("vigente")));
                break;

            case "desempeño":
                desempeñoAuxiliar = new Desempeño();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String texto = buffer.toString().trim();

        switch (qName) {
            case "nombre":
                if (desempeñoAuxiliar != null) {
                    desempeñoAuxiliar.setNombre(texto);
                } else if (cursoAuxiliar != null) {
                    cursoAuxiliar.setNombre(texto);
                } else if (cicloAuxiliar != null) {
                    cicloAuxiliar.setCiclo(texto);
                } else if (escuelaAuxiliar != null) {
                    escuelaAuxiliar.setNombre(texto);
                } else if (departamentoAuxiliar != null) {
                    departamentoAuxiliar.setNombre(texto);
                } else if (facultad != null) {
                    facultad.setNombre(texto);
                }
                break;

            case "abreviatura":
                facultad.setAbreviatura(texto);
                break;

            case "tipo":
                cursoAuxiliar.setTipo(texto);
                break;

            case "codigoCurso":
                cursoAuxiliar.setCodigoCurso(texto);
                break;

            case "prerrequisitos":
                cursoAuxiliar.setPrerrequisitos(texto);
                break;

            case "cicloEstudio":
                cursoAuxiliar.setCicloEstudio(Integer.parseInt(texto));
                break;

            case "creditos":
                cursoAuxiliar.setCreditos(Integer.parseInt(texto));
                break;

            case "HorasTeoricaSemanales":
                cursoAuxiliar.setHorasTeoricaSemanales(Integer.parseInt(texto));
                break;

            case "HorasPracticasSemanales":
                cursoAuxiliar.setHorasPracticasSemanales(Integer.parseInt(texto));
                break;

            case "sumilla":
                cursoAuxiliar.setSumilla(texto);
                break;

            case "competenciaProfesional":
                cursoAuxiliar.setCompetenciaProfesional(texto);
                break;

            case "capacidadDelCurso":
                cursoAuxiliar.setCapacidadDelCurso(texto);
                break;

            case "descripcion":
                if (desempeñoAuxiliar != null) {
                    desempeñoAuxiliar.setDesempeño(texto);
                }
                break;

            case "desempeño":
                desempeños.add(desempeñoAuxiliar);
                desempeñoAuxiliar = null;
                break;

            case "curso":
                cursoAuxiliar.setDesempeños(new ArrayList<>(desempeños));
                desempeños.clear();
                cursos.add(cursoAuxiliar);
                cursoAuxiliar = null;
                break;

            case "ciclo":
                cicloAuxiliar.setCuros(new ArrayList<>(cursos));
                cursos.clear();
                ciclos.add(cicloAuxiliar);
                cicloAuxiliar = null;
                break;

            case "escuela":
                escuelaAuxiliar.setCiclo(new ArrayList<>(ciclos));
                ciclos.clear();
                escuelas.add(escuelaAuxiliar);
                escuelaAuxiliar = null;
                break;

            case "departamentoAcademico":
                departamentoAuxiliar.setEscuelas(new ArrayList<>(escuelas));
                escuelas.clear();
                departamentos.add(departamentoAuxiliar);
                departamentoAuxiliar = null;
                break;

            case "facultad":
                facultad.setDepartamentosAcademicos(new ArrayList<>(departamentos));
                departamentos.clear();
                break;
        }

        buffer.setLength(0);
    }

    public Facultad getFacultad() {
        return facultad;
    }
}