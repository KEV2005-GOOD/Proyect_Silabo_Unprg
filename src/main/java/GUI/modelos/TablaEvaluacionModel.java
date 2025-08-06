package GUI.modelos;

import entidades.Unidad;
import entidades.HabilidadRequerida;
import entidades.Semana;
import entidades.EvidenciaAprendizaje;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaEvaluacionModel extends AbstractTableModel {

    private List<Unidad> unidades;

    private final String[] columnas = {
        "Desempeño", "Habilidad", "Evidencia de Aprendizaje", "Instrumento de Evaluación"
    };

    private final List<Object[]> filas = new ArrayList<>();

    
    public List<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidad> unidades) {
        this.unidades = unidades;
        fireTableDataChanged();
    }

    private void cargarFilas() {
        filas.clear();
        if (unidades == null) {
            return;
        }

        for (Unidad unidad : unidades) {
            String desempeño = unidad.getDesempeño();

            for (HabilidadRequerida habilidad : unidad.getHabilidadesRequeridas()) {
                String nombreHabilidad = habilidad.getHabilidad();

                for (Semana semana : habilidad.getSemanas()) {
                    EvidenciaAprendizaje evidencia = semana.getEvidenciasAprendizaje();

                    if (evidencia != null && evidencia.getEvidencia() != null) {
                        filas.add(new Object[]{
                            desempeño,
                            nombreHabilidad,
                            evidencia.getEvidencia(),
                            evidencia.getInstrumentoEvaluacion()
                        });

                        // Para simular agrupación visual
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
