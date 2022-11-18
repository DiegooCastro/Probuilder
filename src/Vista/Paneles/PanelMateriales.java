/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;
import Clases.ClassFunciones;
import Clases.ClassFuncionesSQL;
import Controlador.MtoGastosMateriales;
import Controlador.MtoPresupuesto;
import Vista.Frames.frmAlerta;
import Vista.Frames.frmBuscador;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class PanelMateriales extends javax.swing.JPanel {

    /**
     * Creates new form PanelMateriales
     * @param proyecto
     */
    public PanelMateriales(String proyecto) {
        initComponents();
        idProyecto = fun.getIdentificador("select * from Proyecto where Nombre_Proyecto = '"+proyecto+"'");
        idPresupuesto = fun.getIdentificador("select * from Presupuesto_Proyecto where Proyecto = '"+idProyecto+"'");
        cargarTabla();
        spModel = new SpinnerNumberModel(0, 0, 0, 1.0);  
        jSPCantidad.setModel(spModel);
    }

    DefaultTableModel modelo;
    MtoGastosMateriales var = new MtoGastosMateriales();
    MtoPresupuesto pre = new MtoPresupuesto();
    ClassFuncionesSQL fun = new ClassFuncionesSQL();
    ClassFunciones func = new ClassFunciones();
    private final int idProyecto;
    private final int idPresupuesto;
    private int idGastoMaterial;
    private int fila;
    
    private int cantidadInicial;
    private int cantidadBodega;
    
    private SpinnerNumberModel spModel;  

    private void cargarTabla()
    {
        modelo = (DefaultTableModel)Tabla.getModel();
        fun.cargarTabla("select * from  Vista_GastoMateriales where presupuesto = '"+idPresupuesto+"'", modelo);
    }
    
    private void actualizarPresupuesto()
    {
        pre.setIdPresupuesto(idPresupuesto);
        pre.setIdProyecto(idProyecto);
        pre.actualizarGastoMaterial(pre);
        pre.actualizarTotales(pre);
    }
    
    private void borrarCampos()
    {
        spModel = new SpinnerNumberModel(0, 0, 0, 1);  
        jSPCantidad.setModel(spModel);
        jTFMaterial.setText(null);
        jTFPrecioUni.setText(null);
        jTFPrecioTotal.setText(null);
        jTFUnidadMedida.setText(null);
        jTFCantidadDisponible.setText(null);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnIngresar.setEnabled(true);
        idGastoMaterial = -1;
        cargarTabla();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSPCantidad = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        btnIngresar = new LIB.FSButtonMD();
        btnBorrarCampos = new LIB.FSButtonMD();
        btnModificar = new LIB.FSButtonMD();
        btnEliminar = new LIB.FSButtonMD();
        jTFPrecioUni = new LIB.FSTexFieldMD();
        jTFMaterial = new LIB.FSTexFieldMD();
        jTFUnidadMedida = new LIB.FSTexFieldMD();
        jTFCantidadDisponible = new LIB.FSTexFieldMD();
        jTFPrecioTotal = new LIB.FSTexFieldMD();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla = new rojerusan.RSTableMetro();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel2.setText("Gastos de Materiales");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconGastosMateriales.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel1.setText("Material");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setText("Precio Unitario $:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel4.setText("Cantidad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel5.setText("Precio Total $:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel7.setText("Unidad Medida");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jSPCantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jSPCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSPCantidadStateChanged(evt);
            }
        });
        jPanel1.add(jSPCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 290, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel8.setText("Disponible");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, 30));

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
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 210, -1));

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
        jPanel1.add(btnBorrarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 220, -1));

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
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 220, -1));

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
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 320, 200, -1));

        jTFPrecioUni.setEditable(false);
        jTFPrecioUni.setForeground(new java.awt.Color(0, 0, 0));
        jTFPrecioUni.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFPrecioUni.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFPrecioUni.setPlaceholder("");
        jPanel1.add(jTFPrecioUni, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 280, 40));

        jTFMaterial.setEditable(false);
        jTFMaterial.setForeground(new java.awt.Color(0, 0, 0));
        jTFMaterial.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFMaterial.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFMaterial.setPlaceholder("");
        jPanel1.add(jTFMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 240, 40));

        jTFUnidadMedida.setEditable(false);
        jTFUnidadMedida.setForeground(new java.awt.Color(0, 0, 0));
        jTFUnidadMedida.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFUnidadMedida.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFUnidadMedida.setPlaceholder("");
        jPanel1.add(jTFUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 280, -1));

        jTFCantidadDisponible.setForeground(new java.awt.Color(0, 0, 0));
        jTFCantidadDisponible.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFCantidadDisponible.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFCantidadDisponible.setPlaceholder("");
        jPanel1.add(jTFCantidadDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 290, -1));

        jTFPrecioTotal.setForeground(new java.awt.Color(0, 0, 0));
        jTFPrecioTotal.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFPrecioTotal.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFPrecioTotal.setPlaceholder("");
        jPanel1.add(jTFPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 290, -1));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Presupuesto", "Material", "Cantidad", "Precio Total", "Unidad", "CantidadBodega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            Tabla.getColumnModel().getColumn(6).setMinWidth(0);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 940, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        frmBuscador mat = new frmBuscador("materiales",2);
        mat.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jSPCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSPCantidadStateChanged
        if (jTFPrecioUni.getText().isEmpty() && Integer.parseInt(jSPCantidad.getValue().toString()) != 0) 
        {
            new frmAlerta("Seleccione un material",2).setVisible(true);
            jSPCantidad.setValue(Integer.parseInt("0"));
        }
        else
        {
            calcularTotal();
        }
    }//GEN-LAST:event_jSPCantidadStateChanged

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        int cantidadUtilizar = Integer.parseInt(jSPCantidad.getValue().toString());
        cantidadBodega = Integer.parseInt(jTFCantidadDisponible.getText());
        var.setDisponible(cantidadBodega - cantidadUtilizar);
        var.setCantidad(cantidadUtilizar);
        var.setMaterial(fun.getIdentificador("select * from Materiales where Nombre_Material = '"+jTFMaterial.getText()+"'"));
        var.setPrecioTotal(Double.parseDouble(jTFPrecioTotal.getText()));
        var.setPresupuesto(idPresupuesto);
        if (var.ingresarGastoMaterial(var)) 
        {
            cargarTabla();
            actualizarPresupuesto();
            borrarCampos();
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnBorrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCamposActionPerformed
        borrarCampos();
    }//GEN-LAST:event_btnBorrarCamposActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int cantidadUtilizar = Integer.parseInt(jSPCantidad.getValue().toString());
        int diferencia = cantidadInicial - cantidadUtilizar;  
        var.setDisponible(cantidadBodega+diferencia);
        var.setCantidad(cantidadUtilizar);
        var.setMaterial(fun.getIdentificador("select * from Materiales where Nombre_Material = '"+jTFMaterial.getText()+"'"));
        var.setPrecioTotal(Double.parseDouble(jTFPrecioTotal.getText()));
        var.setIdMateriales(idGastoMaterial);
        if (var.modificarGastoMaterial(var)) 
        {
            cargarTabla();
            actualizarPresupuesto();
            borrarCampos();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        var.setDisponible(cantidadBodega+cantidadInicial);
        var.setMaterial(fun.getIdentificador("select * from Materiales where Nombre_Material = '"+jTFMaterial.getText()+"'"));
        var.setIdMateriales(idGastoMaterial);
        if (var.eliminarGastoMaterial(var)) 
        {
            cargarTabla();
            actualizarPresupuesto();
            borrarCampos();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        fila = Tabla.getSelectedRow();
        if (fila != -1)
        {
            fila = Tabla.getSelectedRow();
            idGastoMaterial = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
            jTFMaterial.setText(Tabla.getValueAt(fila, 2).toString());
        
            cantidadBodega = Integer.parseInt(Tabla.getValueAt(fila, 6).toString());
            cantidadInicial = Integer.parseInt(Tabla.getValueAt(fila, 3).toString());
        
        
            spModel = new SpinnerNumberModel(cantidadInicial, 1, cantidadBodega+cantidadInicial, 1);  
            jSPCantidad.setModel(spModel);
        
            jTFPrecioUni.setText(String.valueOf(var.getPrecioUnitario(fun.getIdentificador("select * from Materiales where Nombre_Material = '"+jTFMaterial.getText()+"'"))));
            jTFPrecioTotal.setText(Tabla.getValueAt(fila, 4).toString());
            jTFUnidadMedida.setText(Tabla.getValueAt(fila, 5).toString());
            jTFCantidadDisponible.setText(Tabla.getValueAt(fila, 6).toString());
        
            btnIngresar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
        }
    }//GEN-LAST:event_TablaMouseClicked

    private void calcularTotal()
    {
        int cantidad = Integer.parseInt(jSPCantidad.getValue().toString());
        double precioUni = Double.parseDouble(jTFPrecioUni.getText());
        jTFPrecioTotal.setText(func.formatoDecimales(cantidad*precioUni));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Tabla;
    private LIB.FSButtonMD btnBorrarCampos;
    private LIB.FSButtonMD btnEliminar;
    private LIB.FSButtonMD btnIngresar;
    private LIB.FSButtonMD btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JSpinner jSPCantidad;
    private javax.swing.JScrollPane jScrollPane3;
    public static LIB.FSTexFieldMD jTFCantidadDisponible;
    public static LIB.FSTexFieldMD jTFMaterial;
    public static LIB.FSTexFieldMD jTFPrecioTotal;
    public static LIB.FSTexFieldMD jTFPrecioUni;
    public static LIB.FSTexFieldMD jTFUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
