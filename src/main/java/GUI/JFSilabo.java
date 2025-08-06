package GUI;

import com.mycompany.proyect_silabo_unprg.Proyect_Silabo_Unprg;
import entidades.DepartamentoAcademico;
import entidades.Docente;
import entidades.Escuela;
import entidades.Facultad;
import entidades.Silabo;
import entidades.Usuario;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFSilabo extends javax.swing.JFrame {

    private Escuela escuela = null;
    private Facultad facultad = null;
    private DepartamentoAcademico depa = null;

    private static Usuario userLogged;

    Usuario usuario;

    public JFSilabo(Usuario usuario) {
        this.userLogged = usuario;
        initComponents();
        mostrarBienvenida();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpSilabo = new javax.swing.JDesktopPane();
        pnLateral = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        lblBienvenida = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        dpSilabo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout dpSilaboLayout = new javax.swing.GroupLayout(dpSilabo);
        dpSilabo.setLayout(dpSilaboLayout);
        dpSilaboLayout.setHorizontalGroup(
            dpSilaboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        dpSilaboLayout.setVerticalGroup(
            dpSilaboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnLateral.setBackground(new java.awt.Color(0, 86, 163));

        btnInicio.setBackground(new java.awt.Color(25, 118, 210));
        btnInicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setBorderPainted(false);
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.setIconTextGap(12);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnCrear.setBackground(new java.awt.Color(25, 118, 210));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create.png"))); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.setBorderPainted(false);
        btnCrear.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCrear.setIconTextGap(12);
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnAbrir.setBackground(new java.awt.Color(25, 118, 210));
        btnAbrir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAbrir.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open.png"))); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.setBorderPainted(false);
        btnAbrir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAbrir.setIconTextGap(12);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(25, 118, 210));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        jButton1.setText("Cuenta");
        jButton1.setBorderPainted(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setIconTextGap(12);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnExportar.setBackground(new java.awt.Color(25, 118, 210));
        btnExportar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportar.setForeground(new java.awt.Color(255, 255, 255));
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/export.png"))); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.setBorderPainted(false);
        btnExportar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExportar.setIconTextGap(12);
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        lblBienvenida.setBackground(new java.awt.Color(255, 255, 255));
        lblBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBienvenida.setText("Bienvenido {grade} {fullname}");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenUsuario.png"))); // NOI18N

        javax.swing.GroupLayout pnLateralLayout = new javax.swing.GroupLayout(pnLateral);
        pnLateral.setLayout(pnLateralLayout);
        pnLateralLayout.setHorizontalGroup(
            pnLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnLateralLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(lblLogo)
                .addContainerGap(90, Short.MAX_VALUE))
            .addComponent(lblBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnLateralLayout.setVerticalGroup(
            pnLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLateralLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblLogo)
                .addGap(28, 28, 28)
                .addComponent(lblBienvenida)
                .addGap(102, 102, 102)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dpSilabo))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dpSilabo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        limpiarDesktopPane(dpSilabo);
        JIIncio frm = JIIncio.crear(this.dpSilabo);
        frm.setVisible(true);
        try {
            frm.setMaximum(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        JICrearSilabo frmCrear = null;
        JDCrearSilabo frm1 = null;
        limpiarDesktopPane(dpSilabo);
        Silabo silabo;
        if (frm1 == null) {
            frm1 = new JDCrearSilabo(null, true);
            silabo = frm1.agregar();
            if (silabo.getEscuela() != null) {
                try {
                    // Crear o reutilizar la ventana del silabo
                    frmCrear = JICrearSilabo.crear(dpSilabo, silabo, userLogged);
                } catch (IOException ex) {
                    Logger.getLogger(JFSilabo.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (frmCrear != null) {
                    frmCrear.setVisible(true);
                    try {
                        frmCrear.setMaximum(true);
                    } catch (Exception e) {
                    }
                }
            }
            frm1 = null;
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        limpiarDesktopPane(dpSilabo);
        JIExportar frm = JIExportar.crear(this.dpSilabo);
        frm.setVisible(true);
        try {
            frm.setMaximum(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarDesktopPane(dpSilabo);
        JICuenta frm = JICuenta.crear(this.dpSilabo, userLogged);
        frm.setVisible(true);
        try {
            frm.setMaximum(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        // Crear el JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Abrir archivo de sílabo XML");

        // Configurar filtro de archivo solo para XML
        FileNameExtensionFilter filtroXml = new FileNameExtensionFilter("Archivos XML (*.xml)", "xml");

        // Agregar filtro al fileChooser
        fileChooser.setFileFilter(filtroXml);
        fileChooser.setAcceptAllFileFilterUsed(false);

        // Configurar directorio inicial 
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // Mostrar el diálogo
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();

            /////////////////IMPORTANTE LEAN ESTO DOWNS////////////////////
            // Aquí puedes agregar la lógica para procesar el archivo XML
            try {
                procesarArchivoImportado(archivoSeleccionado);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Error al abrir el archivo XML: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    /////////////////IMPORTANTE LEAN ESTO DOWNS////////////////////
    /**
     * Procesa el archivo XML importado
     * @param archivo El archivo XML seleccionado por el usuario
     * @throws Exception Si hay un error al procesar el archivo
     */
    private void procesarArchivoImportado(File archivo) throws Exception {
        if (archivo == null || !archivo.exists()) {
            throw new Exception("El archivo no existe");
        }

        String nombreArchivo = archivo.getName().toLowerCase();

        // Verificar que sea un archivo XML
        if (!nombreArchivo.endsWith(".xml")) {
            throw new Exception("Solo se admiten archivos XML");
        }

        // Limpiar el desktop pane antes de cargar el nuevo contenido
        limpiarDesktopPane(dpSilabo);

        // Procesar el archivo XML
        procesarArchivoXML(archivo);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this,
                "Archivo XML cargado exitosamente: " + archivo.getName(),
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /////////////////IMPORTANTE LEAN ESTO DOWNS////////////////////
    /**
     * Procesa archivos XML
     */
    private void procesarArchivoXML(File archivo) throws Exception {
        // TODO: Implementar lógica para archivos XML
        System.out.println("Procesando archivo XML: " + archivo.getName());
        System.out.println("Ruta del archivo: " + archivo.getAbsolutePath());

        // Aquí puedes agregar tu lógica específica para procesar el XML
        // Por ejemplo:
        // - Parsear el XML
        // - Extraer datos del sílabo
        // - Crear objetos de entidades
        // - Mostrar en una ventana interna
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFSilabo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFSilabo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFSilabo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFSilabo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new JFSilabo(userLogged).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JDesktopPane dpSilabo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel pnLateral;
    // End of variables declaration//GEN-END:variables

    private void mostrarBienvenida() {
        if (userLogged != null && userLogged.getDocente() != null) {
            Docente d = userLogged.getDocente();
            String saludo = "Bienvenido " + d.getGrado() + " " + d.getApellidos();
            lblBienvenida.setText(saludo);
        } else {
            lblBienvenida.setText("Bienvenido usuario");
        }
    }

    public void limpiarDesktopPane(JDesktopPane desktopPane) {
        for (JInternalFrame frame : desktopPane.getAllFrames()) {
            try {
                frame.setClosed(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
                desktopPane.remove(frame);
            }
        }

        desktopPane.removeAll();
        desktopPane.repaint();
    }

}
