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
import logica.clases.Cliente;
import logica.clases.Envio;
import logica.clases.Estado;
import logica.clases.Paquete;
import logica.dataTypes.TipoEstado;

/**
 *
 * @author MarmaduX
 */
public class ServicioEnvio {
    private Connection conexion = new Conexion().getConexion();
    
    public ArrayList<Envio> listarEnvios() {
        Cliente cliente;
        Paquete paquete;
        ArrayList<Estado> estados;
        ArrayList<Envio> listadoEnv = new ArrayList<Envio>();
        try {
            PreparedStatement listadoEnvios = conexion.prepareStatement("SELECT E.id as IdEnvio, C.cedula AS Cedula,"
                    + " C.nombre AS Nombre, C.apellido AS Apellido, P.id AS IdPaquete, P.descripcion AS DescripcionPaquete"
                    + " FROM envio AS E, envio_cliente AS EC, cliente AS C, paquete AS P "
                    + " WHERE EC.idEnvio = E.id AND EC.cedulaCliente = C.cedula AND EC.tipoEntrega = 'Envio' AND P.id = E.idPaquete");
            ResultSet resListadoEnvios = listadoEnvios.executeQuery();
            while (resListadoEnvios.next()) {
                estados = new ArrayList<Estado>();
                PreparedStatement listadoEstados = conexion.prepareStatement("SELECT E.* "
                        + " FROM estado AS E, envio_estado AS EE "
                        + " WHERE E.id = EE.idEstado AND EE.idEnvio =" + resListadoEnvios.getInt("IdEnvio"));
                ResultSet reslistadoEstados = listadoEstados.executeQuery();
                while (reslistadoEstados.next()) {
                    estados.add( new Estado(reslistadoEstados.getString("comentario"), 
                            TipoEstado.valueOf(reslistadoEstados.getString("tipo")), 
                            reslistadoEstados.getTimestamp("fechaEstado"),
                            reslistadoEstados.getInt("id")));
                }
                cliente = new Cliente(resListadoEnvios.getInt("Cedula"), resListadoEnvios.getString("Nombre"), resListadoEnvios.getString("Apellido"), null);
                paquete = new Paquete(resListadoEnvios.getString("DescripcionPaquete"), 0, true, true, resListadoEnvios.getInt("IdPaquete"), null);
                listadoEnv.add(new Envio(resListadoEnvios.getInt("IdEnvio"), null, null, null, paquete, cliente, null, estados));
            }
        } catch (SQLException ex) {
            Logger.getLogger("Error en la consulta de obtener los usuarios");
        }
        return listadoEnv;
    }
    
    public ArrayList<Envio> obtenerEnvios(){
         ArrayList<Envio> resultado = new ArrayList<Envio>();
        try {
                
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM Envio");
            ResultSet resultadoDeLaQuery = query.executeQuery();
            while(resultadoDeLaQuery.next()) {
                int idEnvio = resultadoDeLaQuery.getInt("id");
                int idPaquete = resultadoDeLaQuery.getInt("idPaquete");
                int idTarifa = resultadoDeLaQuery.getInt("idTarifa");
                int idDireccionOrigen = resultadoDeLaQuery.getInt("idDireccionOrigen");
                int idDireccionDestino = resultadoDeLaQuery.getInt("idDireccionDestino");
                int idPago = resultadoDeLaQuery.getInt("idPago");
                
              //  resultado.add(new Object(int idEnvio, ));
            }
                } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        
        return resultado;
    }
    
}

    
