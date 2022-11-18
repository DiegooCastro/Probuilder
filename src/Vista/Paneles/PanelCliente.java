package Vista.Paneles;

import Clases.ClassFunciones;
import Clases.ClassFuncionesSQL;
import Controlador.MtoCliente;
import Vista.Frames.frmAlerta;
import Vista.Frames.frmBuscador;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Castro
 */
public class PanelCliente extends javax.swing.JPanel {

    //Declaracion de variables y objetos para la clase   
    ClassFuncionesSQL SQL = new ClassFuncionesSQL();
    ClassFunciones fun = new ClassFunciones();
    MtoCliente cli = new MtoCliente();
    
    //Declaracion de atributos de la clase
    private DefaultTableModel tb;
    private int id;
    private int fila;
    
    public PanelCliente() {
        initComponents();
        tb = (DefaultTableModel) Tabla.getModel();
        cargarTabla();
        fun.soloLetras(jTFNombre, 40);
        fun.soloLetras(jTFApellido, 40);
        fun.soloNumeros(jTFTelefono, 9);
        fun.soloNumeros(jTFDUI, 10);
        fun.longitudMaxima(jTFCorreo, 75);
    }
    
    /**
     * Metodo para cargar los datos en la tabla
     */
    private void cargarTabla()
    {
        SQL.cargarTabla("select * from Vista_Cliente", tb); //Refrescamos la tabla de datos
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSelectEmpresa = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTFNombre = new LIB.FSTexFieldMD();
        jTFCorreo = new LIB.FSTexFieldMD();
        jTFApellido = new LIB.FSTexFieldMD();
        jTFDUI = new LIB.FSTexFieldMD();
        jTFTelefono = new LIB.FSTexFieldMD();
        btnIngresar = new LIB.FSButtonMD();
        btnModificar = new LIB.FSButtonMD();
        btnBorrarCampos = new LIB.FSButtonMD();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new rojerusan.RSTableMetro();
        jTFEmpresa = new LIB.FSTexFieldMD();
        jTFBusqueda = new LIB.FSTexFieldMD();
        btnBusqueda = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSelectEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        lblSelectEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectEmpresaMouseClicked(evt);
            }
        });
        add(lblSelectEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel8.setText("Correo");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel7.setText("DUI");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel4.setText("Empresa");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel6.setText("Telefono");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setText("Apellido");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel2.setText("Nombre");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("GESTION DE CLIENTES");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 301, 39));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Clientes.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, -1, -1));

        jTFNombre.setForeground(new java.awt.Color(0, 0, 0));
        jTFNombre.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFNombre.setPlaceholder(" Nombre Cliente*");
        add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 280, 40));

        jTFCorreo.setForeground(new java.awt.Color(0, 0, 0));
        jTFCorreo.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFCorreo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFCorreo.setPlaceholder(" Correo Cliente*");
        add(jTFCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 280, 40));

        jTFApellido.setForeground(new java.awt.Color(0, 0, 0));
        jTFApellido.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFApellido.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFApellido.setPlaceholder(" Apellido Cliente*");
        add(jTFApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 280, 40));

        jTFDUI.setForeground(new java.awt.Color(0, 0, 0));
        jTFDUI.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFDUI.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFDUI.setPlaceholder(" DUI Cliente*");
        jTFDUI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFDUIKeyPressed(evt);
            }
        });
        add(jTFDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 280, 40));

        jTFTelefono.setForeground(new java.awt.Color(0, 0, 0));
        jTFTelefono.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFTelefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFTelefono.setPlaceholder(" Telefono Cliente*");
        jTFTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFTelefonoKeyPressed(evt);
            }
        });
        add(jTFTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 280, 40));

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Agregar.png"))); // NOI18N
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
        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 210, -1));

        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Iconos_Actualizar.png"))); // NOI18N
        btnModificar.setText("  Modificar Empresa");
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
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 220, -1));

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
        add(btnBorrarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 210, -1));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Empresa", "Nombre", "Apellido", "Telefono", "DUI", "Correo"
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
        jScrollPane1.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setMinWidth(0);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(6).setMinWidth(0);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 950, 260));

        jTFEmpresa.setEditable(false);
        jTFEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        jTFEmpresa.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFEmpresa.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFEmpresa.setPlaceholder("");
        add(jTFEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 240, 40));

        jTFBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        jTFBusqueda.setBordeColorFocus(new java.awt.Color(0, 0, 102));
        jTFBusqueda.setFont(new java.awt.Font("Roboto Bold", 1, 15)); // NOI18N
        jTFBusqueda.setPlaceholder(" Busqueda (DUI) ");
        jTFBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBusquedaKeyPressed(evt);
            }
        });
        add(jTFBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, 170, 60));

        btnBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Busqueda.png"))); // NOI18N
        btnBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusquedaMouseClicked(evt);
            }
        });
        add(btnBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, -1, 50));
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para borrar los campos del formulario
    private void Borrar_Campos()
    {
        btnIngresar.setEnabled(true);
        btnModificar.setEnabled(false);
        jTFEmpresa.setText(null);
        jTFCorreo.setText(null);
        jTFTelefono.setText(null);
        jTFNombre.setText(null);
        jTFApellido.setText(null);
        jTFDUI.setText(null);
    }
    
    private void lblSelectEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectEmpresaMouseClicked
        frmBuscador c = new frmBuscador("empresa",1);
        c.setVisible(true);
    }//GEN-LAST:event_lblSelectEmpresaMouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (jTFEmpresa.getText().trim().isEmpty() || jTFNombre.getText().trim().isEmpty() || jTFCorreo.getText().trim().isEmpty() || jTFTelefono.getText().trim().isEmpty()|| jTFApellido.getText().trim().isEmpty() || jTFDUI.getText().trim().isEmpty()) 
        {
            new frmAlerta("Complete todos los campos solicitados",2).setVisible(true);
        }
        else
        {
            if (jTFCorreo.getText().endsWith("@gmail.com")) 
            {
                try
                {
                    cli.setEmpresa(SQL.getIdentificador("select * from Empresa where Nombre_Empresa = '"+jTFEmpresa.getText()+"'"));
                    cli.setCorreo(jTFCorreo.getText());
                    cli.setTelefono(jTFTelefono.getText());
                    cli.setNombre(jTFNombre.getText());
                    cli.setApellido(jTFApellido.getText());
                    cli.setDUI(jTFDUI.getText());
                    if (cli.ingresarCliente(cli)) 
                    {
                        cargarTabla();
                        Borrar_Campos();
                    }
                }
                catch(Exception e)
                {
                    new frmAlerta("Ingrese el tipo de dato correctamente",3).setVisible(true);
                    System.out.println(e);
                }
            }
            else
            {
                new frmAlerta("Ingrese un correo valido",2).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTFEmpresa.getText().trim().isEmpty() || jTFNombre.getText().trim().isEmpty() || jTFCorreo.getText().trim().isEmpty() || jTFTelefono.getText().trim().isEmpty()|| jTFApellido.getText().trim().isEmpty() || jTFDUI.getText().trim().isEmpty()) 
        {
            new frmAlerta("Complete todos los campos solicitados",2).setVisible(true);
        }
        else
        {
            if (jTFCorreo.getText().endsWith("@gmail.com")) 
            {
                try
                {
                    cli.setEmpresa(SQL.getIdentificador("select * from Empresa where Nombre_Empresa = '"+jTFEmpresa.getText()+"'"));
                    cli.setCorreo(jTFCorreo.getText());
                    cli.setTelefono(jTFTelefono.getText());
                    cli.setNombre(jTFNombre.getText());
                    cli.setApellido(jTFApellido.getText());
                    cli.setDUI(jTFDUI.getText());
                    if (cli.modificarCliente(cli,id)) 
                    {
                        cargarTabla();
                        Borrar_Campos();
                    }
                }
                catch(Exception e)
                {
                    new frmAlerta("Ingrese el tipo de dato correctamente",3).setVisible(true);
                }
            }
            else
            {
                new frmAlerta("Ingrese un correo electronico valido",2).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCamposActionPerformed
        Borrar_Campos();
        cargarTabla();
    }//GEN-LAST:event_btnBorrarCamposActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        fila = Tabla.getSelectedRow();
        id = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
        jTFEmpresa.setText(Tabla.getValueAt(fila, 1).toString());
        jTFNombre.setText(Tabla.getValueAt(fila, 2).toString());
        jTFApellido.setText(Tabla.getValueAt(fila, 3).toString());
        jTFTelefono.setText(Tabla.getValueAt(fila, 4).toString());
        jTFDUI.setText(Tabla.getValueAt(fila, 5).toString());
        jTFCorreo.setText(Tabla.getValueAt(fila, 6).toString());
        btnIngresar.setEnabled(false);
        btnModificar.setEnabled(true);
    }//GEN-LAST:event_TablaMouseClicked

    private void jTFDUIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDUIKeyPressed
        fun.agregarGuiones(jTFDUI, 8);
    }//GEN-LAST:event_jTFDUIKeyPressed

    private void jTFTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoKeyPressed
        fun.agregarGuiones(jTFTelefono, 4);
    }//GEN-LAST:event_jTFTelefonoKeyPressed

    private void jTFBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusquedaKeyPressed
        if (jTFBusqueda.getText().length() > 1)
        {
            String dui= "%"+jTFBusqueda.getText()+"%";
            SQL.busquedaFiltrada(tb, "select * from Vista_Cliente where DUI like '"+dui+"'");
        }
        else
        {
            cargarTabla();
        }
    }//GEN-LAST:event_jTFBusquedaKeyPressed

    private void btnBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusquedaMouseClicked
        if (jTFNombre.getText().trim().isEmpty())
        {
            new frmAlerta("Ingrese el nombre del cliente",1).setVisible(true);
        }
        else
        {
            String nombre = "%"+jTFNombre.getText()+"%";
            String apellido = "%"+jTFApellido.getText()+"%";
            if (SQL.busquedaFiltrada(tb, "select * from Vista_Cliente where Nombre like '"+nombre+"' and Apellido like '"+apellido+"'"))
            {
                new frmAlerta("Se encontraron los siguientes resultados",4).setVisible(true);
                Borrar_Campos();
            }
            else
            {
                new frmAlerta("No se encontro ningun cliente",2).setVisible(true);
                cargarTabla();
            }
        }
    }//GEN-LAST:event_btnBusquedaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Tabla;
    private LIB.FSButtonMD btnBorrarCampos;
    private javax.swing.JLabel btnBusqueda;
    private LIB.FSButtonMD btnIngresar;
    private LIB.FSButtonMD btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private LIB.FSTexFieldMD jTFApellido;
    private LIB.FSTexFieldMD jTFBusqueda;
    private LIB.FSTexFieldMD jTFCorreo;
    private LIB.FSTexFieldMD jTFDUI;
    public static LIB.FSTexFieldMD jTFEmpresa;
    private LIB.FSTexFieldMD jTFNombre;
    private LIB.FSTexFieldMD jTFTelefono;
    private javax.swing.JLabel lblSelectEmpresa;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
