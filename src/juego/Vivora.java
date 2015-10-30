/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.ArrayList;

/**
 *
 * @author tati
 */
public class Vivora {
    
    private Tablero tablero;
    private int direccion=1; //1 = derecha, 2=arriba, 3= izquiera, 4= abajo
    private ArrayList vivora = new ArrayList(); //Array de casillas que se va actualizando constantemente
    private Casilla cabeza;
    private Casilla cola;
    private boolean estoymuerta;
    
    public Vivora(Tablero tab) {
        estoymuerta = false;
        cabeza = new Casilla(1,5);
        cola = new Casilla(1,1);
        tablero=tab;
       
        for (int aux=1;aux<6;aux++){
            tablero.getTablero()[1][aux].setTengoSnake(true);
            vivora.add(vivora.size(),tablero.getTablero()[1][aux]);
        }
    }

    public ArrayList getVivora() {
        return vivora;
    }

    public void setVivora(ArrayList vivora) {
        this.vivora = vivora;
    }
    
   public void comer(){
       vivora.add(this.cola);
       
       
   }

    public Casilla getCabeza() {
        return cabeza;
    }

    public Casilla getCola() {
        return cola;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setCabeza(Casilla cabeza) {
        this.cabeza = cabeza;
    }

    public void setCola(Casilla cola) {
        this.cola = cola;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void setEstoymuerta(boolean estoymuerta) {
        this.estoymuerta = estoymuerta;
    }

    public boolean getEstoymuerta() {
        return estoymuerta;
    }
    
    
   
   
    public void mover(){
        int auxi=0,auxj=0;
        Casilla nuevaCasilla;
        switch(direccion){
            case 1: 
                auxi=this.cabeza.getI();
                
                break;
            
            case 2:
                break;
                
            case 3:
                break;
                
            case 4:
                   break;        
        }
        
        try{
                  nuevaCasilla=tablero.getTablero()[auxi][auxj];
                  vivora.add(0,(Object)nuevaCasilla);
                  int p = vivora.indexOf((Object)cola);
                  Casilla auxiliar = (Casilla) vivora.get(p-1);
                  vivora.remove((Object)cola);
                  cola = auxiliar;
                  cabeza=nuevaCasilla;
                   
                           }
               catch(Exception e){
                   
               }
    }
     
    
    
}
