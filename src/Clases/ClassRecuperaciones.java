/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/** Clase de metodos y mantemientos de la seccion recuperaciones
 * @since 15/04/2020
 * @author Diego Castro
 * @version 1.0
 */
public class ClassRecuperaciones 
{   
    //Declaracion de objetos de conexion
    ClassSeguridad encry = new ClassSeguridad();
    ClassConexion con = new ClassConexion();
    PreparedStatement ps;
    ResultSet rs;
    
    //Declaracion de variables 
    private int id;
    private int tipo;
    private String usuario;
    private String correo;
    private static int idUsuario;
    
    /**
     * @return the id
     */
    public int getId() 
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) 
    {
        this.id = id;
    }

     /**
     * @return the tipo
     */
    public int getTipo() 
    {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) 
    {
        this.tipo = tipo;
    }
    
    /**
     * @return the usuario
     */
    public String getUsuario() 
    {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }

    /**
     * @return the correo
     */
    public String getCorreo() 
    {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) 
    {
        this.correo = correo;
    }
    
    /** Metodo para validar la existencia del usuario en la base de datos y obtener sus datos 
     * @param var objeto de la clase para invocar los metodos de obtencion de datos
     * @return respuesta si se encontro o no el usuario 
     */
    public boolean validarUsuario(ClassRecuperaciones var)
    {
        boolean respuesta = false;
        try
        {
            String sql = "select * from Vista_Usuario where Usuario = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1,var.getUsuario());
            rs = ps.executeQuery();          
            if(rs.next())
            {
                var.setId(rs.getInt(1)); //Obtenemos el ID
                var.setTipo(rs.getInt(2)); //Obtenemos el tipo de usuario
                var.setCorreo(rs.getString(7));//Obtenemos el correo electronico
                idUsuario = var.getId();
                respuesta = true;
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return respuesta;
    }
    
    /**Metodo para validar que la clave sea la correcta
     * @param clave contiene la clave del usuario
     * @param usuario contiene el usuario que anteriormente ingresaron
     * @return respuesta si es valida o no la contraseña
     */
    public boolean validarClave(String clave,String usuario)
    {
        boolean respuesta = false;
        try
        {
            String sql = "select * from usuarios where usuario = ? and clave = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1,usuario);
            ps.setString(2,clave);
            rs = ps.executeQuery();          
            if(rs.next())
            { 
                respuesta = true;
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return respuesta;
    }
    
    /** Metodo de recuperacion por correo electronico envia un correo al usuario 
     * @param receptor direccion de correo que recibira el correo
     * @param mensaje mensaje que se enviara al correo
     * @return respuesta si se envio o no el correo electronico
     */
    public boolean recuperacionCorreo(String receptor,String mensaje)
    {
        boolean respuesta = false;
        try 
        {
            Properties p = new Properties();
            p.setProperty("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(p);
            String remitente = "botcastroll24@gmail.com"; //Correo
            String pass = "Extreme8000"; //Clave
            String asunto = "Recuperacion de contraseña por medio de correo electronico";

            MimeMessage mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(remitente));
            mess.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            mess.setSubject(asunto);
            mess.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(remitente, pass);
            t.sendMessage(mess, mess.getRecipients(Message.RecipientType.TO));
            t.close();
            respuesta = true;
        } 
        catch (AddressException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 
        catch (MessagingException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        }
        return respuesta;
    }  
    
    /**Metodo para cambiar la contraseña del usuario
     * @param clave contiene la nueva clave del usuario
     * @param usuario contiene el usuario que cambiara su contraseña
     * @return si se realizo la consulta o no
     */
    public boolean cambiarClave(String clave,String usuario)
    {
        boolean respuesta = false;
        try
        {
            int Estado = 1;
            String contraseña = encry.encriptacionMD5(clave);
            String sql = "update Usuarios set Clave = ? , Estado = ? where Usuario = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, contraseña);
            ps.setInt(2, Estado);
            ps.setString(3, usuario);
            if (!ps.execute()) 
            {
                JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente");
                respuesta = true;
            }
        }
        catch(HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return respuesta;
    }
    
    /** Metodo para llenar el modelo de tabla para la funcion recuperacion administrador
     * @param modelo objeto del modelo de la tabla donde se ingresaran los datos
     * @return respuesta si se realizo o no la consulta
     */
    public boolean cargarAdmin(DefaultTableModel modelo)
    {
        boolean respuesta = false;
        try
        {
            modelo.setRowCount(0);
            String sql = "select * from Vista_Recuperadores";
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery(); 
            Object[] o = new Object[5];
            while(rs.next())
            {
                o[0] = rs.getString(4);
                o[1] = rs.getString(3);
                o[2] = rs.getString(8);
                o[3] = rs.getString(2);
                o[4] = rs.getString(7);
                modelo.addRow(o);
            }
            respuesta = true;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return respuesta;
    }
    
    /**Metodo para cambiar la contraseña del usuario mediante recuperacion directa
     * @param clave contiene la nueva clave del usuario
     * @param usuario contiene el usuario que cambiara su contraseña
     * @return si se realizo la consulta o no
     */
    public boolean claveAdmin(String clave,String usuario)
    {
        boolean respuesta = false;
        try
        {
            int estado = 2;
            String contraseña = encry.encriptacionMD5(clave);
            String sql = "update Usuarios set Clave= ?, Estado = ? where Usuario = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, contraseña);
            ps.setInt(2, estado);
            ps.setString(3, usuario);
            if (!ps.execute()) 
            {
                respuesta = true;
            }
        }
        catch(HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return respuesta;
    }
    
    public int getUsuario(String usuario)
    {
        int respuesta = 0;
        try
        {
            String sql = "select * from Usuarios where usuario = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, usuario);
            rs  = ps.executeQuery();
            while(rs.next())
            {
                respuesta = rs.getInt(1);
            }
        }
        catch(HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return respuesta;
    }
}
