/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author leo
 */
public class Conexion {

    private static final String PROPERTIES_FILE = "database.properties";
    private static Conexion instancia;
    private Connection connection;
    private Properties properties;

    public Conexion() {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream(PROPERTIES_FILE);
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        if (connection == null) {
            try {
                connection = (Connection) DriverManager.getConnection(getUrl(), getUser(), getPassword());
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        return connection;
    }

    public String getUrl() {
        return properties.getProperty("db.url");
    }

    public String getUser() {
        return properties.getProperty("db.user");
    }

    public String getPassword() {
        return properties.getProperty("db.password");
    }
    
}
