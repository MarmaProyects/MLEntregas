/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Autenticacion;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author Angelo
 */
public class AutenticacionU {

    private static final String PROPERTIES_FILE = "database.properties";
    private Properties properties;

    public boolean verificarAutenticacionUsuario(int code) {
        properties = new Properties();
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

    public void setCodigo(String codigo) {
        properties.setProperty("codigo", codigo);
    }

}
