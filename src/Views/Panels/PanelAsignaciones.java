/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Panels;

import Helpers.Consulta;
import Helpers.Funciones;
import Helpers.FuncionesSQL;
import Models.Asignaciones;
import Models.Presupuesto;
import Views.Frames.frmAlert;
import Views.Frames.frmCatalogoMini;
import Views.Frames.frmBuscador;
import java.sql.Date;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class PanelAsignaciones extends javax.swing.JPanel {

    /**
     * Creates new form PanelAsignaciones
     *
     * @param proyecto
     */
    public PanelAsignaciones(String proyecto) {
        initComponents();
        jTFProyecto.setText(proyecto);
        idProyecto = funSQL.getIdentificador(consulta.consultarIdProyecto(proyecto));
        idPresupuesto = funSQL.getIdentificador(consulta.consultarIdPresupuesto(idProyecto));
        modelo = (DefaultTableModel) Tabla.getModel();
        this.proyecto = proyecto;
        cargarTabla();
        jTF[0] = jTFAsignacion;
        jTF[1] = jTFTotal;
        jTF[2] = jTFSueldo;
        jTF[3] = jTFTotal;
        jTF[4] = jTFEncargado;
    }

    JTextField[] jTF = new JTextField[5];

    /**
     * Metodo para cargar los datos en la tabla
     */
    private void cargarTabla() {
        funSQL.cargarTabla(consulta.queryTablaAsignaciones(proyecto), modelo);
    }

    private DefaultTableModel modelo;

    //Declaracion de objetos de las clases
    Consulta consulta = new Consulta();
    Presupuesto pre = new Presupuesto();
    FuncionesSQL funSQL = new FuncionesSQL();
    Funciones fun = new Funciones();
    Asignaciones asig = new Asignaciones();

    //Declaracion de atributos de la clase
    public static String DUI;
    private String proyecto;
    private int idProyecto;
    private int idPresupuesto;
    private int fila;
    private int id;

    private void calcularSueldoTotal() {
        if (jDCFechaFin.getDatoFecha() == null || jDCFechaInicio.getDatoFecha() == null || jTFEncargado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el encargado y rangos de fechas para calcular el pago total");
        } else {
            if (jDCFechaInicio.getDatoFecha().compareTo(jDCFechaFin.getDatoFecha()) < 0) {
                try {
                    fun.separarEncargado(jTFEncargado, asig);
                    int idPersonal = funSQL.getIdentificador("select * from Personal where Nombre = '" + asig.getNombre() + "' and Apellido = '" + asig.getApellido() + "' and DUI = '" + DUI + "'");
                    Date fechaInicio = fun.obtenerFecha(jDCFechaInicio);
                    Date fechaFin = fun.obtenerFecha(jDCFechaFin);
                    DecimalFormat f = new DecimalFormat("###,###.##");
                    jTFTotal.setText(f.format(funSQL.obtenerPagoTotal(idPersonal, fechaInicio, fechaFin)));
                } catch (Exception e) {
                    System.out.println(e);
                    jTFTotal.setText("0");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fecha inicial mayor a la final");
            }
        }
    }

    private void borrarCampos() {
        fun.borrarCampos(jTF);
        cmbEstado.setSelectedIndex(0);
        btnIngresar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        jDCFechaInicio.setDatoFecha(null);
        jDCFechaFin.setDatoFecha(null);
        cargarTabla();
        id = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnEncargado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCalcular = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAsignacion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFSueldo = new LIB.FSTexFieldMD();
        jTFTotal = new LIB.FSTexFieldMD();
        jTFAsignacion = new LIB.FSTexFieldMD();
        jTFProyecto = new LIB.FSTexFieldMD();
        cmbEstado = new RSMaterialComponent.RSComboBoxMaterial();
        jTFEncargado = new LIB.FSTexFieldMD();
        btnIngresar = new LIB.FSButtonMD();
        btnBorrarCampos = new LIB.FSButtonMD();
        btnModificar = new LIB.FSButtonMD();
        btnEliminar = new LIB.FSButtonMD();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new rojerusan.RSTableMetro();
        jDCFechaFin = new rojeru_san.rsdate.RSDateChooser();
        jDCFechaInicio = new rojeru_san.rsdate.RSDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEncargado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        btnEncargado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEncargadoMouseClicked(evt);
            }
        });
        jPanel2.add(btnEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, -1, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel5.setText("Encargado");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel9.setText("Fecha Inicio");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel11.setText("Fecha Fin");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, 30));

        lblCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconCalcular (2).png"))); // NOI18N
        lblCalcular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCalcularMouseClicked(evt);
            }
        });
        jPanel2.add(lblCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 310, 30, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel12.setText("Pago Total $:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel4.setText("Asignacion");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        btnAsignacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        btnAsignacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignacionMouseClicked(evt);
            }
        });
        jPanel2.add(btnAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setText("Proyecto");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel7.setText("Estado");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel6.setText("Sueldo $:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jTFSueldo.setEditable(false);
        jTFSueldo.setForeground(new java.awt.Color(0, 0, 0));
        jTFSueldo.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFSueldo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFSueldo.setPlaceholder("");
        jPanel2.add(jTFSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 280, 40));

        jTFTotal.setEditable(false);
        jTFTotal.setForeground(new java.awt.Color(0, 0, 0));
        jTFTotal.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFTotal.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFTotal.setPlaceholder("");
        jPanel2.add(jTFTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 250, 40));

        jTFAsignacion.setEditable(false);
        jTFAsignacion.setForeground(new java.awt.Color(0, 0, 0));
        jTFAsignacion.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFAsignacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFAsignacion.setPlaceholder("");
        jPanel2.add(jTFAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 250, 40));

        jTFProyecto.setEditable(false);
        jTFProyecto.setForeground(new java.awt.Color(0, 0, 0));
        jTFProyecto.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFProyecto.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFProyecto.setPlaceholder(" Nombre Proyecto*");
        jPanel2.add(jTFProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 280, 40));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No realizada", "Realizada", " " }));
        cmbEstado.setEnabled(false);
        cmbEstado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel2.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 270, -1));

        jTFEncargado.setEditable(false);
        jTFEncargado.setForeground(new java.awt.Color(0, 0, 0));
        jTFEncargado.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFEncargado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFEncargado.setPlaceholder("");
        jPanel2.add(jTFEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 240, 40));

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Agregar.png"))); // NOI18N
        btnIngresar.setText("  Ingresar Asignacion");
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
        jPanel2.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 220, -1));

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
        jPanel2.add(btnBorrarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 220, -1));

        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Iconos_Actualizar.png"))); // NOI18N
        btnModificar.setText("  Modificar Asignacion");
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
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 220, -1));

        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Eliminar.png"))); // NOI18N
        btnEliminar.setText("  Eliminar Asignacion");
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
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, 220, -1));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Proyecto", "Asignacion", "Estado", "Nombre", "Apellido", "Inicio", "Fin", "Sueldo", "Pago", "DUI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
            Tabla.getColumnModel().getColumn(8).setMinWidth(0);
            Tabla.getColumnModel().getColumn(8).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(8).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(9).setMinWidth(0);
            Tabla.getColumnModel().getColumn(9).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(9).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(10).setMinWidth(0);
            Tabla.getColumnModel().getColumn(10).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 920, 170));

        jDCFechaFin.setColorBackground(new java.awt.Color(0, 51, 102));
        jDCFechaFin.setColorButtonHover(new java.awt.Color(0, 51, 153));
        jDCFechaFin.setColorForeground(new java.awt.Color(0, 0, 0));
        jDCFechaFin.setEnabled(false);
        jDCFechaFin.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jDCFechaFin.setFuente(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jDCFechaFin.setPlaceholder("Seleccione la fecha");
        jPanel2.add(jDCFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 290, 30));

        jDCFechaInicio.setColorBackground(new java.awt.Color(0, 51, 102));
        jDCFechaInicio.setColorButtonHover(new java.awt.Color(0, 51, 153));
        jDCFechaInicio.setColorForeground(new java.awt.Color(0, 0, 0));
        jDCFechaInicio.setEnabled(false);
        jDCFechaInicio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jDCFechaInicio.setFuente(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jDCFechaInicio.setPlaceholder("Seleccione la fecha");
        jPanel2.add(jDCFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 290, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel8.setText("Asignacion actividades");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconManoObra.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignacionMouseClicked
        frmCatalogoMini c = new frmCatalogoMini("asignaciones", 1);
        c.setVisible(true);
    }//GEN-LAST:event_btnAsignacionMouseClicked

    private void btnEncargadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEncargadoMouseClicked
        frmBuscador c = new frmBuscador("encargado", 2);
        c.setVisible(true);
    }//GEN-LAST:event_btnEncargadoMouseClicked

    private void actualizarPresupuesto() {
        pre.setIdPresupuesto(idPresupuesto);
        pre.setIdProyecto(idProyecto);
        pre.actualizarManoObra(pre);
        pre.actualizarTotales(pre);
    }

    private void lblCalcularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCalcularMouseClicked
        calcularSueldoTotal();
    }//GEN-LAST:event_lblCalcularMouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (jTFEncargado.getText().trim().isEmpty() || jTFAsignacion.getText().trim().isEmpty()) {
            new frmAlert("Complete todos los campos solicitados", 2).setVisible(true);
        } else {
            if (jDCFechaInicio.getDatoFecha().before(jDCFechaFin.getDatoFecha())) {
                if (!jTFTotal.getText().trim().isEmpty()) {
                    fun.separarEncargado(jTFEncargado, asig);
                    asig.setAsignacion(funSQL.getIdentificador("select * from Asignaciones where Asignacion = '" + jTFAsignacion.getText() + "'"));
                    asig.setEncargado(funSQL.getIdentificador("select * from Personal where Nombre = '" + asig.getNombre() + "' and Apellido = '" + asig.getApellido() + "' and DUI = '" + DUI + "'"));
                    asig.setEstado(cmbEstado.getSelectedIndex() + 1);
                    asig.setProyecto(idProyecto);
                    asig.setFechaInicio(fun.obtenerFecha(jDCFechaInicio));
                    asig.setFechaFin(fun.obtenerFecha(jDCFechaFin));
                    asig.setGastoTotal(Double.parseDouble(jTFTotal.getText().replaceAll("\\,", "")));
                    if (asig.ingresarAsignacion(asig));
                    {
                        actualizarPresupuesto();
                        cargarTabla();
                        borrarCampos();
                    }
                } else {
                    new frmAlert("Calcule el gasto total a pagar", 2).setVisible(true);
                }
            } else {
                new frmAlert("La fecha inicial es mayor a la fecha final", 2).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnBorrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCamposActionPerformed
        borrarCampos();
    }//GEN-LAST:event_btnBorrarCamposActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTFEncargado.getText().trim().isEmpty() || jTFAsignacion.getText().trim().isEmpty() || id == -1) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        } else {
            if (jDCFechaInicio.getDatoFecha().before(jDCFechaFin.getDatoFecha())) {
                if (!jTFTotal.getText().trim().isEmpty()) {
                    fun.separarEncargado(jTFTotal, asig);
                    calcularSueldoTotal();
                    asig.setAsignacion(funSQL.getIdentificador("select * from Asignaciones where Asignacion = '" + jTFAsignacion.getText() + "'"));
                    asig.setEncargado(funSQL.getIdentificador("select * from Personal where Nombre = '" + asig.getNombre() + "' and Apellido = '" + asig.getApellido() + "' and DUI = '" + DUI + "'"));
                    asig.setEstado(cmbEstado.getSelectedIndex() + 1);
                    asig.setProyecto(idProyecto);
                    asig.setFechaInicio(fun.obtenerFecha(jDCFechaInicio));
                    asig.setFechaFin(fun.obtenerFecha(jDCFechaFin));
                    asig.setGastoTotal(Double.parseDouble(jTFTotal.getText().replaceAll("\\,", "")));
                    if (asig.modificarAsignacion(asig, id)) {
                        actualizarPresupuesto();
                        cargarTabla();
                        borrarCampos();
                    }
                } else {
                    new frmAlert("Calcule el gasto total a pagar", 2).setVisible(true);
                }
            } else {
                new frmAlert("La fecha inicial es mayor a la fecha final", 2).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (id == -1) {
            new frmAlert("Debes seleccionar el registro que deseas eliminar", 2).setVisible(true);
        } else {
            if (asig.eliminarAsignacion(id)) {
                actualizarPresupuesto();
                cargarTabla();
                borrarCampos();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        fila = Tabla.getSelectedRow();
        if (fila != -1) {
            id = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
            jTFProyecto.setText(Tabla.getValueAt(fila, 1).toString());
            jTFAsignacion.setText(Tabla.getValueAt(fila, 2).toString());
            cmbEstado.setSelectedItem(Tabla.getValueAt(fila, 3).toString());
            jTFEncargado.setText(Tabla.getValueAt(fila, 4).toString() + " " + Tabla.getValueAt(fila, 5).toString());
            jDCFechaInicio.setDatoFecha(fun.ConvertirFecha(Tabla.getValueAt(fila, 6).toString()));
            jDCFechaFin.setDatoFecha(fun.ConvertirFecha(Tabla.getValueAt(fila, 7).toString()));
            jTFSueldo.setText(Tabla.getValueAt(fila, 8).toString());
            jTFTotal.setText(Tabla.getValueAt(fila, 9).toString());
            DUI = Tabla.getValueAt(fila, 10).toString();
            btnIngresar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
        }
    }//GEN-LAST:event_TablaMouseClicked

    public PanelAsignaciones() {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Tabla;
    private javax.swing.JLabel btnAsignacion;
    private LIB.FSButtonMD btnBorrarCampos;
    private LIB.FSButtonMD btnEliminar;
    private javax.swing.JLabel btnEncargado;
    private LIB.FSButtonMD btnIngresar;
    private LIB.FSButtonMD btnModificar;
    private RSMaterialComponent.RSComboBoxMaterial cmbEstado;
    private rojeru_san.rsdate.RSDateChooser jDCFechaFin;
    private rojeru_san.rsdate.RSDateChooser jDCFechaInicio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static LIB.FSTexFieldMD jTFAsignacion;
    public static LIB.FSTexFieldMD jTFEncargado;
    public static LIB.FSTexFieldMD jTFProyecto;
    public static LIB.FSTexFieldMD jTFSueldo;
    public static LIB.FSTexFieldMD jTFTotal;
    private javax.swing.JLabel lblCalcular;
    // End of variables declaration//GEN-END:variables
}
