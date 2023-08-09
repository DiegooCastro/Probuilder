/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Frames;

import Helpers.FuncionesSQL;
import Models.GastosMateriales;
import Models.Presupuesto;
import FiveCodMover.FiveCodMoverJFrame;
import static Views.Frames.frmMenuPrincipal.lblConPresupuesto;
import Views.Panels.PanelAsignaciones;
import Views.Panels.PanelCliente;
import Views.Panels.PanelMateriales;
import Views.Panels.PanelPresupuesto;
import Views.Panels.PanelProyecto;
import Views.Panels.PanelRegistroCompras;
import Views.Panels.PanelUsuario;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Castro
 */
public class frmBuscador extends javax.swing.JFrame {

    /**
     * Creates new form frmBuscador
     *
     * @param formulario
     */
    public frmBuscador(String formulario, int caso) {
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.formulario = formulario;
        tb = (DefaultTableModel) Tabla.getModel();
        cargarDatosTabla(this.formulario);
        this.caso = caso;
    }

    //Declaracion de objetos de la clase
    GastosMateriales mat = new GastosMateriales();
    Presupuesto obj = new Presupuesto();
    FuncionesSQL fun = new FuncionesSQL();

    //Declaracion de atributos de la clase   
    private DefaultTableModel tb;
    private String formulario;
    private int fila;
    private int caso;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        PanelSuperior = new javax.swing.JPanel();
        lblMinimizar = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblCampo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTFCampo1 = new LIB.FSTexFieldMD();
        jTFCampo2 = new LIB.FSTexFieldMD();
        lblCampo2 = new javax.swing.JLabel();
        btnSeleccionarRegistro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelSuperior.setBackground(new java.awt.Color(33, 50, 66));
        PanelSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelSuperiorMouseDragged(evt);
            }
        });
        PanelSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelSuperiorMousePressed(evt);
            }
        });

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Boton-Minimizar.png"))); // NOI18N

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Boton-Cerrar.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelSuperiorLayout = new javax.swing.GroupLayout(PanelSuperior);
        PanelSuperior.setLayout(PanelSuperiorLayout);
        PanelSuperiorLayout.setHorizontalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        PanelSuperiorLayout.setVerticalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblMinimizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCerrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelPrincipal.add(PanelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, -1));

        lblCampo1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblCampo1.setText("Campo 1");
        PanelPrincipal.add(lblCampo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_SmallBusqueda.png"))); // NOI18N
        PanelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 30, 35));

        jTFCampo1.setForeground(new java.awt.Color(0, 0, 0));
        jTFCampo1.setBordeColorFocus(new java.awt.Color(0, 51, 51));
        jTFCampo1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jTFCampo1.setPlaceholder("");
        jTFCampo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCampo1KeyTyped(evt);
            }
        });
        PanelPrincipal.add(jTFCampo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 200, 40));

        jTFCampo2.setForeground(new java.awt.Color(0, 0, 0));
        jTFCampo2.setBordeColorFocus(new java.awt.Color(0, 51, 51));
        jTFCampo2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jTFCampo2.setPlaceholder("");
        jTFCampo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCampo2KeyTyped(evt);
            }
        });
        PanelPrincipal.add(jTFCampo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 240, 40));

        lblCampo2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblCampo2.setText("Campo 2");
        PanelPrincipal.add(lblCampo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 50));

        btnSeleccionarRegistro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeleccionarRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Seleccionar.png"))); // NOI18N
        btnSeleccionarRegistro.setText("Seleccionar Registro");
        btnSeleccionarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarRegistroActionPerformed(evt);
            }
        });
        PanelPrincipal.add(btnSeleccionarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 230, 40));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setResizable(false);
            Tabla.getColumnModel().getColumn(2).setResizable(false);
            Tabla.getColumnModel().getColumn(3).setResizable(false);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        PanelPrincipal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 410, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para cargar los datos en la cabecera de la tabla
     *
     * @param cabecera matriz con los datos que se ingresaran en la tabla
     */
    private void cargarCabecera(String cabecera[], String campo1, String campo2) {
        for (String cabecera1 : cabecera) {
            tb.addColumn(cabecera1);
        }
        lblCampo1.setText(campo1);
        lblCampo2.setText(campo2);
    }

    /**
     * Metodo para completar las columnas de la tabla y cargar los
     * correspondientes datos
     *
     * @param formulario nombre del formulario para identificar desde que
     * formulario se accedio
     */
    private void cargarDatosTabla(String formulario) {
        tb.setRowCount(0);
        tb.setColumnCount(0);

        switch (formulario) {
            case "cliente":
                String cabecera[] = {"Nombre", "Apellido", "DUI"};
                cargarCabecera(cabecera, "Nombre Cliente", "DUI");
                fun.cargarTabla("select Nombre,Apellido,DUI from Cliente", tb);
                break;

            case "encargado":
                String cabecera2[] = {"Nombre", "Apellido", "DUI", "Salario"};
                cargarCabecera(cabecera2, "Encargado", "DUI");
                fun.cargarTabla("select Nombre,Apellido,DUI,Sueldo from Personal", tb);
                break;

            case "materiales":
                String cabecera3[] = {"Material", "Unidad", "Estado", "Disponible"};
                cargarCabecera(cabecera3, "Material", "Estado");
                fun.cargarTabla("select Nombre_Material,u.Unidad_Medida,m.Estado,Cantidad_Disponible from Materiales m, Unidad_Medida u where m.Unidad = u.Id_UnidadMedida ", tb);
                break;

            case "proyecto":
                String cabecera4[] = {"Proyecto", "Cliente"};
                cargarCabecera(cabecera4, "Cliente", "Proyecto");
                fun.cargarTabla("select Nombre_Proyecto,concat(c.Nombre ,' ',c.Apellido) as Cliente from proyecto p,Cliente c where p.Cliente = c.Id_Cliente", tb);
                break;

            case "supervisor":
                String cabecera6[] = {"Usuario", "Nombre", "DUI"};
                cargarCabecera(cabecera6, "Usuario", "Nombre");
                fun.cargarTabla("select Usuario,concat(p.Nombre,' ',p.Apellido) as Nombre,DUI from Usuario u,Personal p where u.trabajador = p.id_personal", tb);
                break;

            case "empresa":
                String cabecera7[] = {"Empresa", "Telefono", "Correo"};
                cargarCabecera(cabecera7, "Empresa", "Telefono");
                if (caso == 1) {
                    fun.cargarTabla("select Nombre,Telefono,Correo from Empresa ", tb);
                } else {
                    fun.cargarTabla("select Nombre,Telefono,Correo from Empresa where Tipo = 2 ", tb);
                }
                break;
        }
    }

    /**
     * Metodo para cargar los datos en los textfields al seleccionar una fila de
     * la tabla
     *
     * @param formulario formulario para saber que datos se necesitaran
     */
    private void seleccionarTabla(String formulario) {
        fila = Tabla.getSelectedRow();
        if (fila != -1) {
            switch (formulario) {
                case "cliente":
                    jTFCampo1.setText(Tabla.getValueAt(fila, 0).toString() + " " + Tabla.getValueAt(fila, 1).toString());
                    jTFCampo2.setText(Tabla.getValueAt(fila, 2).toString());
                    break;

                case "encargado":
                    jTFCampo1.setText(Tabla.getValueAt(fila, 0).toString() + " " + Tabla.getValueAt(fila, 1).toString());
                    jTFCampo2.setText(Tabla.getValueAt(fila, 2).toString());
                    break;

                case "materiales":
                    jTFCampo1.setText(Tabla.getValueAt(fila, 0).toString());
                    jTFCampo2.setText(Tabla.getValueAt(fila, 2).toString());
                    break;

                case "proyecto":
                    jTFCampo1.setText(Tabla.getValueAt(fila, 1).toString());
                    jTFCampo2.setText(Tabla.getValueAt(fila, 0).toString());
                    break;

                case "seguro":
                    jTFCampo1.setText(Tabla.getValueAt(fila, 2).toString());
                    jTFCampo2.setText(Tabla.getValueAt(fila, 0).toString());
                    break;

                case "supervisor":
                    jTFCampo1.setText(Tabla.getValueAt(fila, 0).toString());
                    jTFCampo2.setText(Tabla.getValueAt(fila, 1).toString());
                    break;

                case "empresa":
                    jTFCampo1.setText(Tabla.getValueAt(fila, 0).toString());
                    jTFCampo2.setText(Tabla.getValueAt(fila, 1).toString());
                    break;
            }
        }
    }

    /**
     * Metodo para realizar una busqueda filtrada en los buscadores
     *
     * @param formulario formulario para saber que dato debe
     * buscarse(Distincion)
     */
    private void busquedaFiltrada(String formulario) {
        if (jTFCampo2.getText().length() > 1 || jTFCampo1.getText().length() > 1) {
            switch (formulario) {
                case "cliente":
                    String dui = "%" + jTFCampo2.getText() + "%";
                    fun.busquedaFiltrada(tb, "select Nombre,Apellido,DUI from Vista_Cliente where DUI like '" + dui + "'");
                    break;

                case "encargado":
                    String dui1 = "%" + jTFCampo2.getText() + "%";
                    fun.busquedaFiltrada(tb, "select Nombre,Apellido,DUI,Sueldo from Personal where DUI like '" + dui1 + "'");
                    break;

                case "materiales":
                    String material = "%" + jTFCampo1.getText() + "%";
                    fun.busquedaFiltrada(tb, "select Nombre_Material,u.Unidad_Medida,e.Estado_Material,Cantidad_Disponible from Materiales m, Unidad_Medida u,Estado_Materiales e where m.Unidad = u.Id_UnidadMedida and e.Id_EstadoMateriales = m.Estado and Nombre_Material like '" + material + "'");
                    break;

                case "proyecto":
                    String proyecto = "%" + jTFCampo2.getText() + "%";
                    fun.busquedaFiltrada(tb, "select Nombre_Proyecto,concat(c.Nombre ,' ',c.Apellido) as Cliente from proyecto p,Cliente c where p.Cliente = c.Id_Cliente and Nombre_Proyecto like '" + proyecto + "'");
                    break;

                case "seguro":
                    String seguro = "%" + jTFCampo2.getText() + "%";
                    fun.busquedaFiltrada(tb, "select Seguro,s.Costo,d.Duracion from Seguro s,Duracion_Seguro d where d.Id_Duracion = s.Duracion and Seguro like '" + seguro + "'");
                    break;

                case "supervisor":
                    String supervisor = "%" + jTFCampo1.getText() + "%";
                    fun.busquedaFiltrada(tb, "select Usuario,concat(p.Nombre,' ',p.Apellido) as Nombre,DUI from Usuario u,Personal p and Usuario like '" + supervisor + "'");
                    break;

                case "empresa":
                    String empresa = "%" + jTFCampo1.getText() + "%";
                    if (caso == 1) {
                        fun.busquedaFiltrada(tb, "select Nombre_Empresa,Telefono,Correo_Empresa from Empresa where Nombre_Empresa like '" + empresa + "'");
                    } else {
                        fun.busquedaFiltrada(tb, "select Nombre_Empresa,Telefono,Correo_Empresa from Empresa where like '" + empresa + "'");
                    }
                    break;
            }
        } else {
            cargarDatosTabla(formulario);
        }
    }

    /**
     * Metodo prara escribir registro en textfield segun el formulario desde el
     * que se accedio
     *
     * @param dato cadena de texto que se colocara en el textfield del otro form
     * @param formulario formulario en el cual se ingresaran los datos
     * (Distincion)
     */
    private void seleccionarRegistro(String formulario) {
        if (jTFCampo1.getText().trim().isEmpty() || jTFCampo2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        } else {
            switch (formulario) {
                case "cliente":
                    PanelProyecto.jTFCliente.setText(Tabla.getValueAt(fila, 0).toString() + " " + Tabla.getValueAt(fila, 1).toString());
                    PanelProyecto.DUI = Tabla.getValueAt(fila, 2).toString();
                    break;

                case "encargado":
                    String nombre = Tabla.getValueAt(fila, 0).toString();
                    String apellido = Tabla.getValueAt(fila, 1).toString();
                    String dui = Tabla.getValueAt(fila, 2).toString();
                    String salario = Tabla.getValueAt(fila, 3).toString();
                    if (caso == 1) {
                        PanelUsuario.jTFTrabajador.setText(nombre + " " + apellido);
                        PanelUsuario.jTFDUI.setText(dui);
                    } else {
                        PanelAsignaciones.DUI = dui;
                        PanelAsignaciones.jTFSueldo.setText(salario);
                        PanelAsignaciones.jTFEncargado.setText(nombre + " " + apellido);
                    }
                    break;

                case "materiales":
                    String material = Tabla.getValueAt(fila, 0).toString();
                    String unidad = Tabla.getValueAt(fila, 1).toString();
                    String disponible = Tabla.getValueAt(fila, 3).toString();
                    if (caso == 1) {
                        PanelRegistroCompras.jTFMaterial.setText(material);
                        PanelRegistroCompras.jTFUnidad.setText(unidad);
                    } else {
                        if (!"Agotado".equals(Tabla.getValueAt(fila, 2).toString())) {
                            PanelMateriales.jTFMaterial.setText(material);
                            PanelMateriales.jTFCantidadDisponible.setText(disponible);
                            PanelMateriales.jTFUnidadMedida.setText(unidad);
                            SpinnerNumberModel spModel = new SpinnerNumberModel(1, 1, Integer.parseInt(disponible), 1);
                            PanelMateriales.jSPCantidad.setModel(spModel);
                        } else {
                            JOptionPane.showMessageDialog(null, "No puedes seleccionar un material agotado");
                        }
                    }
                    break;

                case "proyecto":
                    String proyecto = Tabla.getValueAt(fila, 0).toString();
                    if (caso == 1) {
                        PanelPresupuesto.jTFProyecto.setText(proyecto);
                        frmMenuPrincipal.nombreProyecto = proyecto;
                        obj.setIdProyecto(fun.getIdentificador("select * from Proyecto where Nombre_Proyecto = '" + proyecto + "'"));
                        PanelPresupuesto.idProyecto = obj.getIdProyecto();
                        obj.cargarPresupuesto(obj);
                        lblConPresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconDesbloqueado.png")));
                        frmMenuPrincipal.lblConPresupuesto.setVisible(true);
                        PanelPresupuesto.datos = obj.cargarPresupuesto(obj);
                    }
                    break;

                case "supervisor":
                    String usuario = Tabla.getValueAt(fila, 0).toString();
                    PanelProyecto.jTFSupervisor.setText(usuario);
                    break;

                case "empresa":
                    String empresa = Tabla.getValueAt(fila, 0).toString();
                    if (caso == 1) {
                        PanelCliente.jTFEmpresa.setText(empresa);
                    } else {
                        PanelRegistroCompras.jTFProveedor.setText(empresa);
                    }
                    break;
            }
            this.dispose();
        }
    }

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void btnSeleccionarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarRegistroActionPerformed
        seleccionarRegistro(formulario);
    }//GEN-LAST:event_btnSeleccionarRegistroActionPerformed

    private void PanelSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSuperiorMousePressed
        FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_PanelSuperiorMousePressed

    private void PanelSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSuperiorMouseDragged
        FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_PanelSuperiorMouseDragged

    private void jTFCampo2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCampo2KeyTyped
        busquedaFiltrada(formulario);
    }//GEN-LAST:event_jTFCampo2KeyTyped

    private void jTFCampo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCampo1KeyTyped
        busquedaFiltrada(formulario);
    }//GEN-LAST:event_jTFCampo1KeyTyped

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        seleccionarTabla(formulario);
    }//GEN-LAST:event_TablaMouseClicked

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
            java.util.logging.Logger.getLogger(frmBuscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBuscador().setVisible(true);
            }
        });
    }

    public frmBuscador() {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelSuperior;
    private rojerusan.RSTableMetro Tabla;
    private javax.swing.JButton btnSeleccionarRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private LIB.FSTexFieldMD jTFCampo1;
    private LIB.FSTexFieldMD jTFCampo2;
    private javax.swing.JLabel lblCampo1;
    private javax.swing.JLabel lblCampo2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblMinimizar;
    // End of variables declaration//GEN-END:variables
}
