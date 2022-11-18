/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;
import Clases.ClassFuncionesSQL;
import Controlador.MtoPresupuesto;
import Vista.Frames.frmAlerta;
import Vista.Frames.frmBuscador;
import Vista.Frames.frmCostoProyecto;

/**
 *
 * @author Diego Castro
 */
public class PanelPresupuesto extends javax.swing.JPanel {

    /**
     * Creates new form PanelPresupuesto
     */
    public PanelPresupuesto() {
        initComponents();
    }

    //Declaracion de objetos de las clases
    MtoPresupuesto var = new MtoPresupuesto();
    ClassFuncionesSQL fun = new ClassFuncionesSQL();  
    public static int idProyecto;
    
    public static String[] datos = new String[6]; 
    
    public PanelPresupuesto(String proyecto)
    {
        initComponents();
        jTFProyecto.setText(proyecto);
        var.setIdProyecto(fun.getIdentificador("select * from Proyecto where Nombre_Proyecto = '"+proyecto+"'"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblSelectProyecto = new javax.swing.JLabel();
        jTFProyecto = new LIB.FSTexFieldMD();
        lblSelectProyecto2 = new javax.swing.JLabel();
        btnBorrarCampos = new LIB.FSButtonMD();
        btnBorrarCampos1 = new LIB.FSButtonMD();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 620));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblSelectProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        lblSelectProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectProyectoMouseClicked(evt);
            }
        });

        jTFProyecto.setEditable(false);
        jTFProyecto.setBackground(new java.awt.Color(255, 255, 255));
        jTFProyecto.setForeground(new java.awt.Color(0, 0, 0));
        jTFProyecto.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFProyecto.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFProyecto.setPlaceholder("Seleccione un proyecto");

        lblSelectProyecto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconMiniInstalaciones.png"))); // NOI18N
        lblSelectProyecto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectProyecto2MouseClicked(evt);
            }
        });

        btnBorrarCampos.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/negocios-y-finanzas.png"))); // NOI18N
        btnBorrarCampos.setText("  Generar Reporte");
        btnBorrarCampos.setColorHover(new java.awt.Color(204, 204, 204));
        btnBorrarCampos.setColorNormal(new java.awt.Color(255, 255, 255));
        btnBorrarCampos.setColorPressed(new java.awt.Color(255, 255, 255));
        btnBorrarCampos.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnBorrarCampos.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnBorrarCampos.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        btnBorrarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCamposActionPerformed(evt);
            }
        });

        btnBorrarCampos1.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarCampos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Reporte4.png"))); // NOI18N
        btnBorrarCampos1.setText("  Cargar Subtotales");
        btnBorrarCampos1.setColorHover(new java.awt.Color(204, 204, 204));
        btnBorrarCampos1.setColorNormal(new java.awt.Color(255, 255, 255));
        btnBorrarCampos1.setColorPressed(new java.awt.Color(255, 255, 255));
        btnBorrarCampos1.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnBorrarCampos1.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnBorrarCampos1.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        btnBorrarCampos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCampos1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnBorrarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarCampos1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jTFProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSelectProyecto)
                .addGap(45, 45, 45))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(533, Short.MAX_VALUE)
                    .addComponent(lblSelectProyecto2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(453, 453, 453)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTFProyecto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSelectProyecto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBorrarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrarCampos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblSelectProyecto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 1020, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblSelectProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectProyectoMouseClicked
        frmBuscador c = new frmBuscador("proyecto",1);
        c.setVisible(true);
    }//GEN-LAST:event_lblSelectProyectoMouseClicked

    private void lblSelectProyecto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectProyecto2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSelectProyecto2MouseClicked

    private void btnBorrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCamposActionPerformed
   
    }//GEN-LAST:event_btnBorrarCamposActionPerformed

    private void btnBorrarCampos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCampos1ActionPerformed
        if (!jTFProyecto.getText().trim().isEmpty()) 
        {
            var.setIdProyecto(fun.getIdentificador("select * from Proyecto where nombre_proyecto = '"+jTFProyecto.getText()+"'"));
            String[] subtotales = var.cargarPresupuesto(var); 
            frmCostoProyecto c = new frmCostoProyecto(subtotales);
            c.setVisible(true);
        }
        else
        {
            new frmAlerta("Seleccione uno de los proyectos",2).setVisible(true);
        }
    }//GEN-LAST:event_btnBorrarCampos1ActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LIB.FSButtonMD btnBorrarCampos;
    private LIB.FSButtonMD btnBorrarCampos1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static LIB.FSTexFieldMD jTFProyecto;
    private javax.swing.JLabel lblSelectProyecto;
    private javax.swing.JLabel lblSelectProyecto2;
    // End of variables declaration//GEN-END:variables
}
