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
import logica.clases.Pago;
import logica.dataTypes.MetodoPago;

/**
 *
 * @author leo
 */
public class ServicioPago {

    private Connection conexion = new Conexion().getConnection();
    private static final Logger LOGGER = Logger.getLogger(ServicioEnvio.class.getName());

    public int createPago(int idTarifa, int idLocalidad) {
        int idPago = 0;
        float tarPrecio = 0, locPrecio = 0;
        try {
            PreparedStatement queryLocalidadTarifa = conexion.prepareStatement("SELECT l.precio AS LocPrecio, t.precioBase AS TarPrecio"
                    + " FROM localidad AS l, tarifa AS t WHERE l.id=" + idLocalidad + " AND t.id=" + idTarifa);
            ResultSet resultadoqueryLocalidadTarifa = queryLocalidadTarifa.executeQuery();
            while (resultadoqueryLocalidadTarifa.next()) {
                locPrecio = resultadoqueryLocalidadTarifa.getFloat("LocPrecio");
                tarPrecio = resultadoqueryLocalidadTarifa.getFloat("TarPrecio");
            }

            PreparedStatement queryCrearPago = conexion.prepareStatement(""
                    + "INSERT INTO pago (precio) "
                    + "VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            queryCrearPago.setFloat(1, locPrecio + tarPrecio);
            queryCrearPago.executeUpdate();
            ResultSet idP = queryCrearPago.getGeneratedKeys();
            if (idP.next()) {
                idPago = idP.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return idPago;
    }
    
    public void pagarUnEnvio(int idPago, String metodo) {
        try {
            PreparedStatement queryLocalidadTarifa = conexion.prepareStatement("UPDATE pago SET metodoPago = '"
                    + metodo + "', fechaPago = CURRENT_TIMESTAMP WHERE id = " + idPago);
            queryLocalidadTarifa.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }
    
    public ArrayList<Pago> traerLosPagosNoAsociados() {
        ArrayList<Pago> pagos = new ArrayList<Pago>();
        try {
            PreparedStatement queryTraerPago = conexion.prepareStatement("SELECT *" +
            "FROM pago " +
            "LEFT JOIN envio ON pago.id = envio.idPago " +
            "WHERE envio.idPago IS NULL;");
            ResultSet pagoResultSet = queryTraerPago.executeQuery();
            while (pagoResultSet.next()) {
                pagos.add(new Pago(pagoResultSet.getFloat("precio"), MetodoPago.valueOf(pagoResultSet.getString("metodoPago")), pagoResultSet.getTimestamp("fechaPago"), pagoResultSet.getInt("id"))); 
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return pagos;
    }

    public void editarUnPago(int idPago, float precio) {
        try {
            PreparedStatement queryEditarPago = conexion.prepareStatement("UPDATE pago SET precio = ? "
                    + "WHERE id = " + idPago);
            queryEditarPago.setFloat(1, precio);
            queryEditarPago.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }
}
