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
import logica.clases.Cliente;

/**
 *
 * @author leo
 */
public class ServicioCliente {
    private Connection conexion = new Conexion().getConexion();
    
     public void insertarCliente(int cedula, String nombre, String apellido ,int telefono) {
        try {
            PreparedStatement query = conexion.prepareStatement("INSERT INTO `cliente` (`cedula`,`nombre`, `apellido`,`telefono`) VALUES ('" + cedula + "','" + nombre + "', '" + apellido + "', '" + telefono + "');");
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public ArrayList<Cliente> obtenerCliente(){
         ArrayList<Cliente> resultado = new ArrayList<Cliente>();
        try {
                
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM Cliente");
            ResultSet resultadoDeLaQuery = query.executeQuery();
            while(resultadoDeLaQuery.next()) {
                int ci = resultadoDeLaQuery.getInt("cedula");
                String nombre = resultadoDeLaQuery.getString("nombre");
                String apellido = resultadoDeLaQuery.getString("apellido");
                int telefono = resultadoDeLaQuery.getInt("telefono");
                resultado.add(new Cliente(ci, nombre, apellido, Integer.toString(telefono)));
            }
                } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        
        return resultado;
    }
}
