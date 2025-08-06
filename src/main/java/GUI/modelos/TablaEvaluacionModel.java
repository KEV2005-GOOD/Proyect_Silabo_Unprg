package GUI.modelos;

import entidades.Unidad;
import entidades.HabilidadRequerida;
import entidades.Semana;
import entidades.EvidenciaAprendizaje;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaEvaluacionModel extends AbstractTableModel {

    private List<Unidad> unidad;
    private Unidad unidadSeleccinada;

    private final String[] columnas = {
        "Desempeño", "Habilidad", "Evidencia de Aprendizaje", "Instrumento de Evaluación"
    };

    private final List<Object[]> filas = new ArrayList<>();

    public List<Unidad> getUnidad() {
        return unidad;
    }

    public void setUnidad(List<Unidad> unidad) {
        this.unidad = unidad;
        this.unidadSeleccinada = null;
        cargarFilas();
        fireTableDataChanged();
    }

    public Unidad getUnidadSeleccinada() {
        return unidadSeleccinada;
    }

    public void setUnidadSeleccinada(Unidad unidadSeleccinada) {
        this.unidadSeleccinada = unidadSeleccinada;
        this.unidad = null;
        cargarFilas();
        fireTableDataChanged();
    }

    private void cargarFilas() {
        filas.clear();
        List<Unidad> fuente = unidadSeleccinada != null ? List.of(unidadSeleccinada) : unidad;
        if (fuente == null) {
            return;
        }

        for (Unidad u : fuente) {
            String nombreUnidad = u.getNombre();
            String desempeño = u.getDesempeño();

            for (HabilidadRequerida habilidad : u.getHabilidadesRequeridas()) {
                String nombreHabilidad = habilidad.getHabilidad();

                for (Semana semana : habilidad.getSemanas()) {
                    EvidenciaAprendizaje evidencia = semana.getEvidenciasAprendizaje();

                    if (evidencia != null && evidencia.getEvidencia() != null) {
                        filas.add(new Object[]{
                            desempeño,
                            nombreHabilidad,
                            evidencia.getTipoEvidencia()+"\n"+ evidencia.getEvidencia() ,
                            evidencia.getInstrumentoEvaluacion()
                        });

                        nombreUnidad = "";
                        desempeño = "";
                        nombreHabilidad = "";
                    }
                }
            }
        }
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return filas.get(rowIndex)[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
