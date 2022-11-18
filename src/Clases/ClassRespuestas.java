/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/** Clase correspondiente a recuperacion por preguntas de seguridad
 * @since 19/04/2020
 * @author Diego Castro
 * @version 1.0
 */
public class ClassRespuestas 
{
    //Declaracion de objetos de conexion
    ClassConexion con = new ClassConexion();
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    
    //Declaracion de atributos que serviran para almacenar los datos  
    public int[] preguntas = new int[3];
    public String[] respuestas = new String[3];
    private int i;
    
    //Atributos de la clase class respuestas
    private String[] respuesta;
    private int[] pregunta;
    private int cont;
    
    /**
     * @return the respuesta
     */
    public String[] getRespuesta() 
    {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String[] respuesta) 
    {
        this.respuesta = respuesta;
    }

    /**
     * @return the pregunta
     */
    public int[] getPregunta() 
    {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(int[] pregunta) 
    {
        this.pregunta = pregunta;
    }
   
    /** Metodo para ingresar las preguntas y respuestas en la base de datos
     * @param obj objeto de clase para invocar metodos que retornan preguntas seleccionadas
     * @return si se ejecuto o no la sentencia
     */
    public boolean asignarPreguntas(ClassRespuestas obj)
    {
        boolean res = false;
        try
        {
            for (int i = 0; i < 3; i++) 
            {
                String sql = "insert into Respuestas_Seguridad values(?,?,?,?)";
                ps = con.getConnection().prepareStatement(sql);
                //ps.setInt(1, user.getMaxIdUsuario());
                ps.setInt(2, pregunta[i]);
                ps.setString(3, respuesta[i]);
                //ps.setString(4, emp.getDate());
                if (!ps.execute()) 
                {
                    cont = cont + 1;
                }
            }
            if (cont == 3) 
            {
                JOptionPane.showMessageDialog(null, "Las respuestas fueron asignadas correctamente a su usuario","Proceso completado",1);
                res = true;
            }
            cont = 0;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return res;
    }
    
    /** Metodo para obtener las preguntas y respuestas del usuario
     * @param obj de la clase para invocar metodos get set
     */
    public void getPreguntas(ClassRespuestas obj)
    {
        try
        {
           String query = "select * from Respuestas_Seguridad where Usuario = ?";
           ps = con.getConnection().prepareStatement(query);
           //ps.setInt(1,FrmRecuperadores.id);
           rs = ps.executeQuery();
           i = 0;
           while(rs.next())
           {
                obj.respuestas[i] = rs.getString(4);
                obj.preguntas[i] = rs.getInt(3);
                i = i + 1;
           }
        }
        catch(HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /** Metodo para ingresar las preguntas seleccionadas por el usuario
     * @param modelo modelo de combobox al que se ingresara el item
     * @param id es el identificador de la pregunta
     */
    public void comboBoxPreguntas(DefaultComboBoxModel modelo,int id)
    {
        try
        {
           modelo.removeAllElements();
           String query = "select * from Preguntas_Seguridad where Id_Preguntas = ?";
           ps = con.getConnection().prepareStatement(query);
           ps.setInt(1, id);
           rs = ps.executeQuery();
           while(rs.next())
           {
               modelo.addElement(rs.getString(2));
           }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /** Metodo para cargar las pregutas de la base de datos
     * @param modelo modelo del combobox en el que se ingresaran las preguntas
     * @return el modelo del combobox con los datos ingresados 
     */
    public DefaultComboBoxModel cmbPreguntas(DefaultComboBoxModel modelo)
    {
        try
        {
           modelo.removeAllElements();
           String query = "select * from Preguntas_Seguridad where Id_Preguntas != 1";
           ps = con.getConnection().prepareStatement(query);
           rs = ps.executeQuery();
           while(rs.next())
           {
               modelo.addElement(rs.getString(2));
           }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return modelo;
    }
}
