package Views.Frames;

import FiveCodMover.FiveCodMoverJFrame;
import Helpers.FuncionesSQL;
import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author Diego Castro
 */
public class frmRecuperacion extends javax.swing.JFrame {

    FuncionesSQL funSQL = new FuncionesSQL();
    private int codigo;
    
    public frmRecuperacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtCodigo.setEchoChar((char) 0);
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtCodigo.setEchoChar('*');
        txtClave.setEchoChar('*');
        txtClave2.setEchoChar('*');
        btnActualizarClave.setEnabled(false);
        btnEnviarCorreo.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtCodigo = new LIB.FSPasswordFieldMD();
        txtCorreo = new LIB.FSTexFieldMD();
        jLabel4 = new javax.swing.JLabel();
        lblRecuperacion = new javax.swing.JLabel();
        btnEnviarCorreo = new LIB.FSButtonMD();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnIngresar = new LIB.FSButtonMD();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtClave = new LIB.FSPasswordFieldMD();
        txtClave2 = new LIB.FSPasswordFieldMD();
        btnActualizarClave = new LIB.FSButtonMD();

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

        txtCodigo.setBackground(new java.awt.Color(50, 75, 94));
        txtCodigo.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigo.setBordeColorFocus(new java.awt.Color(204, 204, 204));
        txtCodigo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        txtCodigo.setPlaceholder(" Ingrese el codigo enviado");
        jPanel3.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 300, 40));

        txtCorreo.setBackground(new java.awt.Color(50, 75, 94));
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setBordeColorFocus(new java.awt.Color(204, 204, 204));
        txtCorreo.setBordeColorNoFocus(new java.awt.Color(50, 75, 94));
        txtCorreo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        txtCorreo.setPlaceholder(" Ingrese su correo electronico");
        txtCorreo.setSelectedTextColor(new java.awt.Color(50, 75, 94));
        jPanel3.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 300, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Recuperacion de contraseña");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, 50));

        lblRecuperacion.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblRecuperacion.setForeground(new java.awt.Color(255, 255, 255));
        lblRecuperacion.setText("Regresar al login");
        lblRecuperacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRecuperacionMouseClicked(evt);
            }
        });
        jPanel3.add(lblRecuperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, 30));

        btnEnviarCorreo.setText("Verificar codigo");
        btnEnviarCorreo.setColorHover(new java.awt.Color(34, 55, 76));
        btnEnviarCorreo.setColorNormal(new java.awt.Color(33, 51, 66));
        btnEnviarCorreo.setColorPressed(new java.awt.Color(18, 31, 43));
        btnEnviarCorreo.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCorreoActionPerformed(evt);
            }
        });
        jPanel3.add(btnEnviarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 310, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bloqueado.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 50));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 360, 10));

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/correoDesbloqueado.png"))); // NOI18N
        btnIngresar.setColorHover(new java.awt.Color(240, 240, 240));
        btnIngresar.setColorNormal(new java.awt.Color(50, 75, 94));
        btnIngresar.setColorPressed(new java.awt.Color(50, 75, 94));
        btnIngresar.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnIngresar.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel3.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 40, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 450));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/minimizarLogin.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 20, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrarLogin.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, 40));

        txtClave.setEditable(false);
        txtClave.setForeground(new java.awt.Color(0, 0, 0));
        txtClave.setBordeColorFocus(new java.awt.Color(204, 204, 204));
        txtClave.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        txtClave.setPlaceholder(" Nueva clave*");
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 300, 40));

        txtClave2.setEditable(false);
        txtClave2.setForeground(new java.awt.Color(0, 0, 0));
        txtClave2.setBordeColorFocus(new java.awt.Color(204, 204, 204));
        txtClave2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        txtClave2.setPlaceholder(" Confirmar clave*");
        jPanel1.add(txtClave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 300, 40));

        btnActualizarClave.setText("Actualizar clave");
        btnActualizarClave.setColorHover(new java.awt.Color(34, 55, 76));
        btnActualizarClave.setColorNormal(new java.awt.Color(33, 51, 66));
        btnActualizarClave.setColorPressed(new java.awt.Color(18, 31, 43));
        btnActualizarClave.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnActualizarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 300, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
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

    private void btnActualizarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClaveActionPerformed
        if (txtClave.getText().equals(txtClave2.getText())) {
            funSQL.actualizarClave(txtClave.getText(), txtCorreo.getText());
        } else {
            new frmAlert("Las claves no coinciden",2);
        }
    }//GEN-LAST:event_btnActualizarClaveActionPerformed

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

    private void btnEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCorreoActionPerformed
        if (codigo == Integer.parseInt(txtCodigo.getText())) {
            btnEnviarCorreo.setEnabled(false);
            btnActualizarClave.setEnabled(true);
            new frmAlert("El codigo es correcto",1);
        } else {
            new frmAlert("El codigo no coincide",2);
        }
    }//GEN-LAST:event_btnEnviarCorreoActionPerformed

    private void lblRecuperacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRecuperacionMouseClicked
        frmLogin a = new frmLogin();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblRecuperacionMouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        codigo = (int)Math.floor(Math.random()*10000+1);;
        if (txtCorreo.getText().isEmpty()) {
            new frmAlert("Ingrese un correo electronico",2);
        } else{
            funSQL.enviarCorreo("Codigo de recuperacion de contraseña es " + codigo, "Recuperacion de contraseña", txtCorreo.getText());
            btnEnviarCorreo.setEnabled(true);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(frmRecuperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRecuperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRecuperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRecuperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRecuperacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LIB.FSButtonMD btnActualizarClave;
    private LIB.FSButtonMD btnEnviarCorreo;
    private LIB.FSButtonMD btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblRecuperacion;
    private LIB.FSPasswordFieldMD txtClave;
    private LIB.FSPasswordFieldMD txtClave2;
    private LIB.FSPasswordFieldMD txtCodigo;
    private LIB.FSTexFieldMD txtCorreo;
    // End of variables declaration//GEN-END:variables
}
