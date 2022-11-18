package Vista.Paneles;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import Clases.ClassFuncionesSQL;
import javax.swing.JOptionPane;
import Controlador.MtoPersonal;
import Clases.ClassFunciones;
import Vista.Frames.frmAlerta;
import Vista.Frames.frmCatalogoMini;

/** Clase del panel personal
 * @version 1.0
 * @author Diego Castro
 * @since 13/07/2020
 */
public class PanelPersonal extends javax.swing.JPanel {

    //Declaracion de variables y objetos para la clase
    MtoPersonal personal = new MtoPersonal();
    ClassFuncionesSQL sql = new ClassFuncionesSQL();
    ClassFunciones fun = new ClassFunciones();
    
    //Declaracion de atributos de la clase
    DefaultComboBoxModel cmb;
    DefaultTableModel tb;
    private int idPersonal;
    private int fila;
    
    public PanelPersonal() {
        initComponents();
        tb = (DefaultTableModel) Tabla.getModel();
        sql.cargarTabla("select * from Vista_Personal", tb);
        fun.soloLetras(jTFNombre, 40);
        fun.soloLetras(jTFApellido, 40);
        fun.soloNumeros(jTFTelefono, 9);
        fun.soloNumeros(jTFDUI, 10);
        fun.soloNumeros(jTFSueldo, 8);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblSelectProfesion = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jTFTelefono = new LIB.FSTexFieldMD();
        cmbEstado = new RSMaterialComponent.RSComboBoxMaterial();
        jDateContratacion = new rojeru_san.rsdate.RSDateChooser();
        btnIngresar = new LIB.FSButtonMD();
        btnBorrarCampos = new LIB.FSButtonMD();
        btnModificar = new LIB.FSButtonMD();
        btnEliminar = new LIB.FSButtonMD();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla = new rojerusan.RSTableMetro();
        jTFSueldo = new LIB.FSTexFieldMD();
        jTFApellido = new LIB.FSTexFieldMD();
        jTFNombre = new LIB.FSTexFieldMD();
        jTFDUI = new LIB.FSTexFieldMD();
        jTFProfesion = new LIB.FSTexFieldMD();

        jPasswordField1.setText("jPasswordField1");

        jToggleButton1.setText("jToggleButton1");

        jScrollPane1.setViewportView(jEditorPane1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel4.setText("Profesion");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel9.setText("Estado");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel11.setText("Contratacion");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, -1, -1));

        lblSelectProfesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        lblSelectProfesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectProfesionMouseClicked(evt);
            }
        });
        add(lblSelectProfesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, -1, 40));

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_SmallBusqueda.png"))); // NOI18N
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
        });
        add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 40, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel2.setText("Nombre");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 111, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setText("Apellido");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel6.setText("Telefono");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel7.setText("DUI");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel8.setText("Sueldo $:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono-Personal.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, 40));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("GESTION DE PERSONAL");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 290, 40));

        jTFTelefono.setForeground(new java.awt.Color(0, 0, 0));
        jTFTelefono.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFTelefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFTelefono.setPlaceholder(" Telefono Empleado*");
        jTFTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTelefonoKeyTyped(evt);
            }
        });
        add(jTFTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 250, 40));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));
        cmbEstado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 300, 40));

        jDateContratacion.setColorBackground(new java.awt.Color(0, 0, 102));
        jDateContratacion.setColorButtonHover(new java.awt.Color(0, 0, 51));
        jDateContratacion.setColorForeground(new java.awt.Color(0, 0, 0));
        jDateContratacion.setEnabled(false);
        jDateContratacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jDateContratacion.setFuente(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        add(jDateContratacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 310, 30));

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Agregar.png"))); // NOI18N
        btnIngresar.setText("  Ingresar Personal");
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
        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 210, -1));

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
        add(btnBorrarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 210, -1));

        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Iconos_Actualizar.png"))); // NOI18N
        btnModificar.setText("  Modificar Personal");
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
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 210, -1));

        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Eliminar.png"))); // NOI18N
        btnEliminar.setText("  Eliminar Personal");
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
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 220, -1));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Profesion", "Estado", "Cargo", "Nombre", "Apellido", "Telefono", "DUI", "Area", "Sueldo", "Contratacion"
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
        jScrollPane3.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setMinWidth(0);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(1).setMinWidth(0);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(1).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(2).setMinWidth(0);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(2).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(3).setMinWidth(0);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(3).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(9).setMinWidth(0);
            Tabla.getColumnModel().getColumn(9).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(9).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(10).setMinWidth(0);
            Tabla.getColumnModel().getColumn(10).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 930, 180));

        jTFSueldo.setForeground(new java.awt.Color(0, 0, 0));
        jTFSueldo.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFSueldo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFSueldo.setPlaceholder(" Sueldo Empleado*");
        add(jTFSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 250, 40));

        jTFApellido.setForeground(new java.awt.Color(0, 0, 0));
        jTFApellido.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFApellido.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFApellido.setPlaceholder(" Apellido Empleado*");
        add(jTFApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 250, 40));

        jTFNombre.setForeground(new java.awt.Color(0, 0, 0));
        jTFNombre.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFNombre.setPlaceholder(" Nombre Empleado*");
        add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 250, 40));

        jTFDUI.setForeground(new java.awt.Color(0, 0, 0));
        jTFDUI.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFDUI.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFDUI.setPlaceholder(" DUI Empleado*");
        jTFDUI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFDUIKeyTyped(evt);
            }
        });
        add(jTFDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, 40));

        jTFProfesion.setEditable(false);
        jTFProfesion.setForeground(new java.awt.Color(0, 0, 0));
        jTFProfesion.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFProfesion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFProfesion.setPlaceholder("");
        add(jTFProfesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 270, 40));
    }// </editor-fold>//GEN-END:initComponents
    
    private void Borrar_Campos()
    {
        btnIngresar.setEnabled(true);
        jTFNombre.setText(null);
        jTFApellido.setText(null);
        jTFTelefono.setText(null);
        jTFDUI.setText(null);
        jTFProfesion.setText(null);
        jTFSueldo.setText(null);
        fila = -1;
        btnIngresar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    private void lblSelectProfesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectProfesionMouseClicked
        frmCatalogoMini c = new frmCatalogoMini("profesion",1);
        c.setVisible(true);
    }//GEN-LAST:event_lblSelectProfesionMouseClicked

    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
        if (jTFNombre.getText().trim().isEmpty()) 
        {
            new frmAlerta("Debes ingresar el nombre de la empresa que deseas buscar",2).setVisible(true);
        }
        else
        {
            String nombre = '%'+jTFNombre.getText()+'%';
            String apellido = '%'+jTFApellido.getText()+'%';
            String dui = '%'+jTFDUI.getText()+'%';
            if (sql.busquedaFiltrada(tb, "select * from Vista_Personal where nombre like '"+nombre+"' or apellido like '"+apellido+"' or DUI like '"+dui+"'")) 
            {
                new frmAlerta("Se encontraron los siguientes registros",1).setVisible(true);
                Borrar_Campos();
            }
            else
            {
                new frmAlerta("No se encontro ningun registro en la base de datos",3).setVisible(true);
            }
        }
    }//GEN-LAST:event_lblBuscarMouseClicked

    private boolean obtenerEstado(){
        boolean estado = true;
        if (cmbEstado.getSelectedItem() == "Activo") {
            estado = true;
        } else if(cmbEstado.getSelectedItem() == "Inactivo") {
            estado = false;
        }
        return estado;
    }
    
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (jTFNombre.getText().trim().isEmpty() || jTFApellido.getText().trim().isEmpty() || jTFTelefono.getText().trim().isEmpty() || jTFDUI.getText().trim().isEmpty()|| jTFProfesion.getText().trim().isEmpty()) 
        {
            new frmAlerta("Completa todos los campos solicitados",2).setVisible(true);
        }
        else
        { 
            try
            {
                personal.setNombre(jTFNombre.getText());
                personal.setApellido(jTFApellido.getText());
                personal.setTelefono(jTFTelefono.getText());
                personal.setSueldo(Double.parseDouble(jTFSueldo.getText()));
                personal.setDui(jTFDUI.getText());
                personal.setProfesion(sql.getIdentificador("select * from Profesion where profesion = '"+jTFProfesion.getText()+"'"));
                personal.setEstado(obtenerEstado());         
                personal.setContratacion(fun.obtenerFecha(jDateContratacion));
                
                if (personal.ingresarPersonal(personal)) 
                {
                    sql.cargarTabla("select * from Vista_Personal", tb);
                    Borrar_Campos();
                }
            }
            catch(NumberFormatException e)
            {
                new frmAlerta("Ingrese el tipo de dato correctamente",3).setVisible(true);
            }
        } 
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnBorrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCamposActionPerformed
        Borrar_Campos();
        sql.cargarTabla("select * from Vista_Personal", tb); //Refrescamos la tabla de datos
    }//GEN-LAST:event_btnBorrarCamposActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTFNombre.getText().trim().isEmpty() || jTFApellido.getText().trim().isEmpty() || jTFTelefono.getText().trim().isEmpty() || jTFDUI.getText().trim().isEmpty()|| jTFProfesion.getText().trim().isEmpty()) 
        {
            new frmAlerta("Completa todos los campos solicitados",2).setVisible(true);
        }
        else
        {
            try
            {
                personal.setNombre(jTFNombre.getText());
                personal.setApellido(jTFApellido.getText());
                personal.setTelefono(jTFTelefono.getText());
                personal.setDui(jTFDUI.getText());
                personal.setSueldo(Double.parseDouble(jTFSueldo.getText()));
                personal.setProfesion(sql.getIdentificador("select * from Profesion where profesion = '"+jTFProfesion.getText()+"'"));
                personal.setEstado(obtenerEstado());
                personal.setContratacion(fun.obtenerFecha(jDateContratacion));
                personal.setIdPersonal(idPersonal);
                if (personal.modificarPersonal(personal)) 
                {
                    sql.cargarTabla("select * from Vista_Personal", tb);
                    Borrar_Campos();
                }
            }
            catch(NumberFormatException e)
            {
                new frmAlerta("Ingrese el tipo de dato correctamente",3).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (fila < 0) 
        {
            new frmAlerta("Selecciona el registro que deseas eliminar",2).setVisible(true);
        }
        else
        {
            if (JOptionPane.showConfirmDialog(null, "Deseas eliminar este registro","Confirme",JOptionPane.YES_NO_OPTION) == 0) 
            {
                if (personal.eliminarPersonal(idPersonal)) 
                {
                    sql.cargarTabla("select * from Vista_Personal", tb);
                    Borrar_Campos();
                }
            }   
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        fila = Tabla.getSelectedRow();
        idPersonal = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
        jTFProfesion.setText(Tabla.getValueAt(fila, 1).toString());
        cmbEstado.setSelectedItem(Tabla.getValueAt(fila, 2));
        jTFNombre.setText(Tabla.getValueAt(fila, 3).toString());
        jTFApellido.setText(Tabla.getValueAt(fila, 4).toString());
        jTFTelefono.setText(Tabla.getValueAt(fila, 5).toString());
        jTFDUI.setText(Tabla.getValueAt(fila, 6).toString());
        jTFSueldo.setText(Tabla.getValueAt(fila, 7).toString());
        jDateContratacion.setDatoFecha(fun.ConvertirFecha(Tabla.getValueAt(fila, 8).toString()));
        btnIngresar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_TablaMouseClicked

    private void jTFDUIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDUIKeyTyped
        fun.agregarGuiones(jTFDUI, 8);
    }//GEN-LAST:event_jTFDUIKeyTyped

    private void jTFTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoKeyTyped
        fun.agregarGuiones(jTFTelefono, 4);
    }//GEN-LAST:event_jTFTelefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Tabla;
    private LIB.FSButtonMD btnBorrarCampos;
    private LIB.FSButtonMD btnEliminar;
    private LIB.FSButtonMD btnIngresar;
    private LIB.FSButtonMD btnModificar;
    private RSMaterialComponent.RSComboBoxMaterial cmbEstado;
    private rojeru_san.rsdate.RSDateChooser jDateContratacion;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private LIB.FSTexFieldMD jTFApellido;
    private LIB.FSTexFieldMD jTFDUI;
    private LIB.FSTexFieldMD jTFNombre;
    public static LIB.FSTexFieldMD jTFProfesion;
    private LIB.FSTexFieldMD jTFSueldo;
    private LIB.FSTexFieldMD jTFTelefono;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblSelectProfesion;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
