/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author tati
 */
public class CasillaVisual {
    
  private  Casilla casilla;
  private int i,j;
  private   JButton boton;

    public CasillaVisual(Casilla casilla, int i, int j) {
        this.casilla = casilla;
        this.i = i;
        this.j = j;
        this.boton = new JButton();  
        
        boton.setBounds(j*20-20, i*20-20, 20, 20); //Primeros 2 parametros la pos. Ultimos 2 = tamaño
        boton.setBorder(null);
       
        
        boton.setBackground(Color.lightGray); //Color de Muerto
        
        if(this.casilla.getTengoSnake())
            boton.setBackground(Color.red);
        if(this.casilla.getTengoComida())
            boton.setBackground(Color.YELLOW);
        boton.setVisible(true);
       
        
    }

    public JButton getBoton() {
        return boton;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }}
    
    
