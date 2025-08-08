package GUI;

import GUI.modelos.modeloComboEvidencia;
import entidades.EvaluacionesCalificadas;
import entidades.HabilidadRequerida;
import entidades.Semana;
import entidades.Unidad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class JDAgregarEvaluacion extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JDAgregarEvaluacion.class.getName());
    private static EvaluacionesCalificadas evalucionReturn;
    private static List<String> cob = new ArrayList<>();
    private static List<Unidad> unidadeslis;
    private modeloComboEvidencia modeloCombo = new modeloComboEvidencia();
    private static int podi;
    private static List<Semana> semanasDisponibles = new ArrayList<>();

    public JDAgregarEvaluacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void darleUnidades(List<Unidad> unidades) {
        this.unidadeslis = unidades;
        cargarEvaluacion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbEvidencia = new javax.swing.JComboBox<>();
        txtSigla = new javax.swing.JTextField();
        spPeso = new javax.swing.JSpinner();
        lblPeso = new javax.swing.JLabel();
        lblEvidenciaAprendizaje = new javax.swing.JLabel();
        lblSigla = new javax.swing.JLabel();
        lblCronograma = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbCronograma = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cmbEvidencia.setModel(this.modeloCombo);
        cmbEvidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEvidenciaActionPerformed(evt);
            }
        });

        txtSigla.setEditable(false);

        spPeso.setModel(new javax.swing.SpinnerNumberModel(5, 0, null, 5));

        lblPeso.setText("Peso: ");

        lblEvidenciaAprendizaje.setText("Evidencia de Aprendizaje: ");

        lblSigla.setText("Sigla:");

        lblCronograma.setText("Cronograma: ");

        jLabel4.setText("%");

        cmbCronograma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Constantemente", "Semana 1", "Semana 2", "Semana 3", "Semana 4", "Semana 5", "Semana 6", "Semana 7", "Semana 8", "Semana 9", "Semana 10", "Semana 11", "Semana 12", "Semana 13", "Semana 14", "Semana 15", "Semana 16" }));
        cmbCronograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCronogramaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(39, 39, 39)
                .addComponent(btnCancelar)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSigla)
                                .addGap(51, 51, 51)
                                .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEvidenciaAprendizaje)
                                .addGap(18, 18, 18)
                                .addComponent(cmbEvidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(80, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCronograma)
                            .addComponent(lblPeso))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spPeso)
                            .addComponent(cmbCronograma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEvidenciaAprendizaje)
                    .addComponent(cmbEvidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSigla)
                    .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeso)
                    .addComponent(spPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCronograma)
                    .addComponent(cmbCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        evalucionReturn = null;
        this.dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbEvidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEvidenciaActionPerformed
        int pos = cmbEvidencia.getSelectedIndex();
        if (pos > -1) {
            String dato;
            dato = cob.get(pos);
            cargarDatos(dato);
        }
    }//GEN-LAST:event_cmbEvidenciaActionPerformed

    private void cmbCronogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCronogramaActionPerformed
        int pos = this.cmbCronograma.getSelectedIndex();
        if (pos > -1) {
            podi = pos;
        }
    }//GEN-LAST:event_cmbCronogramaActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (validar() == true) {
            // Crear la evaluación con los datos seleccionados
            String evidenciaSeleccionada = (String) cmbEvidencia.getSelectedItem();
            if (evidenciaSeleccionada != null) {
                cargarDatos(evidenciaSeleccionada);
            }

            this.dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDAgregarEvaluacion dialog = new JDAgregarEvaluacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmbCronograma;
    private javax.swing.JComboBox<String> cmbEvidencia;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCronograma;
    private javax.swing.JLabel lblEvidenciaAprendizaje;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblSigla;
    private javax.swing.JSpinner spPeso;
    private javax.swing.JTextField txtSigla;
    // End of variables declaration//GEN-END:variables

    private void cargarEvaluacion() {
        // Limpiar listas anteriores
        cob.clear();
        semanasDisponibles.clear();

        for (Unidad unidad : unidadeslis) {
            if (unidad.getHabilidadesRequeridas() != null) {
                for (HabilidadRequerida habilidad : unidad.getHabilidadesRequeridas()) {
                    if (habilidad.getSemanas() != null) {
                        for (Semana semana : habilidad.getSemanas()) {
                            // Agregar semana a la lista si no existe ya
                            boolean semanaExiste = semanasDisponibles.stream()
                                    .anyMatch(s -> s.getNumeroSemana() == semana.getNumeroSemana());
                            if (!semanaExiste) {
                                semanasDisponibles.add(semana);
                            }

                            if (semana.getEvidenciasAprendizaje() != null) {
                                String tipo = semana.getEvidenciasAprendizaje().getTipoEvidencia();
                                if (!cob.contains(tipo)) {
                                    cob.add(tipo);
                                }
                            }
                        }
                    }
                }
            }
        }

        // Ordenar semanas por número
        semanasDisponibles.sort((s1, s2) -> Integer.compare(s1.getNumeroSemana(), s2.getNumeroSemana()));

        // Cargar combo de cronograma con semanas reales
        cargarComboCronograma();

        cmbEvidencia.setSelectedIndex(-1);
        cmbCronograma.setSelectedIndex(-1);
        modeloCombo.setNombres(cob);
    }

    private void cargarComboCronograma() {
        // Crear modelo para el combo de cronograma
        String[] opcionesCronograma = new String[semanasDisponibles.size() + 1];
        opcionesCronograma[0] = "Constantemente";

        for (int i = 0; i < semanasDisponibles.size(); i++) {
            opcionesCronograma[i + 1] = "Semana " + semanasDisponibles.get(i).getNumeroSemana();
        }

        cmbCronograma.setModel(new javax.swing.DefaultComboBoxModel<>(opcionesCronograma));
    }

    private void cargarDatos(String dato) {
        txtSigla.setText(obtenerIniciales(dato));
        if (validarDatos() == true) {
            EvaluacionesCalificadas eva = new EvaluacionesCalificadas();
            eva.setNombreEvaluacion(dato);
            eva.setSiglasEvaluacion(txtSigla.getText());
            eva.setPeso((int) spPeso.getValue());

            // Obtener cronograma seleccionado
            String cronogramaSeleccionado = (String) cmbCronograma.getSelectedItem();
            eva.setCronograma(cronogramaSeleccionado);

            evalucionReturn = eva;
        }
    }

    private boolean validar() {
        // Validar que se haya seleccionado una evidencia
        if (cmbEvidencia.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una evidencia de aprendizaje.");

            return false;
        }

        if (cmbCronograma.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(null, " \"Por favor seleccione un cronograma.");

            return false;
        }
        return true;
    }

    public String obtenerIniciales(String frase) {
        if (frase == null || frase.trim().isEmpty()) {
            return "";
        }
        String[] palabras = frase.trim().split("\\s+");
        StringBuilder iniciales = new StringBuilder();
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                iniciales.append(Character.toUpperCase(palabra.charAt(0)));
            }
        }
        return iniciales.toString();
    }

    private boolean validarDatos() {
        return true;
    }

    public static EvaluacionesCalificadas agregar() {
        return evalucionReturn;
    }

}
