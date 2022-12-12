/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Vista.Frames.frmAlerta;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            //Si es verdadero existe el usuario en la base
            if (rs.next()) 
            {
                //Obtenemos el id del usuario
                idUsuario = rs.getInt(1); 
                // Estado true usuario activo
                query = "select * from Usuario where Usuario = ? and Estado = true"; 
                ps = con.getConnection().prepareStatement(query);
                ps.setString(1,obj.getUsuario());
                rs = ps.executeQuery();
                // Si es verdadero el usuario no esta bloqueado 
                if (rs.next()) 
                {
                    // Hacemos la consulta de usuario y contraseña
                    query = "select * from Usuario where Usuario = ? and Clave = ?"; 
                    ps = con.getConnection().prepareStatement(query);
                    ps.setString(1, obj.getUsuario());
                    ps.setString(2, obj.getClave());
                    rs = ps.executeQuery();
                    // Si es verdadero el inicio de sesion esta completo
                    if (rs.next()) 
                    {
                        // Obtenemos los datos del usuario
                        idUsuario = rs.getInt(1); 
                        estadoUsuario = rs.getBoolean(2);
                        nombreUsuario = rs.getString(4);
                        respuesta = true;
                    }
                    else
                    {               
                        new frmAlerta("La contraseña es incorrecta",2).setVisible(true); 
                    }
                }
                else
                {
                    new frmAlerta("Su usuario esta bloqueado",3).setVisible(true); 
                }
            }
            else
            {
                new frmAlerta("Usuario no encontrado",2).setVisible(true); 
            }
        }
        catch(HeadlessException | SQLException e)
        {
            System.out.println("Error critico al iniciar sesion :" + e);
        }
        return respuesta; 
    }
}


