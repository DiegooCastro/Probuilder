/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public abstract class Database {

    //Declaracion de la variable de tipo conexion
    private Connection con;

    /**
     * Metodo para realizar la conexion entre la base de datos y netbens
     *
     * @return el objeto conexion con la conexion a la base
     */
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_probuilder", "postgres", "2002");
        } catch (SQLException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
