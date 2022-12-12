/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class ClassConexion 
{
    //Declaracion de la variable de tipo conexion
    private Connection con;
    
    /**
     * Metodo para realizar la conexion entre la base de datos y netbens
     * @return el objeto conexion con la conexion a la base
     */
    public Connection getConnection2()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=pruebina", "sa", "2002");
        }
        catch (ClassNotFoundException | SQLException e)
        {
            con= null;
            System.out.println(e);
        }
        return con;
    }
    
    public Connection getConnection() 
    {
        try 
        { 
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pr","postgres", "2002");
        } 
        catch (SQLException ex)     
        {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(ClassConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
