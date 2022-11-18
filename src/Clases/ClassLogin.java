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
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ClassLogin 
{
    ClassConexion con = new ClassConexion();
    PreparedStatement ps;
    ResultSet rs;
    
    private String query;
    private String usuario;
    private String clave;
    
    public static int idUsuario;
    public static boolean estadoUsuario;
    public static String nombreUsuario;
    
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    /**
     * Metodo para validar todos los posibles escenarios a la hora de iniciar sesion en el sistema
     * @param obj objeto para llamar a los metodos get set de la clase 
     * @return si el inicio de sesion fue exitoso
     */
    public boolean iniciarSesion(ClassLogin obj)
    {
        boolean respuesta = false;
        try
        {
            query = "select * from Usuario where Usuario = ?";
            ps = con.getConnection().prepareStatement(query);
            ps.setString(1, obj.getUsuario());
            rs = ps.executeQuery();
            if (rs.next()) //Si es verdadero existe el usuario en la base
            {
                idUsuario = rs.getInt(1); //Obtenemos el id del usuario
                query = "select * from Usuario where Usuario = ? and Estado = true"; //Estado true usuario activo
                ps = con.getConnection().prepareStatement(query);
                ps.setString(1,obj.getUsuario());
                rs = ps.executeQuery();
                if (rs.next()) //Si es verdadero el usuario no esta bloqueado ni inactivo
                {
                    query = "select * from Usuario where Usuario = ? and Clave = ?"; //Hacemos la consulta de usuario y contraseña
                    ps = con.getConnection().prepareStatement(query);
                    ps.setString(1, obj.getUsuario());
                    ps.setString(2, obj.getClave());
                    rs = ps.executeQuery();
                    if (rs.next()) //Si es verdadero el inicio de sesion esta completo
                    {
                        idUsuario = rs.getInt(1); //Obtenemos los datos del usuario
                        estadoUsuario = rs.getBoolean(2);
                        nombreUsuario = rs.getString(4);
                        JOptionPane.showMessageDialog(null, "Acceso concedido","Bienvenido",1);
                        respuesta = true;
                    }
                    else
                    {               
                        JOptionPane.showMessageDialog(null, "La contraseña ingresada es incorrecta","Acceso denegado",2);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El usuario se encuentra inactivo o bloqueado","Acceso denegado",2);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El usuario no existe en la base de datos","Acceso denegado",2);
            }
        }
        catch(HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error critico"+e);
        }
        return respuesta; 
    }
}


