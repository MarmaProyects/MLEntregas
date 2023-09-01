/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mlentregas;

import BaseDeDatos.Conexion;
import java.sql.Connection;

/**
 *
 * @author MarmaduX
 */
public class MLEntregas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conexion = new Conexion().getConexion();
        int id = 4;
        if (id > 1 || id < 6) {
            System.err.println("hola");
        }
    }
}
