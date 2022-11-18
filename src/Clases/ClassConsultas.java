/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Diego
 */
public class ClassConsultas 
{
    private String queryId;
    private String querySelect;
    private String queryComboBox;
    
    public String consultarIdProyecto(String proyecto)
    {
        queryId = "select * from Proyecto where Nombre_Proyecto = '"+proyecto+"'";
        return queryId;
    }
    
    public String consultarIdPresupuesto(int idProyecto)
    {
        queryId = "select * from Presupuesto_Proyecto where Proyecto = '"+idProyecto+"'";
        return queryId;
    }
    
    public String comboBoxEstadoAsignacion()
    {
        queryComboBox = "select * from Estado_Asignacion";
        return queryComboBox;
    }
    
    public String queryTablaAsignaciones(String proyecto)
    {
        querySelect = "select * from Vista_Asignaciones where Nombre_Proyecto = '"+proyecto+"'";
        return querySelect;
    }
   
}
