/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Autenticacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Angelo
 */
public class AutenticacionU {

    private static final String PROPERTIES_FILE = "database.properties";
    private Properties properties;

    public AutenticacionU() {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream(PROPERTIES_FILE);
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean verificarAutenticacionUsuario(int code) {
        int codigoAsignado = -1;
        try {
            FileInputStream input = new FileInputStream(PROPERTIES_FILE);
            properties.load(input);
            input.close();
            if (properties.getProperty("codigo") != null) {
                codigoAsignado = Integer.parseInt(properties.getProperty("codigo"));
            }
            return (code == codigoAsignado);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getCodigo() {
        return properties.getProperty("codigo");
    }

    public void setCodigo(String codigo) {
        properties.setProperty("codigo", codigo);
        try (OutputStream outputStream = new FileOutputStream("database.properties")) {
            properties.store(outputStream, "Codigo Guardado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
