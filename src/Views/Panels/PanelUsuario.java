package Views.Panels;

import Helpers.Funciones;
import Helpers.FuncionesSQL;
import Models.Usuarios;
import Views.Frames.frmAlerta;
import Views.Frames.frmBuscador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase del panel usuario
 *
 * @version 1.0
 * @author Diego Castro
 * @since 13/07/2020
 */
public class PanelUsuario extends javax.swing.JPanel {

    //Creacion de objetos para la clase
    FuncionesSQL funSQL = new FuncionesSQL();
    Funciones fun = new Funciones();
    Usuarios user = new Usuarios();

    //Declaracion de atributos de la clase
    DefaultTableModel tb;
    private int idUsuario;
    private int fila;

    public PanelUsuario() {
        initComponents();
        tb = (DefaultTableModel) Tabla.getModel();
        funSQL.cargarTabla("select * from Vista_Usuarios", tb);
        funSQL.cargarComboBox("select * from Tipo_Usuario", cmbTipo);
        fun.longitudMaxima(jTFUsuario, 40);
        fun.longitudMaxima(jTFCorreo, 75);
        jTFDUI.setVisible(false);
        jTFAccion.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblSelectTrabajador = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTFCorreo = new LIB.FSTexFieldMD();
        cmbTipo = new RSMaterialComponent.RSComboBoxMaterial();
        jTFDUI = new LIB.FSTexFieldMD();
        jTFTrabajador = new LIB.FSTexFieldMD();
        jTFUsuario = new LIB.FSTexFieldMD();
        btnIngresar = new LIB.FSButtonMD();
        btnBorrarCampos = new LIB.FSButtonMD();
        btnModificar = new LIB.FSButtonMD();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla = new rojerusan.RSTableMetro();
        btnEliminar = new LIB.FSButtonMD();
        jTFAccion = new LIB.FSTexFieldMD();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("GESTION DE USUARIOS");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 300, 64));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Usuario2.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, 64));

        lblSelectTrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        lblSelectTrabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectTrabajadorMouseClicked(evt);
            }
        });
        add(lblSelectTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 130, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel11.setText("Tipo");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 40, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel6.setText("Trabajador");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 120, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel2.setText("Usuario");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 80, -1));

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_SmallBusqueda.png"))); // NOI18N
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
        });
        add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel12.setText("Correo");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 60, 30));

        jTFCorreo.setForeground(new java.awt.Color(0, 0, 0));
        jTFCorreo.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFCorreo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFCorreo.setPlaceholder(" Correo Usuario*");
        add(jTFCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 280, 40));

        cmbTipo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 290, -1));

        jTFDUI.setEditable(false);
        jTFDUI.setForeground(new java.awt.Color(0, 0, 0));
        jTFDUI.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFDUI.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFDUI.setPlaceholder("");
        jTFDUI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFDUIKeyTyped(evt);
            }
        });
        add(jTFDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 20, 40));

        jTFTrabajador.setEditable(false);
        jTFTrabajador.setForeground(new java.awt.Color(0, 0, 0));
        jTFTrabajador.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFTrabajador.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFTrabajador.setPlaceholder("");
        add(jTFTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 240, 40));

        jTFUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jTFUsuario.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFUsuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFUsuario.setPlaceholder(" Nombre Usuario*");
        add(jTFUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 280, 40));

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Agregar.png"))); // NOI18N
        btnIngresar.setText("  Ingresar Usuario");
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
        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 210, -1));

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
        add(btnBorrarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 200, -1));

        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Iconos_Actualizar.png"))); // NOI18N
        btnModificar.setText("  Modificar Usuario");
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
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 210, -1));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estado", "Usuario", "Clave", "Correo", "Nombre", "Apellido", "DUI", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
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
            Tabla.getColumnModel().getColumn(3).setMinWidth(0);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(3).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(4).setMinWidth(0);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(4).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(6).setResizable(false);
            Tabla.getColumnModel().getColumn(8).setMinWidth(0);
            Tabla.getColumnModel().getColumn(8).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 940, 340));

        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconDesbloqueado.png"))); // NOI18N
        btnEliminar.setText(" Desactivar Personal");
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
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 220, -1));

        jTFAccion.setForeground(new java.awt.Color(0, 0, 0));
        jTFAccion.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFAccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFAccion.setPlaceholder(" Nombre Empleado*");
        add(jTFAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 150, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void Borrar_Campos() {
        jTFUsuario.setText(null);
        cmbTipo.setSelectedIndex(0);
        jTFCorreo.setText(null);
        jTFTrabajador.setText(null);
        jTFDUI.setText(null);
        idUsuario = -1;
        funSQL.cargarTabla("select * from Vista_Usuarios", tb);
        btnIngresar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    private void lblSelectTrabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectTrabajadorMouseClicked
        frmBuscador c = new frmBuscador("encargado", 1);
        c.setVisible(true);
    }//GEN-LAST:event_lblSelectTrabajadorMouseClicked

    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
        if (jTFUsuario.getText().trim().isEmpty()) {
            new frmAlerta("Debes ingresar el usuario que deseas buscar ", 2).setVisible(true);
        } else {
            if (idUsuario == -1) {
                new frmAlerta("Selecciona un registro", 1).setVisible(true);
            } else {
                String usuario = '%' + jTFUsuario.getText() + '%';
                String correo = '%' + jTFCorreo.getText() + '%';
                String dui = '%' + jTFDUI.getText() + '%';
                if (funSQL.busquedaFiltrada(tb, "select * from Vista_Usuarios where Usuario like '" + usuario + "' or Correo_Electronico like '" + correo + "' or DUI like '" + dui + "'")) {
                    new frmAlerta("Se encontraron los siguientes registros", 1).setVisible(true);
                    Borrar_Campos();
                } else {
                    new frmAlerta("No se encontro ningun registro", 2).setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_lblBuscarMouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (jTFUsuario.getText().trim().isEmpty() || jTFCorreo.getText().trim().isEmpty() || jTFDUI.getText().trim().isEmpty()) {
            new frmAlerta("Complete todos los campos solicitados", 2).setVisible(true);
        } else {
            if (jTFCorreo.getText().endsWith("@gmail.com")) {
                try {
                    user.setIdTrabajador(funSQL.getIdentificador("SELECT * FROM Personal where DUI = '" + jTFDUI.getText() + "'"));
                    user.setUsuario(jTFUsuario.getText());
                    user.setClave("primeruso");
                    user.setCorreo(jTFCorreo.getText());
                    user.setTipo(cmbTipo.getSelectedIndex() + 1);
                    if (user.ingresarUsuario(user)) {
                        funSQL.cargarTabla("select * from Vista_Usuarios", tb);
                        Borrar_Campos();
                    }
                } catch (Exception e) {
                    new frmAlerta("Ingrese el tipo de dato correcto", 3).setVisible(true);
                }
            } else {
                new frmAlerta("Ingrese un correo electronico valido", 2).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnBorrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCamposActionPerformed
        Borrar_Campos();
    }//GEN-LAST:event_btnBorrarCamposActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTFUsuario.getText().trim().isEmpty() || jTFCorreo.getText().trim().isEmpty() || jTFDUI.getText().trim().isEmpty()) {
            new frmAlerta("Complete todos los campos solicitados", 2).setVisible(true);
        } else {
            if (jTFCorreo.getText().endsWith("@gmail.com")) {
                try {
                    user.setIdTrabajador(funSQL.getIdentificador("SELECT * FROM Personal where DUI = '" + jTFDUI.getText() + "'"));
                    user.setIdUsuario(idUsuario);
                    user.setUsuario(jTFUsuario.getText());
                    user.setCorreo(jTFCorreo.getText());
                    user.setTipo(cmbTipo.getSelectedIndex() + 1);
                    if (user.modificarUsuario(user)) {
                        funSQL.cargarTabla("select * from Vista_Usuarios", tb);
                        Borrar_Campos();
                    }
                } catch (Exception e) {
                    new frmAlerta("Ingrese el tipo de dato correcto", 3).setVisible(true);
                }
            } else {
                new frmAlerta("Ingrese un correo electronico valido", 2).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        fila = Tabla.getSelectedRow();
        idUsuario = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
        jTFTrabajador.setText(Tabla.getValueAt(fila, 5).toString() + " " + Tabla.getValueAt(fila, 6).toString());
        cmbTipo.setSelectedItem(Tabla.getValueAt(fila, 8));
        jTFUsuario.setText(Tabla.getValueAt(fila, 2).toString());
        jTFCorreo.setText(Tabla.getValueAt(fila, 4).toString());
        jTFDUI.setText(Tabla.getValueAt(fila, 7).toString());
        btnIngresar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        if (Tabla.getValueAt(fila, 1).equals("Activo")) {
            btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconBloqueado.png")));
            btnEliminar.setText(" Desactivar Usuario");
            jTFAccion.setText("desactivar");
        } else {
            btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconDesbloqueado.png")));
            btnEliminar.setText(" Activar Usuario");
            jTFAccion.setText("activar");
        }
    }//GEN-LAST:event_TablaMouseClicked

    private void jTFDUIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDUIKeyTyped
        fun.agregarGuiones(jTFDUI, 8);
    }//GEN-LAST:event_jTFDUIKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (fila < 0) {
            new frmAlerta("Selecciona el registro que deseas eliminar", 2).setVisible(true);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Deseas eliminar este registro", "Confirme", JOptionPane.YES_NO_OPTION) == 0) {
                boolean accion;
                if (jTFAccion.getText().equals("desactivar")) {
                    accion = false;
                } else {
                    accion = true;
                }
                if (user.eliminarUsuario(idUsuario, accion)) {
                    funSQL.cargarTabla("select * from Vista_Usuario", tb);
                    Borrar_Campos();
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Tabla;
    private LIB.FSButtonMD btnBorrarCampos;
    private LIB.FSButtonMD btnEliminar;
    private LIB.FSButtonMD btnIngresar;
    private LIB.FSButtonMD btnModificar;
    private RSMaterialComponent.RSComboBoxMaterial cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private LIB.FSTexFieldMD jTFAccion;
    private LIB.FSTexFieldMD jTFCorreo;
    public static LIB.FSTexFieldMD jTFDUI;
    public static LIB.FSTexFieldMD jTFTrabajador;
    private LIB.FSTexFieldMD jTFUsuario;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblSelectTrabajador;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
