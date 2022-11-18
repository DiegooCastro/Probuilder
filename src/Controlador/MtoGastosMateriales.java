/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.ClassConexion;
import Clases.ClassFunciones;
import Clases.ClassFuncionesSQL;
import Vista.Frames.frmAlerta;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class MtoGastosMateriales 
{
    ClassConexion con = new ClassConexion();
    ClassFuncionesSQL fun = new ClassFuncionesSQL();
    ClassFunciones funq = new ClassFunciones();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    private int idMateriales,presupuesto,material,cantidad,disponible;
    private double precioTotal;
   
     /**
     * @return the idMateriales
     */
    public int getIdMateriales() {
        return idMateriales;
    }

    /**
     * @param idMateriales the idMateriales to set
     */
    public void setIdMateriales(int idMateriales) {
        this.idMateriales = idMateriales;
    }

    /**
     * @return the presupuesto
     */
    public int getPresupuesto() {
        return presupuesto;
    }

    /**
     * @return the disponible
     */
    public int getDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }
    
    /**
     * @param presupuesto the presupuesto to set
     */
    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * @return the material
     */
    public int getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(int material) {
        this.material = material;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    
    public boolean ingresarGastoMaterial(MtoGastosMateriales var)
    {
        boolean retorno = false;
        try
        {
            String sql = "select * from Gastos_Materiales where Material = ? and Presupuesto = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getMaterial());
            ps.setInt(2, var.getPresupuesto());
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                new frmAlerta("El material ya se encuentra asignado al presupuesto",2).setVisible(true);
            }
            else
            {
                sql = "insert into Gastos_Materiales (Presupuesto,Material,Cantidad,Precio_Total,Fecha_Modificacion) values(?,?,?,?,?)";
                ps = con.getConnection().prepareStatement(sql);
                ps.setInt(1, var.getPresupuesto());
                ps.setInt(2, var.getMaterial());
                ps.setInt(3, var.getCantidad());
                ps.setDouble(4, var.getPrecioTotal());
                ps.setDate(5, fun.getDate());
                if (!ps.execute()) 
                {
                    new frmAlerta("Detalle material ingresado correctamente",1).setVisible(true);
                    retorno = true;
                    actualizarBodega(var.getMaterial(),var.getDisponible());
                }
            }
        }
        catch(HeadlessException | SQLException e)
        {
            System.out.println(e);
        }
        return retorno;
    }
    
    public boolean modificarGastoMaterial(MtoGastosMateriales var)
    {
        boolean retorno = false;
        try
        {
            String sql = "update Gastos_Materiales set Cantidad = ? , Precio_Total = ? , Fecha_Modificacion = ? where Id_GastoMateriales = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getCantidad());
            ps.setDouble(2, var.getPrecioTotal());
            ps.setDate(3, fun.getDate());
            ps.setInt(4, var.getIdMateriales());
            if (!ps.execute()) 
            {
                new frmAlerta("Detalle de material modificado correctamente",1).setVisible(true);
                retorno = true;
                actualizarBodega(var.getMaterial(),var.getDisponible());
            }
                      
        }
        catch(HeadlessException | SQLException e)
        {
            System.out.println(e);
        }
        return retorno;
    }
    
    public boolean eliminarGastoMaterial(MtoGastosMateriales var)
    {
        boolean retorno = false;
        try
        {
            String sql = "delete from Gastos_Materiales where Id_GastoMateriales = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getIdMateriales());
            if (!ps.execute()) 
            {
                new frmAlerta("Detalle de material eliminado correctamente",1).setVisible(true);
                retorno = true;
                actualizarBodega(var.getMaterial(),var.getDisponible());
            }             
        }
        catch(HeadlessException | SQLException e)
        {
            System.out.println(e);
        }
        return retorno;
    }
    
    public String getPrecioUnitario(int idMaterial)
    {
        String precioUni = "0";
        try
        {
            String sql = "select getPromedioPrecio('"+idMaterial+"')";
            st = con.getConnection().createStatement();
            rs = st.executeQuery(sql);
            double precio = 0;
            if (rs.next()) 
            {
                precio = rs.getDouble(1);
            }
            precioUni = funq.formatoDecimales(precio);
        }
        catch(SQLException e)
        {
            System.out.print(e);
        }
        return precioUni;
    }
    
    public void actualizarBodega(int idMaterial,int cantidadDisponible)
    {
        try
        {
            String sql = "select actualizarBodega('"+cantidadDisponible+"','"+idMaterial+"')";
            ps = con.getConnection().prepareStatement(sql);
            if (!ps.execute()) 
            {
                //JOptionPane.showMessageDialog(null, "cantidad actualizada");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}
