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
public class Tablero {
    
    private Casilla[][] tablero;
    private  int i=32,j=42;

 

    public Tablero() {
        int numi;
        numi = (int) (Math.random()*32+1);
        
        while(numi==1){
             numi=(int)(Math.random())*i;
        }
        int numj;
        numj=(int)(Math.random())*42+1;
        
        this.tablero = new Casilla[i][j];
         for (int auxi=0;auxi<i;auxi++){
           for (int auxj=0;auxj<j;auxj++){
               
               tablero[auxi][auxj]=new Casilla(auxi,auxj);            
           }
           
       }
         tablero[numi][numj].setTengoComida(true);
         System.out.println(numi+" "+numj);
    }
    
    
     @Override
    public String toString() {
        String cadena ="";
        
       for (int auxi=0;auxi<i;auxi++){
           for (int auxj=0;auxj<j;auxj++){
              // cadena+=" "+auxi+" ; "+auxj+" :";
            // cadena+= " "+matrix[auxi][auxj].getEstoyVivo()+" ";
               if( tablero[auxi][auxj].getTengoSnake())
                  cadena+= " 1 ";
              else cadena+= " 0 ";
           }
           cadena += "\n";
       }
        return cadena;
    }

    public Casilla[][] getTablero() {
        return tablero;
    }
    
    
}
