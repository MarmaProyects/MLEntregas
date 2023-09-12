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
import java.util.ArrayList;
import java.util.logging.Logger;
import logica.clases.Direccion;

/**
 *
 * @author leo
 */
public class ServicioDireccion {

    private Connection conexion = new Conexion().getConnection();
    private static final Logger LOGGER = Logger.getLogger(ServicioEnvio.class.getName());

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
            LOGGER.severe("Error: " + e);
        }
    }

    public Direccion traerDireccionPorId(int idDireccion) {
        Direccion direccionRes = null;
        try {
            PreparedStatement queryTraerDireccion = conexion.prepareStatement("SELECT * FROM direccion WHERE id = " + idDireccion);
            ResultSet direccionResultSet = queryTraerDireccion.executeQuery();
            if (direccionResultSet.next()) {
                direccionRes = new Direccion(direccionResultSet.getString("calle"), direccionResultSet.getString("calle2"),
                        direccionResultSet.getString("apartamento"), direccionResultSet.getInt("nroPuerta"), idDireccion, " ", 0);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return direccionRes;
    }
    
    public ArrayList<Direccion> traerLasDirecciones() {
        ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
        try {
            PreparedStatement queryTraerDireccion = conexion.prepareStatement("SELECT direccion.id, direccion.calle, direccion.calle2,"
                    + " direccion.nroPuerta, direccion.apartamento, localidad.nombre "
                    + "FROM direccion, localidad, localidad_direccion WHERE localidad.id = localidad_direccion.idLocalidad"
                    + " AND direccion.id = localidad_direccion.idDireccion");
            ResultSet direccionResultSet = queryTraerDireccion.executeQuery();
            while (direccionResultSet.next()) {
                direcciones.add(new Direccion(direccionResultSet.getString("calle"), direccionResultSet.getString("calle2"),
                        direccionResultSet.getString("apartamento"), direccionResultSet.getInt("nroPuerta"),
                        direccionResultSet.getInt("id"), direccionResultSet.getString("nombre"), 0)); 
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return direcciones;
    }

}
