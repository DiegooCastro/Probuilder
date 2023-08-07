/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import java.awt.Event;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author Kstro
 */
public class Validator {
    /**
     * Metodo para bloquear la accion de poder copiar
     * @param jTF objeto del textfield que se desea restringir el copy paste
     */
    public void bloquearCopiar(JTextField jTF)
    {
        InputMap map = jTF.getInputMap(JTextField.WHEN_FOCUSED);
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    /**
     * Metodo para validar que solo puedan ingresarse letras en el textfield
     * @param jTF textfield al que desea colocarle el filtro
     */
    public void soloLetras(JTextField jTF)
    {
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
    
    /**
     * Metodo para validar que solo puedan ingresarse numeros en el textfield
     * @param jTF textfield al que desea colocarle el filtro
     */
    public void soloNumeros(JTextField jTF)
    {
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
    
    /**
     * Metodo para limitar la cantidad de caracteres que el usuario puede ingresar
     * @param jTF objeto del textfield que se desea limitar los caracteres
     * @param longitud es el valor de la longitud maxima que se desea aplicar
     */
    public void longitudMaxima(JTextField jTF,int longitud)
    {
        bloquearCopiar(jTF);
        jTF.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                int c = jTF.getText().length();
                if (c >= longitud) 
                {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Longitud Maxima");
                }
            }
        });
    }
}
