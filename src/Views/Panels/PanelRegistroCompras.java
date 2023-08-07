package Views.Panels;

import Helpers.Funciones;
import Helpers.FuncionesSQL;
import Helpers.Imagen;
import Models.Materiales;
import Views.Frames.frmBuscador;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Castro
 */
public class PanelRegistroCompras extends javax.swing.JPanel {

    public PanelRegistroCompras() {
        initComponents();
        try {
            cargarTabla();
            //jTFEncargado.setText("Castroll");
            spModel = new SpinnerNumberModel(0, 0, 1000, 1);
            jSPCantidad.setModel(spModel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSelectProveedor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblSelectMaterial = new javax.swing.JLabel();
        jSPCantidad = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTFPrecioUni = new LIB.FSTexFieldMD();
        jTFMaterial = new LIB.FSTexFieldMD();
        jTFProveedor = new LIB.FSTexFieldMD();
        jTFEncargado = new LIB.FSTexFieldMD();
        jTFPrecioTotal = new LIB.FSTexFieldMD();
        btnIngresar = new LIB.FSButtonMD();
        btnBorrarCampos = new LIB.FSButtonMD();
        btnModificar = new LIB.FSButtonMD();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla = new rojerusan.RSTableMetro();
        lblCampo1 = new javax.swing.JLabel();
        jTFUnidad = new LIB.FSTexFieldMD();
        jTFBusquedaMaterial = new LIB.FSTexFieldMD();
        jLabel10 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        jToggleButton1.setText("jToggleButton1");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel6.setText("Proveedor");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setText("Unidad Medida");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel2.setText("Encargado");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel8.setText("Precio Unitario $:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel7.setText("Cantidad ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        lblSelectProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        lblSelectProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectProveedorMouseClicked(evt);
            }
        });
        add(lblSelectProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, 40, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel4.setText("Precio Total  $:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("REGISTRO DE COMPRAS");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, 50));

        lblSelectMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        lblSelectMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectMaterialMouseClicked(evt);
            }
        });
        add(lblSelectMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));

        jSPCantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jSPCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSPCantidadStateChanged(evt);
            }
        });
        add(jSPCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 260, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel5.setText("Material");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconRegistroCompras.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, 50));

        jTFPrecioUni.setForeground(new java.awt.Color(0, 0, 0));
        jTFPrecioUni.setBordeColorFocus(new java.awt.Color(0, 51, 51));
        jTFPrecioUni.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFPrecioUni.setPlaceholder("");
        add(jTFPrecioUni, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 260, 40));

        jTFMaterial.setEditable(false);
        jTFMaterial.setForeground(new java.awt.Color(0, 0, 0));
        jTFMaterial.setBordeColorFocus(new java.awt.Color(0, 51, 51));
        jTFMaterial.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFMaterial.setPlaceholder("");
        add(jTFMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 220, 40));

        jTFProveedor.setEditable(false);
        jTFProveedor.setForeground(new java.awt.Color(0, 0, 0));
        jTFProveedor.setBordeColorFocus(new java.awt.Color(0, 51, 51));
        jTFProveedor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFProveedor.setPlaceholder("");
        add(jTFProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 220, 40));

        jTFEncargado.setForeground(new java.awt.Color(0, 0, 0));
        jTFEncargado.setBordeColorFocus(new java.awt.Color(0, 51, 51));
        jTFEncargado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFEncargado.setPlaceholder("");
        jTFEncargado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFEncargadoKeyTyped(evt);
            }
        });
        add(jTFEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 590, 210, 40));

        jTFPrecioTotal.setForeground(new java.awt.Color(0, 0, 0));
        jTFPrecioTotal.setBordeColorFocus(new java.awt.Color(0, 51, 51));
        jTFPrecioTotal.setEnabled(false);
        jTFPrecioTotal.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFPrecioTotal.setPlaceholder("");
        add(jTFPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 260, 40));

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Agregar.png"))); // NOI18N
        btnIngresar.setText("  Ingresar Compra");
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
        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 310, -1));

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
        add(btnBorrarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 290, -1));

        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Iconos_Actualizar.png"))); // NOI18N
        btnModificar.setText("  Modificar Compra");
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
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 300, -1));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Material", "Encargado", "Proveedor", "Cantidad  ", "Precio", "Monto", "Disponible", "Estado", "Unidad", "Fecha"
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
            Tabla.getColumnModel().getColumn(4).setMinWidth(90);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(90);
            Tabla.getColumnModel().getColumn(4).setMaxWidth(90);
            Tabla.getColumnModel().getColumn(7).setMinWidth(0);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(0);
            Tabla.getColumnModel().getColumn(7).setMaxWidth(0);
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

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 670, 260));

        lblCampo1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblCampo1.setText("Material");
        add(lblCampo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, -1, 50));

        jTFUnidad.setEditable(false);
        jTFUnidad.setForeground(new java.awt.Color(0, 0, 0));
        jTFUnidad.setBordeColorFocus(new java.awt.Color(0, 51, 51));
        jTFUnidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFUnidad.setPlaceholder("");
        add(jTFUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, 260, 40));

        jTFBusquedaMaterial.setForeground(new java.awt.Color(0, 0, 0));
        jTFBusquedaMaterial.setBordeColorFocus(new java.awt.Color(0, 51, 51));
        jTFBusquedaMaterial.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTFBusquedaMaterial.setPlaceholder("");
        jTFBusquedaMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBusquedaMaterialKeyTyped(evt);
            }
        });
        add(jTFBusquedaMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 460, 170, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_SmallBusqueda.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(934, 440, 40, 90));
    }// </editor-fold>//GEN-END:initComponents

    //Declaracion de objetos de clases a utilizar
    Materiales mat = new Materiales();
    Imagen img = new Imagen();
    Funciones fun = new Funciones();
    FuncionesSQL sql = new FuncionesSQL();

    //Declaracion de atributos de la clase
    private SpinnerNumberModel spModel;
    private int cantidadInicial;
    private int idRegistro;
    public static DefaultTableModel tb;
    private int fila;

    private void borrarCampos() {
        spModel = new SpinnerNumberModel(0, 0, 1000, 1);
        jSPCantidad.setModel(spModel);
        jTFMaterial.setText(null);
        jTFProveedor.setText(null);
        jTFPrecioUni.setText(null);
        jTFPrecioTotal.setText(null);
        jTFUnidad.setText(null);
        btnIngresar.setEnabled(true);
        btnModificar.setEnabled(false);
        jTFEncargado.setEnabled(true);
        sql.cargarTabla("select * from Vista_CompraMaterial", tb);
    }

    private void cargarTabla() {
        tb = (DefaultTableModel) Tabla.getModel();
        sql.cargarTabla("select * from Vista_CompraMaterial", tb);
    }

    private void lblSelectMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectMaterialMouseClicked
        frmBuscador c = new frmBuscador("materiales", 1);
        c.setVisible(true);
    }//GEN-LAST:event_lblSelectMaterialMouseClicked

    private void lblSelectProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectProveedorMouseClicked
        frmBuscador c = new frmBuscador("empresa", 2);
        c.setVisible(true);
    }//GEN-LAST:event_lblSelectProveedorMouseClicked

    private void jSPCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSPCantidadStateChanged
        fun.calcularTotal(jSPCantidad, jTFPrecioUni, jTFPrecioTotal);
        if (jTFPrecioUni.getText().trim().equals("")) {
            jSPCantidad.setValue(0);
            jTFPrecioTotal.setText(null);
        }
    }//GEN-LAST:event_jSPCantidadStateChanged

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (jTFMaterial.getText().isEmpty() || jTFPrecioTotal.getText().isEmpty() || Integer.parseInt(jTFPrecioTotal.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        } else {
            mat.setCantidadComprada(Integer.parseInt(jSPCantidad.getValue().toString()));
            mat.setEncargado(sql.getIdentificador("select * from Usuario where Usuario = 'Castroll'"));
            mat.setMaterial(sql.getIdentificador("select * from Materiales where Nombre_Material = '" + jTFMaterial.getText() + "'"));
            mat.setMontoCompra(Double.parseDouble(jTFPrecioTotal.getText()));
            mat.setPrecioUnitari(Double.parseDouble(jTFPrecioUni.getText()));
            mat.setProveedor(sql.getIdentificador("select * from Empresa where Nombre_Empresa = '" + jTFProveedor.getText() + "'"));
            if (mat.ingresarCompraMaterial(mat)) {
                cargarTabla();
                borrarCampos();
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnBorrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCamposActionPerformed
        borrarCampos();
        cargarTabla();
    }//GEN-LAST:event_btnBorrarCamposActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTFMaterial.getText().isEmpty() || jTFPrecioTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        } else {
            int cantidadReal = Integer.parseInt(jSPCantidad.getValue().toString()) - cantidadInicial;
            mat.setIdCompra(idRegistro);
            mat.setCantidadComprada(Integer.parseInt(jSPCantidad.getValue().toString()));
            mat.setCantidadReal(cantidadReal);
            mat.setEncargado(sql.getIdentificador("select * from Usuario where Usuario = '" + jTFEncargado.getText() + "'"));
            mat.setMaterial(sql.getIdentificador("select * from Materiales where Nombre_Material = '" + jTFMaterial.getText() + "'"));
            mat.setMontoCompra(Double.parseDouble(jTFPrecioTotal.getText()));
            mat.setPrecioUnitari(Double.parseDouble(jTFPrecioUni.getText()));
            mat.setProveedor(sql.getIdentificador("select * from Empresa where Nombre_Empresa = '" + jTFProveedor.getText() + "'"));
            if (mat.modificarCompraMaterial(mat)) {
                cargarTabla();
                borrarCampos();
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        fila = Tabla.getSelectedRow();
        jTFEncargado.setEditable(false);
        idRegistro = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
        jTFMaterial.setText(Tabla.getValueAt(fila, 1).toString());
        jTFEncargado.setText(Tabla.getValueAt(fila, 2).toString());
        jTFProveedor.setText(Tabla.getValueAt(fila, 3).toString());
        cantidadInicial = Integer.parseInt(Tabla.getValueAt(fila, 4).toString());
        jTFPrecioUni.setText(Tabla.getValueAt(fila, 5).toString());
        jTFPrecioTotal.setText(Tabla.getValueAt(fila, 6).toString());
        jSPCantidad.setValue(Integer.parseInt(Tabla.getValueAt(fila, 4).toString()));
        //jTFEstado.setText(Tabla.getValueAt(fila, 8).toString()); //1 salto
        jTFUnidad.setText(Tabla.getValueAt(fila, 9).toString());
        btnIngresar.setEnabled(false);
        btnModificar.setEnabled(true);
    }//GEN-LAST:event_TablaMouseClicked

    private void jTFBusquedaMaterialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusquedaMaterialKeyTyped
        if (jTFBusquedaMaterial.getText().length() > 1) {
            String material = "%" + jTFBusquedaMaterial.getText() + "%";
            sql.cargarTabla("select * from Vista_CompraMaterial where Nombre_Material like '" + material + "'", tb);
        } else {
            cargarTabla();
        }
    }//GEN-LAST:event_jTFBusquedaMaterialKeyTyped

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

    }//GEN-LAST:event_jLabel10MouseClicked

    private void jTFEncargadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFEncargadoKeyTyped
        if (jTFEncargado.getText().length() > 1) {
            String encargado = "%" + jTFEncargado.getText() + "%";
            sql.cargarTabla("select * from Vista_CompraMaterial where Encargado like '" + encargado + "'", tb);
        } else {
            cargarTabla();
        }
    }//GEN-LAST:event_jTFEncargadoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Tabla;
    private LIB.FSButtonMD btnBorrarCampos;
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
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSpinner jSPCantidad;
    private javax.swing.JScrollPane jScrollPane3;
    public static LIB.FSTexFieldMD jTFBusquedaMaterial;
    public static LIB.FSTexFieldMD jTFEncargado;
    public static LIB.FSTexFieldMD jTFMaterial;
    public static LIB.FSTexFieldMD jTFPrecioTotal;
    private LIB.FSTexFieldMD jTFPrecioUni;
    public static LIB.FSTexFieldMD jTFProveedor;
    public static LIB.FSTexFieldMD jTFUnidad;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblCampo1;
    private javax.swing.JLabel lblSelectMaterial;
    private javax.swing.JLabel lblSelectProveedor;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
