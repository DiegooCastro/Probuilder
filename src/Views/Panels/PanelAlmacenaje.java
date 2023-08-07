package Views.Panels;

import Helpers.FuncionesSQL;
import Helpers.Imagen;
import Models.Materiales;
import Views.Frames.frmAlerta;
import Views.Frames.frmCatalogoMini;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Castro
 */
public class PanelAlmacenaje extends javax.swing.JPanel {

    public PanelAlmacenaje() {
        initComponents();
        jTFDescripcion.setWrapStyleWord(true);
        jTFDescripcion.setLineWrap(true);
        cargarTabla();
    }

    //Declaracion de objetos
    Imagen img = new Imagen();
    FuncionesSQL sql = new FuncionesSQL();
    Materiales obj = new Materiales();

    //Declaracion de atributos de la clase
    private DefaultTableModel tb;
    private String ruta;
    private int fila;
    private int idMaterial;

    private void borrarCampos() {
        jTFMaterial.setText(null);
        jTFDescripcion.setText(null);
        jTFUnidad.setText(null);
        lblImagen.setIcon(null);
        jTFDisponible.setText(null);
        ruta = null;
        idMaterial = -1;
        fila = -1;
        btnIngresar.setEnabled(true);
        btnModificar.setEnabled(false);
    }

    /**
     * Metodo para cargar los datos en la tabla
     */
    private void cargarTabla() {
        tb = (DefaultTableModel) Tabla.getModel();
        sql.cargarTabla("select * from Vista_Materiales", tb);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFDescripcion = new javax.swing.JTextArea();
        lblSelectImagen = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTFUnidad = new LIB.FSTexFieldMD();
        btnIngresar = new LIB.FSButtonMD();
        btnModificar = new LIB.FSButtonMD();
        jTFMaterial = new LIB.FSTexFieldMD();
        jTFDisponible = new LIB.FSTexFieldMD();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla = new rojerusan.RSTableMetro();
        jTFBusqueda = new LIB.FSTexFieldMD();
        btnBorrarCampos1 = new LIB.FSButtonMD();

        jPasswordField1.setText("jPasswordField1");

        jToggleButton1.setText("jToggleButton1");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel6.setText("C/U Disponible");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel2.setText("Busqueda");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, -1, 40));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("ALMACENAJE DE MATERIALES");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setText("Material");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel7.setText("Descripcion");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 30));

        jTFDescripcion.setColumns(20);
        jTFDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFDescripcion.setRows(5);
        jScrollPane1.setViewportView(jTFDescripcion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 270, 130));

        lblSelectImagen.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblSelectImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Add.png"))); // NOI18N
        lblSelectImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectImagenMouseClicked(evt);
            }
        });
        add(lblSelectImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel10.setText("Fotografia");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, 30, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel4.setText("Unidad Medida");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 70));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 250, 130));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconAlmacenajeMateriales.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, 50));

        jTFUnidad.setEditable(false);
        jTFUnidad.setForeground(new java.awt.Color(0, 0, 0));
        jTFUnidad.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFUnidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFUnidad.setPlaceholder("");
        add(jTFUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 220, 40));

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Agregar.png"))); // NOI18N
        btnIngresar.setText("  Ingresar Material");
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
        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 290, -1));

        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Iconos_Actualizar.png"))); // NOI18N
        btnModificar.setText("  Modificar Material");
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
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 320, -1));

        jTFMaterial.setForeground(new java.awt.Color(0, 0, 0));
        jTFMaterial.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFMaterial.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFMaterial.setPlaceholder(" Nombre Material*");
        add(jTFMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 260, 40));

        jTFDisponible.setEditable(false);
        jTFDisponible.setForeground(new java.awt.Color(0, 0, 0));
        jTFDisponible.setBordeColorFocus(new java.awt.Color(0, 0, 51));
        jTFDisponible.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFDisponible.setPlaceholder("");
        add(jTFDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 460, 190, 40));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Unidad", "Material", "Descripcion", "Foto", "Estado", "Cantidad"
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
            Tabla.getColumnModel().getColumn(3).setMinWidth(0);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(3).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(4).setMinWidth(0);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(4).setMaxWidth(0);
            Tabla.getColumnModel().getColumn(5).setMinWidth(0);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 650, 250));

        jTFBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        jTFBusqueda.setBordeColorFocus(new java.awt.Color(0, 0, 102));
        jTFBusqueda.setFont(new java.awt.Font("Roboto Bold", 1, 15)); // NOI18N
        jTFBusqueda.setPlaceholder(" Nombre Material");
        jTFBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBusquedaKeyTyped(evt);
            }
        });
        add(jTFBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 590, 190, 50));

        btnBorrarCampos1.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarCampos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_BorrarCampos.png"))); // NOI18N
        btnBorrarCampos1.setText("  Borrar Campos");
        btnBorrarCampos1.setColorHover(new java.awt.Color(204, 204, 204));
        btnBorrarCampos1.setColorNormal(new java.awt.Color(255, 255, 255));
        btnBorrarCampos1.setColorPressed(new java.awt.Color(255, 255, 255));
        btnBorrarCampos1.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnBorrarCampos1.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnBorrarCampos1.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        btnBorrarCampos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCampos1ActionPerformed(evt);
            }
        });
        add(btnBorrarCampos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 280, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void lblSelectImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectImagenMouseClicked
        ruta = img.seleccionarImagen(lblImagen);
    }//GEN-LAST:event_lblSelectImagenMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        frmCatalogoMini c = new frmCatalogoMini("unidad", 1);
        c.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (jTFMaterial.getText().isEmpty() || jTFDescripcion.getText().isEmpty()) {
            new frmAlerta("Complete todos los campos solicitados", 2).setVisible(true);
        } else {
            obj.setDescripcion(jTFDescripcion.getText());
            obj.setIdUnidad(sql.getIdentificador("select * from Unidad_Medida where Unidad_Medida = '" + jTFUnidad.getText() + "'"));
            obj.setIdMaterial(idMaterial);
            obj.setNombre(jTFMaterial.getText());
            obj.setDisponible(0);
            if (ruta == null) {
                obj.setFotoMaterial(null);
            } else {
                obj.setFotoMaterial(img.codificarLogo(ruta));
            }
            if (obj.ingresarMaterial(obj)) {
                cargarTabla();
                borrarCampos();
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTFMaterial.getText().isEmpty() || jTFDescripcion.getText().isEmpty()) {
            new frmAlerta("Complete todos los campos solicitados", 2).setVisible(true);
        } else {
            obj.setDescripcion(jTFDescripcion.getText());
            obj.setIdUnidad(sql.getIdentificador("select * from Unidad_Medida where Unidad_Medida = '" + jTFUnidad.getText() + "'"));
            obj.setIdMaterial(idMaterial);
            obj.setNombre(jTFMaterial.getText());
            if (ruta == null) {
                obj.setFotoMaterial(null);
            } else {
                obj.setFotoMaterial(img.codificarLogo(ruta));
            }
            if (obj.modificarMaterial(obj)) {
                cargarTabla();
                borrarCampos();
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        fila = Tabla.getSelectedRow();
        idMaterial = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
        jTFUnidad.setText(Tabla.getValueAt(fila, 1).toString());
        jTFMaterial.setText(Tabla.getValueAt(fila, 2).toString());
        jTFDescripcion.setText(Tabla.getValueAt(fila, 3).toString());
        try {
            byte[] logo = (byte[]) Tabla.getValueAt(fila, 4);
            img.cargarLogo(logo, lblImagen);
        } catch (Exception e) {
        }
        jTFDisponible.setText(Tabla.getValueAt(fila, 6).toString());
        btnIngresar.setEnabled(false);
        btnModificar.setEnabled(true);
    }//GEN-LAST:event_TablaMouseClicked

    private void jTFBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusquedaKeyTyped
        if (jTFBusqueda.getText().length() > 1) {
            String material = "%" + jTFBusqueda.getText() + "%";
            sql.busquedaFiltrada(tb, "select * from Vista_Materiales where Nombre_Material like '" + material + "'");
        } else {
            sql.cargarTabla("select * from Vista_Materiales", tb);
        }
    }//GEN-LAST:event_jTFBusquedaKeyTyped

    private void btnBorrarCampos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCampos1ActionPerformed
        borrarCampos();
    }//GEN-LAST:event_btnBorrarCampos1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Tabla;
    private LIB.FSButtonMD btnBorrarCampos1;
    private LIB.FSButtonMD btnIngresar;
    private LIB.FSButtonMD btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private LIB.FSTexFieldMD jTFBusqueda;
    private javax.swing.JTextArea jTFDescripcion;
    public static LIB.FSTexFieldMD jTFDisponible;
    private LIB.FSTexFieldMD jTFMaterial;
    public static LIB.FSTexFieldMD jTFUnidad;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblSelectImagen;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
