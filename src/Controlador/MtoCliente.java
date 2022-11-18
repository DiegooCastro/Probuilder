/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.ClassConexion;
import Vista.Frames.frmAlerta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Diego
 */
public class MtoCliente 
{
    //Declaracion de variables de conexion
    ClassConexion con = new ClassConexion();
    private PreparedStatement ps;
    private ResultSet rs;   
    
    /*** Metodo para ingresar los datos en la base de datos 
     * @param var objeto de la clase para invocar metodos que permitan el envio de datos
     * @return variable de tipo boolean que confirma si se realizo la consulta 
     */
    
    public boolean ingresarCliente(MtoCliente var)
    {
        boolean respuesta = false;
        try
        {
            String val = "select * from Cliente where Nombre = ? and DUI = ?";
            ps = con.getConnection().prepareStatement(val);
            ps.setString(1, var.getNombre());
            ps.setString(2, var.getDUI());
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                new frmAlerta("El cliente ingresado esta registrado",2).setVisible(true);
            }
            else
            {
                String sql = "insert into Cliente (Empresa,Nombre,Apellido,Telefono,DUI,Correo_Electronico) values(?,?,?,?,?,?)";
                ps = con.getConnection().prepareStatement(sql);
                ps.setInt(1, var.getEmpresa());
                ps.setString(2, var.getNombre());
                ps.setString(3, var.getApellido());
                ps.setString(4, var.getTelefono());
                ps.setString(5, var.getDUI());
                ps.setString(6, var.getCorreo());
                if (!ps.execute()) 
                {
                    new frmAlerta("Cliente registrado correctamente",1).setVisible(true);
                    respuesta = true;
                }
                else
                {   
                    new frmAlerta("Error al ingresar los datos del cliente",3).setVisible(true);
                }
            }
            con.getConnection().close();
        }
        catch(SQLException e)
        {
            new frmAlerta("Error critico de conexion",3).setVisible(true);
            System.out.println(e);
        }
        return respuesta;
    }
    
    /*** Metodo para actualizar los datos en la base de datos 
     * @param var objeto de la clase para invocar metodos que permitan el envio de datos
     * @param id identificador del registro al que se desea actualizar
     * @return variable de tipo boolean que confirma si se realizo la consulta 
     */
    
    public boolean modificarCliente(MtoCliente var, int id)
    {
        boolean respuesta = false;
        try
        {
            String sql = "update Cliente set Empresa = ?,Nombre = ?,Apellido= ?,Telefono = ?,DUI= ?,Correo_Electronico =? where Id_Cliente = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getEmpresa());
            ps.setString(2, var.getNombre());
            ps.setString(3, var.getApellido());
            ps.setString(4, var.getTelefono());
            ps.setString(5, var.getDUI());
            ps.setString(6, var.getCorreo());
            ps.setInt(7, id);
            if (!ps.execute()) 
            {
                new frmAlerta("Datos del cliente modificados correctamente",1).setVisible(true);
                respuesta = true;
            }
            else
            {   
                new frmAlerta("Error al modificar los datos del cliente",3).setVisible(true);
            }       
            con.getConnection().close();
        }
        catch(SQLException e)
        {
            new frmAlerta("Error critico de conexion",3).setVisible(true);
            System.out.println(e);
        }
        return respuesta;
    }
    
    //Declaracion de atributos de la clase
    private int empresa;
    private String apellido;
    private String nombre;
    private String telefono;
    private String dui;
    private String correo;
    
    /**
     * @return the Empresa
     */
    public int getEmpresa() 
    {
        return empresa;
    }

    /**
     * @param empresa the Tipo_Empresa to set
     */
    public void setEmpresa(int empresa) 
    {
        this.empresa = empresa;
    }

    /**
     * @return el apellido del cliente
     */
    public String getApellido() 
    {
        return apellido;
    }

    /**
     * @param apellido del cliente
     */
    public void setApellido(String apellido) 
    {
        this.apellido = apellido;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() 
    {
        return nombre;
    }

    /**
     * @param nombre the Ubicacion to set
     */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() 
    {
        return telefono;
    }

    /**
     * @param telefono the Telefono to set
     */
    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }

    /**
     * @return the DUI
     */
    public String getDUI() 
    {
        return dui;
    }

    /**
     * @param dui the Telefono2 to set
     */
    public void setDUI(String dui) 
    {
        this.dui = dui;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() 
    {
        return correo;
    }

    /**
     * @param correo the Correo to set
     */
    public void setCorreo(String correo) 
    {
        this.correo = correo;
    }
}
