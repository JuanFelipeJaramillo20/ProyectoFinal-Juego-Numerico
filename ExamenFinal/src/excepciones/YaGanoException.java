/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author juanf
 */
public class YaGanoException extends Exception {

    public YaGanoException() {
        super("Este jugador ganó en la anterior ronda. Parece trampa.");
    }
    
    
}
