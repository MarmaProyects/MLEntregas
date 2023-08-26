/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author leo
 */
public class Conexion {
    
    
    
    private static Conexion instancia;
    private Connection connection;
    

    public Conexion() {
    }
    
   //JDBC
    
    public Connection getConexion() {
        if (connection == null) {
            String host = "localhost";
            String port = "3306";
            String db = "mlentregas";
            String user = "root";
            String password = "";
            try {
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, password);
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        return connection;
    }
    
    
}
