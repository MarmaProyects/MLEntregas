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
import java.util.logging.Logger;
import logica.clases.Tarifa;

/**
 *
 * @author MarmaduX
 */
public class ServicioTarifa {
    private Connection conexion = new Conexion().getConexion();

    public void crearTarifa(String nombre, float precioBase) {
        try {
            PreparedStatement query = conexion.prepareStatement("INSERT INTO `tarifa` (`nombre`, `precioBase`) VALUES ('" + nombre + "','" + precioBase + "');");
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public ArrayList<Tarifa> listarTarifas() {
        String nombre;
        float precioBase;
        int id;
        ArrayList resultado = new ArrayList();
        try {
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM tarifa");
            ResultSet resQuery = query.executeQuery();
            while(resQuery.next()){
                nombre = resQuery.getString("nombre");
                precioBase = resQuery.getFloat("precioBase");
                id = resQuery.getInt("id");
                resultado.add(new Tarifa(precioBase, nombre, id));
            }
        } catch (SQLException ex) {
            Logger.getLogger("Error en la consulta de obtener los usuarios");
        }
        return resultado;
    }
}
