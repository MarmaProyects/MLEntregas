/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mlentregas;

import BaseDeDatos.Conexion;
import Presentacion.CrearCliente;
import Presentacion.FormCrearLocalidad;
import Presentacion.CrearSeccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.fabrica.Fabrica;
import logica.interfaces.IProximidad;

/**
 *
 * @author MarmaduX
 */
public class MLEntregas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conexion = new Conexion().getConexion();
    }

}
