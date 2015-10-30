/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author tati
 */
public class Casilla {
    
   private int i, j;
   private boolean tengoSnake;
   private boolean tengoComida;
  

    public Casilla() {
    }

    public Casilla(int i, int j) {
        this.i = i;
        this.j = j;
        tengoSnake=false;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setTengoSnake(boolean tengoSnake) {
        this.tengoSnake = tengoSnake;
    }

    public boolean getTengoSnake() {
        return tengoSnake;
    }

    public void setTengoComida(boolean t) {
       tengoComida=t;
    }

    public boolean getTengoComida() {
        return tengoComida;
    }
    
    
}
   
    
    
    
    
    

