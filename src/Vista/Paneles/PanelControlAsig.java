/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Clases.ClassFunciones;
import Clases.ClassFuncionesSQL;
import Controlador.MtoAsignaciones;
import RSMaterialComponent.RSCheckBoxMaterial;
import Vista.Frames.frmAlerta;
import Vista.Frames.frmAvanceActividades;
import Vista.Frames.frmBuscador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Castro
 */
public class PanelControlAsig extends javax.swing.JPanel {

    /**
     * Creates new form PanelControlAsig
     */
    public PanelControlAsig() {
        initComponents();
        tb = (DefaultTableModel)Tabla.getModel();
    }

    private static DefaultTableModel tb;
    public static String Proyecto;
    static ClassFuncionesSQL sql = new ClassFuncionesSQL();
    ClassFunciones fun = new ClassFunciones();
    
    MtoAsignaciones  obj = new MtoAsignaciones ();
    
    private int idAsignacion;
    private int estado;
    
    public static void cargarTabla(String proyecto)
    {
        sql.cargarTabla("select * from Vista_Actividades where Nombre_Proyecto = '"+proyecto+"'", tb);
    }
    
    private void borrarCampos()
    {
        idAsignacion = -1;
        jTFProyecto.setText(null);
        jTFAsignacion.setText(null);
        cbNoRealizado.setSelected(false);
        cbProceso.setSelected(false);
        cbRealizado.setSelected(false);
        jTFEncargado.setText(null);
        jDCFechaInicio.setDatoFecha(null);
        jDCFechaFin.setDatoFecha(null);
        jTFDUI.setText(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new rojerusan.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jTFProyecto = new LIB.FSTexFieldMD();
        jTFAsignacion = new LIB.FSTexFieldMD();
        btnAsignacion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFDUI = new LIB.FSTexFieldMD();
        jLabel6 = new javax.swing.JLabel();
        jDCFechaFin = new rojeru_san.rsdate.RSDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDCFechaInicio = new rojeru_san.rsdate.RSDateChooser();
        btnRefrescar = new LIB.FSButtonMD();
        btnActualizar = new LIB.FSButtonMD();
        jSeparator1 = new javax.swing.JSeparator();
        cbProceso = new RSMaterialComponent.RSCheckBoxMaterial();
        cbNoRealizado = new RSMaterialComponent.RSCheckBoxMaterial();
        cbRealizado = new RSMaterialComponent.RSCheckBoxMaterial();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTFEncargado = new LIB.FSTexFieldMD();
        btnReporte = new LIB.FSButtonMD();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel2.setText("Supervision de Actividades");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, 40));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Proyecto", "Asignacion", "Estado", "Encargado", "Inicio", "Fin", "DUI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true
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
        jScrollPane2.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setMinWidth(0);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(1).setMinWidth(0);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(1).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(3).setResizable(false);
            Tabla.getColumnModel().getColumn(7).setMinWidth(0);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 670, 330));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setText("Proyecto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, 30));

        jTFProyecto.setEditable(false);
        jTFProyecto.setForeground(new java.awt.Color(0, 0, 0));
        jTFProyecto.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFProyecto.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFProyecto.setPlaceholder(" Nombre Proyecto*");
        jPanel1.add(jTFProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 250, 40));

        jTFAsignacion.setEditable(false);
        jTFAsignacion.setForeground(new java.awt.Color(0, 0, 0));
        jTFAsignacion.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFAsignacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFAsignacion.setPlaceholder("");
        jPanel1.add(jTFAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 290, 40));

        btnAsignacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        btnAsignacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignacionMouseClicked(evt);
            }
        });
        jPanel1.add(btnAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 120, -1, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Encargado");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, -1, 30));

        jTFDUI.setEditable(false);
        jTFDUI.setForeground(new java.awt.Color(0, 0, 0));
        jTFDUI.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFDUI.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFDUI.setPlaceholder(" DUI Encargado*");
        jPanel1.add(jTFDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, 210, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel6.setText("Estado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, 20));

        jDCFechaFin.setColorBackground(new java.awt.Color(0, 51, 102));
        jDCFechaFin.setColorButtonHover(new java.awt.Color(0, 51, 153));
        jDCFechaFin.setColorForeground(new java.awt.Color(0, 0, 0));
        jDCFechaFin.setEnabled(false);
        jDCFechaFin.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jDCFechaFin.setFuente(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jDCFechaFin.setPlaceholder("");
        jPanel1.add(jDCFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 300, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel11.setText("Fecha Fin");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel9.setText("Fecha Inicio");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 30));

        jDCFechaInicio.setColorBackground(new java.awt.Color(0, 51, 102));
        jDCFechaInicio.setColorButtonHover(new java.awt.Color(0, 51, 153));
        jDCFechaInicio.setColorForeground(new java.awt.Color(0, 0, 0));
        jDCFechaInicio.setEnabled(false);
        jDCFechaInicio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jDCFechaInicio.setFuente(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jDCFechaInicio.setPlaceholder("");
        jPanel1.add(jDCFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 290, 30));

        btnRefrescar.setForeground(new java.awt.Color(0, 0, 0));
        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconEstadistica.png"))); // NOI18N
        btnRefrescar.setText("  Cargar Estadistica");
        btnRefrescar.setColorHover(new java.awt.Color(204, 204, 204));
        btnRefrescar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnRefrescar.setColorPressed(new java.awt.Color(255, 255, 255));
        btnRefrescar.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnRefrescar.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnRefrescar.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 600, 240, -1));

        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconMostrar.png"))); // NOI18N
        btnActualizar.setColorHover(new java.awt.Color(204, 204, 204));
        btnActualizar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnActualizar.setColorPressed(new java.awt.Color(255, 255, 255));
        btnActualizar.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnActualizar.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnActualizar.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 40, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, 230, 20));

        cbProceso.setForeground(new java.awt.Color(0, 0, 51));
        cbProceso.setText(" En proceso");
        cbProceso.setColorCheck(new java.awt.Color(255, 255, 0));
        cbProceso.setColorUnCheck(new java.awt.Color(255, 255, 51));
        cbProceso.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        cbProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProcesoActionPerformed(evt);
            }
        });
        jPanel1.add(cbProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 130, -1));

        cbNoRealizado.setForeground(new java.awt.Color(0, 0, 51));
        cbNoRealizado.setText(" No realizado");
        cbNoRealizado.setColorCheck(new java.awt.Color(153, 0, 51));
        cbNoRealizado.setColorUnCheck(new java.awt.Color(153, 0, 0));
        cbNoRealizado.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        cbNoRealizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNoRealizadoActionPerformed(evt);
            }
        });
        jPanel1.add(cbNoRealizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 140, -1));

        cbRealizado.setForeground(new java.awt.Color(0, 0, 51));
        cbRealizado.setText(" Realizado");
        cbRealizado.setColorCheck(new java.awt.Color(0, 153, 51));
        cbRealizado.setColorUnCheck(new java.awt.Color(102, 153, 0));
        cbRealizado.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        cbRealizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRealizadoActionPerformed(evt);
            }
        });
        jPanel1.add(cbRealizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 120, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Busqueda.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 350, -1, 90));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel7.setText("Actividad");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconActividad.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 50, -1));

        jTFEncargado.setForeground(new java.awt.Color(0, 0, 0));
        jTFEncargado.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFEncargado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFEncargado.setPlaceholder(" Nombre Encargado*");
        jTFEncargado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFEncargadoKeyTyped(evt);
            }
        });
        jPanel1.add(jTFEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 210, 40));

        btnReporte.setForeground(new java.awt.Color(0, 0, 0));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconRegistroMat.png"))); // NOI18N
        btnReporte.setText("    Generar Reporte ");
        btnReporte.setColorHover(new java.awt.Color(204, 204, 204));
        btnReporte.setColorNormal(new java.awt.Color(255, 255, 255));
        btnReporte.setColorPressed(new java.awt.Color(255, 255, 255));
        btnReporte.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnReporte.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnReporte.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        int fila = Tabla.getSelectedRow();
        idAsignacion = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
        jTFProyecto.setText(Tabla.getValueAt(fila, 1).toString());
        jTFAsignacion.setText(Tabla.getValueAt(fila, 2).toString());
        String estado = Tabla.getValueAt(fila, 3).toString();
        switch (estado) 
        {
            case "No realizado":
                validarRadioButton(cbNoRealizado,cbProceso,cbRealizado);
                break;
            case "En proceso":
                validarRadioButton(cbProceso,cbNoRealizado,cbRealizado);
                break;
            default:
                validarRadioButton(cbRealizado,cbProceso,cbNoRealizado);
                break;
        }
        jTFEncargado.setText(Tabla.getValueAt(fila, 4).toString());
        jDCFechaInicio.setDatoFecha(fun.ConvertirFecha(Tabla.getValueAt(fila, 5).toString()));
        jDCFechaFin.setDatoFecha(fun.ConvertirFecha(Tabla.getValueAt(fila, 6).toString()));
        jTFDUI.setText(Tabla.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_TablaMouseClicked

    private void btnAsignacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignacionMouseClicked
        frmBuscador c = new frmBuscador("proyecto",2);
        c.setVisible(true);
    }//GEN-LAST:event_btnAsignacionMouseClicked

    public static String fechaFin;
    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        if (!jTFProyecto.getText().trim().isEmpty()) 
        {
            int[] datos;
            datos = obj.obtenerDatosEstadisticos(sql.getIdentificador("select * from Proyecto where Nombre_Proyecto = '"+jTFProyecto.getText()+"'"));
            fechaFin = obj.obtenerFechaFinalizacion(sql.getIdentificador("select * from Proyecto where Nombre_Proyecto = '"+jTFProyecto.getText()+"'"));
            frmAvanceActividades c = new frmAvanceActividades(datos);
            c.setVisible(true);
        }
        else
        {
            new frmAlerta("Seleccione uno de los proyectos",2).setVisible(true);
        }
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (idAsignacion != -1 || jTFDUI.getText().trim().isEmpty()) 
        {
            if (!cbNoRealizado.isSelected() && !cbProceso.isSelected() && !cbRealizado.isSelected()) 
            {
                JOptionPane.showMessageDialog(null, "Selecciona el estado de asignacion");
            }
            else
            {
                obj.setEstado(estado);
                obj.setEncargado(sql.getIdentificador("select * from Personal where DUI = '"+jTFDUI.getText()+"'"));
                if (obj.modificarEstadoAsignacion(obj, idAsignacion)) 
                {
                    cargarTabla(PanelControlAsig.Proyecto);
                    borrarCampos();
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Selecciona una asignacion");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cbRealizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRealizadoActionPerformed
        validarRadioButton(cbRealizado,cbProceso,cbNoRealizado);
        estado = 3;
    }//GEN-LAST:event_cbRealizadoActionPerformed

    private void cbProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProcesoActionPerformed
        validarRadioButton(cbProceso,cbNoRealizado,cbRealizado);
        estado = 2;
    }//GEN-LAST:event_cbProcesoActionPerformed

    private void cbNoRealizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNoRealizadoActionPerformed
        validarRadioButton(cbNoRealizado,cbProceso,cbRealizado);
        estado = 1;
    }//GEN-LAST:event_cbNoRealizadoActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteActionPerformed

    private void jTFEncargadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFEncargadoKeyTyped
        if (jTFEncargado.getText().length() <= 1) 
        {
            sql.cargarTabla("select * from vista_asignaciones where nombre_proyecto = '"+Proyecto+"'", tb);
        }
    }//GEN-LAST:event_jTFEncargadoKeyTyped

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        if (jTFEncargado.getText().trim().isEmpty()) 
        {
            new frmAlerta("Ingrese el indicio del empleado a buscar",2).setVisible(true);
        }
        else
        {
            if (jTFEncargado.getText().length() > 1) 
            {
                String encargado = "%"+jTFEncargado.getText()+"%";
                sql.busquedaFiltrada(tb, "select * from vista_asignaciones where nombre like '"+encargado+"' and nombre_proyecto = '"+Proyecto+"'");
            }
            else
            {
                sql.cargarTabla("select * from vista_asignaciones where nombre_proyecto = '"+Proyecto+"'", tb);
            }    
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void validarRadioButton(RSCheckBoxMaterial rs1,RSCheckBoxMaterial rs2,RSCheckBoxMaterial rs3)
    {
        rs1.setSelected(true);
        rs2.setSelected(false);
        rs3.setSelected(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Tabla;
    private LIB.FSButtonMD btnActualizar;
    private javax.swing.JLabel btnAsignacion;
    private LIB.FSButtonMD btnRefrescar;
    private LIB.FSButtonMD btnReporte;
    private RSMaterialComponent.RSCheckBoxMaterial cbNoRealizado;
    private RSMaterialComponent.RSCheckBoxMaterial cbProceso;
    private RSMaterialComponent.RSCheckBoxMaterial cbRealizado;
    private rojeru_san.rsdate.RSDateChooser jDCFechaFin;
    private rojeru_san.rsdate.RSDateChooser jDCFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public static LIB.FSTexFieldMD jTFAsignacion;
    public static LIB.FSTexFieldMD jTFDUI;
    public static LIB.FSTexFieldMD jTFEncargado;
    public static LIB.FSTexFieldMD jTFProyecto;
    // End of variables declaration//GEN-END:variables
}
