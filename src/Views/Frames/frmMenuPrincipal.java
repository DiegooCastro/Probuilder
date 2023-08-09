package Views.Frames;

import Views.Panels.PanelCliente;
import Views.Panels.PanelProyecto;
import Views.Panels.PanelUsuario;
import Views.Panels.PanelPersonal;
import Views.Panels.PanelEmpresa;
import FiveCodMover.FiveCodMoverJFrame;
import Views.Panels.PanelAlmacenaje;
import Views.Panels.PanelRegistroCompras;
import Views.Panels.PanelAsignaciones;
import Views.Panels.PanelMateriales;
import Views.Panels.PanelPreliminares;
import Views.Panels.PanelPresupuesto;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Diego Castro
 */
public class frmMenuPrincipal extends javax.swing.JFrame {

    public frmMenuPrincipal(String usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        lblUsuario.setText("Usuario: " + usuario);
        inicializarMenu();
        ocultarSubMenu(pnlTodos);
        ocultarSide(pnlSide);
    }

    private void ocultarSide(JLabel[] o) {
        for (JLabel o1 : o) {
            o1.setVisible(false);
        }
    }

    //Declaracion de atributos de la clase
    public static String nombreProyecto;
    public static String usuario = "Castroll";
    private int mostrarPresupuesto = 1;
    private int mostrarTrabajador = 1;
    private int mostrarAlmacen = 1;

    //Declaracion de matricez de paneles para hacerlos visibles o invisibles
    JPanel[] pnlTrabajadores = new JPanel[2];
    JPanel[] pnlPresupuesto = new JPanel[3];
    JPanel[] pnlAlmacenaje = new JPanel[2];
    JPanel[] pnlTodos = new JPanel[7];
    JLabel[] pnlSide = new JLabel[7];

    /**
     * Metodo que se encarga de ingresar los paneles btn dentro de las matrices
     * y colocar el borde
     */
    private void inicializarMenu() {
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        pnlPresupuesto[0] = btnManoObra;
        pnlPresupuesto[1] = btnGastoPreliminar;
        pnlPresupuesto[2] = btnMaterial;

        pnlTrabajadores[0] = btnPersonal;
        pnlTrabajadores[1] = btnUsuarios;

        pnlAlmacenaje[0] = btnRegistroMat;
        pnlAlmacenaje[1] = btnCompraMat;

        pnlSide[0] = PanelSideEmpresa;
        pnlSide[1] = PanelSideClientes;
        pnlSide[2] = PanelSideProyectos;
        pnlSide[3] = PanelSidePresupuesto;
        pnlSide[4] = PanelSideTrababajador;
        pnlSide[5] = PanelSideAlmacenaje;
        pnlSide[6] = PanelSideAsignaciones;

        pnlTodos[0] = btnPersonal;
        pnlTodos[1] = btnUsuarios;
        pnlTodos[2] = btnRegistroMat;
        pnlTodos[3] = btnCompraMat;
        pnlTodos[4] = btnManoObra;
        pnlTodos[5] = btnGastoPreliminar;
        pnlTodos[6] = btnMaterial;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        PanelIconos = new javax.swing.JPanel();
        IconoEmpresa = new javax.swing.JLabel();
        IconoTrabajadores = new javax.swing.JLabel();
        IconoClientes = new javax.swing.JLabel();
        IconoProyecto = new javax.swing.JLabel();
        IconoPrespuesto = new javax.swing.JLabel();
        IconoAlmacen = new javax.swing.JLabel();
        IconoCerrarSesion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PanelSidePresupuesto = new javax.swing.JLabel();
        PanelSideEmpresa = new javax.swing.JLabel();
        PanelSideClientes = new javax.swing.JLabel();
        PanelSideTrababajador = new javax.swing.JLabel();
        PanelSideProyectos = new javax.swing.JLabel();
        PanelSideAsignaciones = new javax.swing.JLabel();
        PanelSideAlmacenaje = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JPanel();
        btnEmpresa = new javax.swing.JPanel();
        lblEmpresa = new javax.swing.JLabel();
        btnEspacio = new javax.swing.JPanel();
        lblEspacio = new javax.swing.JLabel();
        btnTrabajadores = new javax.swing.JPanel();
        lblTrabajador = new javax.swing.JLabel();
        lblConTrabajador = new javax.swing.JLabel();
        btnPersonal = new javax.swing.JPanel();
        lblPersonal = new javax.swing.JLabel();
        IconoPersonal = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JPanel();
        lblUsuarios = new javax.swing.JLabel();
        IconoUsuario = new javax.swing.JLabel();
        btnClientes = new javax.swing.JPanel();
        lblClientes = new javax.swing.JLabel();
        btnAlmacen = new javax.swing.JPanel();
        lblAlmacenaje = new javax.swing.JLabel();
        lblConAlmacenaje = new javax.swing.JLabel();
        btnRegistroMat = new javax.swing.JPanel();
        lblRegistro = new javax.swing.JLabel();
        IconoRegistro = new javax.swing.JLabel();
        btnCompraMat = new javax.swing.JPanel();
        lblCompraMateriales = new javax.swing.JLabel();
        lblIconCompraMateriales = new javax.swing.JLabel();
        btnProyectos = new javax.swing.JPanel();
        lblProyecto = new javax.swing.JLabel();
        btnPresupuesto = new javax.swing.JPanel();
        lblPresupuesto = new javax.swing.JLabel();
        lblConPresupuesto = new javax.swing.JLabel();
        btnManoObra = new javax.swing.JPanel();
        lblManoObra = new javax.swing.JLabel();
        lblIconManoObra = new javax.swing.JLabel();
        btnGastoPreliminar = new javax.swing.JPanel();
        lblPreliminar = new javax.swing.JLabel();
        lblIconPreliminares = new javax.swing.JLabel();
        btnMaterial = new javax.swing.JPanel();
        lblMaterial = new javax.swing.JLabel();
        lblIconMateriales = new javax.swing.JLabel();
        btnControlAsig = new javax.swing.JPanel();
        lblClientes1 = new javax.swing.JLabel();
        pnlContenedor = new javax.swing.JPanel();
        pnlSuperior = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        PanelPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelPrincipalMouseDragged(evt);
            }
        });
        PanelPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelPrincipalMousePressed(evt);
            }
        });
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelIconos.setBackground(new java.awt.Color(28, 30, 42));
        PanelIconos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IconoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/empresa.png"))); // NOI18N
        PanelIconos.add(IconoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 50));

        IconoTrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trabajador.png"))); // NOI18N
        PanelIconos.add(IconoTrabajadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 50));

        IconoClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/enProceso.png"))); // NOI18N
        PanelIconos.add(IconoClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 50));

        IconoProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/proyecto.png"))); // NOI18N
        PanelIconos.add(IconoProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 50));

        IconoPrespuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconPresupuesto.png"))); // NOI18N
        PanelIconos.add(IconoPrespuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 50));

        IconoAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/entrega.png"))); // NOI18N
        PanelIconos.add(IconoAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 50));

        IconoCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrarSesion.png"))); // NOI18N
        IconoCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconoCerrarSesionMouseClicked(evt);
            }
        });
        PanelIconos.add(IconoCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, -1, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/actividadRealizada.png"))); // NOI18N
        PanelIconos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 252, -1, 40));

        PanelSidePresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Xd.jpg"))); // NOI18N
        PanelIconos.add(PanelSidePresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, -1));

        PanelSideEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Xd.jpg"))); // NOI18N
        PanelIconos.add(PanelSideEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        PanelSideClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Xd.jpg"))); // NOI18N
        PanelIconos.add(PanelSideClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        PanelSideTrababajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Xd.jpg"))); // NOI18N
        PanelIconos.add(PanelSideTrababajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        PanelSideProyectos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Xd.jpg"))); // NOI18N
        PanelIconos.add(PanelSideProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        PanelSideAsignaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Xd.jpg"))); // NOI18N
        PanelIconos.add(PanelSideAsignaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, -1));

        PanelSideAlmacenaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Xd.jpg"))); // NOI18N
        PanelIconos.add(PanelSideAlmacenaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        pnlMenu.add(PanelIconos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        PanelMenu.setBackground(new java.awt.Color(44, 47, 62));

        btnEmpresa.setBackground(new java.awt.Color(44, 47, 62));
        btnEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpresaMouseClicked(evt);
            }
        });
        btnEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpresa.setText("EMPRESA");
        btnEmpresa.add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 50));

        btnEspacio.setBackground(new java.awt.Color(44, 47, 62));
        btnEspacio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEspacio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEspacio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEspacio.setForeground(new java.awt.Color(255, 255, 255));
        btnEspacio.add(lblEspacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 50));

        btnTrabajadores.setBackground(new java.awt.Color(44, 47, 62));
        btnTrabajadores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnTrabajadores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTrabajador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTrabajador.setForeground(new java.awt.Color(255, 255, 255));
        lblTrabajador.setText("TRABAJADOR");
        lblTrabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTrabajadorMouseClicked(evt);
            }
        });
        btnTrabajadores.add(lblTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 50));

        lblConTrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/expandirSubmenu.png"))); // NOI18N
        lblConTrabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConTrabajadorMouseClicked(evt);
            }
        });
        btnTrabajadores.add(lblConTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 30));

        btnPersonal.setBackground(new java.awt.Color(35, 37, 49));
        btnPersonal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPersonalMouseClicked(evt);
            }
        });
        btnPersonal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPersonal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPersonal.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonal.setText("PERSONAL");
        btnPersonal.add(lblPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 50));

        IconoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/servicios.png"))); // NOI18N
        btnPersonal.add(IconoPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        btnUsuarios.setBackground(new java.awt.Color(35, 37, 49));
        btnUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
        });
        btnUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarios.setText("USUARIOS");
        btnUsuarios.add(lblUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 50));

        IconoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/usuario.png"))); // NOI18N
        btnUsuarios.add(IconoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        btnClientes.setBackground(new java.awt.Color(44, 47, 62));
        btnClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesMouseClicked(evt);
            }
        });
        btnClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClientes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblClientes.setText("CLIENTES");
        btnClientes.add(lblClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 50));

        btnAlmacen.setBackground(new java.awt.Color(44, 47, 62));
        btnAlmacen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlmacenMouseClicked(evt);
            }
        });
        btnAlmacen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAlmacenaje.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAlmacenaje.setForeground(new java.awt.Color(255, 255, 255));
        lblAlmacenaje.setText("ALMACENAJE");
        lblAlmacenaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAlmacenajeMouseClicked(evt);
            }
        });
        btnAlmacen.add(lblAlmacenaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 50));

        lblConAlmacenaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/expandirSubmenu.png"))); // NOI18N
        lblConAlmacenaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConAlmacenajeMouseClicked(evt);
            }
        });
        btnAlmacen.add(lblConAlmacenaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 30));

        btnRegistroMat.setBackground(new java.awt.Color(35, 37, 49));
        btnRegistroMat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegistroMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistroMatMouseClicked(evt);
            }
        });
        btnRegistroMat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegistro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblRegistro.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistro.setText("REGISTRO ");
        btnRegistroMat.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 30));

        IconoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconRegistroMat.png"))); // NOI18N
        btnRegistroMat.add(IconoRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnCompraMat.setBackground(new java.awt.Color(35, 37, 49));
        btnCompraMat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCompraMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCompraMatMouseClicked(evt);
            }
        });
        btnCompraMat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCompraMateriales.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblCompraMateriales.setForeground(new java.awt.Color(255, 255, 255));
        lblCompraMateriales.setText("COMPRA");
        btnCompraMat.add(lblCompraMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        lblIconCompraMateriales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/compraMat.png"))); // NOI18N
        btnCompraMat.add(lblIconCompraMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        btnProyectos.setBackground(new java.awt.Color(44, 47, 62));
        btnProyectos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProyectosMouseClicked(evt);
            }
        });
        btnProyectos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProyecto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProyecto.setForeground(new java.awt.Color(255, 255, 255));
        lblProyecto.setText("PROYECTOS");
        btnProyectos.add(lblProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 50));

        btnPresupuesto.setBackground(new java.awt.Color(44, 47, 62));
        btnPresupuesto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPresupuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPresupuestoMouseClicked(evt);
            }
        });
        btnPresupuesto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPresupuesto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPresupuesto.setForeground(new java.awt.Color(255, 255, 255));
        lblPresupuesto.setText("PRESUPUESTO");
        btnPresupuesto.add(lblPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 150, 50));

        lblConPresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bloqueado.png"))); // NOI18N
        lblConPresupuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConPresupuestoMouseClicked(evt);
            }
        });
        btnPresupuesto.add(lblConPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 30));

        btnManoObra.setBackground(new java.awt.Color(35, 37, 49));
        btnManoObra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnManoObra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblManoObra.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblManoObra.setForeground(new java.awt.Color(255, 255, 255));
        lblManoObra.setText("MANO OBRA");
        lblManoObra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManoObraMouseClicked(evt);
            }
        });
        btnManoObra.add(lblManoObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        lblIconManoObra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconManoObra.png"))); // NOI18N
        btnManoObra.add(lblIconManoObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4, -1, 40));

        btnGastoPreliminar.setBackground(new java.awt.Color(35, 37, 49));
        btnGastoPreliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGastoPreliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPreliminar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblPreliminar.setForeground(new java.awt.Color(255, 255, 255));
        lblPreliminar.setText("PRELIMINARES");
        lblPreliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPreliminarMouseClicked(evt);
            }
        });
        btnGastoPreliminar.add(lblPreliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        lblIconPreliminares.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconPreliminares.png"))); // NOI18N
        btnGastoPreliminar.add(lblIconPreliminares, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnMaterial.setBackground(new java.awt.Color(28, 30, 42));
        btnMaterial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnMaterial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaterial.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblMaterial.setForeground(new java.awt.Color(255, 255, 255));
        lblMaterial.setText("MATERIALES");
        lblMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMaterialMouseClicked(evt);
            }
        });
        btnMaterial.add(lblMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        lblIconMateriales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconMateriales.png"))); // NOI18N
        btnMaterial.add(lblIconMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnControlAsig.setBackground(new java.awt.Color(44, 47, 62));
        btnControlAsig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnControlAsig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnControlAsigMouseClicked(evt);
            }
        });
        btnControlAsig.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClientes1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblClientes1.setForeground(new java.awt.Color(153, 153, 153));
        lblClientes1.setText("ASIGNACIONES");
        btnControlAsig.add(lblClientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 50));

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnPersonal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEspacio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpresa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(btnProyectos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnControlAsig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlmacen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(btnRegistroMat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(btnCompraMat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(btnPresupuesto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(btnManoObra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGastoPreliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaterial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrabajadores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addComponent(btnEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnControlAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnRegistroMat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCompraMat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnManoObra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnGastoPreliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMenu.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 250, 690));

        PanelPrincipal.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 320, 690));

        pnlContenedor.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        PanelPrincipal.add(pnlContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 1010, 670));

        pnlSuperior.setBackground(new java.awt.Color(28, 30, 42));

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrarMenu.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario: Castroll");

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconMinimizar.png"))); // NOI18N
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSuperiorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1004, Short.MAX_VALUE)
                .addComponent(lblMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(lblMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipal.add(pnlSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 60));

        getContentPane().add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanelPrincipalMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPrincipalMouseDragged
        FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_PanelPrincipalMouseDragged

    private void PanelPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPrincipalMousePressed
        FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_PanelPrincipalMousePressed

    /**
     * Metodo para ocultar todos los elementos de un submenu
     *
     * @param pnlOcultar matriz con los paneles a ocultar
     */
    private void ocultarSubMenu(JPanel[] pnlOcultar) {
        for (JPanel pnl1 : pnlOcultar) {
            pnl1.setVisible(false);
        }
        pnlContenedor.removeAll();
        pnlContenedor.revalidate();
        pnlContenedor.repaint();
    }

    /**
     * Metodo para ocultar todos los paneles side del menu
     *
     * @param panelSide matriz con los paneles a ocultar
     */
    private void ocultarPanelesSide(JLabel panelSide) {
        for (JLabel pnlSide1 : pnlSide) {
            pnlSide1.setVisible(false);
        }
        panelSide.setVisible(true);
    }

    /**
     * Metodo para mostrar los elementos de una matriz de paneles
     *
     * @param pnlMostrar matriz con los paneles a mostrar
     */
    private void mostrarSubMenu(JPanel[] pnlMostrar) {
        for (JPanel pnl2 : pnlMostrar) {
            pnl2.setVisible(true);
        }
    }

    /**
     * Metodo para cargar los paneles en el panel contenedor
     *
     * @param panel que se desea mostrar en el contenedor
     */
    private void cargarPaneles(JPanel panel, JPanel contenedor) {
        panel.setLocation(0, 0);
        contenedor.removeAll();
        contenedor.add(panel);
        contenedor.revalidate();
        contenedor.repaint();
        int ancho = contenedor.getWidth();
        int alto = contenedor.getHeight();
        panel.setSize(ancho, alto);
    }

    /**
     * Metodo para cargar el formulario empresa
     */
    private void cargarEmpresa() {
        ocultarPanelesSide(PanelSideEmpresa);
        PanelEmpresa empresa = new PanelEmpresa();
        cargarPaneles(empresa, pnlContenedor);
    }

    /**
     * Metodo para cargar el formulario clientes
     */
    private void cargarClientes() {
        ocultarPanelesSide(PanelSideClientes);
        PanelCliente cliente = new PanelCliente();
        cargarPaneles(cliente, pnlContenedor);
    }

    /**
     * Metodo para cargar el formulario proyecto
     */
    private void cargarProyecto() {
        ocultarPanelesSide(PanelSideProyectos);
        PanelProyecto proyectos = new PanelProyecto();
        cargarPaneles(proyectos, pnlContenedor);
    }

    /**
     * Metodo para cargar las diferentes opciones del menu presupuesto ademas de
     * mostrar y ocultar los sub elementos
     */
    private void cargarPresupuesto() {
        ocultarPanelesSide(PanelSidePresupuesto);
        switch (mostrarPresupuesto) {
            case 1:
                nombreProyecto = null;
                PanelPresupuesto pre = new PanelPresupuesto();
                cargarPaneles(pre, pnlContenedor);
                mostrarPresupuesto++;
                lblConPresupuesto.setVisible(true);
                lblConPresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bloqueado.png")));

                break;

            case 2:
                ocultarSubMenu(pnlAlmacenaje);
                ocultarSubMenu(pnlTrabajadores);
                if (nombreProyecto != null) {
                    mostrarSubMenu(pnlPresupuesto);
                    PanelPresupuesto panelPre = new PanelPresupuesto(nombreProyecto);
                    cargarPaneles(panelPre, pnlContenedor);
                }
                mostrarPresupuesto++;
                break;

            default:
                ocultarSubMenu(pnlTodos);
                mostrarPresupuesto = 1;
                break;
        }
    }

    /**
     * Metodo para mostrar y ocultar el submenu ademas de actualizar el icono de
     * menu contraido
     */
    private void cargarTrabajador() {
        ocultarPanelesSide(PanelSideTrababajador);
        ocultarSubMenu(pnlTodos);
        if (mostrarTrabajador == 1) {
            lblConAlmacenaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/expandirSubmenu.png")));
            lblConTrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/contraerSubmenu.png")));
            lblConPresupuesto.setVisible(false);
            mostrarSubMenu(pnlTrabajadores);
            mostrarTrabajador = 2;
        } else {
            lblConTrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconExpandir.png")));
            mostrarTrabajador = 1;
        }
    }

    /**
     * Metodo para mostrar y ocultar el submenu ademas de actualizar el icono de
     * menu contraido en la opcion almacenaje
     */
    private void cargarAlmacenaje() {
        ocultarPanelesSide(PanelSideAlmacenaje);
        ocultarSubMenu(pnlTodos);
        if (mostrarAlmacen == 1) {
            lblConTrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/expandirSubmenu.png")));
            lblConAlmacenaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/contraerSubmenu.png")));
            lblConPresupuesto.setVisible(false);
            mostrarSubMenu(pnlAlmacenaje);
            mostrarAlmacen = 2;
        } else {
            lblConAlmacenaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/expandirSubmenu.png")));
            mostrarAlmacen = 1;
        }
    }

    private void btnEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpresaMouseClicked
        cargarEmpresa();
    }//GEN-LAST:event_btnEmpresaMouseClicked

    private void btnPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonalMouseClicked
        PanelPersonal personal = new PanelPersonal();
        cargarPaneles(personal, pnlContenedor);
    }//GEN-LAST:event_btnPersonalMouseClicked

    private void btnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseClicked
        cargarClientes();
    }//GEN-LAST:event_btnClientesMouseClicked

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        PanelUsuario usuario = new PanelUsuario();
        cargarPaneles(usuario, pnlContenedor);
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProyectosMouseClicked
        cargarProyecto();
    }//GEN-LAST:event_btnProyectosMouseClicked

    private void btnPresupuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPresupuestoMouseClicked
        cargarPresupuesto();
    }//GEN-LAST:event_btnPresupuestoMouseClicked

    private void lblAlmacenajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlmacenajeMouseClicked
        cargarAlmacenaje();
    }//GEN-LAST:event_lblAlmacenajeMouseClicked

    private void btnAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlmacenMouseClicked
        cargarAlmacenaje();
    }//GEN-LAST:event_btnAlmacenMouseClicked

    private void btnRegistroMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMatMouseClicked
        PanelAlmacenaje c = new PanelAlmacenaje();
        cargarPaneles(c, pnlContenedor);
    }//GEN-LAST:event_btnRegistroMatMouseClicked

    private void btnCompraMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompraMatMouseClicked
        PanelRegistroCompras c = new PanelRegistroCompras();
        cargarPaneles(c, pnlContenedor);
    }//GEN-LAST:event_btnCompraMatMouseClicked

    private void lblTrabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTrabajadorMouseClicked
        cargarTrabajador();
    }//GEN-LAST:event_lblTrabajadorMouseClicked

    private void lblPreliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPreliminarMouseClicked
        if (nombreProyecto == null) {
            JOptionPane.showMessageDialog(null, "Selecciona tu proyecto");
        } else {
            PanelPreliminares pnlPreliminares = new PanelPreliminares(nombreProyecto);
            cargarPaneles(pnlPreliminares, PanelPresupuesto.jPanel2);
            mostrarPresupuesto = 2;
        }
    }//GEN-LAST:event_lblPreliminarMouseClicked

    private void lblMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaterialMouseClicked
        if (nombreProyecto == null) {
            JOptionPane.showMessageDialog(null, "Selecciona tu proyecto");
        } else {
            PanelMateriales pnlPreliminares = new PanelMateriales(nombreProyecto);
            cargarPaneles(pnlPreliminares, PanelPresupuesto.jPanel2);
            mostrarPresupuesto = 2;
        }

    }//GEN-LAST:event_lblMaterialMouseClicked

    private void lblManoObraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManoObraMouseClicked
        if (nombreProyecto == null) {
            JOptionPane.showMessageDialog(null, "Selecciona tu proyecto");
        } else {
            PanelAsignaciones pnlAsignacion = new PanelAsignaciones(nombreProyecto);
            cargarPaneles(pnlAsignacion, PanelPresupuesto.jPanel2);
            mostrarPresupuesto = 2;
        }

    }//GEN-LAST:event_lblManoObraMouseClicked

    private void lblConTrabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConTrabajadorMouseClicked
        cargarTrabajador();
    }//GEN-LAST:event_lblConTrabajadorMouseClicked

    private void lblConPresupuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConPresupuestoMouseClicked

    }//GEN-LAST:event_lblConPresupuestoMouseClicked

    private void IconoCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconoCerrarSesionMouseClicked
        frmLogin c = new frmLogin();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_IconoCerrarSesionMouseClicked

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setExtendedState(1);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblConAlmacenajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConAlmacenajeMouseClicked
        cargarAlmacenaje();
    }//GEN-LAST:event_lblConAlmacenajeMouseClicked

    private void btnControlAsigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnControlAsigMouseClicked
        //cargarAsignaciones();
    }//GEN-LAST:event_btnControlAsigMouseClicked

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
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new frmMenuPrincipal(args[0]).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconoAlmacen;
    private javax.swing.JLabel IconoCerrarSesion;
    private javax.swing.JLabel IconoClientes;
    private javax.swing.JLabel IconoEmpresa;
    private javax.swing.JLabel IconoPersonal;
    private javax.swing.JLabel IconoPrespuesto;
    private javax.swing.JLabel IconoProyecto;
    private javax.swing.JLabel IconoRegistro;
    private javax.swing.JLabel IconoTrabajadores;
    private javax.swing.JLabel IconoUsuario;
    private javax.swing.JPanel PanelIconos;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel PanelSideAlmacenaje;
    private javax.swing.JLabel PanelSideAsignaciones;
    private javax.swing.JLabel PanelSideClientes;
    private javax.swing.JLabel PanelSideEmpresa;
    private javax.swing.JLabel PanelSidePresupuesto;
    private javax.swing.JLabel PanelSideProyectos;
    private javax.swing.JLabel PanelSideTrababajador;
    private javax.swing.JPanel btnAlmacen;
    private javax.swing.JPanel btnClientes;
    private javax.swing.JPanel btnCompraMat;
    private javax.swing.JPanel btnControlAsig;
    private javax.swing.JPanel btnEmpresa;
    private javax.swing.JPanel btnEspacio;
    private javax.swing.JPanel btnGastoPreliminar;
    private javax.swing.JPanel btnManoObra;
    private javax.swing.JPanel btnMaterial;
    private javax.swing.JPanel btnPersonal;
    private javax.swing.JPanel btnPresupuesto;
    private javax.swing.JPanel btnProyectos;
    private javax.swing.JPanel btnRegistroMat;
    private javax.swing.JPanel btnTrabajadores;
    private javax.swing.JPanel btnUsuarios;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAlmacenaje;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblClientes1;
    private javax.swing.JLabel lblCompraMateriales;
    private javax.swing.JLabel lblConAlmacenaje;
    public static javax.swing.JLabel lblConPresupuesto;
    private javax.swing.JLabel lblConTrabajador;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEspacio;
    private javax.swing.JLabel lblIconCompraMateriales;
    private javax.swing.JLabel lblIconManoObra;
    private javax.swing.JLabel lblIconMateriales;
    private javax.swing.JLabel lblIconPreliminares;
    private javax.swing.JLabel lblManoObra;
    private javax.swing.JLabel lblMaterial;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblPersonal;
    private javax.swing.JLabel lblPreliminar;
    private javax.swing.JLabel lblPresupuesto;
    private javax.swing.JLabel lblProyecto;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblTrabajador;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlSuperior;
    // End of variables declaration//GEN-END:variables
}
