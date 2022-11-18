package Vista.PreLogin;

import Clases.ClassFunciones;
import Clases.ClassFuncionesSQL;
import Clases.ClassImagenes;
import Clases.ClassSeguridad;
import Clases.ClassRespuestas;
import Controlador.MtoEmpresa;
import Controlador.MtoPersonal;
import Controlador.MtoUsuarios;
import FiveCodMover.FiveCodMoverJFrame;
import Vista.Frames.frmLogin;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/** Clase del formulario menu de primer uso
 * @since 11/07/2020
 * @author Diego Castro
 * @version 1.0
 */
public final class frmPrimerUso extends javax.swing.JFrame 
{
    public frmPrimerUso() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarFormularios(emp); //Primer formulario mostrado al cargar formulario empresa
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlOpciones = new javax.swing.JPanel();
        lblConfig = new javax.swing.JLabel();
        lblInicial = new javax.swing.JLabel();
        PanelAdmin = new javax.swing.JPanel();
        LineDirecta = new javax.swing.JPanel();
        PanelSideEmpresa = new javax.swing.JPanel();
        PanelSideEmp = new javax.swing.JPanel();
        lblConfigEmpresa = new javax.swing.JLabel();
        lblConfigRoot = new javax.swing.JLabel();
        PanelSidePreguntas = new javax.swing.JPanel();
        PanelCorreo = new javax.swing.JPanel();
        PanelSideCorreo = new javax.swing.JPanel();
        lblConfigSeg = new javax.swing.JLabel();
        PanelSideFin = new javax.swing.JPanel();
        PanelSideConfig = new javax.swing.JPanel();
        lblConfigFin = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        PnlContenedor = new javax.swing.JPanel();
        PanelPreg = new javax.swing.JPanel();
        BarraTitulo = new javax.swing.JPanel();
        lblMinimizar = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblPrimerUso = new javax.swing.JLabel();
        PnlControles = new javax.swing.JPanel();
        PnlContinuar = new javax.swing.JPanel();
        lblContinuar = new javax.swing.JLabel();
        lbl_Continuar = new javax.swing.JLabel();
        PnlRegresar = new javax.swing.JPanel();
        lblRegresar = new javax.swing.JLabel();
        lbl_Regresar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlOpciones.setBackground(new java.awt.Color(51, 73, 94));

        lblConfig.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblConfig.setForeground(new java.awt.Color(255, 255, 255));
        lblConfig.setText("CONFIGURACION");

        lblInicial.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblInicial.setForeground(new java.awt.Color(255, 255, 255));
        lblInicial.setText("INICIAL");

        PanelAdmin.setBackground(new java.awt.Color(51, 73, 94));
        PanelAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout LineDirectaLayout = new javax.swing.GroupLayout(LineDirecta);
        LineDirecta.setLayout(LineDirectaLayout);
        LineDirectaLayout.setHorizontalGroup(
            LineDirectaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        LineDirectaLayout.setVerticalGroup(
            LineDirectaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        PanelAdmin.add(LineDirecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        PanelSideEmpresa.setBackground(new java.awt.Color(0, 0, 153));
        PanelSideEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PanelSideEmpLayout = new javax.swing.GroupLayout(PanelSideEmp);
        PanelSideEmp.setLayout(PanelSideEmpLayout);
        PanelSideEmpLayout.setHorizontalGroup(
            PanelSideEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        PanelSideEmpLayout.setVerticalGroup(
            PanelSideEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        PanelSideEmpresa.add(PanelSideEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        PanelAdmin.add(PanelSideEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblConfigEmpresa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblConfigEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblConfigEmpresa.setText("Configuracion de Empresa");
        PanelAdmin.add(lblConfigEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 250, 35));

        lblConfigRoot.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblConfigRoot.setForeground(new java.awt.Color(255, 255, 255));
        lblConfigRoot.setText("Configuracion de ROOT");

        javax.swing.GroupLayout PanelSidePreguntasLayout = new javax.swing.GroupLayout(PanelSidePreguntas);
        PanelSidePreguntas.setLayout(PanelSidePreguntasLayout);
        PanelSidePreguntasLayout.setHorizontalGroup(
            PanelSidePreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        PanelSidePreguntasLayout.setVerticalGroup(
            PanelSidePreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        PanelCorreo.setBackground(new java.awt.Color(51, 73, 94));
        PanelCorreo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PanelSideCorreoLayout = new javax.swing.GroupLayout(PanelSideCorreo);
        PanelSideCorreo.setLayout(PanelSideCorreoLayout);
        PanelSideCorreoLayout.setHorizontalGroup(
            PanelSideCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        PanelSideCorreoLayout.setVerticalGroup(
            PanelSideCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        PanelCorreo.add(PanelSideCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblConfigSeg.setBackground(new java.awt.Color(51, 73, 94));
        lblConfigSeg.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblConfigSeg.setForeground(new java.awt.Color(255, 255, 255));
        lblConfigSeg.setText("Configuracion de Seguridad");
        PanelCorreo.add(lblConfigSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 35));

        PanelSideFin.setBackground(new java.awt.Color(51, 73, 94));
        PanelSideFin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PanelSideConfigLayout = new javax.swing.GroupLayout(PanelSideConfig);
        PanelSideConfig.setLayout(PanelSideConfigLayout);
        PanelSideConfigLayout.setHorizontalGroup(
            PanelSideConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        PanelSideConfigLayout.setVerticalGroup(
            PanelSideConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        PanelSideFin.add(PanelSideConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblConfigFin.setBackground(new java.awt.Color(51, 73, 94));
        lblConfigFin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblConfigFin.setForeground(new java.awt.Color(255, 255, 255));
        lblConfigFin.setText("Finalizar Configuracion");
        PanelSideFin.add(lblConfigFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 35));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconAjustesInicial.png"))); // NOI18N

        javax.swing.GroupLayout PnlOpcionesLayout = new javax.swing.GroupLayout(PnlOpciones);
        PnlOpciones.setLayout(PnlOpcionesLayout);
        PnlOpcionesLayout.setHorizontalGroup(
            PnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlOpcionesLayout.createSequentialGroup()
                .addComponent(PanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PnlOpcionesLayout.createSequentialGroup()
                .addGroup(PnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlOpcionesLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(PnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblConfig)
                            .addComponent(lblInicial))
                        .addGap(18, 18, 18)
                        .addComponent(lblIcono))
                    .addGroup(PnlOpcionesLayout.createSequentialGroup()
                        .addComponent(PanelSidePreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblConfigRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelSideFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        PnlOpcionesLayout.setVerticalGroup(
            PnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlOpcionesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PnlOpcionesLayout.createSequentialGroup()
                        .addComponent(lblConfig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInicial))
                    .addComponent(lblIcono))
                .addGap(71, 71, 71)
                .addComponent(PanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(PnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConfigRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelSidePreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(PanelCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(PanelSideFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        getContentPane().add(PnlOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 330, 499));

        PnlContenedor.setBackground(new java.awt.Color(255, 255, 255));

        PanelPreg.setBackground(new java.awt.Color(51, 73, 94));
        PanelPreg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PnlContenedorLayout = new javax.swing.GroupLayout(PnlContenedor);
        PnlContenedor.setLayout(PnlContenedorLayout);
        PnlContenedorLayout.setHorizontalGroup(
            PnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(PanelPreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 711, Short.MAX_VALUE))
        );
        PnlContenedorLayout.setVerticalGroup(
            PnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorLayout.createSequentialGroup()
                .addGap(0, 232, Short.MAX_VALUE)
                .addComponent(PanelPreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 188, Short.MAX_VALUE))
        );

        getContentPane().add(PnlContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 750, 420));

        BarraTitulo.setBackground(new java.awt.Color(33, 50, 66));
        BarraTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraTituloMouseDragged(evt);
            }
        });
        BarraTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraTituloMousePressed(evt);
            }
        });
        BarraTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Boton-Minimizar.png"))); // NOI18N
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });
        BarraTitulo.add(lblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, -1, 40));

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Boton-Cerrar.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        BarraTitulo.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, -1, 40));

        lblPrimerUso.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblPrimerUso.setForeground(new java.awt.Color(255, 255, 255));
        lblPrimerUso.setText("PRIMER USO DEL SISTEMA");
        BarraTitulo.add(lblPrimerUso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        getContentPane().add(BarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        PnlControles.setBackground(new java.awt.Color(255, 255, 255));

        PnlContinuar.setBackground(new java.awt.Color(51, 73, 94));

        lblContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Siguiente.png"))); // NOI18N
        lblContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblContinuarMouseClicked(evt);
            }
        });

        lbl_Continuar.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lbl_Continuar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Continuar.setText("Continuar");

        javax.swing.GroupLayout PnlContinuarLayout = new javax.swing.GroupLayout(PnlContinuar);
        PnlContinuar.setLayout(PnlContinuarLayout);
        PnlContinuarLayout.setHorizontalGroup(
            PnlContinuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlContinuarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_Continuar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContinuar)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        PnlContinuarLayout.setVerticalGroup(
            PnlContinuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContinuarLayout.createSequentialGroup()
                .addGroup(PnlContinuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_Continuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PnlRegresar.setBackground(new java.awt.Color(51, 73, 94));

        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/Icono_Anterior.png"))); // NOI18N
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMouseClicked(evt);
            }
        });

        lbl_Regresar.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lbl_Regresar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Regresar.setText("Regresar");

        javax.swing.GroupLayout PnlRegresarLayout = new javax.swing.GroupLayout(PnlRegresar);
        PnlRegresar.setLayout(PnlRegresarLayout);
        PnlRegresarLayout.setHorizontalGroup(
            PnlRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlRegresarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Regresar)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        PnlRegresarLayout.setVerticalGroup(
            PnlRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlRegresarLayout.createSequentialGroup()
                .addGroup(PnlRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(lbl_Regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PnlControlesLayout = new javax.swing.GroupLayout(PnlControles);
        PnlControles.setLayout(PnlControlesLayout);
        PnlControlesLayout.setHorizontalGroup(
            PnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlControlesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(PnlRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                .addComponent(PnlContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        PnlControlesLayout.setVerticalGroup(
            PnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PnlRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PnlContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(PnlControles, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 750, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Creacion de objetos de todos los paneles que se mostraran en el menu   
    PnlPrimerFinalizar fin = new PnlPrimerFinalizar();
    PnlPrimerRoot root = new PnlPrimerRoot();
    PnlPrimerEmpresa emp = new PnlPrimerEmpresa();
    
    //Creacion de objetos de clases de mantenimientos
    MtoEmpresa empre = new MtoEmpresa();
    MtoPersonal per = new MtoPersonal();
    MtoUsuarios user = new MtoUsuarios();
   
    //Creacion de objetos de las clases a utilizar
    ClassFuncionesSQL sql = new ClassFuncionesSQL();
    ClassFunciones fun = new ClassFunciones();
    ClassRespuestas seguridad = new ClassRespuestas();
    ClassImagenes img = new ClassImagenes();
    ClassSeguridad encry = new ClassSeguridad();
    

    /** Atributo que contiene el identicador del panel en el que se encuentra el usuario
     *
     */
    protected static int id = 1;
    
    /** Metodo para comprobar si se debe actualizar o ingresar datos en la tabla empresa ademas de validar los campos vacios
     * @return si se logro ejecutar la sentencia correspondiente
     */
    public boolean sentenciaEmpresa()
    {
        boolean respuesta = false;
        if (emp.txtEmpresa.getText().isEmpty() || emp.txtCorreo.getText().isEmpty()|| emp.txtTelefono.getText().isEmpty()|| emp.txtUbicacion.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        }
        else
        {
            if (!emp.txtCorreo.getText().endsWith("@gmail.com")) 
            {
                JOptionPane.showMessageDialog(null, "Debes ingresar una direccion de correo valida");
            }
            else
            {
                empre.setEmpresa(emp.txtEmpresa.getText());
                empre.setUbicacion(emp.txtUbicacion.getText());
                empre.setTelefono(emp.txtTelefono.getText());
                empre.setCorreo(emp.txtCorreo.getText());                    
                if (JOptionPane.showConfirmDialog(this, "Desea ingresar el logo seleccionado","Desea continuar",JOptionPane.YES_NO_OPTION)== 0) 
                {
                    empre.setCargarLogo(img.codificarLogo(emp.path));
                }
                if (PnlPrimerEmpresa.consulta == 1) //Ejecutar metodo actualizar 
                {
                    respuesta = empre.modificarEmpresa(empre);
                }
                else //Ejecutar metodo ingresar
                {
                    respuesta = empre.ingresarEmpresa(empre);
                }
            }
        }
        return respuesta;
    }
    
    /** Metodo para comprobar si se debe actualizar o ingresar datos en la tabla usuario ademas de validar los campos vacios
     * @return si se logro ejecutar la sentencia correspondiente
     */
    private boolean sentenciaUsuario()
    {
        boolean respuesta = false;
        if (root.txtUsuario.getText().trim().isEmpty() || root.txtClave.getText().trim().isEmpty()||root.txtNombre.getText().trim().isEmpty() || root.txtApellido.getText().trim().isEmpty() || root.txtDUI.getText().trim().isEmpty()||  root.txtSalario.getText().trim().isEmpty()) 
        {
             JOptionPane.showMessageDialog(null, "Complete todos los campos obligatorios","Existen campos vacion",2);
        }
        else
        {          
            if (root.txtClave.getText().equals(root.txtConfirmar.getText())) 
            {
                if (!root.txtCorreo.getText().endsWith("@gmail.com")) 
                {
                    JOptionPane.showMessageDialog(null, "Ingrese un correo valido");
                }
                else
                {//consPer consUser
                    user.setUsuario(root.txtUsuario.getText());          
                    per.setNombre(root.txtNombre.getText());
                    per.setApellido(root.txtApellido.getText());
                    user.setCorreo(root.txtCorreo.getText());
                    per.setDui(root.txtDUI.getText());
                    user.setClave(encry.encriptacionMD5(root.txtClave.getText()));
                    per.setProfesion(sql.getIdentificador("select * from Profesion where Profesion = '"+PnlPrimerRoot.txtProfesion.getText()+"'"));
                    per.setSueldo(Double.parseDouble(root.txtSalario.getText()));
                    per.setContratacion(fun.ConvertirFecha(PnlPrimerRoot.DateContratacion.getFormatoFecha()));
                    user.setEstado(1);
                    user.setTipo(1);
                    try
                    {
                        per.setTelefono(root.txtTelefono.getText());
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }           
                    if (per.ingresarPersonal(per)) //Ejecutamos los dos metodos de ingresar trabajador
                    {
                        respuesta = user.ingresarUsuario(user); //Ingresar los datos del usuario
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
        }
        return respuesta;
    }
    
    /** Metodo para validar los datos y para ingresar los datos en la tabla respuestas preguntas
     * @return si se logro ejecutar la sentencia correspondiente
     */
   /* public boolean sentenciaSeguridad()
    {
        boolean respuesta = false;
        if (seg.cmbPregunta1.getSelectedIndex() == seg.cmbPregunta2.getSelectedIndex()|| seg.cmbPregunta3.getSelectedIndex() == seg.cmbPregunta2.getSelectedIndex() || seg.cmbPregunta1.getSelectedIndex() == seg.cmbPregunta3.getSelectedIndex()) 
        {
            JOptionPane.showMessageDialog(null, "Debes seleccionar preguntas diferentes");
        }
        else
        {
            if (seg.txtRespuesta1.getText().isEmpty()|| seg.txtRespuesta2.getText().isEmpty()|| seg.txtRespuesta3.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(null,"No puedes dejar campos vacios");
            }
            else
            {
                String[] respuestas = new String[3]; //Declaracion de matricez para almacenar las respuestas encriptadas
                int[] preguntas = new int[3]; //Declaracion de matricez para almacenar el id de las preguntas
                preguntas[0] = seg.cmbPregunta1.getSelectedIndex()+2; //Sumamos dos porque el index de las preguntas comienza en 0 y la primer pregunta es tiene valor 2
                preguntas[1] = seg.cmbPregunta2.getSelectedIndex()+2;
                preguntas[2] = seg.cmbPregunta3.getSelectedIndex()+2;
                respuestas[0] = encry.encriptacionMD5(seg.txtRespuesta1.getText());
                respuestas[1] = encry.encriptacionMD5(seg.txtRespuesta2.getText());
                respuestas[2] = encry.encriptacionMD5(seg.txtRespuesta3.getText());
                seguridad.setPregunta(preguntas); //Enviamos la matriz a la clase de mantenimientos
                seguridad.setRespuesta(respuestas);
                respuesta = (seguridad.asignarPreguntas(seguridad));                          
            }            
        }       
        return respuesta;
    }*/
   
    /** Metodo para eliminar el efecto hover de todos los elementos del menu
     * 
     */
    private void EliminarHover()
    {
        LineDirecta.setBackground(new java.awt.Color(240,240,240));  
        PanelSidePreguntas.setBackground(new java.awt.Color(240,240,240));  
        PanelSideCorreo.setBackground(new java.awt.Color(240,240,240));  
        PanelSideConfig.setBackground(new java.awt.Color(240,240,240));  
    }
    
    /**
     * Metodo para cargar los formularios en el panel contenedor
     * @param panel panel que desea mostrarse
     */
    private void cargarFormularios(JPanel panel)
    {
        EliminarHover();
        LineDirecta.setBackground(new java.awt.Color(0,153,51));
        panel.setLocation(5,5);
        panel.setSize(900,500);
        PnlContenedor.removeAll();
        PnlContenedor.add(panel,BorderLayout.CENTER);
        PnlContenedor.revalidate();
        PnlContenedor.repaint();
    }  

    /** Metodo para avanzar de formulario en formulario dentro del menu
     * @param id identificador del panel que el menu debe mostrar 
     */
    private void avanzarFormulario(int id)
    {
        switch(id)
        {
            case(1): //En este caso muestra el panel empresa
                if (sentenciaEmpresa()==true) 
                {
                   cargarFormularios(root);
                   frmPrimerUso.id = 2; //ID estatico del formulario para saber la accion que se debe realizar
                }
                break;
            
            case(2): //En este caso muestra el panel usuario
                if (sentenciaUsuario()==true) 
                {
                    ///cargarFormularios();
                    //frmPrimerUso.id = 3;
                }
                break;
                
            case(3): //En este caso muestra el panel preguntas
               /* if (sentenciaSeguridad() == true) 
                {
                    cargarFormularios(fin);
                    frmPrimerUso.id = 4;
                }    */         
            break;
            
            case(4): //En este caso muestra el login
                frmLogin c = new frmLogin();
                c.setVisible(true);
                this.dispose();
            break;
        }
    }
           
    /** Metodo para ir retrocediendo de formulario en formulario dentro del menu*/
    private void retrocederFormulario()
    {
        if (frmPrimerUso.id  != 1) //Si el id no es igual a 1 se restara una unidad
        {
            frmPrimerUso.id = frmPrimerUso.id - 1;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No puedes retroceder mas");
        }
        switch(id) 
        {
            case(1):
                cargarFormularios(emp);
                PnlPrimerEmpresa.consulta = 1;
            break;
            
            case(2):
                cargarFormularios(root);
            break;
            
            /*case(3):
                cargarFormularios(seg);
            break;*/
            
            case(4):
                cargarFormularios(fin);
            break;
        }
    }
    
    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        System.exit(1);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void BarraTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraTituloMouseDragged
        FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_BarraTituloMouseDragged

    private void BarraTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraTituloMousePressed
        FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_BarraTituloMousePressed

    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        retrocederFormulario();
    }//GEN-LAST:event_lblRegresarMouseClicked

    private void lblContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblContinuarMouseClicked
        avanzarFormulario(id);
    }//GEN-LAST:event_lblContinuarMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrimerUso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrimerUso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraTitulo;
    private javax.swing.JPanel LineDirecta;
    private javax.swing.JPanel PanelAdmin;
    private javax.swing.JPanel PanelCorreo;
    private javax.swing.JPanel PanelPreg;
    private javax.swing.JPanel PanelSideConfig;
    private javax.swing.JPanel PanelSideCorreo;
    private javax.swing.JPanel PanelSideEmp;
    private javax.swing.JPanel PanelSideEmpresa;
    private javax.swing.JPanel PanelSideFin;
    private javax.swing.JPanel PanelSidePreguntas;
    private javax.swing.JPanel PnlContenedor;
    private javax.swing.JPanel PnlContinuar;
    private javax.swing.JPanel PnlControles;
    private javax.swing.JPanel PnlOpciones;
    private javax.swing.JPanel PnlRegresar;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblConfig;
    private javax.swing.JLabel lblConfigEmpresa;
    private javax.swing.JLabel lblConfigFin;
    private javax.swing.JLabel lblConfigRoot;
    private javax.swing.JLabel lblConfigSeg;
    private javax.swing.JLabel lblContinuar;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblInicial;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblPrimerUso;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lbl_Continuar;
    private javax.swing.JLabel lbl_Regresar;
    // End of variables declaration//GEN-END:variables
}
