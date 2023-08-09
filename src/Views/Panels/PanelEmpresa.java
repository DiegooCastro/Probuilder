package Views.Panels;

import Helpers.Funciones;
import Helpers.FuncionesSQL;
import Helpers.Imagen;
import Models.Empresa;
import Views.Frames.frmAlert;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Castro
 */
public class PanelEmpresa extends javax.swing.JPanel {

    //Declaracion de objetos de la clase empresa 
    FuncionesSQL SQL = new FuncionesSQL();
    Funciones fun = new Funciones();
    Imagen img = new Imagen();
    Empresa emp = new Empresa();

    //Declaracion de atributos de la clase
    private DefaultTableModel tb;
    private String ruta = null;
    private int idEmpresa;
    private int fila;

    public PanelEmpresa() {
        initComponents();
        tb = (DefaultTableModel) Tabla.getModel();
        SQL.cargarTabla("select * from Vista_Empresa", tb);
        SQL.cargarComboBox("select * from Tipo_Empresa", cmbTipo);
        btnModificar.setEnabled(false);
        fun.longitudMaxima(jTFEmpresa, 40);
        fun.longitudMaxima(jTFUbicacion, 75);
        fun.soloNumeros(jTFTelefono, 9);
        fun.longitudMaxima(jTFCorreo, 60);
        fun.soloNumeros(jTFTelefono2, 9);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBotones = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTFUbicacion = new LIB.FSTexFieldMD();
        cmbTipo = new RSMaterialComponent.RSComboBoxMaterial();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new rojerusan.RSTableMetro();
        lblImagen = new javax.swing.JLabel();
        jTFTelefono = new LIB.FSTexFieldMD();
        jTFEmpresa = new LIB.FSTexFieldMD();
        jTFCorreo = new LIB.FSTexFieldMD();
        jTFTelefono2 = new LIB.FSTexFieldMD();
        btnBorrarCampos = new LIB.FSButtonMD();
        btnModificar = new LIB.FSButtonMD();
        btnIngresar = new LIB.FSButtonMD();
        jLabel11 = new javax.swing.JLabel();
        jTFBusqueda = new LIB.FSTexFieldMD();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBotones.setLayout(new java.awt.GridLayout(1, 0));
        add(PanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 476, 1827, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setText("Tipo Empresa");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, 50));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setText("Telefono");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setText("Telefono 2");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setText("Correo");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 168, -1, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("Empresa");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setText("Ubicacion");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/empresa.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, -1, 70));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("GESTION DE EMPRESA");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 50));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/busqueda.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, -1, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/agregar.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, 30));

        jTFUbicacion.setForeground(new java.awt.Color(0, 0, 0));
        jTFUbicacion.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFUbicacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFUbicacion.setPlaceholder(" Ubicacion ");
        add(jTFUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 260, 40));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de empresa", " " }));
        cmbTipo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 250, 40));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo Empresa", "Empresa", "Ubicacion", "Telefono", "Correo", "Telefono 2", "Logo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.setAltoHead(30);
        Tabla.setColorBackgoundHead(new java.awt.Color(44, 47, 62));
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
        jScrollPane1.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setMinWidth(0);
            Tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(3).setMinWidth(0);
            Tabla.getColumnModel().getColumn(3).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(7).setMinWidth(0);
            Tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 950, 230));

        lblImagen.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 200, 100));

        jTFTelefono.setForeground(new java.awt.Color(0, 0, 0));
        jTFTelefono.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFTelefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFTelefono.setPlaceholder(" Telefono Empresa*");
        jTFTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTelefonoKeyTyped(evt);
            }
        });
        add(jTFTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 260, 40));

        jTFEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        jTFEmpresa.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFEmpresa.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFEmpresa.setPlaceholder(" Nombre Empresa*");
        add(jTFEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 260, 40));

        jTFCorreo.setForeground(new java.awt.Color(0, 0, 0));
        jTFCorreo.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFCorreo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFCorreo.setPlaceholder(" Correo Empresa*");
        add(jTFCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 260, 40));

        jTFTelefono2.setForeground(new java.awt.Color(0, 0, 0));
        jTFTelefono2.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFTelefono2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFTelefono2.setPlaceholder(" Telefono 2 Empresa*");
        jTFTelefono2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTelefono2KeyTyped(evt);
            }
        });
        add(jTFTelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 260, 40));

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
        add(btnBorrarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 230, -1));

        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/botonActualizar.png"))); // NOI18N
        btnModificar.setText("  Modificar Empresa");
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
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 230, -1));

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/botonAgregar.png"))); // NOI18N
        btnIngresar.setText("  Ingresar Empresa");
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
        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 220, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel11.setText("Logo");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, -1, 30));

        jTFBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        jTFBusqueda.setBordeColorFocus(new java.awt.Color(0, 0, 102));
        jTFBusqueda.setFont(new java.awt.Font("Roboto Bold", 1, 15)); // NOI18N
        jTFBusqueda.setPlaceholder(" Busqueda (Empresa)");
        jTFBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBusquedaKeyPressed(evt);
            }
        });
        add(jTFBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 370, 180, 50));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 410, 10));
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para borrar los campos del formulario
    private void Borrar_Campos() {
        SQL.cargarTabla("select * from Vista_Empresa", tb); //Refrescamos la tabla de datos
        btnIngresar.setEnabled(true);
        btnModificar.setEnabled(false);
        jTFEmpresa.setText(null);
        jTFTelefono.setText(null);
        jTFTelefono.setText(null);
        jTFTelefono2.setText(null);
        jTFUbicacion.setText(null);
        jTFCorreo.setText(null);
        lblImagen.setIcon(null);
        ruta = null;
    }

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        ruta = img.seleccionarImagen(lblImagen);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (jTFEmpresa.getText().trim().isEmpty() || jTFUbicacion.getText().trim().isEmpty() || jTFTelefono.getText().trim().isEmpty() || jTFTelefono.getText().trim().isEmpty() || jTFTelefono2.getText().trim().isEmpty()) {
            new frmAlert("Complete los campos solicitados", 2).setVisible(true);
        } else {
            if (jTFCorreo.getText().endsWith("@gmail.com")) {
                try {
                    if (ruta == null) {
                        emp.setCargarLogo(null);
                    } else {
                        emp.setCargarLogo(img.codificarLogo(ruta));
                    }
                } catch (Exception e) {
                    emp.setCargarLogo(null);
                }
                emp.setEmpresa(jTFEmpresa.getText());
                emp.setCorreo(jTFCorreo.getText());
                emp.setTelefono(jTFTelefono.getText());
                emp.setTelefono2(jTFTelefono2.getText());
                emp.setUbicacion(jTFUbicacion.getText());
                emp.setTipo_Empresa(cmbTipo.getSelectedIndex() + 1);
                if (emp.ingresarEmpresa(emp)) {
                    Borrar_Campos();
                }
            } else {
                new frmAlert("Ingrese un correo electronico valido", 2).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTFEmpresa.getText().trim().isEmpty() || jTFUbicacion.getText().trim().isEmpty() || jTFTelefono.getText().trim().isEmpty() || jTFTelefono.getText().trim().isEmpty() || jTFTelefono2.getText().trim().isEmpty()) {
            new frmAlert(" Complete los campos solicitados", 2).setVisible(true);
        } else {
            if (jTFCorreo.getText().endsWith("@gmail.com")) {
                try {
                    if (ruta == null) {
                        emp.setCargarLogo(null);
                    } else {
                        emp.setCargarLogo(img.codificarLogo(ruta));
                    }
                } catch (Exception e) {
                    emp.setCargarLogo(null);
                }
                emp.setEmpresa(jTFEmpresa.getText());
                emp.setCorreo(jTFCorreo.getText());
                emp.setTelefono(jTFTelefono.getText());
                emp.setTelefono2(jTFTelefono2.getText());
                emp.setUbicacion(jTFUbicacion.getText());
                emp.setTipo_Empresa(cmbTipo.getSelectedIndex() + 1);
                emp.setIdEmpresa(idEmpresa);
                if (emp.modificarEmpresa(emp)) {
                    Borrar_Campos();
                }
            } else {
                new frmAlert("Ingrese un correo electronico valido", 2).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCamposActionPerformed
        Borrar_Campos();
    }//GEN-LAST:event_btnBorrarCamposActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        fila = Tabla.getSelectedRow();
        idEmpresa = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
        cmbTipo.setSelectedItem(Tabla.getValueAt(fila, 1));
        jTFEmpresa.setText(Tabla.getValueAt(fila, 2).toString());
        jTFUbicacion.setText(Tabla.getValueAt(fila, 3).toString());
        jTFTelefono.setText(Tabla.getValueAt(fila, 4).toString());
        jTFCorreo.setText(Tabla.getValueAt(fila, 5).toString());
        jTFTelefono2.setText(Tabla.getValueAt(fila, 6).toString());
        btnModificar.setEnabled(true);
        btnIngresar.setEnabled(false);
        try {
            byte[] imagen = (byte[]) Tabla.getValueAt(fila, 7);
            img.cargarLogo(imagen, lblImagen);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_TablaMouseClicked

    private void jTFTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoKeyTyped
        fun.agregarGuiones(jTFTelefono, 4);
    }//GEN-LAST:event_jTFTelefonoKeyTyped

    private void jTFTelefono2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefono2KeyTyped
        fun.agregarGuiones(jTFTelefono2, 4);
    }//GEN-LAST:event_jTFTelefono2KeyTyped

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        if (jTFEmpresa.getText().trim().isEmpty()) {
            new frmAlert("Ingrese el nombre de la empresa", 2).setVisible(true);
        } else {
            String nombreEmpresa = "%" + jTFEmpresa.getText() + "%";
            String telefonoEmpresa = "%" + jTFTelefono.getText() + "%";
            String tipoEmpresa = cmbTipo.getSelectedItem().toString();
            if (SQL.busquedaFiltrada(tb, "select * from Vista_Empresa where nombre_empresa like '" + nombreEmpresa + "' or Telefono = '" + telefonoEmpresa + "' and Tipo_Empresa = '" + tipoEmpresa + "'")) {
                new frmAlert("Se encontraron los siguentes registros", 3).setVisible(true);
            } else {
                new frmAlert("No se encontro ningun registro", 3).setVisible(true);
            }
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jTFBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusquedaKeyPressed
        if (jTFBusqueda.getText().length() > 1) {
            String empresa = "%" + jTFBusqueda.getText() + "%";
            SQL.busquedaFiltrada(tb, "select * from Vista_Empresa where nombre like '" + empresa + "'");
        } else {
            SQL.cargarTabla("select * from Vista_Empresa", tb);
        }
    }//GEN-LAST:event_jTFBusquedaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotones;
    private rojerusan.RSTableMetro Tabla;
    private LIB.FSButtonMD btnBorrarCampos;
    private LIB.FSButtonMD btnIngresar;
    private LIB.FSButtonMD btnModificar;
    private RSMaterialComponent.RSComboBoxMaterial cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private LIB.FSTexFieldMD jTFBusqueda;
    private LIB.FSTexFieldMD jTFCorreo;
    private LIB.FSTexFieldMD jTFEmpresa;
    private LIB.FSTexFieldMD jTFTelefono;
    private LIB.FSTexFieldMD jTFTelefono2;
    private LIB.FSTexFieldMD jTFUbicacion;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
