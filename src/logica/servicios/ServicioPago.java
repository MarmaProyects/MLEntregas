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
import java.util.logging.Logger;
/**
 *
 * @author leo
 */
public class ServicioPago {
    private Connection conexion = new Conexion().getConnection();

    public int createPago(int idTarifa, int idLocalidad) {
        int idPago = 0;
        float tarPrecio = 0, locPrecio = 0;
        try {
            PreparedStatement queryLocalidadTarifa = conexion.prepareStatement("SELECT l.precio AS LocPrecio, t.precioBase AS TarPrecio"
                    + " FROM localidad AS l, tarifa AS t WHERE l.id="+ idLocalidad + " AND t.id=" + idTarifa);
            ResultSet resultadoqueryLocalidadTarifa = queryLocalidadTarifa.executeQuery();
            while(resultadoqueryLocalidadTarifa.next()) {
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
            Logger.getLogger("Error en crear Direccion Destino" + e.getMessage());
        }
        return idPago;
    }
}
