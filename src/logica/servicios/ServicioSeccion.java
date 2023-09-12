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
import java.util.ArrayList;
import logica.clases.Localidad;
import logica.clases.Seccion;
import logica.fabrica.Fabrica;
import logica.interfaces.IProximidad;

/**
 *
 * @author franc
 */
public class ServicioSeccion {

    private Connection conexion = new Conexion().getConnection();
    private IProximidad IPR;
    private static final Logger LOGGER = Logger.getLogger(ServicioEnvio.class.getName());

    public ArrayList<Seccion> obtenerListaSeccion() {
        ArrayList<Seccion> resultado = new ArrayList<Seccion>();
        try {
            PreparedStatement query = conexion.prepareStatement("SELECT id, nombre, cantidad, COALESCE(idLocalidad, '-1') AS idLocalidad FROM seccion");
            ResultSet resultadoDeLaQuery = query.executeQuery();
            while (resultadoDeLaQuery.next()) {
                String nombre = resultadoDeLaQuery.getString("nombre");
                int cantidad = Integer.parseInt(resultadoDeLaQuery.getString("cantidad"));
                int id = resultadoDeLaQuery.getInt("id");
                int idLocalidad = resultadoDeLaQuery.getInt("idLocalidad");
                resultado.add(new Seccion(nombre, cantidad, id, idLocalidad));
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return resultado;
    }

    public void agregarUnaSeccion(String nombre, String localidad) {

        this.IPR = Fabrica.getInstancia().getControladorLocalidad();
        if (localidad.equals(" ")) {
            try {
                PreparedStatement query = conexion.prepareStatement("INSERT INTO `seccion` (`nombre`, `cantidad`) VALUES ('" + nombre + "','0');");
                query.executeUpdate();
            } catch (SQLException e) {
                LOGGER.severe("Error: " + e);
            }
        } else {
            ArrayList<Localidad> localidades = this.IPR.obtenerLasLocalidades();
            int idLocalidad = 0;
            for (Localidad loc : localidades) {
                if (loc.getNombre().equals(localidad)) {
                    idLocalidad = loc.getIdLocalidad();
                    break;
                }
            }
            try {
                PreparedStatement query = conexion.prepareStatement("INSERT INTO `seccion` (`idLocalidad`,`nombre`, `cantidad`) VALUES ('" + idLocalidad + "','" + nombre + "','0');");
                query.executeUpdate();
            } catch (SQLException e) {
                LOGGER.severe("Error: " + e);
            }
        }
    }

    public boolean eliminarUnaSeccion(int id) {
        boolean seccion_paquete = false;
        try {
            PreparedStatement querySeccion_paquete = conexion.prepareStatement("SELECT * FROM `seccion_paquete` WHERE idSeccion = " + id);
            ResultSet resultado_seccion_paquete = querySeccion_paquete.executeQuery();
            if (resultado_seccion_paquete.next()) {
                seccion_paquete = true;
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }

        if (!seccion_paquete) {
            try {
                PreparedStatement query = conexion.prepareStatement("DELETE FROM `seccion` WHERE id = " + id);
                int rowsAffected = query.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                LOGGER.severe("Error: " + e);
                return false;
            }
        } else {
            return false;
        }
    }

    public Seccion traerSeccion(int idSeccion) {
        Seccion seccion = null;
        try {
            PreparedStatement queryTraer = conexion.prepareStatement("SELECT * FROM `seccion` WHERE id = " + idSeccion);
            ResultSet seccionExtraida = queryTraer.executeQuery();
            if (seccionExtraida.next()) {
                String nombre = seccionExtraida.getString("nombre");
                int idLocalidad = seccionExtraida.getInt("idLocalidad");
                int cantidad = seccionExtraida.getInt("cantidad");
                seccion = new Seccion(nombre, cantidad, idSeccion, idLocalidad);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return seccion;
    }

    public boolean editarSeccion(int idSeccion, String nombre, int idLocalidad) {
        if (idLocalidad == 0) {
            try {
                PreparedStatement query = conexion.prepareStatement("UPDATE `seccion` SET `nombre` = '" + nombre + "',`idLocalidad`= null" + " WHERE `id` = '" + idSeccion + "'");
                int rowsAffected = query.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                LOGGER.severe("Error: " + e);
                return false;
            }
        } else {
            try {
                PreparedStatement query = conexion.prepareStatement("UPDATE `seccion` SET `nombre` = '" + nombre + "',`idLocalidad`='" + idLocalidad + "' WHERE `id` = '" + idSeccion + "'");
                int rowsAffected = query.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                LOGGER.severe("Error: " + e);
                return false;
            }
        }

    }

    public ArrayList<Seccion> obtenerLasSecciones() {
        ArrayList<Seccion> resultado = new ArrayList<Seccion>();
        try {

            PreparedStatement query = conexion.prepareStatement("SELECT * FROM seccion");
            ResultSet resultadoDeLaQuery = query.executeQuery();
            while (resultadoDeLaQuery.next()) {
                int id = resultadoDeLaQuery.getInt("id");
                int idLocalidad = resultadoDeLaQuery.getInt("idLocalidad");
                String nombre = resultadoDeLaQuery.getString("nombre");
                int cantidad = resultadoDeLaQuery.getInt("cantidad");
                resultado.add(new Seccion(nombre, cantidad, id, null));
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }

        return resultado;
    }

    public int obtenerIdSeccion_Paquete(int idPaquete) {
        int resultado = 0;
        try {
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM seccion_paquete WHERE seccion_paquete.idPaquete = " + idPaquete);
            ResultSet resultadoDeLaQuery = query.executeQuery();
            while (resultadoDeLaQuery.next()) {
                if (idPaquete == resultadoDeLaQuery.getInt("idPaquete")) {
                    resultado = resultadoDeLaQuery.getInt("idSeccion");
                    break;
                }
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return resultado;
    }
}
