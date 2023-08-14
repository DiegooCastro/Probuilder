package Views.Frames;

import FiveCodMover.FiveCodMoverJFrame;
import Helpers.Login;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Castro
 */
public class frmLogin extends javax.swing.JFrame {

    //Declaracion de objetos de la clase
    Login log = new Login();

    public frmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtContraseña.setEchoChar((char) 0);
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        cargarCredenciales();
        txtContraseña.setEchoChar('*');
    }

    private void cargarCredenciales() {
        try {
            File archivo = new File("datos.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            if (linea != null) {
                String clave = "", usuario = "", caracter = "";
                int palabra = 1;

                for (int i = 0; i < linea.length(); i++) {
                    caracter = String.valueOf(linea.charAt(i));
                    if (caracter.trim().isEmpty()) {
                        palabra = 2;
                    } else {
                        if (palabra == 1) {
                            usuario = usuario + caracter;
                        } else {
                            clave = clave + caracter;
                        }
                    }
                    txtUsuario.setText(usuario);
                    txtContraseña.setText(clave);
                    txtContraseña.setEchoChar('*');
                    id = 2;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void guardarCredenciales() {
        try {
            String ruta = "datos.txt";
            File file = new File(ruta);
            if (cbRecordarme.isSelected()) {
                String contenido = txtUsuario.getText() + ' ' + txtContraseña.getText();
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("");
                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private int id = 1;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnLogin = new LIB.FSButtonMD();
        txtContraseña = new LIB.FSPasswordFieldMD();
        txtUsuario = new LIB.FSTexFieldMD();
        cbRecordarme = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        lblRecuperacion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(33, 51, 66));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, -1));

        jPanel3.setBackground(new java.awt.Color(50, 75, 94));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setText("Acceder");
        btnLogin.setColorHover(new java.awt.Color(34, 55, 76));
        btnLogin.setColorNormal(new java.awt.Color(33, 51, 66));
        btnLogin.setColorPressed(new java.awt.Color(18, 31, 43));
        btnLogin.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel3.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 280, 50));

        txtContraseña.setBackground(new java.awt.Color(50, 75, 94));
        txtContraseña.setForeground(new java.awt.Color(255, 255, 255));
        txtContraseña.setBordeColorFocus(new java.awt.Color(204, 204, 204));
        txtContraseña.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        txtContraseña.setPlaceholder(" Contraseña*");
        jPanel3.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 192, 310, 40));

        txtUsuario.setBackground(new java.awt.Color(50, 75, 94));
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setBordeColorFocus(new java.awt.Color(204, 204, 204));
        txtUsuario.setBordeColorNoFocus(new java.awt.Color(50, 75, 94));
        txtUsuario.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        txtUsuario.setPlaceholder(" Usuario*");
        txtUsuario.setSelectedTextColor(new java.awt.Color(50, 75, 94));
        jPanel3.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 102, 303, 40));

        cbRecordarme.setBackground(new java.awt.Color(50, 75, 94));
        cbRecordarme.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbRecordarme.setForeground(new java.awt.Color(255, 255, 255));
        cbRecordarme.setText("Recuerdame ");
        jPanel3.add(cbRecordarme, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, 40));

        lblRecuperacion.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblRecuperacion.setForeground(new java.awt.Color(255, 255, 255));
        lblRecuperacion.setText("¿Olvidaste tu contraseña?");
        lblRecuperacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRecuperacionMouseClicked(evt);
            }
        });
        jPanel3.add(lblRecuperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 450));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconProbuilder.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 270, 340));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/minimizarLogin.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 20, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrarLogin.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (txtUsuario.getText().trim().isEmpty() || txtContraseña.getText().trim().isEmpty()) {
            new frmAlert("Complete los campos solicitados", 2).setVisible(true);
        } else {
            log.setUsuario(txtUsuario.getText());
            log.setClave(txtContraseña.getText());
            if (log.iniciarSesion(log)) {
                int estado;
                if (Login.estadoUsuario) {
                    estado = 1;
                } else {
                    estado = 0;
                }

                switch (estado) {
                    case 1:
                        guardarCredenciales();
                        frmMenuPrincipal m = new frmMenuPrincipal(txtUsuario.getText());
                        m.setVisible(true);
                        this.dispose();
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no disponible...");
                        break;
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setExtendedState(1);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_jPanel1MousePressed

    private void lblRecuperacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRecuperacionMouseClicked
        frmRecuperacion a = new frmRecuperacion();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblRecuperacionMouseClicked

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LIB.FSButtonMD btnLogin;
    private javax.swing.JCheckBox cbRecordarme;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblRecuperacion;
    private LIB.FSPasswordFieldMD txtContraseña;
    private LIB.FSTexFieldMD txtUsuario;
    // End of variables declaration//GEN-END:variables
}
