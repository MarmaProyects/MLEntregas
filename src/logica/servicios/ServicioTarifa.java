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
    
    public Tarifa traerTarifa(int idTarifa) {
        Tarifa tarifa = null;
        try {
            System.err.println(idTarifa);
            PreparedStatement queryTraer = conexion.prepareStatement("SELECT *  FROM `tarifa` WHERE id = " + idTarifa);
            ResultSet tarifaExtraida = queryTraer.executeQuery();
            if(tarifaExtraida.next()){
                String nombre = tarifaExtraida.getString("nombre");
                System.err.println(nombre);
                float precioBase = tarifaExtraida.getFloat("precioBase");
                int id = tarifaExtraida.getInt("id");
                tarifa = new Tarifa(precioBase, nombre, id);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return tarifa;
    }
    
    public boolean editarTarifa(int idTarifa, String nombre, float precio) {
        try {
            PreparedStatement query = conexion.prepareStatement("UPDATE `tarifa` SET `nombre`='" + nombre + "',`precioBase`= " + precio + " WHERE id = " + idTarifa);
            int rowsAffected = query.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public boolean eliminarTarifa(int idTarifa) {
        try {
            PreparedStatement query = conexion.prepareStatement("DELETE FROM `tarifa` WHERE id = " + idTarifa);
            int rowsAffected = query.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public ArrayList<Tarifa> listarTarifas() {
        String nombre;
        float precioBase;
        int id;
        ArrayList<Tarifa> resultado = new ArrayList<Tarifa>();
        try {
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM tarifa");
            ResultSet resQuery = query.executeQuery();
            while (resQuery.next()) {
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
