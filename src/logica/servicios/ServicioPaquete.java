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
import logica.clases.Paquete;
import logica.clases.Seccion;
import logica.fabrica.Fabrica;
import logica.interfaces.IProximidad;

/**
 *
 * @author leo
 */
public class ServicioPaquete {
    private Connection conexion = new Conexion().getConexion();
    
    
    public ArrayList<Paquete> obtenerPaquetes(){
         ArrayList<Paquete> resultado = new ArrayList<Paquete>();
        try {
                
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM paquete");
            ResultSet resultadoDeLaQuery = query.executeQuery();
            while(resultadoDeLaQuery.next()) {
                int id = resultadoDeLaQuery.getInt("id");
                String descripcion = resultadoDeLaQuery.getString("descripcion");
                float peso = resultadoDeLaQuery.getFloat("peso");
                Boolean esFragil = resultadoDeLaQuery.getBoolean("esFragil");
                Boolean esEspecial = resultadoDeLaQuery.getBoolean("esEspecial");
                //obtenerSeccion dos consultas, consulta en seccion_paquete para obtener idSeccion, y luego obtener el nombre con la segunda consulta
                ServicioSeccion ServicioSeccion = new ServicioSeccion();
                int idSeccion = ServicioSeccion.obtenerIdSeccion_Paquete(id);
                IProximidad IP = Fabrica.getInstancia().getControladorSeccion();
                Seccion nombreSeccion = IP.buscarSeccion(idSeccion);
               // resultado.add(new Paquete(id, descripcion, peso, esFragil, esEspecial, nombreSeccion.getNombre()));
            }
                } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        
        return resultado;
    }
}
