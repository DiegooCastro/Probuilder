/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.ClassConexion;
import Clases.ClassFuncionesSQL;
import Vista.Frames.frmAlerta;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class MtoPreliminares 
{
    ClassConexion con = new ClassConexion();
    ClassFuncionesSQL fun = new ClassFuncionesSQL();
    PreparedStatement ps;
    ResultSet rs;
    
    private int presupuesto,idGastoPreliminar;
    private double precioUni,precioTotal;
    private String sql, descripcion,gastoPreliminar;
    
    /**
     * @return the presupuesto
     */
    public int getPresupuesto() {
        return presupuesto;
    }

    /**
     * @param presupuesto the presupuesto to set
     */
    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    /**
     * @return the gastoPreliminar
     */
    public String getGastoPreliminar() {
        return gastoPreliminar;
    }

    /**
     * @param gastoPreliminar the gastoPreliminar to set
     */
    public void setGastoPreliminar(String gastoPreliminar) {
        this.gastoPreliminar = gastoPreliminar;
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
     * @return the idGastoPreliminar
     */
    public int getIdGastoPreliminar() {
        return idGastoPreliminar;
    }

    /**
     * @param idGastoPreliminar the idGastoPreliminar to set
     */
    public void setIdGastoPreliminar(int idGastoPreliminar) {
        this.idGastoPreliminar = idGastoPreliminar;
    }

    /**
     * @return the precioUni
     */
    public double getPrecioUni() {
        return precioUni;
    }

    /**
     * @param precioUni the precioUni to set
     */
    public void setPrecioUni(double precioUni) {
        this.precioUni = precioUni;
    }

    /**
     * @return the precioTotal
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * @param precioTotal the precioTotal to set
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    public boolean ingresarPreliminares(MtoPreliminares var)
    {
        boolean retorno = false;
        try
        {
            sql = "select * from Gastos_Preliminares where Gasto = ? and Presupuesto = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, var.getGastoPreliminar());
            ps.setInt(2, var.getPresupuesto());
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                new frmAlerta("El gasto ya esta registrado en el presupuesto",2).setVisible(true);
            }
            else
            {
                sql = "insert into Gastos_Preliminares (Presupuesto,Gasto,Precio_Total,Descripcion,Fecha_Modificacion) values(?,?,?,?,?)";
                ps = con.getConnection().prepareStatement(sql);
                ps.setInt(1, var.getPresupuesto());
                ps.setString(2, var.getGastoPreliminar());
                ps.setDouble(3, var.getPrecioTotal());
                ps.setString(4, var.getDescripcion());
                ps.setDate(5, fun.getDate());
                if (!ps.execute()) 
                {
                    new frmAlerta("Gasto preliminar registrado correctamente",1).setVisible(true);
                    retorno = true;
                }
            }
        }
        catch(HeadlessException | SQLException e)
        {
            System.out.println(e);
        }
        return retorno;
    }
    
    public boolean modificarPreliminares(MtoPreliminares var)
    {
        boolean retorno = false;
        try
        {
            sql = "update Gastos_Preliminares set Gasto = ? , Precio_Total = ? , Descripcion = ? , Fecha_Modificacion = ? where Id_GastoPreliminar = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, var.getGastoPreliminar());
            ps.setDouble(2, var.getPrecioTotal());
            ps.setString(3, var.getDescripcion());
            ps.setDate(4, fun.getDate());
            ps.setInt(5, var.getIdGastoPreliminar());
            if (!ps.execute()) 
            {
                new frmAlerta("Gasto preliminar modificado correctamente",1).setVisible(true);
                retorno = true;
            }             
        }
        catch(HeadlessException | SQLException e)
        {
            System.out.println(e);
        }
        return retorno;
    }
    
    public boolean eliminarPreliminares(MtoPreliminares var)
    {
        boolean retorno = false;
        try
        {
            sql = "delete from Gastos_Preliminares where Id_GastoPreliminar = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getIdGastoPreliminar());
            if (!ps.execute()) 
            {
                new frmAlerta("Gasto preliminar eliminado correctamente",2).setVisible(true);
                retorno = true;
            }             
        }
        catch(HeadlessException | SQLException e)
        {
            System.out.println(e);
        }
        return retorno;
    }
}
