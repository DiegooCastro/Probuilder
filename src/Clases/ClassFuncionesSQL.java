/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Vista.Frames.frmAlerta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Castro
 */ 
public class ClassFuncionesSQL 
{
    ClassConexion con = new ClassConexion();
    private ResultSetMetaData rm;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private int id;
    
    /**
     * Metodo para cargar los combobox del sistema
     * @param sentencia consulta sql que se enviara a la base 
     * @param cmb combobox al que se insertaran los datos
     */
    public void cargarComboBox(String sentencia,JComboBox cmb)
    {
        try
        {
            cmb.removeAllItems();
            st = con.getConnection().createStatement();
            rs = st.executeQuery(sentencia);
            while(rs.next())
            {
                cmb.addItem(rs.getString(2));
            }
        }
        catch(SQLException e)
        {
            new frmAlerta("Error critico al cargar combobox",3).setVisible(true);
        }
    }
    
    /**
     * Metodo para cargar tabla en cualquier formulario
     * @param sentencia consulta sql que se enviara a la base
     * @param tabla tabla en la que se imprimiran los datos
     */
    
    public void cargarTabla(String sentencia, DefaultTableModel tabla)
    {
        try
        {
            st = con.getConnection().createStatement();
            rs = st.executeQuery(sentencia);
            rm = rs.getMetaData();          
            tabla.setRowCount(0);
            while(rs.next())
            {
                Object[] o = new Object[rm.getColumnCount()];
                for (int i = 0; i < o.length; i++) 
                {
                    if (rs.getObject(i+1).equals(true)) 
                    {
                        o[i] = "Disponible";
                    }
                    else if (rs.getObject(i+1).equals(false)) 
                    {
                        o[i] = "No disponible";
                    }
                    else
                    {
                        o[i] = rs.getObject(i+1);
                    }
                }
                tabla.addRow(o);
            }
        }
        catch(SQLException e)
        {
            new frmAlerta("Error al cargar tabla",3).setVisible(true);
            System.out.println(e);
        }
    }
    
    /**
     * Metodo para buscar el id de las tablas padre
     * @param consulta consulta sql para obtener ID
     * @return valor del ID
     */
    public int getIdentificador(String consulta)
    {
        try
        {
            st = con.getConnection().createStatement();
            rs = st.executeQuery(consulta);
            if(rs.next())
            {
                id = rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error al obtener identificador");
        }
        return id;
    }
    
    /*** Metodo busqueda filtrada para registros cualquier tabla
     * @param sentencia atributo que contiene la sentencia sql para realizar consulta
     * @param tabla modelo de la tabla para ingresar los datos
     * @return la respuesta si se ejecuto o no la sentencia
     */
    public boolean busquedaFiltrada(DefaultTableModel tabla,String sentencia)
    {
        boolean respuesta = false;
        try
        {
            st = con.getConnection().createStatement();
            rs = st.executeQuery(sentencia);
            rm = rs.getMetaData();          
            tabla.setRowCount(0);
            while(rs.next())
            {
                Object[] o = new Object[rm.getColumnCount()];
                for (int i = 0; i < o.length; i++) 
                {
                    o[i] = rs.getObject(i+1);
                }
                tabla.addRow(o);
                respuesta = true;
            }
            con.getConnection().close();
        }
        catch(SQLException e)
        {
            new frmAlerta("Error al realizar busqueda filtrada",3).setVisible(true);
        }
        return respuesta;
    }
    
    public String obtenerCorreo(String Usuario)
    {
        String correo = "";
        try
        {
            String sql = "Select correo_electronico from Usuario where Usuario = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, Usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                correo = rs.getString(1);
            }
        }
        catch(Exception e)
        {
            new frmAlerta("Error critico al obtener correo",3).setVisible(true);
        }
        return correo;
    }
    
    
    
    public Double obtenerPagoTotal(int idPersonal,Date inicio,Date fin)
    {
        Double[] o = new Double[2];
        try
        {
            String sql = "select Sueldo from Personal where Id_Personal = '"+idPersonal+"'";
            st = con.getConnection().createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) 
            {
                o[0] = rs.getDouble(1);
            }
            long diff = fin.getTime() - inicio.getTime();
            int dias =Integer.parseInt(String.valueOf((TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS))));
            o[1] = (o[0] / 30)*dias;
        }
        catch(SQLException e)
        {
            new frmAlerta("Error obtener pago total",3).setVisible(true);
        }
        return o[1];
    }
    
    public Date getDate()
    {
        Date fecha = null;
        try
        {
            String sentencia = "select getDate()";
            st = con.getConnection().createStatement();
            rs = st.executeQuery(sentencia);
            if (rs.next()) 
            {
                fecha = rs.getDate(1);
            }
            con.getConnection().close();
        }
        catch(SQLException e)
        {
            new frmAlerta("Error al obtener funcion de fecha",3).setVisible(true);
        }
        return fecha;
    }
    
    public boolean enviarCorreo(String mensaje,String asunto,String receptor)
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
            new frmAlerta("Error critico al enviar correo",3).setVisible(true);
            JOptionPane.showMessageDialog(null,ex);
        } 
        catch (MessagingException ex) 
        {
            new frmAlerta("Error critico al enviar correo",3).setVisible(true);
            JOptionPane.showMessageDialog(null,ex);
        }
        return respuesta;
    }
    
    ClassSeguridad seg = new ClassSeguridad();
    
    public boolean actualizarClave(String clave,String usuario)
    {
        boolean retorno = false;
        try
        {
            String claveEncriptada = seg.encriptacionMD5(clave);
            String sql = "update Usuario set clave = ? where usuario = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, claveEncriptada);
            ps.setString(2, usuario);
            if (!ps.execute()) 
            {
                retorno = true;
            }
        }
        catch(SQLException e)
        {
            new frmAlerta("Error critico al actualizar clave",2).setVisible(true);
        }
        return retorno;
    }
}
