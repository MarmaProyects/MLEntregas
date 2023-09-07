/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import BaseDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Logger;
import logica.clases.Direccion;

/**
 *
 * @author leo
 */
public class ServicioDireccion {
    
    private Connection conexion = new Conexion().getConnection();
    
    public void editarUnaDireccion(int idDireccion, String calle1, String calle2, int nroPuerta, String apartamento) {
        try {
            PreparedStatement queryEditarDireccion = conexion.prepareStatement("UPDATE direccion SET calle = ?, calle2 = ?, nroPuerta = ?, apartamento = ? "
                    + "WHERE id = " + idDireccion);
            queryEditarDireccion.setString(1, calle1);
            queryEditarDireccion.setString(2, calle2);
            queryEditarDireccion.setInt(3, nroPuerta);
            queryEditarDireccion.setString(4, apartamento);
            queryEditarDireccion.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error " + e);
            Logger.getLogger("Error: " + e);
        }
    }
    
    public Direccion traerDireccionPorId(int idDireccion) {
        Direccion direccionRes = null;
        try {
            PreparedStatement queryTraerDireccion = conexion.prepareStatement("SELECT * FROM direccion WHERE id = " + idDireccion);
            ResultSet direccionResultSet = queryTraerDireccion.executeQuery();
            if (direccionResultSet.next()) {
                direccionRes = new Direccion( direccionResultSet.getString("calle"), direccionResultSet.getString("calle2"), 
                        direccionResultSet.getString("apartamento"), direccionResultSet.getInt("nroPuerta"), idDireccion, " ", 0);
            }
        } catch (Exception e) {

            Logger.getLogger("Error al traer dirección por id" + e);
        }
        return direccionRes;
    }

}
