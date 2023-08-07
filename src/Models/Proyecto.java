/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Helpers.Database;
import Views.Frames.frmAlerta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Castroll
 */
public class Proyecto extends Database {

    //Declaracion de objetos de conexion
    private PreparedStatement ps;

    public boolean ingresarProyecto(Proyecto var) {
        boolean retorno = false;
        try {
            String sql;
            if (var.getUbicacion() != null || var.getDescripcion() != null) {
                sql = "insert into Proyecto (Id_proyecto, Estado , Cliente , Supervisor ,Tipo_Proyecto , Nombre_Proyecto , FechaInicio , FechaFin ,Ubicacion , Descripcion_Proyecto) values(default,default,?,?,?,?,?,?,?,?)";
            } else {
                sql = "insert into Proyecto (Id_proyecto, Estado , Cliente , Supervisor ,Tipo_Proyecto , Nombre_Proyecto ,FechaInicio , FechaFin) values(default,default,?,?,?,?,?,?)";
            }
            ps = super.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getCliente());
            ps.setInt(2, var.getSupervisor());
            ps.setInt(3, var.getTipo());
            ps.setString(4, var.getProyecto());
            ps.setObject(5, var.getFechaInicio());
            ps.setObject(6, var.getFechaFin());
            if (var.getUbicacion() != null || var.getDescripcion() != null) {
                ps.setString(7, var.getUbicacion());
                ps.setString(8, var.getDescripcion());
            }
            if (!ps.execute()) {
                new frmAlerta("Proyecto ingresado correctamente", 1).setVisible(true);
                retorno = true;
            }
        } catch (SQLException e) {
            new frmAlerta("Error al ingresar los datos", 3).setVisible(true);
            System.out.println(e);
        }
        return retorno;
    }

    public boolean modificarProyecto(Proyecto var) {
        boolean retorno = false;
        try {
            String sql;
            if (var.getUbicacion() != null || var.getDescripcion() != null) {
                sql = "update Proyecto set Cliente = ? ,Supervisor = ? , Tipo_Proyecto = ? ,Nombre_Proyecto = ? , FechaInicio = ?, FechaFin = ?,Ubicacion = ? ,Descripcion_Proyecto = ? where Id_Proyecto = ?";
            } else {
                sql = "update Proyecto set Cliente = ? ,Supervisor = ? , Tipo_Proyecto = ? ,Nombre_Proyecto = ? , FechaInicio = ?, FechaFin = ? where Id_Proyecto = ?";
            }
            ps = super.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getCliente());
            ps.setInt(2, var.getSupervisor());
            ps.setInt(3, var.getTipo());
            ps.setString(4, var.getProyecto());
            ps.setObject(5, var.getFechaInicio());
            ps.setObject(6, var.getFechaFin());
            if (var.getUbicacion() != null || var.getDescripcion() != null) {
                ps.setString(7, var.getUbicacion());
                ps.setString(8, var.getDescripcion());
                ps.setInt(9, var.getId());
            } else {
                ps.setInt(7, var.getId());
            }
            if (!ps.execute()) {
                new frmAlerta("Proyecto modificado correctamente", 1).setVisible(true);
                retorno = true;
            }
        } catch (SQLException e) {
            new frmAlerta("Error al modificar los datos", 3).setVisible(true);
            System.out.println(e);
        }
        return retorno;
    }

    //Declaracion de atributos
    private String proyecto, descripcion, ubicacion, nombreCliente, apellidoCliente;
    private int estado, supervisor, tipo, cliente, id;
    private Object fechaInicio, fechaFin;

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
    public Object getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Object fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Object getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Object fechaFin) {
        this.fechaFin = fechaFin;
    }
}
