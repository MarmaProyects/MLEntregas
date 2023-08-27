/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mlentregas;

import BaseDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.fabrica.Fabrica;
import logica.interfaces.IProximidad;

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
        ArrayList resultado = new ArrayList();
        
        try {
                
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM cliente");
            ResultSet resultadoDeLaQuery = query.executeQuery();
            while(resultadoDeLaQuery.next()) {
                String nombre = resultadoDeLaQuery.getString("nombre");
                String apellido = resultadoDeLaQuery.getString("apellido");
                System.out.println(nombre);
                System.out.println(apellido);
                
            }
            
            
                } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
    }
    
}
