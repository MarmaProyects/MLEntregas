/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import BaseDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.clases.Localidad;
import java.util.logging.Logger;

/**
 *
 * @author leo
 */
public class ServicioLocalidad {

    private Connection conexion = new Conexion().getConnection();
    private static final Logger LOGGER = Logger.getLogger(ServicioEnvio.class.getName());

    public void insertarLocalidad(String nombreLocalidad, int codigoPostal) {
        try {
            PreparedStatement query = conexion.prepareStatement("INSERT INTO `localidad` (`nombre`, `codigoPostal`) VALUES ('" + nombreLocalidad + "','" + codigoPostal + "');");
            query.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }
    
    public void editarLocalidad(int IdLocalidad, String nombreLocalidad, int CodigoPostal){
        try {
            PreparedStatement query = conexion.prepareStatement("UPDATE `localidad` SET `nombre` = '" + nombreLocalidad + "', `codigoPostal` = '" + CodigoPostal + "' WHERE `localidad`.`id` = " + IdLocalidad + ";");
            query.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }
    
    public ArrayList<Localidad> obtenerLasLocalidades(){
         ArrayList<Localidad> resultado = new ArrayList<Localidad>();
        try {
                
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM localidad");
            ResultSet resultadoDeLaQuery = query.executeQuery();
            while(resultadoDeLaQuery.next()) {
                int id = resultadoDeLaQuery.getInt("id");
                String nombre = resultadoDeLaQuery.getString("nombre");
                int codigoPostal = resultadoDeLaQuery.getInt("codigoPostal");
                resultado.add(new Localidad(nombre, codigoPostal, id));
            }
                } catch (SQLException e) {
                LOGGER.severe("Error: " + e);
            }
        
        return resultado;
    }
    
    public Localidad obtenerLocalidad(String nombreLocalidad){
         Localidad resultado = null;
        try {
                
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM localidad WHERE localidad.nombre = '" + nombreLocalidad + "';");
            ResultSet resultadoDeLaQuery = query.executeQuery();
            if(resultadoDeLaQuery.next()) {
                int id = resultadoDeLaQuery.getInt("id");
                String nombre = resultadoDeLaQuery.getString("nombre");
                int codigoPostal = resultadoDeLaQuery.getInt("codigoPostal");
                resultado = new Localidad(nombre, codigoPostal, id);
            }
                } catch (SQLException e) {
                LOGGER.severe("Error: " + e);
            }
        
        return resultado;
    }
    

}
