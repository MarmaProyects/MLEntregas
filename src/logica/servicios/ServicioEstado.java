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
import logica.clases.Estado;
import logica.dataTypes.TipoEstado;
import logica.fabrica.Fabrica;
import logica.interfaces.IEnvio;
import java.util.logging.Logger;

/**
 *
 * @author leo
 */
public class ServicioEstado {
    private IEnvio IE;
    private Connection conexion = new Conexion().getConnection();
    private static final Logger LOGGER = Logger.getLogger(ServicioEnvio.class.getName());
    
    public Estado obtenerEstado(int idEstado, int idEnvio){
        Estado estado = null;
        IE = Fabrica.getInstancia().getControladorEstado();
         ArrayList<Estado> resultado = new ArrayList<Estado>();
        try {  
            PreparedStatement listadoEstados = conexion.prepareStatement("SELECT E.id, E.comentario, E.fechaEstado, E.tipo  "
                    + "FROM estado AS E, envio AS ENV, envio_estado AS E_E "
                    + "WHERE E.id = E_E.idEstado AND E_E.idEnvio = ENV.id AND E.id = " + idEstado +" AND ENV.id = "+ idEnvio +";");
            ResultSet reslistadoEstados = listadoEstados.executeQuery();
            while (reslistadoEstados.next()) {
                    estado = new Estado(reslistadoEstados.getString("comentario"),
                            TipoEstado.valueOf(reslistadoEstados.getString("tipo")),
                            reslistadoEstados.getTimestamp("fechaEstado"),
                            reslistadoEstados.getInt("id"));
                }
                } catch (SQLException e) {
                LOGGER.severe("Error: " + e);
            }
        
        return estado;
    }
}


