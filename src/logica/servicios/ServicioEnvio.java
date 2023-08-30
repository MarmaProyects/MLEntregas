/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import BaseDeDatos.Conexion;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author franc
 */
public class ServicioEnvio {
    private Connection conexion = new Conexion().getConexion();
    
    public void facturarEnvio(float precio, String metodoPago) {
        int idEnvio = 0;
        try {
            int idGenerado = 0;
            PreparedStatement query = conexion.prepareStatement("INSERT INTO `pago` (`precio`, `metodoPago`, `fechaPago`) VALUES ("
                    + "" + precio + ",'" + metodoPago + "', CURRENT_TIMESTAMP());", PreparedStatement.RETURN_GENERATED_KEYS);
            query.executeUpdate();
            ResultSet generatedKeys = query.getGeneratedKeys();
            if (generatedKeys.next()) {
                idGenerado = generatedKeys.getInt(1);
            }            
            PreparedStatement queryEnvioPago = conexion.prepareStatement("UPDATE envio SET ´idPago´ ="
                    + "" + idGenerado + "WHERE `id` =" + idEnvio + ");");
            queryEnvioPago.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger("Error");
        }
    }
}
