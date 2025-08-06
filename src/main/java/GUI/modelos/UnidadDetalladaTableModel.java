package GUI.modelos;

import entidades.Unidad;
import entidades.HabilidadRequerida;
import entidades.Semana;
import entidades.EvidenciaAprendizaje;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class UnidadDetalladaTableModel extends AbstractTableModel {

    private Unidad unidad;

    private final String[] columnas = {
        "Desempeño", "Habilidad", "Semana", "Conocimiento", "Actividad", "Evidencia", "Instrumento"
    };

    private final List<Object[]> filas = new ArrayList<>();

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
        cargarFilas();
        fireTableDataChanged();
    }

    private void cargarFilas() {
        filas.clear();
        if (unidad == null || unidad.getHabilidadesRequeridas() == null) {
            return;
        }

        String desempeño = unidad.getDesempeño();

        for (HabilidadRequerida habilidad : unidad.getHabilidadesRequeridas()) {
            String nombreHabilidad = habilidad.getHabilidad();

            for (int i = 0; i < habilidad.getSemanas().size(); i++) {
                Semana semana = habilidad.getSemanas().get(i);
                EvidenciaAprendizaje evidencia = semana.getEvidenciasAprendizaje();

                filas.add(new Object[]{
                    desempeño,
                    nombreHabilidad,
                    semana.getNumeroSemana(),
                    semana.getConocimiento(),
                    semana.getActividadAprendizaje(),
                    evidencia != null ? evidencia.getTipoEvidencia() + ": " + evidencia.getEvidencia() : "",
                    evidencia != null ? evidencia.getInstrumentoEvaluacion() : ""
                });

                desempeño = "";
                nombreHabilidad = "";
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
