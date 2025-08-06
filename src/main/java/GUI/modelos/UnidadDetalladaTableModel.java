package GUI.modelos;

import entidades.Unidad;
import entidades.HabilidadRequerida;
import entidades.Semana;
import entidades.EvidenciaAprendizaje;

import javax.swing.table.AbstractTableModel;

public class UnidadDetalladaTableModel extends AbstractTableModel {

    private Unidad unidad;

    private final String[] columnas = {
        "Desempeño", "Habilidad", "Semana", "Conocimiento", "Actividad", "Evidencia", "Instrumento"
    };

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (unidad == null || unidad.getHabilidadesRequeridas() == null) {
            return 0;
        }

        return unidad.getHabilidadesRequeridas().stream()
                .mapToInt(h -> h.getSemanas() != null ? h.getSemanas().size() : 0)
                .sum();
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
        if (unidad == null) {
            return "";
        }

        int contador = 0;
        for (HabilidadRequerida habilidad : unidad.getHabilidadesRequeridas()) {
            for (Semana semana : habilidad.getSemanas()) {
                if (contador == rowIndex) {
                    EvidenciaAprendizaje evidencia = semana.getEvidenciasAprendizaje();
                    return switch (columnIndex) {
                        case 0 ->
                            unidad.getDesempeño();
                        case 1 ->
                            habilidad.getHabilidad();
                        case 2 ->
                            semana.getNumeroSemana();
                        case 3 ->
                            semana.getConocimiento();
                        case 4 ->
                            semana.getActividadAprendizaje();
                        case 5 ->
                            evidencia != null ? evidencia.getEvidencia() : "";
                        case 6 ->
                            evidencia != null ? evidencia.getInstrumentoEvaluacion() : "";
                        default ->
                            "";
                    };
                }
                contador++;
            }
        }

        return "";
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
