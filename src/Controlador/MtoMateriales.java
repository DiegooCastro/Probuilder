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
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class MtoMateriales 
{
    ClassFuncionesSQL funSql = new ClassFuncionesSQL();
    ClassFunciones fun = new ClassFunciones();
    ClassConexion con = new ClassConexion();
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public boolean ingresarMaterial(MtoMateriales var)
    {
        boolean retorno = false;
        try
        {
            sql = "select * from Materiales where Nombre_Material = ? and Unidad = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, var.getNombre());
            ps.setInt(2, var.getIdUnidad());
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                new frmAlerta("El material ya se encuentra registrado",2).setVisible(true);
            }
            else
            {
                sql = "insert into Materiales (Unidad , Nombre_Material, Descripcion, Foto_Material, Estado,Cantidad_Disponible) values(?,?,?,?,?,?)";
                ps = con.getConnection().prepareStatement(sql);
                ps.setInt(1, var.getIdUnidad());
                ps.setString(2, var.getNombre());
                ps.setString(3, var.getDescripcion());
                ps.setBytes(4, var.getFotoMaterial());
                ps.setInt(5, var.getEstado());
                ps.setInt(6, var.getDisponible());
                if (!ps.execute()) 
                {
                    new frmAlerta("Material registrado correctamente",1).setVisible(true);
                    retorno = true;
                }
            }
        }
        catch(HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return retorno;
    }
    
    public boolean modificarMaterial(MtoMateriales var)
    {
        boolean retorno = false;
        try
        {
            sql = "select * from Materiales where Nombre_Material = ? and Id_Material != ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, var.getNombre());
            ps.setInt(2, var.getIdMaterial());
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                new frmAlerta("El material ya se encuentra registrado",2).setVisible(true);
            }
            else
            {
                sql = "update Materiales set Unidad = ? , Nombre_Material = ? , Descripcion = ? where Id_Material = ?";
                ps = con.getConnection().prepareStatement(sql);
                ps.setInt(1, var.getIdUnidad());
                ps.setString(2, var.getNombre());
                ps.setString(3, var.getDescripcion());
                ps.setInt(4, var.getIdMaterial());
                if (!ps.execute()) 
                {
                    if (var.getFotoMaterial() != null) 
                    {
                        if (JOptionPane.showConfirmDialog(null, "Desea actualizar la imagen del material","Confirme",JOptionPane.YES_NO_OPTION) == 0) 
                        {
                            sql = "update Materiales set Foto_Material = ? where Id_Material = ?";
                            ps = con.getConnection().prepareStatement(sql);
                            ps.setBytes(1, var.getFotoMaterial());
                            ps.setInt(2, var.getIdMaterial());
                            ps.executeUpdate();
                        }
                    }
                    new frmAlerta("Material modificado correctamente",1).setVisible(true);
                    retorno = true;
                }
            }
                               
        }
        catch(HeadlessException | SQLException e)
        {
            new frmAlerta("El material se encuentra registrado",2).setVisible(true);
        }
        return retorno;
    }
    
    public boolean ingresarCompraMaterial(MtoMateriales var)
    {
        boolean retorno = false;
        try
        {
            sql = "insert into Compras_Materiales (Material,Encargado,Proveedor,Cantidad_Comprada,Precio_Unitario,Monto_Total,Fecha_Compra) values(?,?,?,?,?,?,?)";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getMaterial());
            ps.setInt(2, var.getEncargado());
            ps.setInt(3, var.getProveedor());
            ps.setInt(4, var.getCantidadComprada());
            ps.setDouble(5, var.getPrecioUnitari());
            ps.setDouble(6, var.getMontoCompra());
            ps.setDate(7, funSql.getDate());
            if (!ps.execute()) 
            {
                new frmAlerta("Compra de material registrada correctamente",1).setVisible(true);
                retorno = true;
                ingresarAlmacenaje(var.getCantidadComprada(),var.getMaterial());
            }
        }
        catch(HeadlessException | SQLException e)
        {
            new frmAlerta("Error al ingresar compra de material",3).setVisible(true);
            System.out.println(e);
        }
        return retorno;
    }
    
    public void ingresarAlmacenaje(int cantidadComprada, int idMaterial)
    {
        try
        {
            sql = "select ingresarCantidadAlmacenaje (?,?)";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, cantidadComprada);
            ps.setInt(2, idMaterial);
            if (!ps.execute()) 
            {
                System.out.println("Cantidad actualizada correctamente");
            }
            ps.close();
        }
        catch(HeadlessException | SQLException e)
        {
            new frmAlerta("Error al modificar la cantidad de materiales",3).setVisible(true);
            System.out.println(e);
        }
    }
    
    public boolean modificarCompraMaterial(MtoMateriales var)
    {
        boolean retorno = false;
        try
        {
            sql = "update Compras_Materiales set Proveedor = ? , Cantidad_Comprada = ? , Precio_Unitario = ? , Monto_Total = ?, Fecha_Compra = ? where Id_Compra = ?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, var.getProveedor());
            ps.setInt(2, var.getCantidadComprada());
            ps.setDouble(3, var.getPrecioUnitari());
            ps.setDouble(4, var.getMontoCompra());
            ps.setDate(5, funSql.getDate());
            ps.setInt(6, var.getIdCompra());
            if (!ps.execute()) 
            {
                new frmAlerta("Compra de material modificada correctamente",1).setVisible(true);
                retorno = true; 
                actualizarAlmacenaje(var.getMaterial(),var.getCantidadReal());
            }                               
        }
        catch(HeadlessException | SQLException e)
        {
            new frmAlerta("Error al modificar compra de material",3).setVisible(true);
            System.out.println(e);
        }
        return retorno;
    }
       
    public void actualizarAlmacenaje(int idMaterial,int cantidadComprada)
    {
        try
        {
            sql = "select actualizarCantidadAlmacenaje (?,?) ";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, cantidadComprada);
            ps.setInt(2, idMaterial);
            if (!ps.execute()) 
            {
                System.out.println("Cantidad de materiales actualizada correctamente");
            }
            ps.close();
        }
        catch(HeadlessException | SQLException e)
        {
            new frmAlerta("Error al actualizar almacenaje de materiales",3).setVisible(true);
            System.out.println(e);
        }
    }  
    
    private int idMaterial,idUnidad,estado,disponible;
    private String nombre,descripcion;
    private byte[] fotoMaterial;
    
    /**
     * @return the idMaterial
     */
    public int getIdMaterial() {
        return idMaterial;
    }

    /**
     * @param idMaterial the idMaterial to set
     */
    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
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
     * @return the idUnidad
     */
    public int getIdUnidad() {
        return idUnidad;
    }

    /**
     * @param idUnidad the idUnidad to set
     */
    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

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
     * @return the fotoMaterial
     */
    public byte[] getFotoMaterial() {
        return fotoMaterial;
    }

    /**
     * @param fotoMaterial the fotoMaterial to set
     */
    public void setFotoMaterial(byte[] fotoMaterial) {
        this.fotoMaterial = fotoMaterial;
    }
    
    private int idCompra, material,encargado,proveedor,cantidadComprada,cantidadReal;
    private double precioUnitari, montoCompra;
    
    /**
     * @return the idCompra
     */
    public int getIdCompra() {
        return idCompra;
    }

    /**
     * @param idCompra the idCompra to set
     */
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * @return the cantidadReal
     */
    public int getCantidadReal() {
        return cantidadReal;
    }

    /**
     * @param cantidadReal the cantidadReal to set
     */
    public void setCantidadReal(int cantidadReal) {
        this.cantidadReal = cantidadReal;
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
     * @return the encargado
     */
    public int getEncargado() {
        return encargado;
    }

    /**
     * @param encargado the encargado to set
     */
    public void setEncargado(int encargado) {
        this.encargado = encargado;
    }

    /**
     * @return the proveedor
     */
    public int getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the cantidadComprada
     */
    public int getCantidadComprada() {
        return cantidadComprada;
    }

    /**
     * @param cantidadComprada the cantidadComprada to set
     */
    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    /**
     * @return the precioUnitari
     */
    public double getPrecioUnitari() {
        return precioUnitari;
    }

    /**
     * @param precioUnitari the precioUnitari to set
     */
    public void setPrecioUnitari(double precioUnitari) {
        this.precioUnitari = precioUnitari;
    }

    /**
     * @return the montoCompra
     */
    public double getMontoCompra() {
        return montoCompra;
    }

    /**
     * @param montoCompra the montoCompra to set
     */
    public void setMontoCompra(double montoCompra) {
        this.montoCompra = montoCompra;
    }
}
