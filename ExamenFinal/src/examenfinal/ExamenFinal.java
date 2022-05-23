/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinal;

import controlador.Controlador;
import vista.Gui;

/**
 *
 * @author juanf
 */
public class ExamenFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gui juego = new Gui();
        juego.setVisible(true);
        Controlador control = new Controlador(juego);
    }
    
}
