/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Panels;

import Helpers.FuncionesSQL;
import Models.Preliminares;
import Models.Presupuesto;
import Views.Frames.frmAlert;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class PanelPreliminares extends javax.swing.JPanel {

    /**
     * Creates new form PanelPreliminares
     *
     * @param proyecto
     */
    public PanelPreliminares(String proyecto) {
        initComponents();
        modelo = (DefaultTableModel) Tabla.getModel();
        idProyecto = fun.getIdentificador("select * from Proyecto where Nombre_Proyecto = '" + proyecto + "'");
        idPresupuesto = fun.getIdentificador("select * from Presupuesto_Proyecto where Proyecto = '" + idProyecto + "'");
        cargarTabla();
        jTFDescripcion.setWrapStyleWord(true);
        jTFDescripcion.setLineWrap(true);
    }

    DefaultTableModel modelo;
    Preliminares var = new Preliminares();
    Presupuesto pre = new Presupuesto();
    FuncionesSQL fun = new FuncionesSQL();

    private final int idProyecto;
    private final int idPresupuesto;
    private int idPreliminares;
    private int fila;

    private void cargarTabla() {
        fun.cargarTabla("select * from Gastos_Preliminares where presupuesto = '" + idPresupuesto + "'", modelo);
    }

    private void actualizarPresupuesto() {
        pre.setIdPresupuesto(idPresupuesto);
        pre.setIdProyecto(idProyecto);
        pre.actualizarGatosPreliminares(pre);
        pre.actualizarTotales(pre);
    }

    private void borrarCampos() {
        jTFGastoPreliminar.setText(null);
        jTFDescripcion.setText(null);
        jTFPrecioTotal.setText(null);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnIngresar.setEnabled(true);
        idPreliminares = -1;
        fila = -1;
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTFDescripcion = new javax.swing.JTextArea();
        jTFGastoPreliminar = new LIB.FSTexFieldMD();
        jTFPrecioTotal = new LIB.FSTexFieldMD();
        btnIngresar = new LIB.FSButtonMD();
        btnBorrarCampos = new LIB.FSButtonMD();
        btnModificar = new LIB.FSButtonMD();
        btnEliminar = new LIB.FSButtonMD();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla = new rojerusan.RSTableMetro();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel1.setText("Gasto Preliminar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel2.setText("Descripcion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel4.setText("Precio Total $:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel5.setText("Gastos Preliminares");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconGastosPreliminares.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 50, -1));

        jTFDescripcion.setColumns(20);
        jTFDescripcion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTFDescripcion.setRows(5);
        jScrollPane2.setViewportView(jTFDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 260, 190));

        jTFGastoPreliminar.setForeground(new java.awt.Color(0, 0, 0));
        jTFGastoPreliminar.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFGastoPreliminar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFGastoPreliminar.setPlaceholder(" Gasto Preliminar*");
        jPanel1.add(jTFGastoPreliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 260, 40));

        jTFPrecioTotal.setForeground(new java.awt.Color(0, 0, 0));
        jTFPrecioTotal.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFPrecioTotal.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFPrecioTotal.setPlaceholder(" Precio Total*");
        jPanel1.add(jTFPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 260, 40));

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Agregar.png"))); // NOI18N
        btnIngresar.setText("  Ingresar Gasto");
        btnIngresar.setColorHover(new java.awt.Color(204, 204, 204));
        btnIngresar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnIngresar.setColorPressed(new java.awt.Color(255, 255, 255));
        btnIngresar.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnIngresar.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnIngresar.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 210, -1));

        btnBorrarCampos.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_BorrarCampos.png"))); // NOI18N
        btnBorrarCampos.setText("  Borrar Campos");
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
        jPanel1.add(btnBorrarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 210, -1));

        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Iconos_Actualizar.png"))); // NOI18N
        btnModificar.setText("  Modificar Gasto");
        btnModificar.setColorHover(new java.awt.Color(204, 204, 204));
        btnModificar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnModificar.setColorPressed(new java.awt.Color(255, 255, 255));
        btnModificar.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnModificar.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnModificar.setEnabled(false);
        btnModificar.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 210, -1));

        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Eliminar.png"))); // NOI18N
        btnEliminar.setText("  Eliminar Gasto");
        btnEliminar.setColorHover(new java.awt.Color(204, 204, 204));
        btnEliminar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnEliminar.setColorPressed(new java.awt.Color(255, 255, 255));
        btnEliminar.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnEliminar.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnEliminar.setEnabled(false);
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, 210, -1));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Presupuesto", "Gasto Inicial", "Precio Total", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.setAltoHead(30);
        Tabla.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        Tabla.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        Tabla.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        Tabla.setColorSelBackgound(new java.awt.Color(204, 204, 204));
        Tabla.setColorSelForeground(new java.awt.Color(0, 0, 0));
        Tabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Tabla.setFuenteFilas(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tabla.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tabla.setGridColor(new java.awt.Color(0, 0, 0));
        Tabla.setRowHeight(22);
        Tabla.setSelectionBackground(new java.awt.Color(0, 0, 0));
        Tabla.setSelectionForeground(new java.awt.Color(0, 0, 0));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setMinWidth(0);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(1).setMinWidth(0);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(1).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(3).setMinWidth(175);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(175);
            Tabla.getColumnModel().getColumn(3).setMaxWidth(175);
            Tabla.getColumnModel().getColumn(4).setMinWidth(0);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 490, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (jTFGastoPreliminar.getText().isEmpty() || jTFDescripcion.getText().isEmpty() || jTFPrecioTotal.getText().isEmpty()) {
            new frmAlert("Complete todos los campos solicitados", 2).setVisible(true);
        } else {
            var.setPresupuesto(idPresupuesto);
            var.setGastoPreliminar(jTFGastoPreliminar.getText());
            var.setPrecioTotal(Double.parseDouble(jTFPrecioTotal.getText()));
            var.setDescripcion(jTFDescripcion.getText());
            if (var.ingresarPreliminares(var)) {
                cargarTabla();
                actualizarPresupuesto();
                borrarCampos();
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnBorrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCamposActionPerformed
        borrarCampos();
    }//GEN-LAST:event_btnBorrarCamposActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTFGastoPreliminar.getText().isEmpty() || jTFDescripcion.getText().isEmpty() || jTFPrecioTotal.getText().isEmpty()) {
            new frmAlert("Complete todos los campos solicitados", 2).setVisible(true);
        } else {
            var.setPresupuesto(idPresupuesto);
            var.setGastoPreliminar(jTFGastoPreliminar.getText());
            var.setPrecioTotal(Double.parseDouble(jTFPrecioTotal.getText()));
            var.setDescripcion(jTFDescripcion.getText());
            var.setIdGastoPreliminar(idPreliminares);
            if (var.modificarPreliminares(var)) {
                cargarTabla();
                actualizarPresupuesto();
                borrarCampos();
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (idPresupuesto != -1) {
            var.setIdGastoPreliminar(idPreliminares);
            if (var.eliminarPreliminares(var)) {
                cargarTabla();
                actualizarPresupuesto();
                borrarCampos();
            }
        } else {
            new frmAlert("Seleccione el registro que desea eliminar", 2).setVisible(true);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        fila = Tabla.getSelectedRow();
        if (fila != -1) {
            idPreliminares = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
            jTFGastoPreliminar.setText(Tabla.getValueAt(fila, 2).toString());
            jTFPrecioTotal.setText(Tabla.getValueAt(fila, 3).toString());
            jTFDescripcion.setText(Tabla.getValueAt(fila, 4).toString());
            btnIngresar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
        }
    }//GEN-LAST:event_TablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Tabla;
    private LIB.FSButtonMD btnBorrarCampos;
    private LIB.FSButtonMD btnEliminar;
    private LIB.FSButtonMD btnIngresar;
    private LIB.FSButtonMD btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTFDescripcion;
    public static LIB.FSTexFieldMD jTFGastoPreliminar;
    public static LIB.FSTexFieldMD jTFPrecioTotal;
    // End of variables declaration//GEN-END:variables
}
