/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.ClassConexion;
import Vista.Frames.frmAlerta;
import Vista.Paneles.PanelControlAsig;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class MtoAsignaciones 
{
    ClassConexion con = new ClassConexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean ingresarAsignacion(MtoAsignaciones obj)
    {
        boolean retorno = false;
        try
        {
            String sql = "select * from Asignaciones_Proyecto where Proyecto = ? and Asignacion = ? and Encargado = ? or Fecha_Inicio = ? or Fecha_Fin = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, obj.getProyecto());
            ps.setInt(2, obj.getAsignacion());
            ps.setInt(3, obj.getEncargado());
            ps.setDate(4, obj.getFechaInicio());
            ps.setDate(5, obj.getFechaFin());
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                new frmAlerta("El encargado posee una asignacion en el proyecto",2).setVisible(true);
            }
            else
            {
                sql = "insert into Asignaciones_Proyecto (Proyecto , Asignacion , Estado_Asignacion , Encargado , Fecha_Inicio , Fecha_Fin , SueldoTotal)values (?,?,?,?,?,?,?)";
                ps = con.getConnection().prepareStatement(sql);
                ps.setInt(1, obj.getProyecto());
                ps.setInt(2, obj.getAsignacion());
                ps.setInt(3, obj.getEstado());
                ps.setInt(4, obj.getEncargado());
                ps.setDate(5, obj.getFechaInicio());
                ps.setDate(6, obj.getFechaFin());
                ps.setDouble(7, obj.getGastoTotal());
                if (!ps.execute()) 
                {
                    new frmAlerta("Asignacion registrada correctamente",1).setVisible(true);                   
                    sql ="update Personal set Estado = 2 where Id_Personal = '"+obj.getEncargado()+"'";
                    ps = con.getConnection().prepareStatement(sql);
                    if (!ps.execute()) 
                    {
                        System.out.println("Estado Actualizado");
                        sql = "update Personal set Estado = 2 where Id_Personal = ?";
                        ps = con.getConnection().prepareStatement(sql);
                        ps.setInt(1, obj.getEncargado());
                        ps.executeUpdate();
                    }
                    retorno = true;
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return retorno;
    }
    
    public boolean modificarAsignacion(MtoAsignaciones obj, int id)
    {
        boolean retorno = false;
        try
        {
            String sql = "update Asignaciones_Proyecto set Asignacion = ?, Estado_Asignacion = ?, Encargado = ?, Fecha_Inicio = ?, Fecha_Fin = ? , SueldoTotal = ? where Id_Asignaciones = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, obj.getAsignacion());
            ps.setInt(2, obj.getEstado());
            ps.setInt(3, obj.getEncargado());
            ps.setDate(4, obj.getFechaInicio());
            ps.setDate(5, obj.getFechaFin());
            ps.setDouble(6, obj.getGastoTotal());
            ps.setInt(7, id);
            if (!ps.execute()) 
            {
                new frmAlerta("Asignacion actividad modificada correctamente",1).setVisible(true);
                retorno = true;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return retorno;
    }
    
    public boolean eliminarAsignacion(int id)
    {
        boolean retorno = false;
        try
        {
            String sql = "delete from Asignaciones_Proyecto where Id_Asignaciones = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            if (!ps.execute()) 
            {
                new frmAlerta("Asignacion eliminada correctamente",1).setVisible(true);
                retorno = true;
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return retorno;
    }
    
    public int[] obtenerDatosEstadisticos(int id)
    {
        int[] retorno = new int[3];
        try
        {
            String sql = "select (select count(estado_asignacion) from Asignaciones_Proyecto where estado_asignacion = 1 and proyecto = ?) as NoRealizado, \n" +
            "(select count(estado_asignacion) from Asignaciones_Proyecto where estado_asignacion = 2 and proyecto = ?) as EnProceso, \n" +
            "(select count(estado_asignacion) from Asignaciones_Proyecto where estado_asignacion = 3 and proyecto = ?) as Realizado\n" +
            "from Asignaciones_Proyecto a,Proyecto p\n" +
            "where a.proyecto = p.id_proyecto ";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.setInt(3, id);
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                retorno[0] = rs.getInt(3); 
                retorno[1] = rs.getInt(2); 
                retorno[2] = rs.getInt(1); 
                System.out.println("Datos estadisticos obtenidos correctamente");
            }
        }
        catch(SQLException e)
        {
            new frmAlerta("Error critico al obtener datos",3).setVisible(true);
            System.out.println(e);
        }
        return retorno;
    }
    
    public String obtenerFechaFinalizacion(int id)
    {
        String retorno ="";
        try
        {
            String sql = "select fechafin from Proyecto p where id_proyecto = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                retorno = rs.getString(1); 
                System.out.println("Fecha de finalizacion obtenida correctamente");
            }
        }
        catch(SQLException e)
        {
            new frmAlerta("Error critico al obtener datos",3).setVisible(true);
            System.out.println(e);
        }
        return retorno;
    }
    
    public boolean modificarEstadoAsignacion(MtoAsignaciones obj, int id)
    {
        boolean retorno = false;
        try
        {
            String sql = "update Asignaciones_Proyecto set Estado_Asignacion = ? where Id_Asignaciones = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, obj.getEstado());
            ps.setInt(2, id);
            if (!ps.execute()) 
            {
                retorno = true;
                sql = "select * from Asignaciones_Proyecto where Encargado = ? and Estado_Asignacion = ?";
                ps = con.getConnection().prepareStatement(sql);
                ps.setInt(1, obj.getEncargado());
                ps.setInt(2, obj.getEstado());
                rs = ps.executeQuery();
                if (!rs.next()) 
                {
                    sql = "update Personal set Estado = 1 where Id_Personal = ?";
                    ps = con.getConnection().prepareStatement(sql);
                    ps.setInt(1, obj.getEncargado());
                    ps.executeUpdate();
                }
                new frmAlerta("Asignacion modificada correctamente",1).setVisible(true);
                retorno = true;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return retorno;
    }
    
    private int proyecto,asignacion,encargado,estado;
    private String nombre,apellido;
    private Double gastoTotal;
    private Date fechaInicio,fechaFin;
    
    /**
     * @return the proyecto
     */
    public int getProyecto() 
    {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(int proyecto) 
    {
        this.proyecto = proyecto;
    }

    /**
     * @return the gastoTotal
     */
    public Double getGastoTotal() 
    {
        return gastoTotal;
    }

    /**
     * @param gastoTotal the gastoTotal to set
     */
    public void setGastoTotal(Double gastoTotal) 
    {
        this.gastoTotal = gastoTotal;
    }
    
    /**
     * @return the asignacion
     */
    public int getAsignacion() 
    {
        return asignacion;
    }

    /**
     * @param asignacion the asignacion to set
     */
    public void setAsignacion(int asignacion) 
    {
        this.asignacion = asignacion;
    }

    /**
     * @return the encargado
     */
    public int getEncargado() 
    {
        return encargado;
    }

    /**
     * @param encargado the encargado to set
     */
    public void setEncargado(int encargado) 
    {
        this.encargado = encargado;
    }

    /**
     * @return the estado
     */
    public int getEstado() 
    {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) 
    {
        this.estado = estado;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() 
    {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) 
    {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() 
    {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) 
    {
        this.fechaFin = fechaFin;
    }
     /**
     * @return the nombre
     */
    public String getNombre() 
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() 
    {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) 
    {
        this.apellido = apellido;
    }
}
