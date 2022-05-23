/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Jugador;

/**
 *
 * @author juanf
 */
public class AccesoDB {
    Connection conexion;
    
    public void abrirConexion(){
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Interactiva","postgres","univalle");
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarProducto(Jugador jugador){
        abrirConexion();
        try {
            Statement stmt = conexion.createStatement();
            String consulta = "INSERT INTO public.\"Jugador\"(\n" +
"	\"Nombre\", \"Puntaje\")\n" +
"	VALUES ('"+jugador.getNombre()+"', '"+jugador.getPuntuacion()+"');";
            stmt.executeUpdate(consulta);            
        } 
        catch (SQLException ex) {
            Logger.getLogger(AccesoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
    }
}
