/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import control.Teclado;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author tati
 */
public class Juego extends Canvas implements Runnable {
    
    private static JFrame ventana;
    private static Thread thread;
    private int ancho=825,alto=655;
    private String nombre="Vivora";
    private static Teclado teclado;
    private int aps=0; //Actualizaciones por segundo
    private int fps=0; 
    private static volatile boolean enFuncionamiento=false;//volatile le da sincronizacion a la variable.
    private Vivora snake;
    private Tablero tablero;
    private TableroVisual tableroVisual;
        
    public Juego() {
        setPreferredSize(new Dimension(ancho,alto)); 
        
        teclado = new Teclado();
        addKeyListener(teclado); //MUY IMPORTANTE
        
        ventana = new JFrame(nombre);
        ventana.setSize(ancho,alto);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(null);
       // ventana.add(this,BorderLayout.CENTER);
        //ventana.pack(); 
        ventana.setLocationRelativeTo(null);
        
        
        tablero = new Tablero();
        snake = new Vivora(tablero);
        
        tableroVisual = new TableroVisual(tablero);
        for (int auxi=1;auxi<32;auxi++){
           for (int auxj=1;auxj<42;auxj++){
              
               ventana.add(tableroVisual.getTableroVisual()[auxi][auxj].getBoton());
           }
       }   
        ventana.setVisible(true);
    }

    @Override
    public void run() {
        final int nsPorSegundo= 1000000000; //Equivalencia
        final byte APS=4; //Testear, actualizaciones por segundo
        final double nsPorActualizacion=nsPorSegundo/APS; //Cuantos NS tienen que pasar para que actualice 4 veces por segundo.
        
        long referenciaActualizacion= System.nanoTime(); //Cuantos Ns pasaron desde enero de 1970 hasta que hace esta linea
        long referenciaContador = System.nanoTime();
        
        double tiempoTranscurrido;
        double delta = 0; //Cantidad de tiempo que paso desde la ultima act.
       
        requestFocus(); //Le pide a windows que sea la pantalla principal en este momento (mas que nada para el teclado)
         
        System.nanoTime();
        while(enFuncionamiento){
            final long inicioBucle=System.nanoTime(); //momento que inicia el bucle
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion=inicioBucle;
            
            delta = delta + tiempoTranscurrido / nsPorActualizacion;
            
            while(delta >=1){
                actualizar();
                delta--;
            }
            
            if (System.nanoTime() - referenciaContador > nsPorSegundo ){
                ventana.setTitle(nombre + " || APS: "+aps+" || FPS: "+fps);
                aps=0;
                fps=0;
                referenciaContador=System.nanoTime();
            }
            
            mostrar();
        }
       
    }
    
    public synchronized void iniciar(){
        enFuncionamiento=true;
        thread = new Thread(this,"Graficos");
        thread.start();
        
    }
    
    public synchronized void detener() throws InterruptedException{
        enFuncionamiento=false;
        try{
            thread.join();
        }
        catch(Exception e){e.printStackTrace();}
    }
    
    public void actualizar(){
        aps++;
        teclado.actualizar();
        
        
        if(teclado.arriba) {
            snake.setDireccion(2);
            System.out.println("Arriba");
        }

              
        if(teclado.abajo) {
             snake.setDireccion(4);
            System.out.println("Abajo");
        }
        if(teclado.izquierda) {
             snake.setDireccion(3);
            System.out.println("Izquierda");
        }
        if(teclado.derecha) {
             snake.setDireccion(1);
            System.out.println("Derecha");
        }
        
    }
    
    public void mostrar(){
        fps++;
    }
}
