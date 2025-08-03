package GUI.modelos;

import entidades.Unidad;
import entidades.HabilidadRequerida;
import entidades.Semana;
import entidades.EvidenciaAprendizaje;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.stream.Collectors;

public class UnidadTableModel extends AbstractTableModel {

    private List<Unidad> unidades;
    private final String[] columnas = {
        "Desempeño",
        "Habilidades",
        "Semanas",
        "Conocimientos",
        "Actividades",
        "Evidencia"
    };

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidad> unidades) {
        this.unidades = unidades;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return unidades != null ? unidades.size() : 0;
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
    public Class<?> getColumnClass(int columnIndex) {
        return String.class; // Todas las columnas serán de tipo texto
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Solo la columna de desempeño será editable (por ejemplo)
        return columnIndex == 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (unidades == null) return "";

        Unidad u = unidades.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return u.getDesempeño() != null ? u.getDesempeño() : "";

            case 1:
                return u.getHabilidadesRequeridas() != null
                    ? u.getHabilidadesRequeridas().stream()
                        .map(HabilidadRequerida::getHabilidad)
                        .collect(Collectors.joining("; "))
                    : "";

            case 2:
                return u.getHabilidadesRequeridas() != null
                    ? u.getHabilidadesRequeridas().stream()
                        .flatMap(h -> h.getSemanas().stream())
                        .map(Semana::getNumeroSemana)
                        .map(Object::toString)
                        .distinct()
                        .collect(Collectors.joining(", "))
                    : "";

            case 3:
                return u.getHabilidadesRequeridas() != null
                    ? u.getHabilidadesRequeridas().stream()
                        .flatMap(h -> h.getSemanas().stream())
                        .map(Semana::getConocimiento)
                        .collect(Collectors.joining("; "))
                    : "";

            case 4:
                return u.getHabilidadesRequeridas() != null
                    ? u.getHabilidadesRequeridas().stream()
                        .flatMap(h -> h.getSemanas().stream())
                        .map(Semana::getActividadAprendizaje)
                        .collect(Collectors.joining("; "))
                    : "";

            case 5:
                return u.getHabilidadesRequeridas() != null
                    ? u.getHabilidadesRequeridas().stream()
                        //.map(HabilidadRequerida::getEvidenciasAprendizaje)
                       // .filter(ev -> ev != null && ev.getEvidencia() != null)
                        //.map(EvidenciaAprendizaje::getEvidencia)
                       // .collect(Collectors.joining("; "))
                    : "";

            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue == null || unidades == null || rowIndex < 0 || rowIndex >= unidades.size()) {
            return;
        }

        Unidad unidad = unidades.get(rowIndex);
        String texto = aValue.toString().trim();

        if (columnIndex == 0) {
            unidad.setDesempeño(texto);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }
}

