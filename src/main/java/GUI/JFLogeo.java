package GUI;

import Recursos.UsuarioServiceJAXB;
import com.mycompany.proyect_silabo_unprg.Proyect_Silabo_Unprg;
import entidades.Usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFLogeo extends javax.swing.JFrame {

    private int mouseX, mouseY;

    private final UsuarioServiceJAXB servicioXml = new UsuarioServiceJAXB("src/main/resources/Usuarios.xml");
    private int cantidadIntentos = 4;
    private Usuario usuarioLogeado;
    private boolean datoscargados = false;

    public JFLogeo() {
        setUndecorated(true);

        initComponents();
        Proyect_Silabo_Unprg.configurarCampoConPlaceholder(txtUsuario, "Ingresa tu nombre de usuario");
        Proyect_Silabo_Unprg.configurarCampoConPlaceholder(txtPass, "Ingrese su contraseña");
        if (!datoscargados) {
            Proyect_Silabo_Unprg.docentes.clear(); // si aplica refresco
            Proyect_Silabo_Unprg.usuarios = servicioXml.cargarUsuarios(); // carga desde XML
            datoscargados = true;
        }

        setLocationRelativeTo(null);
        setVisible(true);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        lblLogoUnprg = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblIniciarSesion = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        separadorUsuario = new javax.swing.JSeparator();
        lblPass = new javax.swing.JLabel();
        chkVerPassword = new javax.swing.JCheckBox();
        txtPass = new javax.swing.JPasswordField();
        separadorPass = new javax.swing.JSeparator();
        separatorCrear = new javax.swing.JSeparator();
        lblCuenta = new javax.swing.JLabel();
        lblCrearCuenta = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        lblBaner = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        lblX = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogoUnprg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_unprg.png"))); // NOI18N
        background.add(lblLogoUnprg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        lblTitulo.setBackground(new java.awt.Color(204, 204, 204));
        lblTitulo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("PLANIFICA UNPRG");
        background.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 320, -1));

        lblIniciarSesion.setBackground(new java.awt.Color(0, 0, 0));
        lblIniciarSesion.setFont(new java.awt.Font("Roboto ExtraBold", 1, 24)); // NOI18N
        lblIniciarSesion.setForeground(new java.awt.Color(51, 51, 51));
        lblIniciarSesion.setText("INICIAR SESION");
        background.add(lblIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Roboto Condensed Medium", 1, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lblUsuario.setText("USUARIO");
        background.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(242, 240, 240));
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtUsuario.setBorder(null);
        txtUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUsuario.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtUsuario.setSelectionColor(new java.awt.Color(232, 201, 42));
        background.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 370, 30));

        separadorUsuario.setBorder(new javax.swing.border.MatteBorder(null));
        background.add(separadorUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 370, 10));

        lblPass.setFont(new java.awt.Font("Roboto Condensed Medium", 1, 18)); // NOI18N
        lblPass.setForeground(new java.awt.Color(51, 51, 51));
        lblPass.setText("CONTRASEÑA");
        background.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        chkVerPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver_contrasenia.png"))); // NOI18N
        chkVerPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVerPasswordActionPerformed(evt);
            }
        });
        background.add(chkVerPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, -1, -1));

        txtPass.setBackground(new java.awt.Color(242, 240, 240));
        txtPass.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtPass.setForeground(new java.awt.Color(153, 153, 153));
        txtPass.setBorder(null);
        txtPass.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtPass.setSelectionColor(new java.awt.Color(232, 201, 42));
        background.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 370, 30));

        separadorPass.setBorder(new javax.swing.border.MatteBorder(null));
        background.add(separadorPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 370, 10));

        separatorCrear.setBorder(new javax.swing.border.MatteBorder(null));
        background.add(separatorCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 370, 10));

        lblCuenta.setForeground(new java.awt.Color(51, 51, 51));
        lblCuenta.setText("No tienes una cuenta?");
        background.add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, -1, -1));

        lblCrearCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCrearCuenta.setForeground(new java.awt.Color(0, 102, 204));
        lblCrearCuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCrearCuenta.setText(" CREA UNA");
        lblCrearCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblCrearCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCrearCuentaMousePressed(evt);
            }
        });
        background.add(lblCrearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 70, -1));

        btnEntrar.setBackground(new java.awt.Color(232, 201, 42));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login.png"))); // NOI18N
        btnEntrar.setText("ENTRAR");
        btnEntrar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(210, 184, 35), new java.awt.Color(170, 170, 170)));
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        background.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 90, 30));

        lblBaner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBaner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baner_unprg.png"))); // NOI18N
        lblBaner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblBaner.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        background.add(lblBaner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 460));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        lblX.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        lblX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblX.setText("X");
        lblX.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblX.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblXMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(705, Short.MAX_VALUE)
                .addComponent(lblX)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblX, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 720, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkVerPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVerPasswordActionPerformed
        if (chkVerPassword.isSelected()) {
            txtPass.setEchoChar((char) 0); // Muestra texto plano
        } else {
            txtPass.setEchoChar('\u2022'); // Vuelve a ocultar la contraseña
        }
    }//GEN-LAST:event_chkVerPasswordActionPerformed

    private void lblCrearCuentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearCuentaMousePressed
        JFCrearCuenta reg = new JFCrearCuenta();
        reg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCrearCuentaMousePressed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if (this.validarlogeo() == true) {
            JFSilabo frm = new JFSilabo(this.usuarioLogeado);
            frm.setVisible(true);
            frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.dispose();
        } else {
            this.cantidadIntentos--;
            JOptionPane.showMessageDialog(this, "Credenciales Incorrectas le quedan: " + this.cantidadIntentos);

        }

        if (this.cantidadIntentos == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void lblXMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXMousePressed
        this.dispose();
    }//GEN-LAST:event_lblXMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int X = evt.getXOnScreen();
        int Y = evt.getYOnScreen();
        this.setLocation(X - mouseX, Y - mouseY);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_headerMousePressed

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
            java.util.logging.Logger.getLogger(JFLogeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLogeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLogeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLogeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLogeo().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JCheckBox chkVerPassword;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lblBaner;
    private javax.swing.JLabel lblCrearCuenta;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblIniciarSesion;
    private javax.swing.JLabel lblLogoUnprg;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblX;
    private javax.swing.JSeparator separadorPass;
    private javax.swing.JSeparator separadorUsuario;
    private javax.swing.JSeparator separatorCrear;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private boolean validarlogeo() {
        List<Usuario> usuariosXml = servicioXml.cargarUsuarios(); // carga actualizada

        for (Usuario usuario : usuariosXml) {
            if (txtUsuario.getText().equals(usuario.getNombreUsuario())
                    && txtPass.getText().equals(usuario.getContraseña())) {
                this.usuarioLogeado = usuario;
                return true;
            }
        }
        return false;
    }
}
