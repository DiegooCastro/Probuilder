/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Frames;

import Clases.ClassImagenes;
import FiveCodMover.FiveCodMoverJFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class frmGaleria extends javax.swing.JFrame {

    /**
     * Creates new form frmGaleria
     * @param idImagenes
     * @param idProyecto
     */
    public frmGaleria(int[] idImagenes,int idProyecto) 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        this.idImagenes = idImagenes;
        this.idProyecto = idProyecto;
        posicion = 0;
        imagen = 1;
        cargarImagen();
    }
    
    //Declaracion de objeto de la clases a utilizar
    ClassImagenes img = new ClassImagenes();
    
    //Declaracion de atributos de la clase
    private boolean existeImagen;
    private int[] idImagenes; 
    private int idProyecto;
    private int posicion;
    private String ruta;
    private int imagen;
      
    /**
     * Metodo para cargar la imagen dentro del label central
     */
    
    private void cargarImagen()
    {
        lblImagen.setText(null);
        lblImagen.setIcon(null);
        existeImagen = img.cargarLogo(img.obtenerImagen(idImagenes[posicion]), lblImagen);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelImagenCenter = new javax.swing.JPanel();
        PanelTituloGaleria1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblModificarImg = new javax.swing.JLabel();
        lblEliminarImg = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblIngresarImg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblAnterior = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblSiguiente = new javax.swing.JLabel();
        lblSiguienteIcon = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        PanelTituloGaleria = new javax.swing.JPanel();
        lblTituloGaleria = new javax.swing.JLabel();
        lblSeleccionarImg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        PanelImagenCenter.setBackground(new java.awt.Color(102, 255, 255));
        PanelImagenCenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelImagenCenter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelTituloGaleria1.setBackground(new java.awt.Color(51, 73, 94));
        PanelTituloGaleria1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelTituloGaleria1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 73, 94));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblModificarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconModificarImg.png"))); // NOI18N
        lblModificarImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificarImgMouseClicked(evt);
            }
        });

        lblEliminarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconEliminarImg.png"))); // NOI18N
        lblEliminarImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarImgMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 73, 94));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblIngresarImg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblIngresarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_AgregarImagen.png"))); // NOI18N
        lblIngresarImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIngresarImgMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(lblIngresarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIngresarImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lblEliminarImg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(lblModificarImg)
                .addGap(56, 56, 56))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblModificarImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEliminarImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelTituloGaleria1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 0, 490, 50));

        jPanel2.setBackground(new java.awt.Color(51, 73, 94));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblAnterior.setBackground(new java.awt.Color(51, 73, 94));
        lblAnterior.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblAnterior.setForeground(new java.awt.Color(255, 255, 255));
        lblAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Anterior.png"))); // NOI18N
        lblAnterior.setText("  Anterior");
        lblAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnteriorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(lblAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnterior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        PanelTituloGaleria1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        jPanel5.setBackground(new java.awt.Color(51, 73, 94));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSiguiente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        lblSiguiente.setText("Siguiente");
        jPanel5.add(lblSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 50));

        lblSiguienteIcon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSiguienteIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Siguiente.png"))); // NOI18N
        lblSiguienteIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSiguienteIconMouseClicked(evt);
            }
        });
        jPanel5.add(lblSiguienteIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 50));

        PanelTituloGaleria1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 250, 50));

        PanelImagenCenter.add(PanelTituloGaleria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 990, 50));
        PanelImagenCenter.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 570));

        PanelTituloGaleria.setBackground(new java.awt.Color(33, 51, 66));
        PanelTituloGaleria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelTituloGaleria.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelTituloGaleriaMouseDragged(evt);
            }
        });
        PanelTituloGaleria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelTituloGaleriaMousePressed(evt);
            }
        });
        PanelTituloGaleria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloGaleria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTituloGaleria.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloGaleria.setText("Visor de Imagenes");
        PanelTituloGaleria.add(lblTituloGaleria, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, 48));

        lblSeleccionarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Galeria_Imagenes.png"))); // NOI18N
        lblSeleccionarImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSeleccionarImgMouseClicked(evt);
            }
        });
        PanelTituloGaleria.add(lblSeleccionarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 41, 48));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Boton-Minimizar.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        PanelTituloGaleria.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Boton-Cerrar.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        PanelTituloGaleria.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelImagenCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelTituloGaleria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTituloGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelImagenCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSeleccionarImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSeleccionarImgMouseClicked
        ruta = img.seleccionarImagen(lblImagen);
    }//GEN-LAST:event_lblSeleccionarImgMouseClicked

    private void lblAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnteriorMouseClicked
        if (imagen == 1)
        {
            JOptionPane.showMessageDialog(null,"No puedes retroceder");
        }
        else
        {
            lblImagen.setText(null);
            lblImagen.setIcon(null);
            imagen --;
            switch(imagen)
            {
                case 1:
                posicion = 0;
                cargarImagen();
                break;

                case 2:
                posicion = 1;
                cargarImagen();
                break;

                case 3:
                posicion = 2;
                cargarImagen();
                break;

                case 4:
                posicion = 3;
                cargarImagen();
                break;

                case 5:
                posicion = 4;
                cargarImagen();
                break;

                case 6:
                posicion = 5;
                cargarImagen();
                break;
            }
            ruta = null;
        }
    }//GEN-LAST:event_lblAnteriorMouseClicked

    private void lblIngresarImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresarImgMouseClicked
        if (ruta == null)
        {
            JOptionPane.showMessageDialog(null,"No puedes ingresar la misma imagen");
        }
        else
        {
            if (!existeImagen) 
            {
                img.setIdProyecto(idProyecto);
                img.setImagen(img.codificarLogo(ruta));
        
                if (img.ingresarImagen(img))
                {
                    JOptionPane.showMessageDialog(null, "Imagen ingresada correctamente");
                    idImagenes = img.getIdFotografias(idProyecto);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No puedes ingresar una imagen sobre otra");
            }
        }
    }//GEN-LAST:event_lblIngresarImgMouseClicked

    private void lblSiguienteIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSiguienteIconMouseClicked
        if (imagen == 6)
        {
            JOptionPane.showMessageDialog(null,"No puedes seguir avanzando");
        }
        else
        {
            lblImagen.setText(null);
            lblImagen.setIcon(null);
            imagen++;
            switch(imagen)
            {
                case 2:
                posicion = 1;
                cargarImagen();
                break;

                case 3:
                posicion = 2;
                cargarImagen();
                break;

                case 4:
                posicion = 3;
                cargarImagen();
                break;

                case 5:
                posicion = 4;
                cargarImagen();
                break;

                case 6:
                posicion = 5;
                cargarImagen();
                break;
            }
            ruta = null;
        }
    }//GEN-LAST:event_lblSiguienteIconMouseClicked

    private void PanelTituloGaleriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTituloGaleriaMousePressed
        FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_PanelTituloGaleriaMousePressed

    private void PanelTituloGaleriaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTituloGaleriaMouseDragged
        FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_PanelTituloGaleriaMouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setExtendedState(1);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void lblModificarImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarImgMouseClicked
        if (ruta == null)
        {
            JOptionPane.showMessageDialog(null,"Ingresa la nueva imagen");
        }
        else
        {
            img.setIdProyecto(idProyecto);
            img.setIdImagen(idImagenes[posicion]);
            img.setImagen(img.codificarLogo(ruta));
            if (img.modificarImagen(img))
            {
                JOptionPane.showMessageDialog(null, "Imagen modificada correctamente");
            }         
        }
    }//GEN-LAST:event_lblModificarImgMouseClicked

    private void lblEliminarImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarImgMouseClicked
        if (lblImagen.getIcon() == null)
        {
            JOptionPane.showMessageDialog(null,"No hay ninguna imagen");
        }
        else
        {
            if (JOptionPane.showConfirmDialog(null, "Deseas eliminar el registro","Debes confirmar",1,JOptionPane.YES_NO_OPTION) == 0) 
            {
                img.setIdProyecto(idProyecto);
                img.setIdImagen(idImagenes[posicion]);
                if (img.eliminarImagen(img))
                {
                    JOptionPane.showMessageDialog(null, "Imagen eliminada correctamente");
                    idImagenes = img.getIdFotografias(idProyecto);
                    cargarImagen();
                }             
            }
        }
    }//GEN-LAST:event_lblEliminarImgMouseClicked

    public frmGaleria(){}
    
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
            java.util.logging.Logger.getLogger(frmGaleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmGaleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmGaleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmGaleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmGaleria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelImagenCenter;
    private javax.swing.JPanel PanelTituloGaleria;
    private javax.swing.JPanel PanelTituloGaleria1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblAnterior;
    private javax.swing.JLabel lblEliminarImg;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblIngresarImg;
    private javax.swing.JLabel lblModificarImg;
    private javax.swing.JLabel lblSeleccionarImg;
    private javax.swing.JLabel lblSiguiente;
    private javax.swing.JLabel lblSiguienteIcon;
    private javax.swing.JLabel lblTituloGaleria;
    // End of variables declaration//GEN-END:variables
}
