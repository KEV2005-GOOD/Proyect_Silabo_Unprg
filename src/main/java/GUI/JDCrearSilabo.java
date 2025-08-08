package GUI;

import GUI.modelos.DepartamentoComboModel;
import GUI.modelos.EscuelaComboModel;
import GUI.modelos.FacultadComboModel;
import Recursos.VersionesHandler;

import entidades.DepartamentoAcademico;
import entidades.Escuela;
import entidades.Facultad;
import entidades.Silabo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class JDCrearSilabo extends javax.swing.JDialog {

    private Facultad facultadSeleccionada = null;
    private List<Facultad> facultadesVigentes = null;
    private final FacultadComboModel modeloFacultad = new FacultadComboModel();

    private DepartamentoAcademico departamentoSeleccionado = null;
    private List<DepartamentoAcademico> departamentosVigentes = null;
    private final DepartamentoComboModel modeloDepartemento = new DepartamentoComboModel();

    private Escuela escuelaSelecionada = null;
    private List<Escuela> escuelaVigente = null;
    private final EscuelaComboModel modeloEscuela = new EscuelaComboModel();

    private static Silabo silabo;

    public JDCrearSilabo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarPlan();
        setLocationRelativeTo(null);
        cargarFacultades();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmbDepartamento = new javax.swing.JComboBox<>();
        cmbEscuela = new javax.swing.JComboBox<>();
        btnSiguiente = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cmbFacultad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Silabo");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel18.setText("Departamento : ");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel19.setText("Escuela: ");

        cmbDepartamento.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cmbDepartamento.setModel(this.modeloDepartemento);
        cmbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentoActionPerformed(evt);
            }
        });

        cmbEscuela.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cmbEscuela.setModel(this.modeloEscuela);
        cmbEscuela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEscuelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(33, 33, 33)
                        .addComponent(cmbDepartamento, 0, 495, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(cmbEscuela, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel17.setText("Facultad: ");

        cmbFacultad.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cmbFacultad.setModel(this.modeloFacultad);
        cmbFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(406, 406, 406)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(39, 39, 39)
                                .addComponent(cmbFacultad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.silabo = null;
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (validarDatos() == true) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void cmbFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadActionPerformed
        this.departamentoSeleccionado = null;
        this.escuelaSelecionada = null;
        this.departamentosVigentes = null;
        this.escuelaVigente = null;
        int pos = this.cmbFacultad.getSelectedIndex();
        if (pos > -1) {
            this.facultadSeleccionada = this.facultadesVigentes.get(pos);
            cargarDepartamento();
            this.cmbDepartamento.setSelectedIndex(-1);
            this.cmbEscuela.setSelectedIndex(-1);
        }

    }//GEN-LAST:event_cmbFacultadActionPerformed

    private void cmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentoActionPerformed

        this.escuelaSelecionada = null;
        this.escuelaVigente = null;
        int pos = this.cmbDepartamento.getSelectedIndex();
        if (pos > -1) {
            this.departamentoSeleccionado = this.departamentosVigentes.get(pos);
            this.cmbEscuela.setSelectedIndex(-1);
            cargarEscuelas();
        }
    }//GEN-LAST:event_cmbDepartamentoActionPerformed

    private void cmbEscuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEscuelaActionPerformed
        int pos = this.cmbEscuela.getSelectedIndex();
        if (pos > -1) {
            this.escuelaSelecionada = this.escuelaVigente.get(pos);
        }
    }//GEN-LAST:event_cmbEscuelaActionPerformed

    public static void main(String args[]) {

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDCrearSilabo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDCrearSilabo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDCrearSilabo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDCrearSilabo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDCrearSilabo dialog = new JDCrearSilabo(new javax.swing.JFrame(), true);
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

    public Silabo agregar() {
        //this.cargarDatos();// aqui vamos a cargar los datos de las universidades Facultades, departamentos y escuelas comela justto
        this.setVisible(true);
        Silabo sil = new Silabo();
        sil.setFacultad(this.facultadSeleccionada);
        sil.setDepartamento(this.departamentoSeleccionado);
        sil.setEscuela(this.escuelaSelecionada);

        this.silabo = sil;
        return this.silabo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JComboBox<String> cmbEscuela;
    private javax.swing.JComboBox<String> cmbFacultad;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables

    private void cargarFacultades() {

        this.facultadesVigentes = new ArrayList<>();
        this.facultadesVigentes.clear();

        this.facultadesVigentes.add(facultadSeleccionada);

        this.modeloFacultad.setFacultad(this.facultadesVigentes);
        this.cmbFacultad.setSelectedIndex(-1);
    }

    private void cargarDepartamento() {
        if (this.facultadSeleccionada != null) {
            this.departamentosVigentes = new ArrayList<>();
            this.departamentosVigentes.clear();
            for (DepartamentoAcademico depa : this.facultadSeleccionada.getDepartamentosAcademicos()) {
                if (depa.isVigente() == true) {
                    this.departamentosVigentes.add(depa);
                }
            }
            this.modeloDepartemento.setDepartamento(this.departamentosVigentes);
            this.cmbDepartamento.setSelectedIndex(-1);
            this.cmbEscuela.setSelectedIndex(-1);
        }
    }

    private void cargarEscuelas() {
        if (this.departamentoSeleccionado != null) {
            this.escuelaVigente = new ArrayList<>();
            this.escuelaVigente.clear();
            for (Escuela escuelas : this.departamentoSeleccionado.getEscuelas()) {
                if (escuelas.isVigente() == true) {
                    this.escuelaVigente.add(escuelas);
                }
                this.modeloEscuela.setEscuela(this.escuelaVigente);
                this.cmbEscuela.setSelectedIndex(-1);
            }

        }

    }

    private boolean validarDatos() {
        String mensaje = "Selecione";
        if (this.facultadSeleccionada == null) {
            mensaje += " la facultad";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            if (this.departamentoSeleccionado == null) {
                mensaje += " el departamento";
                JOptionPane.showMessageDialog(null, mensaje);
            } else {
                if (this.escuelaSelecionada == null) {
                    mensaje += " la escuela";
                    JOptionPane.showMessageDialog(null, mensaje);

                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private void cargarPlan() {

        try {
            File archivoXML = new File("src/main/resources/BaseDeDatosSilabo.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            VersionesHandler handler = new VersionesHandler();
            parser.parse(archivoXML, handler);
            Facultad facultad = handler.getFacultad();
            facultadSeleccionada = facultad;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
