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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase de funciones del formulario personal
 *
 * @version 1.0
 * @author Diego Castro
 * @since 12/06/2020
 */
public class Personal extends Database {

    //Declaracion de las variables de conexion
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
    public boolean ingresarPersonal(Personal var) {
        boolean respuesta = false;
        try {
            sql = "select * from Personal where DUI = ? or Nombre = ? and Apellido = ?";
            ps = super.getConnection().prepareStatement(sql);
            ps.setString(1, var.getDui());
            ps.setString(2, var.getNombre());
            ps.setString(3, var.getApellido());
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Duplicidad de datos");
            } else {
                sql = "insert into Personal (Id_Personal,Nombre,Apellido,Telefono,DUI,Profesion,Estado,Sueldo) values(default,?,?,?,?,?,default,?)";
                ps = super.getConnection().prepareStatement(sql);
                ps.setString(1, var.getNombre());
                ps.setString(2, var.getApellido());
                ps.setString(3, var.getTelefono());
                ps.setString(4, var.getDui());
                ps.setInt(5, var.getProfesion());
                ps.setDouble(6, var.getSueldo());
                if (!ps.execute()) {
                    new frmAlerta("Empleado registrado correctamente", 1).setVisible(true);
                    respuesta = true;
                } else {
                    new frmAlerta("Error al ingresar al cliente", 2).setVisible(true);
                }
            }
            super.getConnection().close();
        } catch (SQLException e) {
            new frmAlerta("Error critico de conexion", 3).setVisible(true);
            System.out.println(e);
        }
        return respuesta;
    }

    /**
     * * Metodo para actualizar los datos en la base de datos
     *
     * @param var objeto de la clase para invocar metodos que permitan el envio
     * de datos
     * @return variable de tipo boolean que confirma si se realizo la consulta
     */
    public boolean modificarPersonal(Personal var) {
        boolean respuesta = false;
        try {
            sql = "update Personal  set  Profesion = ? , Estado = ? , Nombre = ? , Apellido = ? , Telefono = ? , DUI = ? , Sueldo = ? where Id_Personal = ?";
            ps = super.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getProfesion());
            ps.setBoolean(2, var.getEstado());
            ps.setString(3, var.getNombre());
            ps.setString(4, var.getApellido());
            ps.setString(5, var.getTelefono());
            ps.setString(6, var.getDui());
            ps.setDouble(7, var.getSueldo());
            ps.setInt(8, var.getIdPersonal());
            if (!ps.execute()) {
                new frmAlerta("Datos del empleado modificados correctamente", 1).setVisible(true);
                respuesta = true;
            } else {
                new frmAlerta("Error al ingresar al cliente", 3).setVisible(true);
            }
            super.getConnection().close();
        } catch (SQLException e) {
            new frmAlerta("Error critico de conexion", 3).setVisible(true);
            System.out.println(e);
        }
        return respuesta;
    }

    /**
     * * Metodo para eliminar un registro de la base de datos
     *
     * @param id identificador del registro al que se desea eliminar
     * @param accion true o false
     * @return variable de tipo boolean que confirma si se realizo la consulta
     */
    public boolean eliminarPersonal(int id, boolean accion) {
        boolean respuesta = false;
        try {
            String query = "update Personal  set  Estado = ? where Id_Personal = ?";
            ps = super.getConnection().prepareStatement(query);
            ps.setBoolean(1, accion);
            ps.setInt(2, id);
            if (!ps.execute()) {
                new frmAlerta("Registro inabilitado correctamente", 1).setVisible(true);
                respuesta = true;
            } else {
                new frmAlerta("Error al ingresar al cliente", 3).setVisible(true);
            }
            super.getConnection().close();
        } catch (SQLException e) {
            new frmAlerta("Error al eliminar al cliente", 3).setVisible(true);
            System.out.println(e);
        }
        return respuesta;
    }

    //Declaracion de variables de la clase
    private String nombre, apellido, telefono, dui;
    private int profesion, idPersonal;
    private double sueldo;
    private boolean estado;
    private Date contratacion;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idPersonal
     */
    public int getIdPersonal() {
        return idPersonal;
    }

    /**
     * @param idPersonal the idPersonal to set
     */
    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    /**
     * @return the contratacion
     */
    public Date getContratacion() {
        return contratacion;
    }

    /**
     * @param contratacion the contratacion to set
     */
    public void setContratacion(Date contratacion) {
        this.contratacion = contratacion;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the sueldo
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * @return the dui
     */
    public String getDui() {
        return dui;
    }

    /**
     * @param dui the dui to set
     */
    public void setDui(String dui) {
        this.dui = dui;
    }

    /**
     * @return the profesion
     */
    public int getProfesion() {
        return profesion;
    }

    /**
     * @param profesion the profesion to set
     */
    public void setProfesion(int profesion) {
        this.profesion = profesion;
    }

    /**
     * @return the estado
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
