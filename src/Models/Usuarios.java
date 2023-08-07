/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Helpers.Database;
import Helpers.FuncionesSQL;
import Views.Frames.frmAlert;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase de funciones del formulario usuario
 *
 * @version 1.0
 * @author Diego Castro
 * @since 12/06/2020
 */
public class Usuarios extends Database {

    //Declaracion de las variables de conexion
    FuncionesSQL fun = new FuncionesSQL();
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    /**
     * * Metodo para ingresar los datos en la base de datos
     *
     * @param var objeto de la clase para invocar metodos que permitan el envio
     * de datos
     * @return variable de tipo boolean que confirma si se realizo la consulta
     */
    public boolean ingresarUsuario(Usuarios var) {
        boolean respuesta = false;
        try {
            sql = "select * from Usuario where Usuario = ?";
            ps = super.getConnection().prepareStatement(sql);
            ps.setString(1, var.getUsuario());
            rs = ps.executeQuery();
            if (rs.next()) {
                new frmAlert("El usuario ya esta registrado en el sistema", 2).setVisible(true);
            } else {
                sql = "select * from Usuario where Correo_Electronico = ? or Trabajador = ?";
                ps = super.getConnection().prepareStatement(sql);
                ps.setString(1, var.getCorreo());
                ps.setInt(2, var.getIdTrabajador());
                rs = ps.executeQuery();
                if (rs.next()) {
                    new frmAlert("El empleado esta asignado a un usuario", 2).setVisible(true);
                } else {
                    sql = "insert into Usuario (Id_Usuario,Trabajador,Estado,Tipo,Usuario,Clave,Correo_Electronico) values(default,?,default,?,?,?,?)";
                    ps = super.getConnection().prepareStatement(sql);
                    ps.setInt(1, var.getIdTrabajador());
                    ps.setInt(2, var.getTipo());
                    ps.setString(3, var.getUsuario());
                    ps.setString(4, var.getClave());
                    ps.setString(5, var.getCorreo());
                    if (!ps.execute()) {
                        new frmAlert("Usuario registrado correctamente", 1).setVisible(true);
                        respuesta = true;
                    } else {
                        new frmAlert("Error al registrar usuario", 3).setVisible(true);
                    }
                }
            }
            super.getConnection().close();
        } catch (SQLException e) {
            new frmAlert("Error critico de conexion", 3).setVisible(true);
            System.out.println(e);
        }
        return respuesta;
    }

    /*
     *  Metodo para actualizar los datos en la base de datos
     *  @param var objeto de la clase para invocar metodos que permitan el envio de datos
     *  @return variable de tipo boolean que confirma si se realizo la consulta
     */
    public boolean modificarUsuario(Usuarios var) {
        boolean respuesta = false;
        try {
            sql = "update Usuario  set Usuario = ? , Correo_Electronico = ?, Tipo = ?, Trabajador = ? where Id_Usuario = ?";
            ps = super.getConnection().prepareStatement(sql);
            ps.setString(1, var.getUsuario());
            ps.setString(2, var.getCorreo());
            ps.setInt(3, var.getTipo());
            ps.setInt(4, var.getIdTrabajador());
            ps.setInt(5, var.getIdUsuario());
            if (!ps.execute()) {
                new frmAlert("Usuario actualizado correctamente", 1).setVisible(true);
                respuesta = true;
            } else {
                new frmAlert("Error al modificar datos", 2).setVisible(true);
            }
            super.getConnection().close();
        } catch (SQLException e) {
            new frmAlert("Error critico de conexion", 3).setVisible(true);
        }
        return respuesta;
    }

    /**
     * * Metodo para eliminar un registro de la base de datos
     *
     * @param id identificador del registro al que se desea eliminar
     * @param accion
     * @return variable de tipo boolean que confirma si se realizo la consulta
     */
    public boolean eliminarUsuario(int id, boolean accion) {
        boolean respuesta = false;
        try {
            sql = "update Usuario  set  Estado = ? where Id_Usuario = ?";
            ps = super.getConnection().prepareStatement(sql);
            ps.setBoolean(1, accion);
            ps.setInt(2, id);
            if (!ps.execute()) {
                new frmAlert("Usuario desactivado correctamente", 1).setVisible(true);
                respuesta = true;
            } else {
                new frmAlert("Error al desactivar usuario", 3).setVisible(true);
            }
            super.getConnection().close();
        } catch (SQLException e) {
            new frmAlert("Error critico de conexion", 3).setVisible(true);
        }
        return respuesta;
    }

    //Declaracion de variables de la clase
    private String usuario, clave, correo;
    private int estado, tipo, idUsuario, idTrabajador;

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
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idTrabajador
     */
    public int getIdTrabajador() {
        return idTrabajador;
    }

    /**
     * @param idTrabajador the idTrabajador to set
     */
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
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
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
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
}
