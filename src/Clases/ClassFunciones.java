/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Controlador.MtoAsignaciones;
import Controlador.MtoProyecto;
import LIB.FSTexFieldMD;
import java.awt.Event;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.InputMap;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import rojeru_san.rsdate.RSDateChooser;

/**
 *
 * @author Diego Castro as Castroll
 */
public class ClassFunciones
{
    private String caracter,nombre = "",apellido ="",texto;
    private int palabra,i = 0;
    
    
    /** Metodo para obtener la fecha de un DateChooser y convertirla en String
     * @param RSDateChooser es el datechooser del que se obtendra la fecha
     * @return la fecha convertida en tipo string
     */  
    public Date obtenerFecha(RSDateChooser RSDateChooser)
    {
        java.util.Date fecha = RSDateChooser.getDatoFecha();
        DateFormat f= new SimpleDateFormat("yyyy-MM-dd");
        String FechaString = f.format(fecha);
        Date date = Date.valueOf(FechaString);
        return date;
    }
    
    /** Metodo para convertir la fecha de String a Date
     * @param Fecha es el valor de la fecha en tipo String
     * @return la fecha convertida en tipo date
     */  
    public Date ConvertirFecha(String Fecha)
    {
        Date date;
        date = Date.valueOf(Fecha);
        return date;
    }
    
    /**
     * Metodo para agregar un guion automaticamente al textfield segun numero de caracteres
     * @param jTF textfield al que se le desea agregar el guion
     * @param limit el numero de caracteres limite antes que se agrege el guion
     */
    
    public void agregarGuiones(FSTexFieldMD jTF,int limit)
    {
        int a = jTF.getText().length();
        if (a == limit) 
        {
            jTF.setText(jTF.getText()+"-");
        }
        else if (a == limit+1) 
        {
            jTF.setText(jTF.getText().replace("-", ""));
        }
    }
    
    public String formatoDecimales(double precioTotal) 
    {
        DecimalFormat formato = new DecimalFormat("###.##");
        return formato.format(precioTotal);
    }
    
    public void calcularTotal(JSpinner sPCantidad,JTextField jTFPrecioUni, JTextField jTFTotal)
    {
        if (!jTFPrecioUni.getText().isEmpty()) 
        {
            double precioUnitario = Double.parseDouble(jTFPrecioUni.getText());
            int cantidad = Integer.parseInt(sPCantidad.getValue().toString());
            double precioTotal = precioUnitario*cantidad;
            jTFTotal.setText(formatoDecimales(precioTotal));
        }
        else
        {
            jTFTotal.setText("0");
        }
    }
    
    /**
     * Meotod para saparar el nombre y apellido de una misma cadena de texto
     * @param jTF textfield del que se obtendra el texto
     * @param obj objeto de la clase donde se guardaran los resultados
     */
    public void separarEncargado(JTextField jTF, MtoAsignaciones obj)
    {
        nombre = ""; apellido = "";
        texto = jTF.getText();
        palabra = 1;
        for (int i = 0; i < texto.length(); i++) 
        {     
            caracter = String.valueOf(texto.charAt(i));
            if (caracter.trim().isEmpty()) 
            {
                palabra = 2;
            }
            else
            {
                if (palabra == 1) 
                {
                    nombre = nombre+caracter;
                }
                else
                {
                    apellido = apellido+caracter;
                }
            }
        }
        obj.setNombre(nombre);
        obj.setApellido(apellido);
    }
    
    /**
     * Metodo para saparar el nombre y apellido de una misma cadena de texto
     * @param jTF textfield del que se obtendra el texto
     * @param obj objeto de la clase donde se guardaran los resultados
     */
    public void separarCliente(JTextField jTF, MtoProyecto obj)
    {
        nombre = ""; apellido = "";
        texto = jTF.getText();
        palabra = 1;
        for (int i = 0; i < texto.length(); i++) 
        {     
            caracter = String.valueOf(texto.charAt(i));
            if (caracter.trim().isEmpty()) 
            {
                palabra = 2;
            }
            else
            {
                if (palabra == 1) 
                {
                    nombre = nombre+caracter;
                }
                else
                {
                    apellido = apellido+caracter;
                }
            }
        }
        obj.setNombreCliente(nombre);
        obj.setApellidoCliente(apellido);
    }
    
    /**
     * Metodo para borrar el contenido de todos los campos de texto
     * @param jTF textfield del que se obtendra el texto
     */
    public void borrarCampos(JTextField[] jTF)
    {        
        while(i < jTF.length)
        {
            jTF[i].setText(null);
            i++;
        }
        i = 0;
    }
    
    public void soloLetras(JTextField jTF,int longitudMaxima)
    {
        longitudMaxima(jTF,longitudMaxima);
        jTF.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (Character.isDigit(e.getKeyChar())) 
                {
                    e.consume();
                }
            }
        });
    }
    
    public void soloNumeros(JTextField jTF,int longitudMaxima)
    {
        longitudMaxima(jTF,longitudMaxima);
        jTF.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (!Character.isDigit(e.getKeyChar())) 
                {
                    e.consume();
                }
            }
        });         
    }
    
    public void bloquearCopyPaste(JTextField jTF)
    {
        InputMap map = jTF.getInputMap(jTF.WHEN_FOCUSED);
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void longitudMaxima(JTextField jTF,int longitud)
    {
        jTF.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                int c = jTF.getText().length();
                if (c >= longitud) 
                {
                    e.consume();
                }
            }
        });
    } 
    
    public void longitudMaximaTextArea(JTextArea jTF,int longitud)
    {
        jTF.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                int c = jTF.getText().length();
                if (c >= longitud) 
                {
                    e.consume();
                }
            }
        });
    } 
}
