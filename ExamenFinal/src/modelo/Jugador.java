/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author juanf
 */
public class Jugador {
    
    
    private String nombre;
    private int puntuacion;

    public Jugador(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
    // Un método muy simple para comparar puntuaciones. Explicación paso a paso del funcionamiento según las pruebas:
    // Por ejemplo si tenemos 2 jugadores, el primero con puntuación 30 y el segundo con puntuación 10. En la especificación de pruebas se espera que al comparar ambos valores el ganador sea el jugador numero1
    // Por lo tanto, llamando el método desde el objeto jugador1 se debería ejecutar de la siguiente manera:
    /* public boolean gano(jugador2.getPuntuacion()){
        if ( 10 <= 30 ) 
            return true
    }
    */
    // Por lo tanto esperaríamos que la prueba retorne verdadero (TRUE), y este es el caso en las pruebas. Se realiza la misma lógica con pruebas que generaría un falso y se cumplen todas las pruebas sin ninguna complicación
    public boolean gano(int puntuacion){
        if(puntuacion <= this.puntuacion){
            return true;
        }else{
            return false;
        }
    }
}
