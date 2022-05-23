/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controlador.Controlador;
import modelo.Jugador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanf
 */
public class GanadorTest {
    
    
    private Jugador jugador1;
    private Jugador jugador2;
    
    public GanadorTest() {
        jugador1 = new Jugador("Juan Felipe", 0);
        jugador2 = new Jugador("Luisa Fernanda", 0);
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Iniciando Pruebas");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Pruebas Finalizadas");
    }
    
    @Before
    public void setUp() {
        System.out.println("Iniciando prueba unitaria");
    }
    
    @After
    public void tearDown() {
        System.out.println("Prueba unitaria finalizada");
    }

    //LAS EXPLICACIONES PASO A PASO DE LAS PRUEBAS ESTAN EN LA CLASE JUGADOR
    
    @Test
    public void ganaJugador1(){
        jugador1.setPuntuacion(50);
        jugador2.setPuntuacion(10);
        assertTrue(jugador1.gano(jugador2.getPuntuacion()));
    }
    
    @Test
    public void pierdeJugador1(){
        jugador1.setPuntuacion(50);
        jugador2.setPuntuacion(100);
        assertFalse(jugador1.gano(jugador2.getPuntuacion()));
    }
    
    @Test
    public void ganaJugador2(){
        jugador1.setPuntuacion(50);
        jugador2.setPuntuacion(100);
        assertTrue(jugador2.gano(jugador1.getPuntuacion()));
    }
    
    @Test
    public void pierdeJugador2(){
        jugador1.setPuntuacion(50);
        jugador2.setPuntuacion(10);
        assertFalse(jugador2.gano(jugador1.getPuntuacion()));
    }
}
