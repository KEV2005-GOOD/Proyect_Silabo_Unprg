package GUI;

import Recursos.UsuarioServiceJAXB;
import com.mycompany.proyect_silabo_unprg.Proyect_Silabo_Unprg;
import static com.mycompany.proyect_silabo_unprg.Proyect_Silabo_Unprg.configurarCampoConPlaceholder;
import entidades.Docente;
import entidades.Usuario;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class JFDatosCompletarRegistro extends javax.swing.JFrame {

    private Usuario usuarioRecibido;
    private BufferedImage firma; // variable global en la clase del formulario

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFDatosCompletarRegistro.class.getName());

    public JFDatosCompletarRegistro(Usuario usuario) {
        initComponents();
        this.usuarioRecibido = usuario;
        configurarCampoConPlaceholder(txtDni, "Ingresa tu nombre de usuario");
        configurarCampoConPlaceholder(txtNombres, "Ingrese sus Nombres Completos");
        configurarCampoConPlaceholder(txtApellidos, "Ingrese sus Apellidos Completos");
        configurarCampoConPlaceholder(txtGrado, "Ingrese su grado académico (Ingeniero, Magíster, etc)");
        configurarCampoConPlaceholder(txtCorreo, "Ingrese su correo electrónico");

        actualizarProgreso();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblLogoPanel1 = new javax.swing.JLabel();
        btnFinalizar1 = new javax.swing.JButton();
        btnCuentaStyle = new javax.swing.JButton();
        btnSubirFirma = new javax.swing.JButton();
        barraProgreso = new javax.swing.JProgressBar();
        jPanel5 = new javax.swing.JPanel();
        lblLogoG = new javax.swing.JLabel();
        lblTittle = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        separador = new javax.swing.JSeparator();
        lblApellidos = new javax.swing.JLabel();
        separadorPass = new javax.swing.JSeparator();
        lblGrado = new javax.swing.JLabel();
        txtGrado = new javax.swing.JTextField();
        separatorCorreo = new javax.swing.JSeparator();
        txtApellidos = new javax.swing.JTextField();
        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        separadorUsuario1 = new javax.swing.JSeparator();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        separatorCorreo1 = new javax.swing.JSeparator();
        lblX1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 86, 163));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(lblLogoPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 35, -1, -1));

        btnFinalizar1.setBackground(new java.awt.Color(25, 118, 210));
        btnFinalizar1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnFinalizar1.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizar1.setText("FINALIZAR REGISTRO");
        btnFinalizar1.setBorder(null);
        btnFinalizar1.setBorderPainted(false);
        btnFinalizar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFinalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnFinalizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 598, 192, 41));

        btnCuentaStyle.setBackground(new java.awt.Color(25, 118, 210));
        btnCuentaStyle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnCuentaStyle.setForeground(new java.awt.Color(255, 255, 255));
        btnCuentaStyle.setText("CUENTA");
        btnCuentaStyle.setBorder(null);
        btnCuentaStyle.setBorderPainted(false);
        jPanel4.add(btnCuentaStyle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 53, 192, 41));

        btnSubirFirma.setBackground(new java.awt.Color(25, 118, 210));
        btnSubirFirma.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSubirFirma.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirFirma.setText("SUBIR FIRMA");
        btnSubirFirma.setBorder(null);
        btnSubirFirma.setBorderPainted(false);
        btnSubirFirma.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSubirFirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirFirmaActionPerformed(evt);
            }
        });
        jPanel4.add(btnSubirFirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 551, 192, 41));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 658));

        barraProgreso.setStringPainted(true);
        jPanel3.add(barraProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 638, 393, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogoG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/isotipo_unprg(2).png"))); // NOI18N
        jPanel5.add(lblLogoG, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 14, -1, -1));

        lblTittle.setFont(new java.awt.Font("Roboto ExtraBold", 1, 30)); // NOI18N
        lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTittle.setText("DATOS PERSONALES");
        jPanel5.add(lblTittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 103, -1, -1));

        lblNombres.setFont(new java.awt.Font("Roboto Condensed Medium", 1, 18)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(51, 51, 51));
        lblNombres.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombres.setText("NOMBRES");
        jPanel5.add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 254, 337, -1));

        txtNombres.setBackground(new java.awt.Color(242, 240, 240));
        txtNombres.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(153, 153, 153));
        txtNombres.setBorder(null);
        txtNombres.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNombres.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtNombres.setSelectionColor(new java.awt.Color(232, 201, 42));
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombresKeyReleased(evt);
            }
        });
        jPanel5.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 288, 337, 30));

        separador.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel5.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 320, 337, 10));

        lblApellidos.setFont(new java.awt.Font("Roboto Condensed Medium", 1, 18)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(51, 51, 51));
        lblApellidos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblApellidos.setText("APELLIDOS");
        jPanel5.add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 348, 337, -1));

        separadorPass.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel5.add(separadorPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 418, 337, 10));

        lblGrado.setFont(new java.awt.Font("Roboto Condensed Medium", 1, 18)); // NOI18N
        lblGrado.setForeground(new java.awt.Color(51, 51, 51));
        lblGrado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGrado.setText("GRADO ACADEMICO");
        jPanel5.add(lblGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 446, 337, -1));

        txtGrado.setBackground(new java.awt.Color(242, 240, 240));
        txtGrado.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtGrado.setForeground(new java.awt.Color(153, 153, 153));
        txtGrado.setBorder(null);
        txtGrado.setCaretColor(new java.awt.Color(255, 255, 255));
        txtGrado.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtGrado.setSelectionColor(new java.awt.Color(232, 201, 42));
        txtGrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGradoKeyReleased(evt);
            }
        });
        jPanel5.add(txtGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 476, 337, 30));

        separatorCorreo.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel5.add(separatorCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 506, 337, 10));

        txtApellidos.setBackground(new java.awt.Color(242, 240, 240));
        txtApellidos.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(153, 153, 153));
        txtApellidos.setBorder(null);
        txtApellidos.setCaretColor(new java.awt.Color(255, 255, 255));
        txtApellidos.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtApellidos.setSelectionColor(new java.awt.Color(232, 201, 42));
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidosKeyReleased(evt);
            }
        });
        jPanel5.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 382, 337, 30));

        lblDni.setFont(new java.awt.Font("Roboto Condensed Medium", 1, 18)); // NOI18N
        lblDni.setForeground(new java.awt.Color(51, 51, 51));
        lblDni.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDni.setText("DNI");
        jPanel5.add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 166, 337, -1));

        txtDni.setBackground(new java.awt.Color(242, 240, 240));
        txtDni.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtDni.setForeground(new java.awt.Color(153, 153, 153));
        txtDni.setBorder(null);
        txtDni.setCaretColor(new java.awt.Color(255, 255, 255));
        txtDni.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtDni.setSelectionColor(new java.awt.Color(232, 201, 42));
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
        });
        jPanel5.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 196, 337, 30));

        separadorUsuario1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel5.add(separadorUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 226, 337, 10));

        lblCorreo.setFont(new java.awt.Font("Roboto Condensed Medium", 1, 18)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(51, 51, 51));
        lblCorreo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCorreo.setText("CORREO INSTITUCIONAL");
        jPanel5.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 534, 337, -1));

        txtCorreo.setBackground(new java.awt.Color(242, 240, 240));
        txtCorreo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(153, 153, 153));
        txtCorreo.setBorder(null);
        txtCorreo.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCorreo.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtCorreo.setSelectionColor(new java.awt.Color(232, 201, 42));
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });
        jPanel5.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 564, 337, 30));

        separatorCorreo1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel5.add(separatorCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 594, 337, 10));

        lblX1.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        lblX1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblX1.setText("X");
        lblX1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblX1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblX1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblX1MousePressed(evt);
            }
        });
        jPanel5.add(lblX1, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 14, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 6, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizar1ActionPerformed
        if (validadDatos() == true) {

            String dni = txtDni.getText().trim();
            String nombres = txtNombres.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            String grado = txtGrado.getText().trim();
            String correo = txtCorreo.getText().trim();

            if (Proyect_Silabo_Unprg.validarCamposLlenos(txtNombres, txtApellidos, txtCorreo, txtDni, txtGrado) == false) {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos correctamente.", null, JOptionPane.WARNING_MESSAGE);
                return;
            }

            // La firma ahora es opcional - se puede registrar sin firma
            Docente d = new Docente(nombres, apellidos, grado, dni, correo, grado);
            usuarioRecibido.setDocente(d);

            // Guardar en XML usando el servicio
            UsuarioServiceJAXB servicioXml = new UsuarioServiceJAXB("src/main/resources/Usuarios.xml");
            List<Usuario> usuariosXml = servicioXml.cargarUsuarios();

            // Buscar y actualizar el usuario existente en el XML
            boolean usuarioActualizado = false;
            for (int i = 0; i < usuariosXml.size(); i++) {
                Usuario u = usuariosXml.get(i);
                if (u.getNombreUsuario().equals(usuarioRecibido.getNombreUsuario())) {
                    usuariosXml.set(i, usuarioRecibido); // Reemplazar con los datos completos
                    usuarioActualizado = true;
                    break;
                }
            }

            // Si no se encontró, agregarlo (por seguridad)
            if (!usuarioActualizado) {
                usuariosXml.add(usuarioRecibido);
            }

            // Guardar la lista actualizada en el XML
            servicioXml.guardarUsuarios(usuariosXml);

            // También mantener las listas en memoria para compatibilidad
            Proyect_Silabo_Unprg.usuarios.add(usuarioRecibido);
            Proyect_Silabo_Unprg.docentes.add(d);

            // Mostrar en consola
            System.out.println("==== REGISTRO COMPLETADO ====");
            System.out.println(usuarioRecibido);
            System.out.println("Datos guardados en XML correctamente");
            System.out.println("================================");

            JOptionPane.showMessageDialog(this, "Registro completado con éxito.\nDatos del docente guardados en el sistema.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            new JFLogeo().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnFinalizar1ActionPerformed

    private void txtNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyReleased
        actualizarProgreso();
    }//GEN-LAST:event_txtNombresKeyReleased

    private void txtGradoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGradoKeyReleased
        actualizarProgreso();
    }//GEN-LAST:event_txtGradoKeyReleased

    private void txtApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyReleased
        actualizarProgreso();
    }//GEN-LAST:event_txtApellidosKeyReleased

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        actualizarProgreso();
    }//GEN-LAST:event_txtDniKeyReleased

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        actualizarProgreso();
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void btnSubirFirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirFirmaActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imagen PNG", "png"));

        int option = chooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                firma = ImageIO.read(file); // leer la imagen como BufferedImage
                JOptionPane.showMessageDialog(this, "Firma cargada correctamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al cargar la firma: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSubirFirmaActionPerformed

    private void lblX1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblX1MousePressed
        JFCrearCuenta prim = new JFCrearCuenta();
        prim.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblX1MousePressed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFDatosCompletarRegistro(Proyect_Silabo_Unprg.usuarios.get(0)).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JButton btnCuentaStyle;
    private javax.swing.JButton btnFinalizar1;
    private javax.swing.JButton btnSubirFirma;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblGrado;
    private javax.swing.JLabel lblLogoG;
    private javax.swing.JLabel lblLogoPanel1;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTittle;
    private javax.swing.JLabel lblX1;
    private javax.swing.JSeparator separador;
    private javax.swing.JSeparator separadorPass;
    private javax.swing.JSeparator separadorUsuario1;
    private javax.swing.JSeparator separatorCorreo;
    private javax.swing.JSeparator separatorCorreo1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

    private void actualizarProgreso() {
        int progreso = 0;
        int totalCampos = 5;

        if (!txtDni.getText().trim().isEmpty()) {
            progreso++;
        }
        if (!txtNombres.getText().trim().isEmpty()) {
            progreso++;
        }
        if (!txtApellidos.getText().trim().isEmpty()) {
            progreso++;
        }
        if (!txtGrado.getText().trim().isEmpty()) {
            progreso++;
        }
        if (!txtCorreo.getText().trim().isEmpty()) {
            progreso++;
        }

        int porcentaje = (progreso * 100) / totalCampos;
        barraProgreso.setValue(porcentaje);
    }

    private boolean validadDatos() {
        String msj = "";
        if (!txtDni.getText().replaceAll("\\s+", "").trim().matches("\\d{8}")) {
            msj += "DNI inválido.\n";
            JOptionPane.showMessageDialog(null, msj);
            return false;
        }

        if (!txtNombres.getText().matches("([A-Za-zÁÉÍÓÚáéíóúÑñ]+)( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*") || txtNombres.getText().length() < 2 || txtNombres.getText().length() > 50) {
            msj += "Nombre inválido: solo letras y espacios\n";
            JOptionPane.showMessageDialog(null, msj);
            return false;
        }
        if (!txtApellidos.getText().matches("([A-Za-zÁÉÍÓÚáéíóúÑñ]+)( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*") || txtApellidos.getText().length() < 2 || txtApellidos.getText().length() > 50) {
            msj += "Apellido inválido: solo letras y espacios\n";
            JOptionPane.showMessageDialog(null, msj);
            return false;
        }
        if (!txtCorreo.getText().matches("^[\\w.-]+@unprg\\.edu\\.pe$")) {
            JOptionPane.showMessageDialog(null, "Correo inválido: debe terminar en @unprg.edu.pe");
            return false;
        }

        return true;
    }
}
