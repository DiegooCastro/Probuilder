/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.PreLogin;

import Clases.ClassRespuestas;
import Clases.ClassSeguridad;
import javax.swing.DefaultComboBoxModel;

/** Metodo del formulario primer uso seguridad
 * @since 13/04/2020
 * @author Diego Castro
 * @version 1.0
 */
public class PnlPrimerSeguridad extends javax.swing.JPanel {

    /**
     * Creates new form PrimerUsoSeguridad
     */
    public PnlPrimerSeguridad() {
        initComponents();
        cargarPreguntas();
        validacionJTextField();
    }
    
    //Creacion de objeto para invocar el metodo para llenar combobox
    ClassRespuestas objeto = new ClassRespuestas();
    ClassSeguridad seg = new ClassSeguridad();
    
    /**
     * Metodo para asignar las validaciones correspondientes a cada uno de los JTextField
     */
    private void validacionJTextField()
    {
        seg.longitudMaxima(txtRespuesta1,35);
        seg.longitudMaxima(txtRespuesta1,35);
        seg.longitudMaxima(txtRespuesta1,35);
    }
    /** Metodo para obtener el modelo ingresar las preguntas en el modelo y seleccionar diferentes preguntas*/   
    private void cargarPreguntas()
    {
        DefaultComboBoxModel cmb1 = (DefaultComboBoxModel)cmbPregunta1.getModel(); //Obtenemos el modelo de todos los combobox
        DefaultComboBoxModel cmb2 = (DefaultComboBoxModel)cmbPregunta2.getModel();
        DefaultComboBoxModel cmb3 = (DefaultComboBoxModel)cmbPregunta3.getModel();
        objeto.cmbPreguntas(cmb1); //Enviamos los modelos al metodo de  la clase mto_primeruso
        objeto.cmbPreguntas(cmb2);
        objeto.cmbPreguntas(cmb3);
        cmb1.setSelectedItem(cmbPregunta1.getItemAt(0)); //Seleccionar diferentes preguntas
        cmb2.setSelectedItem(cmbPregunta2.getItemAt(1));
        cmb3.setSelectedItem(cmbPregunta3.getItemAt(2));
    }   
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        lblPreguntas = new javax.swing.JLabel();
        lblRespuestas = new javax.swing.JLabel();
        lblLogoResp = new javax.swing.JLabel();
        lblIconoPreg = new javax.swing.JLabel();
        lblPreg1 = new javax.swing.JLabel();
        cmbPregunta1 = new javax.swing.JComboBox<>();
        cmbPregunta2 = new javax.swing.JComboBox<>();
        lblPreg2 = new javax.swing.JLabel();
        cmbPregunta3 = new javax.swing.JComboBox<>();
        lblPreg3 = new javax.swing.JLabel();
        txtRespuesta3 = new javax.swing.JTextField();
        txtRespuesta2 = new javax.swing.JTextField();
        lblResp2 = new javax.swing.JLabel();
        txtRespuesta1 = new javax.swing.JTextField();
        lblResp1 = new javax.swing.JLabel();
        lblResp3 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPreguntas.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblPreguntas.setText("Preguntas");
        jPanel1.add(lblPreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, 40));

        lblRespuestas.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblRespuestas.setText("Respuestas ");
        jPanel1.add(lblRespuestas, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 40, 140, 40));

        lblLogoResp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconPrimerRespuestas.jpg"))); // NOI18N
        jPanel1.add(lblLogoResp, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 40, -1, -1));

        lblIconoPreg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconografia/IconoPrimerPreguntas.jpg"))); // NOI18N
        jPanel1.add(lblIconoPreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        lblPreg1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblPreg1.setText("Pregunta 1:");
        jPanel1.add(lblPreg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 118, -1, -1));

        cmbPregunta1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbPregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 114, 217, -1));

        cmbPregunta2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbPregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 186, 217, -1));

        lblPreg2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblPreg2.setText("Pregunta 2:");
        jPanel1.add(lblPreg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 190, -1, -1));

        cmbPregunta3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbPregunta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 259, 217, -1));

        lblPreg3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblPreg3.setText("Pregunta 3:");
        jPanel1.add(lblPreg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 263, -1, -1));
        jPanel1.add(txtRespuesta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 259, 204, -1));
        jPanel1.add(txtRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 183, 200, -1));

        lblResp2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblResp2.setText("Respuesta 2*");
        jPanel1.add(lblResp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 187, -1, -1));
        jPanel1.add(txtRespuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 114, 204, -1));

        lblResp1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblResp1.setText("Respuesta 1*");
        jPanel1.add(lblResp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 118, -1, -1));

        lblResp3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblResp3.setText("Respuesta 3*");
        jPanel1.add(lblResp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 263, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 450));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cmbPregunta1;
    public javax.swing.JComboBox<String> cmbPregunta2;
    public javax.swing.JComboBox<String> cmbPregunta3;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIconoPreg;
    private javax.swing.JLabel lblLogoResp;
    private javax.swing.JLabel lblPreg1;
    private javax.swing.JLabel lblPreg2;
    private javax.swing.JLabel lblPreg3;
    private javax.swing.JLabel lblPreguntas;
    private javax.swing.JLabel lblResp1;
    private javax.swing.JLabel lblResp2;
    private javax.swing.JLabel lblResp3;
    private javax.swing.JLabel lblRespuestas;
    public javax.swing.JTextField txtRespuesta1;
    public javax.swing.JTextField txtRespuesta2;
    public javax.swing.JTextField txtRespuesta3;
    // End of variables declaration//GEN-END:variables
}
