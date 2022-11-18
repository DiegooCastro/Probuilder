package Vista.PreLogin;
import Clases.ClassSeguridad;
import Vista.Frames.frmCatalogoMini;

/** Clase del panel primer root configuracion de primer uso
 * @since 12/07/2020
 * @author Diego Castro
 * @version 1.0
 */
public class PnlPrimerRoot extends javax.swing.JPanel {

    //Declaracion de objetos y variables para su uso en la clase
    ClassSeguridad encry = new ClassSeguridad();
    
    public PnlPrimerRoot() 
    {
        initComponents();
        validacionJTextField();
    } 
    
    /**
     * Metodo para asignar las validaciones correspondientes a cada uno de los JTextField
     */
    private void validacionJTextField()
    {
        encry.soloLetras(txtNombre);
        encry.soloLetras(txtApellido);
        encry.soloNumeros(txtSalario);
        encry.longitudMaxima(txtUsuario,35);
        encry.longitudMaxima(txtNombre,30);
        encry.longitudMaxima(txtApellido,30);
        encry.longitudMaxima(txtClave, 35);
        encry.longitudMaxima(txtConfirmar, 35);
        encry.longitudMaxima(txtCorreo, 50);
        encry.longitudMaxima(txtSalario, 8);
        encry.longitudMaxima(txtDireccion, 60);
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblConfirmar = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        lblContraseña = new javax.swing.JLabel();
        txtConfirmar = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        lblDUI = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblProfesion = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        lblContratacion = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtSalario = new javax.swing.JTextField();
        txtDUI = new javax.swing.JFormattedTextField();
        lblIcono = new javax.swing.JLabel();
        txtProfesion = new javax.swing.JTextField();
        lblSelectProfesion = new javax.swing.JLabel();
        lblCorreo1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCorreo2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        DateContratacion = new rojeru_san.rsdate.RSDateChooser();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Configuracion de usuario root");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 25, 367, -1));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblUsuario.setText("Usuario*");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 99, -1, -1));

        lblConfirmar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblConfirmar.setText("Confirmar*");
        jPanel1.add(lblConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 201, -1, -1));
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 148, 178, -1));

        lblContraseña.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblContraseña.setText("Contraseña*");
        jPanel1.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 151, -1, -1));
        jPanel1.add(txtConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 198, 178, -1));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 96, 178, -1));

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblNombre.setText("Nombre*");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 250, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 247, 178, -1));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 349, 197, -1));

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblCorreo.setText("Apellido*");
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 302, -1, -1));

        lblDUI.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDUI.setText("DUI*");
        jPanel1.add(lblDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 99, -1, -1));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTelefono.setText("Telefono");
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 151, -1, -1));

        lblProfesion.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProfesion.setText("Profesion*");
        jPanel1.add(lblProfesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 201, -1, -1));

        lblSalario.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblSalario.setText("Salario*");
        jPanel1.add(lblSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        lblContratacion.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblContratacion.setText("Contratacion*");
        jPanel1.add(lblContratacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 302, -1, -1));

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 148, 197, -1));
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 247, 197, -1));

        try {
            txtDUI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 96, 197, -1));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconPrimerRoot.png"))); // NOI18N
        jPanel1.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 8, 70, 56));
        jPanel1.add(txtProfesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 198, 159, -1));

        lblSelectProfesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Add_Elemento.png"))); // NOI18N
        lblSelectProfesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectProfesionMouseClicked(evt);
            }
        });
        jPanel1.add(lblSelectProfesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 198, -1, 26));

        lblCorreo1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblCorreo1.setText("Correo*");
        jPanel1.add(lblCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 352, -1, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 349, 178, -1));

        lblCorreo2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblCorreo2.setText("Direccion");
        jPanel1.add(lblCorreo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 352, -1, -1));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 299, 178, -1));
        jPanel1.add(DateContratacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblSelectProfesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectProfesionMouseClicked
        frmCatalogoMini c = new frmCatalogoMini("profesion",2);
        c.setVisible(true);
    }//GEN-LAST:event_lblSelectProfesionMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static rojeru_san.rsdate.RSDateChooser DateContratacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblContratacion;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCorreo1;
    private javax.swing.JLabel lblCorreo2;
    private javax.swing.JLabel lblDUI;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProfesion;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSelectProfesion;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblUsuario;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JPasswordField txtClave;
    public javax.swing.JPasswordField txtConfirmar;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JFormattedTextField txtDUI;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtProfesion;
    public javax.swing.JTextField txtSalario;
    public javax.swing.JFormattedTextField txtTelefono;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
