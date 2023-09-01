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
import logica.clases.Direccion;
import logica.clases.Envio;
import logica.clases.Estado;
import logica.clases.Paquete;
import logica.clases.Tarifa;
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
                    estados.add(new Estado(reslistadoEstados.getString("comentario"),
                            TipoEstado.valueOf(reslistadoEstados.getString("tipo")),
                            reslistadoEstados.getTimestamp("fechaEstado"),
                            reslistadoEstados.getInt("id")));
                }
                cliente = new Cliente(resListadoEnvios.getInt("Cedula"), resListadoEnvios.getString("Nombre"), resListadoEnvios.getString("Apellido"), null);
                paquete = new Paquete(resListadoEnvios.getString("DescripcionPaquete"), 0, true, true, resListadoEnvios.getInt("IdPaquete"), null);
                listadoEnv.add(new Envio(resListadoEnvios.getInt("IdEnvio"), null, null, null, paquete, cliente, null, null, estados));
            }
        } catch (SQLException ex) {
            Logger.getLogger("Error en la consulta de obtener los usuarios");
        }
        return listadoEnv;
    }

    public Envio obtenerDetallesEnvio(int idEnvio) {
        Cliente clienteEmisor, clienteReceptor;
        Paquete paquete;
        Tarifa tarifa;
        Direccion direccionDestino, direccionOrigen;
        ArrayList<Estado> estados; 
        Envio envioDetalles = null;
        try {
            PreparedStatement listadoEnvios = conexion.prepareStatement("SELECT DISTINCT E.id as IdEnvio, T.nombre AS NombreTarifa, C.cedula AS CedulaClienteEmisor,"
                    + " C2.cedula AS CedulaClienteReceptor, C.nombre AS NombreEmisor,C.apellido AS ApellidoEmisor,"
                    + " C2.nombre AS NombreReceptor, C2.apellido AS ApellidoReceptor, P.id AS IdPaquete,"
                    + " P.descripcion AS DescripcionPaquete, D.calle AS CalleEmisor, D.calle2 AS Calle2Emisor,"
                    + " D.nroPuerta AS NroPuertaEmisor, D.apartamento AS ApartamentoEmisor, D2.calle AS CalleReceptor,"
                    + " D2.calle2 AS Calle2Receptor, D2.nroPuerta AS NroPuertaReceptor, D2.apartamento AS ApartamentoReceptor"
                    + " FROM envio AS E, envio_cliente AS EC, envio_cliente AS EC2, cliente AS C, cliente AS C2, paquete AS P,"
                    + " tarifa AS T, direccion AS D, direccion AS D2 WHERE EC.idEnvio = E.id AND EC2.idEnvio = E.id AND"
                    + " EC.cedulaCliente = C.cedula AND EC2.cedulaCliente = C2.cedula AND EC.tipoEntrega = \"Envio\" AND"
                    + " EC2.tipoEntrega = \"Recibe\" AND P.id = E.idPaquete AND C.cedula != C2.cedula AND D.id != D2.id AND"
                    + " E.idDireccionOrigen = D.id AND E.idDireccionDestino = D2.id AND T.id = E.idTarifa AND E.id = " + idEnvio + ";");
            ResultSet resListadoEnvios = listadoEnvios.executeQuery();
            while (resListadoEnvios.next()) {
                estados = new ArrayList<Estado>();
                PreparedStatement listadoEstados = conexion.prepareStatement("SELECT E.* "
                        + " FROM estado AS E, envio_estado AS EE "
                        + " WHERE E.id = EE.idEstado AND EE.idEnvio =" + resListadoEnvios.getInt("IdEnvio"));
                ResultSet reslistadoEstados = listadoEstados.executeQuery();
                while (reslistadoEstados.next()) {
                    estados.add(new Estado(reslistadoEstados.getString("comentario"),
                            TipoEstado.valueOf(reslistadoEstados.getString("tipo")),
                            reslistadoEstados.getTimestamp("fechaEstado"),
                            reslistadoEstados.getInt("id")));
                }
                direccionDestino = new Direccion(resListadoEnvios.getString("CalleReceptor"), resListadoEnvios.getString("Calle2Receptor"), resListadoEnvios.getString("ApartamentoReceptor"), resListadoEnvios.getInt("NroPuertaReceptor"), 0, null, 0);
                direccionOrigen = new Direccion(resListadoEnvios.getString("CalleEmisor"), resListadoEnvios.getString("Calle2Emisor"), resListadoEnvios.getString("ApartamentoEmisor"), resListadoEnvios.getInt("NroPuertaEmisor"), 0, null, 0);
                clienteEmisor = new Cliente(resListadoEnvios.getInt("CedulaClienteEmisor"), resListadoEnvios.getString("NombreEmisor"), resListadoEnvios.getString("ApellidoEmisor"), null);
                clienteReceptor = new Cliente(resListadoEnvios.getInt("CedulaClienteReceptor"), resListadoEnvios.getString("NombreReceptor"), resListadoEnvios.getString("ApellidoReceptor"), null);
                paquete = new Paquete(resListadoEnvios.getString("DescripcionPaquete"), 0, true, true, resListadoEnvios.getInt("IdPaquete"), null);
                tarifa = new Tarifa(70, resListadoEnvios.getString("NombreTarifa"), 1);
                envioDetalles = new Envio(idEnvio, direccionDestino, direccionOrigen, tarifa, paquete, clienteEmisor, clienteReceptor, null, estados);
            }
        } catch (SQLException ex) {
            Logger.getLogger("Error en la consulta de obtener los usuarios");
        }
        return envioDetalles;
    }

    public ArrayList<Envio> obtenerEnvios() {
        ArrayList<Envio> resultado = new ArrayList<Envio>();
        try {

            PreparedStatement query = conexion.prepareStatement("SELECT * FROM Envio");
            ResultSet resultadoDeLaQuery = query.executeQuery();
            while (resultadoDeLaQuery.next()) {
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
