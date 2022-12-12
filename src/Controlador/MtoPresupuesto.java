/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.ClassConexion;
import Vista.Frames.frmAlerta;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class MtoPresupuesto 
{
    //Declaracion de objetos
    ClassConexion con = new ClassConexion();
    PreparedStatement ps;
    ResultSet rs;
    
    //Atributos de la clase
    private int idPresupuesto,idProyecto;
    private double preliminares,instalaciones,manoObra,materiale,subTotal,impuestos,montoTotal;
      
    /**
     * @return the idPresupuesto
     */
    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    /**
     * @param idPresupuesto the idPresupuesto to set
     */
    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    /**
     * @return the idProyecto
     */
    public int getIdProyecto() {
        return idProyecto;
    }

    /**
     * @param idProyecto the idProyecto to set
     */
    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    /**
     * @return the preliminares
     */
    public double getPreliminares() {
        return preliminares;
    }

    /**
     * @param preliminares the preliminares to set
     */
    public void setPreliminares(double preliminares) {
        this.preliminares = preliminares;
    }

    /**
     * @return the instalaciones
     */
    public double getInstalaciones() {
        return instalaciones;
    }

    /**
     * @param instalaciones the instalaciones to set
     */
    public void setInstalaciones(double instalaciones) {
        this.instalaciones = instalaciones;
    }

    /**
     * @return the manoObra
     */
    public double getManoObra() {
        return manoObra;
    }

    /**
     * @param manoObra the manoObra to set
     */
    public void setManoObra(double manoObra) {
        this.manoObra = manoObra;
    }

    /**
     * @return the materiale
     */
    public double getMateriale() {
        return materiale;
    }

    /**
     * @param materiale the materiale to set
     */
    public void setMateriale(double materiale) {
        this.materiale = materiale;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the impuestos
     */
    public double getImpuestos() {
        return impuestos;
    }

    /**
     * @param impuestos the impuestos to set
     */
    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    /**
     * @return the montoTotal
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    DecimalFormat f =  new DecimalFormat("###,###.##");
    
    public String[] cargarPresupuesto(MtoPresupuesto var)
    {   
        String[] datos = new String[6];
        try
         {
            String query = "select gastos_preliminares,mano_obra,precio_materiales,subtotal,impuestos,monto_total from Presupuesto_Proyecto where Proyecto = ?";
            ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, var.getIdProyecto());
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                datos[0] = "$"+f.format(rs.getDouble(1));
                datos[1] = "$"+f.format(rs.getDouble(2));
                datos[2] = "$"+f.format(rs.getDouble(3));  
                datos[3] = "$"+f.format(rs.getDouble(4));
                datos[4] = "$"+f.format(rs.getDouble(5));
                datos[5] = "$"+f.format(rs.getDouble(6));
            }
            else
            {
                new frmAlerta("No hay presupuesto",3).setVisible(true);
            }
        }
        catch(HeadlessException | SQLException e)
        {
            new frmAlerta("Error critico al cargar presupuesto",3).setVisible(true);
            System.out.println(e);
        }
        return datos;
    }
    
    public boolean actualizarTotales(MtoPresupuesto var)
    {
        boolean retorno = false;
        try
        {
            String sql = "select actualizarTotales(?)";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getIdPresupuesto());
            if (!ps.execute())
            {
                System.out.println("Totales actualizados");
                retorno = true;
            }
        }
        catch(HeadlessException | SQLException e)
        {
            new frmAlerta("Error critico al actualizar totales",3).setVisible(true);
            System.out.println(e);
        }
        return retorno;
    }
    
    public boolean actualizarGatosPreliminares(MtoPresupuesto var)
    {
        boolean retorno = false;
        try
        {
            String sql = "select actualizarGastoPreliminares(?)";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getIdPresupuesto());
            if (!ps.execute())
            {
                System.out.println("Preliminares actualizados");
                retorno = true;
            }
        }
        catch(HeadlessException | SQLException e)
        {
            System.out.println(e);
        }
        return retorno;
    }
    
    public boolean actualizarManoObra(MtoPresupuesto var)
    {
        boolean retorno = false;
        try
        {
            String sql = "select actualizarManoObra(?,?)";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getIdPresupuesto());
            ps.setInt(2, var.getIdProyecto());
            if (!ps.execute())
            {
                System.out.println("Mano obra actualizados");
                retorno = true;
            }
        }
        catch(HeadlessException | SQLException e)
        {
            System.out.println(e);
        }
        return retorno;
    }
            
    public boolean actualizarGastoMaterial(MtoPresupuesto var)
    {
        boolean retorno = false;
        try
        {
            String sql = "select actualizarGastoMaterial(?)";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getIdPresupuesto());
            if (!ps.execute())
            {
                System.out.println("Materiales actualizados");
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
