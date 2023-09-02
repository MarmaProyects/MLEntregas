/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Autenticacion;

import BaseDeDatos.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Angelo
 */
public class AutenticacionU {

    private static final String PROPERTIES_FILE = "database.properties";
    private static Conexion instancia;
    private Connection connection;
    private Properties properties;

    public boolean verificarAutenticacionUsuario(int code) {
        properties = new Properties();
        int codigoAsignado = 0;
        try {
            FileInputStream input = new FileInputStream(PROPERTIES_FILE);
            properties.load(input);
            input.close();
            //properties.setProperty("codigo", "12");
            //properties.store(new FileWriter("database.properties"), "Datos Actualizados!");
            //System.err.println(properties.getProperty("codigo"));
            codigoAsignado = Integer.parseInt(properties.getProperty("codigo"));
            System.out.println("codigo ingresado " + code);
            System.out.println("codigo correcto " + codigoAsignado);
            if (code == codigoAsignado) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void setCodigo(String codigo) {
        properties.setProperty("codigo", codigo);
    }

}
