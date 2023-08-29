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
import logica.clases.Localidad;
import logica.clases.Seccion;
import logica.fabrica.Fabrica;
import logica.interfaces.IProximidad;

/**
 *
 * @author franc
 */
public class ServicioSeccion {

    private Connection conexion = new Conexion().getConexion();
    private IProximidad IPR;

    public ArrayList<Seccion> obtenerListaSeccion() {
        ArrayList<Seccion> resultado = new ArrayList<Seccion>();
        try {
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM seccion");
            ResultSet resultadoDeLaQuery = query.executeQuery();
            while (resultadoDeLaQuery.next()) {
                String nombre = resultadoDeLaQuery.getString("nombre");
                int cantidad = Integer.parseInt(resultadoDeLaQuery.getString("cantidad"));
                resultado.add(new Seccion(nombre, cantidad));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }

    public void agregarSeccion(String nombre, String localidad) {

        this.IPR = Fabrica.getInstancia().getControladorLocalidad();
        if (localidad.equals(" ")) {
            try {
                PreparedStatement query = conexion.prepareStatement("INSERT INTO `seccion` (`nombre`, `cantidad`) VALUES ('" + nombre + "','0');");
                query.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        } else {
            ArrayList<Localidad> localidades = this.IPR.obtenerLocalidades();
            int idLocalidad = 0;
            for (Localidad loc : localidades) {
                if (loc.getZona().equals(localidad)) {
                    idLocalidad = loc.getIdLocalidad();
                    break;
                }
            }
            try {
                PreparedStatement query = conexion.prepareStatement("INSERT INTO `seccion` (`idLocalidad`,`nombre`, `cantidad`) VALUES ('" + idLocalidad + "','" + nombre + "','0');");
                query.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
