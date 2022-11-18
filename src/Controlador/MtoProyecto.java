/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.ClassConexion;
import Vista.Frames.frmAlerta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Diego Castro $CASTROLL$
 */
public class MtoProyecto 
{
    //Declaracion de objetos de conexion
    ClassConexion con = new ClassConexion();
    private PreparedStatement ps;
       
    public boolean ingresarProyecto(MtoProyecto var)
    {
        boolean retorno = false;
        try
        {
            String sql;
            if (var.getUbicacion() != null || var.getDescripcion() != null) 
            {
                sql = "insert into Proyecto (Estado , Cliente , Supervisor ,Tipo_Proyecto , Nombre_Proyecto , FechaInicio , FechaFin ,Ubicacion , Descripcion_Proyecto) values(?,?,?,?,?,?,?,?,?)";
            }
            else
            {
                sql = "insert into Proyecto (Estado , Cliente , Supervisor ,Tipo_Proyecto , Nombre_Proyecto ,FechaInicio , FechaFin) values(?,?,?,?,?,?,?)";
            }
            
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getEstado());
            ps.setInt(2, var.getCliente());
            ps.setInt(3, var.getSupervisor());
            ps.setInt(4, var.getTipo());
            ps.setString(5, var.getProyecto());
            ps.setDate(6, var.getFechaInicio());
            ps.setDate(7, var.getFechaFin());
            
            
            if (var.getUbicacion() != null || var.getDescripcion() != null) 
            {
                ps.setString(8, var.getUbicacion());
                ps.setString(9, var.getDescripcion());
            }
            
            if (!ps.execute()) 
            {
                new frmAlerta("Proyecto ingresado correctamente",1).setVisible(true);
                retorno = true;
            }
        }
        catch(SQLException e)
        {
            new frmAlerta("Error al ingresar los datos",3).setVisible(true);
            System.out.println(e);
        }
        return retorno;
    }
    
    public boolean modificarProyecto(MtoProyecto var)
    {
        boolean retorno = false;
        try
        {
            String sql;
            
            if (var.getUbicacion() != null || var.getDescripcion() != null) 
            {
                sql = "update Proyecto set Estado = ? , Cliente = ? ,Supervisor = ? , Tipo_Proyecto = ? ,Nombre_Proyecto = ? , FechaInicio = ?, FechaFin = ?,Ubicacion = ? ,Descripcion_Proyecto = ? where Id_Proyecto = ?";
            }
            else
            {
                 sql = "update Proyecto set Estado = ? , Cliente = ? ,Supervisor = ? , Tipo_Proyecto = ? ,Nombre_Proyecto = ? , FechaInicio = ?, FechaFin = ? where Id_Proyecto = ?";
            }
            
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getEstado());
            ps.setInt(2, var.getCliente());
            ps.setInt(3, var.getSupervisor());
            ps.setInt(4, var.getTipo());
            ps.setString(5, var.getProyecto());
            ps.setDate(6, var.getFechaInicio());
            ps.setDate(7, var.getFechaFin());                
            
            if (var.getUbicacion() != null || var.getDescripcion() != null) 
            {
                ps.setString(8, var.getUbicacion());
                ps.setString(9, var.getDescripcion());
                ps.setInt(10, var.getId());
            }
            else
            {
                ps.setInt(8, var.getId());
            }
            
            if (!ps.execute()) 
            {             
                new frmAlerta("Proyecto modificado correctamente",1).setVisible(true);
                retorno = true;
            }
        }
        catch(SQLException e)
        {
            new frmAlerta("Error al modificar los datos",3).setVisible(true);
            System.out.println(e);
        }
        return retorno;
    }
    
    //Declaracion de atributos
    private String proyecto,descripcion,ubicacion,nombreCliente,apellidoCliente;
    private int estado,supervisor,tipo,cliente,id;
    private Date fechaInicio,fechaFin;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the apellidoCliente
     */
    public String getApellidoCliente() {
        return apellidoCliente;
    }

    /**
     * @param apellidoCliente the apellidoCliente to set
     */
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }
    
    /**
     * @return the proyecto
     */
    public String getProyecto() {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the supervisor
     */
    public int getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the cliente
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
