/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import BaseDeDatos.AccesoDB;
import excepciones.YaGanoException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Gui;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.Timer;
import modelo.Jugador;
import timer.ManejadorTimer;

/**
 *
 * @author juanf
 */
public class Controlador{
    
    private Jugador jugadorA;
    private Jugador jugadorB;
    private AccesoDB bd;
    private int[] jugador1;
    private int[] jugador2;
    private ArrayList<String> lista;
    private Gui gui;
    private Timer temporizador;
    private ManejadorTimer mt;
    private boolean gano1;
    private boolean gano2;

    public Controlador(Gui gui) {
        this.gui = gui;
        jugador1 = new int[5];
        jugador2 = new int[5];
        lista = new ArrayList<>();
        mt = new ManejadorTimer();
        temporizador = new Timer(5000, mt);
        leerArchivo();
        setupNumeros();
        bd = new AccesoDB();
            anunciarGanador();
            iniciarTimer();
    }

    private void leerArchivo() {
        RandomAccessFile archivo;
        
        try {
            archivo = new RandomAccessFile("config.txt", "r");
            String lineaActual = "";
            while((lineaActual = archivo.readLine()) != null){
            String[] nums = lineaActual.split(",");
            for( String num : nums){
                lista.add(num);
            }
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    private void setupNumeros(){
        for(int i = 0 ; i < 5 ; i++){
            int temp = Integer.parseInt(lista.get(i));
            jugador1[i] = temp;
        }
        for(int i = 0 ; i < lista.size()-5 ; i++){
            int temp = Integer.parseInt(lista.get(i+4));
            jugador1[i] = temp;
        }
        this.gui.jugador1Casilla1.setText(lista.get(0)+"");
        this.gui.jugador1Casilla2.setText(lista.get(1)+"");
        this.gui.jugador1Casilla3.setText(lista.get(2)+"");
        this.gui.jugador1Casilla4.setText(lista.get(3)+"");
        this.gui.jugador1Casilla5.setText(lista.get(4)+"");
        
        this.gui.jugador2Casilla1.setText(lista.get(5)+"");
        this.gui.jugador2Casilla2.setText(lista.get(6)+"");
        this.gui.jugador2Casilla3.setText(lista.get(7)+"");
        this.gui.jugador2Casilla4.setText(lista.get(8)+"");
        this.gui.jugador2Casilla5.setText(lista.get(9)+"");
        
    }
    
    public void sumarPuntajes(){
        int puntaje1 = 0;
        int puntaje2 = 0;
        for(int i = 0 ; i < 5 ; i++){
            puntaje1 += Integer.parseInt(lista.get(i));
        }
        for(int i = 5 ; i < lista.size() ; i++){
            puntaje2 += Integer.parseInt(lista.get(i));
        }
        jugadorA = new Jugador("Juan Felipe", puntaje1);
        jugadorB = new Jugador("Luisa Fernanda", puntaje2);
    }
    
    public boolean ganoJugador1(){
        return jugadorA.gano(jugadorB.getPuntuacion());
    }
    
    public boolean ganoJugador2(){
        return jugadorB.gano(jugadorA.getPuntuacion());
    }
    
    public void anunciarGanador(){
        try {
            sumarPuntajes();
        String mensaje ="";
        if(ganoJugador1()){
            if(!gano1){
                mensaje += "El jugador Número 1 ganó. Su nombre es: " + jugadorA.getNombre() + ". Y ssu puntaje fue de: " + jugadorA.getPuntuacion();
                JOptionPane.showMessageDialog(null, mensaje, "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
                bd.guardarProducto(jugadorA);
                gano1 = true;
            }else{
                throw new  YaGanoException();
            }
        }else if(ganoJugador2()){
            if(!gano2){
                mensaje += "El jugador Número 2 ganó. Su nombre es: " + jugadorB.getNombre() + ". Y     su puntaje fue de: " + jugadorB.getPuntuacion();
                JOptionPane.showMessageDialog(null, mensaje, "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
                bd.guardarProducto(jugadorB);
                gano2 = true;
            }else{
                throw new YaGanoException();
            }
        }else{
            JOptionPane.showMessageDialog(null, "La casi imposible coincidencia de un empate se dió. Ejecute de nuevo la aplicación por favor.");
        }
        } catch (YaGanoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);                    
        }
    }
    
    public void iniciarTimer(){
        temporizador.start();
        Random random = new Random();
        int num1 = random.nextInt(10-1) + 1;
        lista.set(0, num1+"");
        int num2 = random.nextInt(10-1) + 1;
        lista.set(5, num2+"");
        this.gui.jugador1Casilla1.setText(num1+"");
        this.gui.jugador2Casilla1.setText(num2+"");
            anunciarGanador();
     
        temporizador.stop();
    }
    
}
