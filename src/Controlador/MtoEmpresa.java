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

/** Clase de mantenimientos para la tabla empresa
 *
 * @author Diego Castro
 */
public class MtoEmpresa 
{ 
    //Declaracion de atributos y objetos de conexion
    ClassConexion con = new ClassConexion();
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;    
    
    /*** Metodo para ingresar los datos en la base de datos 
     * @param var objeto de la clase para invocar metodos que permitan el envio de datos
     * @return variable de tipo boolean que confirma si se realizo la consulta 
     */  
    public boolean ingresarEmpresa(MtoEmpresa var)
    {
        boolean respuesta = false;
        try
        {
            sql = "select * from empresa where Nombre = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, var.getEmpresa());
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                new frmAlerta (" La empresa ya esta registrada en el sistema",2).setVisible(true);
            }
            else
            {
                sql = "insert into Empresa (Id_Empresa,Tipo,Nombre,Ubicacion,Telefono,Correo,Telefono2,Logo) values(default,?,?,?,?,?,?,?)";
                ps = con.getConnection().prepareStatement(sql);
                ps.setInt(1, var.getTipo_Empresa());
                ps.setString(2, var.getEmpresa());
                ps.setString(3, var.getUbicacion());
                ps.setString(4, var.getTelefono());
                ps.setString(5, var.getCorreo());
                ps.setString(6, var.getTelefono2());
                ps.setBytes(7, var.getCargarLogo());
                if (!ps.execute()) 
                {
                    new frmAlerta ("Empresa registrada correctamente",1).setVisible(true);
                    respuesta = true;
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
     * @return variable de tipo boolean que confirma si se realizo la consulta 
     */
    
    public boolean modificarEmpresa(MtoEmpresa var)
    {
        boolean respuesta = false;
        try
        {
            sql = "select * from Empresa where Nombre = ? and Id_Empresa != ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, var.getEmpresa());
            ps.setInt(2, var.getIdEmpresa());
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                new frmAlerta("El nombre de la empresa ya esta en uso",2).setVisible(true);
            }
            else
            {
                sql = "update Empresa set Nombre = ? , Tipo = ? , Ubicacion= ?,Telefono = ?,Correo = ? , Telefono2 = ? where Id_Empresa = ?";
                ps = con.getConnection().prepareStatement(sql);
                ps.setString(1, var.getEmpresa());
                ps.setInt(2, var.getTipo_Empresa());
                ps.setString(3, var.getUbicacion());
                ps.setString(4, var.getTelefono());
                ps.setString(5, var.getCorreo());
                ps.setString(6, var.getTelefono2());
                ps.setInt(7, var.getIdEmpresa());
                if (!ps.execute()) 
                {   
                    new frmAlerta("Datos de la empresa modificados correctamente",1).setVisible(true);
                    respuesta = true;
                    if (var.getCargarLogo() != null) 
                    {
                        sql = "update Empresa set Logo = ? where Id_Empresa = ?";
                        ps = con.getConnection().prepareStatement(sql);
                        ps.setBytes(1,var.getCargarLogo());
                        ps.setInt(2, var.getIdEmpresa());
                        if (!ps.execute())  
                        {
                            //new alertSuccess("Logo actualizado correctamente").setVisible(true);
                        }
                    }
                }
                else
                {   
                    new frmAlerta("Error al modificar los datos",3).setVisible(true);
                }       
                con.getConnection().close();
            }
        }
        catch(SQLException e)
        {
            new frmAlerta("Error critico de conexion",3).setVisible(true);
            System.out.println(e);
        }
        return respuesta;
    }
    
    /**
     * Metodo para cargar los datos de la primer empresa e ingresarlos en el formulario primer uso
     * @param var objeto de la clase para mandar a llamar los metodos 
     * @return resultado de la ejecucion de la consulta
     */
    public boolean cargarSucursal(MtoEmpresa var)
    {
        boolean respuesta = false;
        try
        {
            sql = "select * from Empresa";
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                var.setIdEmpresa(rs.getInt(1));
                var.setEmpresa(rs.getString(3));
                var.setUbicacion(rs.getString(4));
                var.setTelefono(rs.getString(5));
                var.setCorreo(rs.getString(6));
                var.setCargarLogo(rs.getBytes(7));
                respuesta = true;
            }
        }
        catch(SQLException e)
        {
            new frmAlerta("Error critico de conexion",3).setVisible(true);
        }
        catch(Exception e)
        {
            new frmAlerta("Error critico de conexion",3).setVisible(true);
        }
        return respuesta;
    }
    
    //Declaracion de atributos de la clase
    private int tipoEmpresa,idEmpresa;
    private byte[] cargarLogo;
    private String empresa,ubicacion,telefono,telefono2,correo;
    
    /**
     * @return the idEmpresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    /**
     * @return the Tipo_Empresa
     */
    public int getTipo_Empresa() 
    {
        return tipoEmpresa;
    }

    /**
     * @param Tipo_Empresa the Tipo_Empresa to set
     */
    public void setTipo_Empresa(int Tipo_Empresa) 
    {
        this.tipoEmpresa = Tipo_Empresa;
    }

    /**
     * @return the cargarLogo
     */
    public byte[] getCargarLogo() {
        return cargarLogo;
    }

    /**
     * @param cargarLogo the cargarLogo to set
     */
    public void setCargarLogo(byte[] cargarLogo) {
        this.cargarLogo = cargarLogo;
    }
    
    /**
     * @return the Empresa
     */
    public String getEmpresa() 
    {
        return empresa;
    }

    /**
     * @param Empresa the Empresa to set
     */
    public void setEmpresa(String Empresa) 
    {
        this.empresa = Empresa;
    }

    /**
     * @return the Ubicacion
     */
    public String getUbicacion() 
    {
        return ubicacion;
    }

    /**
     * @param Ubicacion the Ubicacion to set
     */
    public void setUbicacion(String Ubicacion) 
    {
        this.ubicacion = Ubicacion;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() 
    {
        return telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) 
    {
        this.telefono = Telefono;
    }

    /**
     * @return the Telefono2
     */
    public String getTelefono2() 
    {
        return telefono2;
    }

    /**
     * @param Telefono2 the Telefono2 to set
     */
    public void setTelefono2(String Telefono2) 
    {
        this.telefono2 = Telefono2;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() 
    {
        return correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) 
    {
        this.correo = Correo;
    }
}
