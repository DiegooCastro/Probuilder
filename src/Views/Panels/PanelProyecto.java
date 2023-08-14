package Views.Panels;

import Views.Frames.frmDetalleProyecto;
import Helpers.Funciones;
import Helpers.FuncionesSQL;
import Helpers.Imagen;
import Models.Proyecto;
import Views.Frames.frmAlert;
import Views.Frames.frmBuscador;
import Views.Frames.frmGaleria;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Castro
 */
public class PanelProyecto extends javax.swing.JPanel {

    public PanelProyecto() {
        initComponents();
        modelo = (DefaultTableModel) jTable1.getModel();
        funSQL.cargarTabla("select * from Vista_Proyecto", modelo);
        funSQL.cargarComboBox("select * from Tipo_Proyecto", cmbTipo);
        btnModificar.setEnabled(false);
        idProyecto = -1;
        fun.longitudMaxima(jTFProyecto, 40);

    }

    //Declaracion de objetos de las clases que utilizaremos
    FuncionesSQL funSQL = new FuncionesSQL();
    Funciones fun = new Funciones();
    Imagen img = new Imagen();
    Proyecto pro = new Proyecto();

    //Declaracion de modelo para la tabla del formulario
    DefaultTableModel modelo;

    //Declaracion de atributos para controlar carrusel
    public static String DUI;
    private int[] idImagenes;

    //Declaracion de atributos para uso general
    private int idProyecto;
    private int fila;

    private void cargarTabla() {
        funSQL.cargarTabla("select * from Vista_Proyecto", modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContenedor = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblIconoTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnCliente = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnSupervisor = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTFProyecto = new LIB.FSTexFieldMD();
        cmbTipo = new RSMaterialComponent.RSComboBoxMaterial();
        btnIngresar = new LIB.FSButtonMD();
        btnBorrarCampos = new LIB.FSButtonMD();
        btnModificar = new LIB.FSButtonMD();
        btnImagenes = new LIB.FSButtonMD();
        jTFCliente = new LIB.FSTexFieldMD();
        jTFSupervisor = new LIB.FSTexFieldMD();
        jLabel1 = new javax.swing.JLabel();
        jDateInicio = new rojeru_san.rsdate.RSDateChooser();
        jDateFin = new rojeru_san.rsdate.RSDateChooser();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        PanelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        PanelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("GESTION PROYECTOS");
        PanelContenedor.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 292, 50));

        lblIconoTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/proyecto.png"))); // NOI18N
        PanelContenedor.add(lblIconoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estado", "Nombre Cliente", "Apellido Cliente", "Supervisor", "Tipo Proyecto", "Nombre Proyecto", "Ubicacion", "Descripcion", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAltoHead(30);
        jTable1.setColorBackgoundHead(new java.awt.Color(44, 47, 62));
        jTable1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        jTable1.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        jTable1.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        jTable1.setColorSelBackgound(new java.awt.Color(204, 204, 204));
        jTable1.setColorSelForeground(new java.awt.Color(0, 0, 0));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setFuenteFilas(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(22);
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(6).setMinWidth(150);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(7).setMinWidth(0);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(8).setMinWidth(0);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(9).setMinWidth(0);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(9).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(10).setMinWidth(0);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        PanelContenedor.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 940, 280));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel20.setText("Fecha Fin");
        PanelContenedor.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel21.setText("Fecha Inicio");
        PanelContenedor.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel15.setText("Tipo Proyecto");
        PanelContenedor.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel13.setText("Cliente");
        PanelContenedor.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 30));

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/abrirCatalogo.png"))); // NOI18N
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClienteMouseClicked(evt);
            }
        });
        PanelContenedor.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 168, -1, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel14.setText("Supervisor");
        PanelContenedor.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, 60));

        btnSupervisor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/abrirCatalogo.png"))); // NOI18N
        btnSupervisor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupervisorMouseClicked(evt);
            }
        });
        PanelContenedor.add(btnSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, -1, 60));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel18.setText("Proyecto");
        PanelContenedor.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 30));

        jTFProyecto.setForeground(new java.awt.Color(0, 0, 0));
        jTFProyecto.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFProyecto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jTFProyecto.setPlaceholder(" Nombre Proyecto*");
        PanelContenedor.add(jTFProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 240, 40));

        cmbTipo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        PanelContenedor.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 270, -1));

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/botonAgregar.png"))); // NOI18N
        btnIngresar.setText("  Ingresar Proyecto");
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
        PanelContenedor.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 220, -1));

        btnBorrarCampos.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/botonLimpiar.png"))); // NOI18N
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
        PanelContenedor.add(btnBorrarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 220, -1));

        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/botonActualizar.png"))); // NOI18N
        btnModificar.setText("  Modificar Proyecto");
        btnModificar.setColorHover(new java.awt.Color(204, 204, 204));
        btnModificar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnModificar.setColorPressed(new java.awt.Color(255, 255, 255));
        btnModificar.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnModificar.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnModificar.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        PanelContenedor.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 220, -1));

        btnImagenes.setForeground(new java.awt.Color(0, 0, 0));
        btnImagenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/agregarImagen.png"))); // NOI18N
        btnImagenes.setText("  Visualizar Imagenes");
        btnImagenes.setColorHover(new java.awt.Color(204, 204, 204));
        btnImagenes.setColorNormal(new java.awt.Color(255, 255, 255));
        btnImagenes.setColorPressed(new java.awt.Color(255, 255, 255));
        btnImagenes.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnImagenes.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnImagenes.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        btnImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenesActionPerformed(evt);
            }
        });
        PanelContenedor.add(btnImagenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 220, -1));

        jTFCliente.setEditable(false);
        jTFCliente.setForeground(new java.awt.Color(0, 0, 0));
        jTFCliente.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFCliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jTFCliente.setPlaceholder("");
        PanelContenedor.add(jTFCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 230, 40));

        jTFSupervisor.setEditable(false);
        jTFSupervisor.setForeground(new java.awt.Color(0, 0, 0));
        jTFSupervisor.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFSupervisor.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jTFSupervisor.setPlaceholder("");
        PanelContenedor.add(jTFSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 260, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/configuracion.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        PanelContenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 40, 70));

        jDateInicio.setColorBackground(new java.awt.Color(0, 51, 102));
        jDateInicio.setColorButtonHover(new java.awt.Color(0, 51, 153));
        jDateInicio.setColorForeground(new java.awt.Color(0, 0, 0));
        jDateInicio.setEnabled(false);
        jDateInicio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jDateInicio.setFuente(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jDateInicio.setPlaceholder("");
        PanelContenedor.add(jDateInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 280, 30));

        jDateFin.setColorBackground(new java.awt.Color(0, 51, 102));
        jDateFin.setColorButtonHover(new java.awt.Color(0, 51, 153));
        jDateFin.setColorForeground(new java.awt.Color(0, 0, 0));
        jDateFin.setEnabled(false);
        jDateFin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jDateFin.setFuente(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jDateFin.setPlaceholder("");
        PanelContenedor.add(jDateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 300, 30));
        PanelContenedor.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 450, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSupervisorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupervisorMouseClicked
        frmBuscador c = new frmBuscador("supervisor", 1);
        c.setVisible(true);
    }//GEN-LAST:event_btnSupervisorMouseClicked

    private void btnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseClicked
        frmBuscador c = new frmBuscador("cliente", 1);
        c.setVisible(true);
    }//GEN-LAST:event_btnClienteMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        fila = jTable1.getSelectedRow();
        if (fila != -1) {
            idProyecto = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
            jTFCliente.setText(jTable1.getValueAt(fila, 2).toString() + " " + jTable1.getValueAt(fila, 3).toString());
            jTFSupervisor.setText(jTable1.getValueAt(fila, 4).toString());
            cmbTipo.setSelectedItem(jTable1.getValueAt(fila, 5).toString());
            jTFProyecto.setText(jTable1.getValueAt(fila, 6).toString());
            try {
                frmDetalleProyecto.jTFUbicacion.setText(jTable1.getValueAt(fila, 7).toString());
                frmDetalleProyecto.jTFDescripcion.setText(jTable1.getValueAt(fila, 8).toString());
            } catch (Exception e) {
            }
            jDateInicio.setDatoFecha(fun.ConvertirFecha(jTable1.getValueAt(fila, 9).toString()));
            jDateFin.setDatoFecha(fun.ConvertirFecha(jTable1.getValueAt(fila, 10).toString()));
            idImagenes = img.getIdFotografias(idProyecto);
            btnIngresar.setEnabled(false);
            btnModificar.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (jTFProyecto.getText().trim().isEmpty()) {
            new frmAlert("Complete todos los campos solicitados", 2).setVisible(true);
        } else {
            if (jDateInicio.getDatoFecha().before(jDateFin.getDatoFecha())) {
                fun.separarCliente(jTFCliente, pro);
                pro.setCliente(funSQL.getIdentificador("select * from cliente where Nombre = '" + pro.getNombreCliente() + "' and Apellido = '" + pro.getApellidoCliente() + "' and DUI = '" + DUI + "'"));

                try {
                    if (frmDetalleProyecto.jTFDescripcion.getText() != null || frmDetalleProyecto.jTFUbicacion.getText() != null) {
                        pro.setDescripcion(frmDetalleProyecto.jTFDescripcion.getText());
                        pro.setUbicacion(frmDetalleProyecto.jTFUbicacion.getText());
                    } else {
                        pro.setDescripcion(null);
                        pro.setUbicacion(null);
                    }
                } catch (Exception e) {
                    System.out.println("Detalle proyecto vacio!!!");
                }
                pro.setFechaFin(jDateFin.getDatoFecha());
                pro.setFechaInicio(jDateInicio.getDatoFecha());
                pro.setProyecto(jTFProyecto.getText());
                pro.setSupervisor(funSQL.getIdentificador("select * from Usuario where Usuario = '" + jTFSupervisor.getText() + "'"));
                pro.setTipo(cmbTipo.getSelectedIndex() + 1);
                pro.setEstado(1);
                if (pro.ingresarProyecto(pro)) {
                    cargarTabla();
                    borrarCampos();
                }
            } else {
                new frmAlert("Ingresa fecha inicio menor a la final", 4).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnBorrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCamposActionPerformed
        borrarCampos();
        cargarTabla();
    }//GEN-LAST:event_btnBorrarCamposActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTFProyecto.getText().trim().isEmpty()) {
            new frmAlert("Complete todos los campos solicitados", 2).setVisible(true);
        } else {
            if (jDateInicio.getDatoFecha().before(jDateFin.getDatoFecha())) {
                try {
                    if (frmDetalleProyecto.jTFDescripcion.getText() != null || frmDetalleProyecto.jTFUbicacion.getText() != null) {
                        pro.setDescripcion(frmDetalleProyecto.jTFDescripcion.getText());
                        pro.setUbicacion(frmDetalleProyecto.jTFUbicacion.getText());
                    } else {
                        pro.setDescripcion(null);
                        pro.setUbicacion(null);
                    }
                } catch (Exception e) {
                    System.out.println("Detalle proyecto vacio!!!");
                }

                fun.separarCliente(jTFCliente, pro);
                pro.setCliente(funSQL.getIdentificador("select * from cliente where Nombre = '" + pro.getNombreCliente() + "' and Apellido = '" + pro.getApellidoCliente() + "' or DUI = '" + DUI + "'"));
                pro.setFechaFin(fun.obtenerFecha(jDateFin));
                pro.setFechaInicio(fun.obtenerFecha(jDateInicio));
                pro.setProyecto(jTFProyecto.getText());
                pro.setSupervisor(funSQL.getIdentificador("select * from Usuario where Usuario = '" + jTFSupervisor.getText() + "'"));
                pro.setTipo(cmbTipo.getSelectedIndex() + 1);
                pro.setId(idProyecto);
                pro.setEstado(1);

                if (pro.modificarProyecto(pro)) {
                    cargarTabla();
                    borrarCampos();
                }
            } else {
                new frmAlert("Ingresa fecha inicio menor a la final", 4).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenesActionPerformed
        if (idProyecto != -1) {
            frmGaleria c = new frmGaleria(idImagenes, idProyecto);
            c.setVisible(true);
        } else {
            new frmAlert("Debes seleccionar un proyecto", 2).setVisible(true);
        }
    }//GEN-LAST:event_btnImagenesActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        frmDetalleProyecto c = new frmDetalleProyecto();
        c.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void borrarCampos() {
        cmbTipo.setSelectedIndex(-1);
        jTFSupervisor.setText(null);
        jTFProyecto.setText(null);
        jTFCliente.setText(null);
        jDateInicio.setDatoFecha(null);
        jDateFin.setDatoFecha(null);
        try {
            frmDetalleProyecto.jTFDescripcion.setText(null);
            frmDetalleProyecto.jTFUbicacion.setText(null);
        } catch (Exception e) {
            System.out.println("No esta abierto el panel de detalle!!!");
        }
        btnModificar.setEnabled(false);
        btnIngresar.setEnabled(true);
        idProyecto = -1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContenedor;
    private LIB.FSButtonMD btnBorrarCampos;
    private javax.swing.JLabel btnCliente;
    private LIB.FSButtonMD btnImagenes;
    private LIB.FSButtonMD btnIngresar;
    private LIB.FSButtonMD btnModificar;
    private javax.swing.JLabel btnSupervisor;
    private RSMaterialComponent.RSComboBoxMaterial cmbTipo;
    private rojeru_san.rsdate.RSDateChooser jDateFin;
    private rojeru_san.rsdate.RSDateChooser jDateInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public static LIB.FSTexFieldMD jTFCliente;
    private LIB.FSTexFieldMD jTFProyecto;
    public static LIB.FSTexFieldMD jTFSupervisor;
    private rojerusan.RSTableMetro jTable1;
    private javax.swing.JLabel lblIconoTitulo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
