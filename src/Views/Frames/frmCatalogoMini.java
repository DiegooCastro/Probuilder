/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Frames;

import Helpers.Catalogos;
import Helpers.FuncionesSQL;
import FiveCodMover.FiveCodMoverJFrame;
import Views.Panels.PanelAlmacenaje;
import Views.Panels.PanelAsignaciones;
import Views.Panels.PanelPersonal;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Castro
 */
public class frmCatalogoMini extends javax.swing.JFrame {

    /**
     * Creates new form frmCatalogoMini
     */
    public frmCatalogoMini() {
        initComponents();
    }
    
    public frmCatalogoMini(String formulario,int caso)
    {
        initComponents();
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.formulario = formulario;
        this.caso = caso;
        tb = (DefaultTableModel)jTable1.getModel();
        cargarTabla();
        this.setLocationRelativeTo(null);
    }
    
    //Declaracion de atributos de la clase
    private DefaultTableModel tb;
    private String formulario;
    private int caso;
    private int fila;
    private int id = -1;
    
    //Declaracion de atributos para guardar las diferentes sentencias SQL
    private String queryIngresar,queryModificar,querySelect,queryValidar;
    
    //Declaracion de objetos de clases
    Catalogos cat = new Catalogos();
    FuncionesSQL fun = new FuncionesSQL();

    /**
     * Metodo para cargar los datos en la tabla
     */
    private void cargarTabla()
    {
        switch(formulario)
        {
            case "area":
                querySelect = cat.querySeleccionar("Area_Laboral","Area_Laboral");
                queryIngresar = cat.queryInsercion("Area_Laboral (Area_Laboral)");
                queryValidar = cat.queryValidar("Area_Laboral", "Area_Laboral");
                queryModificar = cat.queryModificar("Area_Laboral","Area_Laboral","Id_AreaLaboral");
                lblCampo1.setText("Area Laboral");
            break;
            
            case "asignaciones":
                querySelect = cat.querySeleccionar("Asignaciones", "Asignacion");
                queryIngresar = cat.queryInsercion("Asignaciones (Asignacion)");
                queryValidar = cat.queryValidar("Asignaciones", "Asignacion");
                queryModificar = cat.queryModificar("Asignaciones","Asignacion","Id_Asignacion");
                lblCampo1.setText("Asignaciones Proyecto");
            break;
            
            case "cargo":
                querySelect = cat.querySeleccionar("Cargo_Laboral", "Cargo");
                queryIngresar = cat.queryInsercion("Cargo_Laboral (Cargo)");
                queryValidar = cat.queryValidar("Cargo_Laboral", "Cargo");
                queryModificar = cat.queryModificar("Cargo_Laboral","Cargo","Id_Cargo");
                lblCampo1.setText("Cargo Laboral");
            break;
            
            case "pago":
                querySelect = cat.querySeleccionar("TiemposPago", "Tipo_Pago");
                queryIngresar = cat.queryInsercion("TiemposPago (Tipo_Pago)");
                queryValidar = cat.queryValidar("TiemposPago", "Tipo_Pago");
                queryModificar = cat.queryModificar("TiemposPago","Tipo_Pago","Id_TiemposPago");
                lblCampo1.setText("Tiempo Pago");
            break;
            
            case "profesion":
                querySelect = cat.querySeleccionar("Profesion", "Profesion");
                queryIngresar = cat.queryInsercion("Profesion (Profesion)");
                queryValidar = cat.queryValidar("Profesion", "Profesion");
                queryModificar = cat.queryModificar("Profesion","Profesion","Id_Profesion");
                lblCampo1.setText("Profesion");
            break;
            
            case "unidad":
                querySelect = cat.querySeleccionar("Unidad_Medida", "Unidad_Medida");
                queryIngresar = cat.queryInsercion("Unidad_Medida (Unidad_Medida)");
                queryValidar = cat.queryValidar("Unidad_Medida", "Unidad_Medida");
                queryModificar = cat.queryModificar("Unidad_Medida","Unidad_Medida","Id_UnidadMedida");
                lblCampo1.setText("Unidad Medida");
            break;
        }   
        fun.cargarTabla(querySelect, tb);
    }
    
    /**
     * Metodo para seleccionar el registro e ingresarlo en su correspondiente formulario
     */
    private void seleccionarRegistro(String formulario)
    {
        if (jTFCampo1.getText().trim().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
        else
        {
            String registro = jTable1.getValueAt(fila, 1).toString();
            switch(formulario)
            {        
                case "area":
                    //PanelPersonal.jTFArea.setText(registro);
                break;
            
                case "asignaciones":
                    PanelAsignaciones.jTFAsignacion.setText(registro);
                break;
                
                case "cargo":
                    //PanelPersonal.jTFCargo.setText(registro);
                break;
            
                case "profesion":
                    if (caso == 1) 
                    {
                        PanelPersonal.jTFProfesion.setText(registro);                 
                    }
                    else
                    {
                        //PnlPrimerRoot.txtProfesion.setText(registro);
                    }
                break;
            
                case "unidad":                    
                    PanelAlmacenaje.jTFUnidad.setText(registro);
                break;
            }   
        this.dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PnlBarra = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro1();
        jTFCampo1 = new LIB.FSTexFieldMD();
        lblCampo1 = new javax.swing.JLabel();
        lblSeleccionar = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlBarra.setBackground(new java.awt.Color(33, 50, 66));
        PnlBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PnlBarraMouseDragged(evt);
            }
        });
        PnlBarra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PnlBarraMousePressed(evt);
            }
        });

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Boton-Cerrar.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Boton-Minimizar.png"))); // NOI18N

        javax.swing.GroupLayout PnlBarraLayout = new javax.swing.GroupLayout(PnlBarra);
        PnlBarra.setLayout(PnlBarraLayout);
        PnlBarraLayout.setHorizontalGroup(
            PnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlBarraLayout.createSequentialGroup()
                .addContainerGap(657, Short.MAX_VALUE)
                .addComponent(lblMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PnlBarraLayout.setVerticalGroup(
            PnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlBarraLayout.createSequentialGroup()
                .addGroup(PnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblMinimizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCerrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(PnlBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, -1));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Registro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColorPrimaryText(new java.awt.Color(0, 0, 0));
        jTable1.setColorSecundaryText(new java.awt.Color(0, 0, 0));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setFontHead(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTable1.setFontRowHover(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setFontRowSelect(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 380, 250));

        jTFCampo1.setForeground(new java.awt.Color(0, 0, 0));
        jTFCampo1.setBordeColorFocus(new java.awt.Color(0, 51, 51));
        jTFCampo1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jTFCampo1.setPlaceholder("");
        jTFCampo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCampo1KeyTyped(evt);
            }
        });
        jPanel1.add(jTFCampo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 230, 40));

        lblCampo1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblCampo1.setText("Campo 1");
        jPanel1.add(lblCampo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 50));

        lblSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Seleccionar.png"))); // NOI18N
        lblSeleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSeleccionarMouseClicked(evt);
            }
        });
        jPanel1.add(lblSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Iconos_Actualizar.png"))); // NOI18N
        btnModificar.setText("  Modificar Registro");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 270, 40));

        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Agregar.png"))); // NOI18N
        btnIngresar.setText("  Ingresar Registro");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 270, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void PnlBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnlBarraMouseDragged
        FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_PnlBarraMouseDragged

    private void PnlBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnlBarraMousePressed
        FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_PnlBarraMousePressed

    private void jTFCampo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCampo1KeyTyped

    }//GEN-LAST:event_jTFCampo1KeyTyped

    private void lblSeleccionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSeleccionarMouseClicked
        seleccionarRegistro(formulario);
    }//GEN-LAST:event_lblSeleccionarMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        fila = jTable1.getSelectedRow();
        id = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
        jTFCampo1.setText(jTable1.getValueAt(fila, 1).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTFCampo1.getText().trim().isEmpty() || id == -1) 
        {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        }
        else
        {
            cat.setRegistro(jTFCampo1.getText());
            cat.setId(id);
            if (cat.ingresarCatalogo(cat, queryValidar, queryModificar)) 
            {
                fun.cargarTabla(querySelect, tb);
                jTFCampo1.setText(null);
            }  
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (jTFCampo1.getText().trim().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        }
        else
        {
            cat.setRegistro(jTFCampo1.getText());
            if (cat.ingresarCatalogo(cat, queryValidar, queryIngresar)) 
            {
                fun.cargarTabla(querySelect, tb);
                jTFCampo1.setText(null);
            }  
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
            java.util.logging.Logger.getLogger(frmCatalogoMini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCatalogoMini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCatalogoMini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCatalogoMini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCatalogoMini().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlBarra;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private LIB.FSTexFieldMD jTFCampo1;
    private rojerusan.RSTableMetro1 jTable1;
    private javax.swing.JLabel lblCampo1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblSeleccionar;
    // End of variables declaration//GEN-END:variables
}
