/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Catalogos extends Database {

    PreparedStatement ps;
    ResultSet rs;
    private String registro;
    private int id;

    /**
     * @return the registro
     */
    public String getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(String registro) {
        this.registro = registro;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    //Declaracion de metodos para realizar las diferentes consultas
    private String query;
    private boolean retorno;

    public String querySeleccionar(String tabla, String campo) {
        query = "select * from " + tabla;
        return query;
    }

    public String queryValidar(String tabla, String campo) {
        query = "select * from " + tabla + " where " + campo + " = ?";
        return query;
    }

    public String queryInsercion(String tabla) {
        query = "insert into " + tabla + " values (?)";
        return query;
    }

    public String queryModificar(String tabla, String campo, String campoId) {
        query = "update " + tabla + " set " + campo + " = ? where " + campoId + " = ?";
        return query;
    }

    public boolean ingresarCatalogo(Catalogos obj, String queryValidar, String queryIngresar) {
        retorno = false;
        try {
            ps = super.getConnection().prepareStatement(queryValidar);
            ps.setString(1, obj.getRegistro());
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Duplicidad de datos");
            } else {
                ps = super.getConnection().prepareStatement(queryIngresar);
                ps.setString(1, obj.getRegistro());
                if (!ps.execute()) {
                    retorno = true;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return retorno;
    }

    public boolean modificarCatalogo(Catalogos obj, String queryModificar) {
        retorno = false;
        try {
            ps = super.getConnection().prepareStatement(queryModificar);
            ps.setString(1, obj.getRegistro());
            ps.setInt(2, obj.getId());
            if (!ps.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return retorno;
    }
}
