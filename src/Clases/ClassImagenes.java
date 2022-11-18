/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Vista.Frames.frmFileChooser;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Diego Castro
 */
public class ClassImagenes 
{
    frmFileChooser f = new frmFileChooser();
    ClassConexion con = new ClassConexion();
    PreparedStatement ps;
    ResultSetMetaData rm;
    ResultSet rs;
    
    private boolean retorno;
    private String query;
    private int idProyecto;
    private byte[] imagen;
    private int idImagen;
    
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
     * @return the imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    /**
     * @return the idImagen
     */
    public int getIdImagen() {
        return idImagen;
    }

    /**
     * @param idImagen the idImagen to set
     */
    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
    
    /** Metodo para mostrar el selector de archivos y para cargar la imagen seleccionada en el label
     * @param lblFoto label donde se colocara la foto seleccionada
     * @return la ruta de la imagen
     */   
    public String seleccionarImagen(JLabel lblFoto)
    {
        String path = null;  
        try
        {                                                                                                                                                                                       
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");                                                                                                                                            
            f.jFileChooser1.setFileFilter(filtro);
            int resultado = f.jFileChooser1.showOpenDialog(null);       
            if (JFileChooser.APPROVE_OPTION == resultado)
            {
                File fichero = f.jFileChooser1.getSelectedFile();
                path = fichero.toString();
                try
                {                                                                                                                                                                                                   
                    ImageIcon icon = new ImageIcon(fichero.toString());                                                                                                                                                                                       
                    Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                    lblFoto.setText(null);   
                    lblFoto.setIcon(icono);
                }
                catch(Exception ex)
                {   
                    JOptionPane.showMessageDialog(null, "Error al abrir la imagen "+ ex);     
                }
            }
        }
        catch(HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return path;
    }
    
    /** Metodo para convertir una cadena de bytes a un ImageIcon para colocarlo como imagen en un JLabel
     * @param logo es la cadena de bytes que contiene la imagen codificada
     * @param lblFotografia es el label donde se imprimira el icono
     * @return 
     */  
    public boolean cargarLogo(byte[] logo,JLabel lblFotografia)
    {
        try
        {   
            if (logo == null) 
            {
                ImageIcon icon = new ImageIcon("src\\Iconografia\\imgSinImagen.jpg");
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFotografia.getWidth(), lblFotografia.getHeight(), Image.SCALE_DEFAULT)); 
                lblFotografia.setIcon(icono);
                retorno = false;
            }
            else
            {
                BufferedImage img;                                                                                                                                                                               
                img = ImageIO.read(new ByteArrayInputStream(logo));     
                ImageIcon icono = new ImageIcon(img);
                Icon foto = new ImageIcon(icono.getImage().getScaledInstance(lblFotografia.getWidth(), lblFotografia.getHeight(), Image.SCALE_DEFAULT));
                lblFotografia.setIcon(foto);
                retorno = true;
            }
         }
         catch(IOException e)
         {
            //System.out.println("Error al cargar imagen "+ e);
         }
         catch(Exception e)
         {
            //System.out.println("Error al cargar imagen aqui"+e);
         }
        return retorno;
    }
   
    /** Metodo para convertir una cadena de bytes a un ImageIcon para colocarlo como imagen en un JLabel
     * @param ruta es la ruta relativa de la ubicacion de la imagen que se desea convertir a bytes[]
     * @return 
     */
    public byte[] codificarLogo(String ruta) 
    {
        byte[] icono = null;
        try
        {    
            File archivo = new File(ruta);                                                                                                                                                                  
            icono = new byte[(int) archivo.length()];      
            InputStream input = new FileInputStream(archivo);
            input.read(icono);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return icono;
    }
    
    public byte[] obtenerImagen(int idFotografia)
    {
        byte[] img = null;
        try
        {
            query ="select Fotografia from Fotografias where Id_Fotografia = ?";
            ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, idFotografia);
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                img = rs.getBytes(1);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return img;
    }
    
    public int[] getIdFotografias(int idProyecto)
    {
        int[] id = new int[6];
        int posicion = 0;
        try
        {
            query ="select * from Fotografias where Proyecto = ?";
            ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, idProyecto);
            rs = ps.executeQuery();
            while(rs.next()) 
            {
                id[posicion] = rs.getInt(1);
                posicion++;     
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return id;
    }
    
    public boolean ingresarImagen(ClassImagenes img)
    {
        try
        {
            query = "insert into Fotografias (proyecto,fotografia) values (?,?)";
            ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, img.getIdProyecto());
            ps.setBytes(2, img.getImagen());
            if (!ps.execute()) 
            {
                retorno = true;
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return retorno;
    }
    
    public boolean modificarImagen(ClassImagenes img)
    {
        try
        {
            query = "update Fotografias set Fotografia = ? where Id_Fotografia = ?";
            ps = con.getConnection().prepareStatement(query);
            ps.setBytes(1, img.getImagen());
            ps.setInt(2, img.getIdImagen());
            if (!ps.execute()) 
            {
                retorno = true;
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return retorno;
    }
    
    public boolean eliminarImagen(ClassImagenes img)
    {
        try
        {
            query = "delete from Fotografias where Id_Fotografia = ?";
            ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, img.getIdImagen());
            if (!ps.execute()) 
            {
                retorno = true;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"HERE"+ e);
        }
        return retorno;
    }
}
