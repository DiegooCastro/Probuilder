/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.PreLogin;
import Clases.ClassImagenes;
import Clases.ClassSeguridad;
import Controlador.MtoEmpresa;

/** Formulario de configuracion de primer empresa
 * @since 13/07/2020
 * @author Diego Castro
 * @version 1.0
 */
public class PnlPrimerEmpresa extends javax.swing.JPanel {

    //Declaracion de objetos de las clases a utilizar 
    MtoEmpresa obj = new MtoEmpresa();
    ClassImagenes funciones = new ClassImagenes();
    ClassSeguridad seg = new ClassSeguridad();
    
    //Variable para definir si se debe ingresar o actualizar
    public static int consulta;
    
    /** Contiene la ruta de la imagen seleccionada*/
    protected String path;
    
    public PnlPrimerEmpresa()
    {
        initComponents();
        inicialEmpresa();
        validacionJTextField();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlContenedor = new javax.swing.JPanel();
        PnlFondoLogo = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblCargarImagen = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JFormattedTextField();
        lblUbicacion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        lblEmpresa = new javax.swing.JLabel();
        lblConfigEmpresa = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtEmpresa = new javax.swing.JTextField();

        PnlContenedor.setBackground(new java.awt.Color(255, 255, 255));
        PnlContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlFondoLogo.setBackground(new java.awt.Color(255, 255, 255));
        PnlFondoLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout PnlFondoLogoLayout = new javax.swing.GroupLayout(PnlFondoLogo);
        PnlFondoLogo.setLayout(PnlFondoLogoLayout);
        PnlFondoLogoLayout.setHorizontalGroup(
            PnlFondoLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        PnlFondoLogoLayout.setVerticalGroup(
            PnlFondoLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        PnlContenedor.add(PnlFondoLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 200, 130));

        lblLogo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblLogo.setText("Logo");
        PnlContenedor.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, -1));

        lblCargarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Add.png"))); // NOI18N
        lblCargarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCargarImagenMouseClicked(evt);
            }
        });
        PnlContenedor.add(lblCargarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        PnlContenedor.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 250, -1));

        lblUbicacion.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblUbicacion.setText("Ubicacion*");
        PnlContenedor.add(lblUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTelefono.setText("Telefono*");
        PnlContenedor.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        PnlContenedor.add(txtUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 250, -1));

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblEmpresa.setText("Empresa*");
        PnlContenedor.add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        lblConfigEmpresa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblConfigEmpresa.setText("Configuracion de primera empresa ");
        PnlContenedor.add(lblConfigEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconPrimerEmpresa.png"))); // NOI18N
        PnlContenedor.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblCorreo.setText("Correo*");
        PnlContenedor.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));
        PnlContenedor.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 200, -1));
        PnlContenedor.add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 250, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para asignar las validaciones correspondientes a cada uno de los JTextField
     */
    private void validacionJTextField()
    {
        seg.soloLetras(txtEmpresa);
        seg.longitudMaxima(txtCorreo,35);
        seg.longitudMaxima(txtUbicacion,60);
        seg.longitudMaxima(txtEmpresa,35);
    }
    
    /** Metodo inicial del panel primer empresa valida si existen datos previos en la base de datos
     */
    private void inicialEmpresa()
    {
        if (obj.cargarSucursal(obj)== true) 
        {
            txtEmpresa.setText(obj.getEmpresa());
            txtUbicacion.setText(obj.getUbicacion());
            txtTelefono.setText(obj.getTelefono());
            txtCorreo.setText(obj.getCorreo());           
            try
            {
                funciones.cargarLogo(obj.getCargarLogo(),lblImagen);
            }
            catch(Exception e){}
            consulta = 1;
        }
        else
        {
            consulta = 2;
        }
        frmPrimerUso.id = 1;
    }  
    
    private void lblCargarImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCargarImagenMouseClicked
        path = funciones.seleccionarImagen(lblImagen); //Metodo para realizar todo el proceso de carga de la imagen  
    }//GEN-LAST:event_lblCargarImagenMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlContenedor;
    private javax.swing.JPanel PnlFondoLogo;
    private javax.swing.JLabel lblCargarImagen;
    private javax.swing.JLabel lblConfigEmpresa;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblIcono;
    public javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblUbicacion;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtEmpresa;
    public javax.swing.JFormattedTextField txtTelefono;
    public javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
