/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import BaseDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author leo
 */
public class servicioLocalidad {

    private Connection conexion = new Conexion().getConexion();

    public void insertarLocalidad(String nombreLocalidad, int codigoPostal) {
        int id = 1;
        try {
            PreparedStatement query = conexion.prepareStatement("INSERT INTO `localidad` (`id`, `nombre`, `codigoPostal`) VALUES ('" + id + "','" + nombreLocalidad + "','" + codigoPostal + "');");
            query.executeUpdate();
            System.out.println("hacido");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

}
