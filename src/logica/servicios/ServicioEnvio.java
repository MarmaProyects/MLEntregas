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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Logger;
import logica.clases.Cliente;
import logica.clases.Direccion;
import logica.clases.Envio;
import logica.clases.Estado;
import logica.clases.Localidad;
import logica.clases.Pago;
import logica.clases.Paquete;
import logica.clases.Seccion;
import logica.clases.Tarifa;
import logica.dataTypes.MetodoPago;
import logica.dataTypes.TipoEstado;

/**
 *
 * @author MarmaduX
 */
public class ServicioEnvio {

    private Connection conexion = new Conexion().getConnection();
    private Object queryTraerDireccionS;
    private static final Logger LOGGER = Logger.getLogger(ServicioEnvio.class.getName());

    public ArrayList<Envio> listarEnvios() {
        Cliente clienteE;
        Cliente clienteR;
        Paquete paquete;
        Direccion direccionD, direccionO;
        Pago pago;
        MetodoPago metodoPago = null;
        ArrayList<Estado> estados;
        ArrayList<Envio> listadoEnv = new ArrayList<Envio>();
        try {
            PreparedStatement listadoEnvios = conexion.prepareStatement("SELECT E.id as IdEnvio, E.codigoR AS codigoR, CE.cedula AS CedulaE, CR.cedula AS CedulaR,"
                    + " CE.nombre AS NombreE, CE.apellido AS ApellidoE, CE.correo AS CorreoE, P.id AS IdPaquete, P.descripcion AS DescripcionPaquete, "
                    + " CR.nombre AS NombreR, CR.apellido AS ApellidoR, CR.correo AS CorreoR,"
                    + "DIRO.calle AS calleOrigen, DIRO.calle2 AS segundaCalleO, DIRO.nroPuerta AS nroPuertaO, DIRD.calle AS calleDestino, "
                    + "PAG.fechaPago AS fechaPago, PAG.precio AS precio, PAG.metodoPago AS metodoPago, PAG.id AS idPago"
                    + " FROM envio AS E, envio_cliente AS EC, cliente AS CE, cliente AS CR, paquete AS P , direccion AS DIRO, direccion AS DIRD, pago AS PAG"
                    + " WHERE EC.idEnvio = E.id AND EC.cedulaCliente = CE.cedula AND EC.tipoEntrega = 'Envio' "
                    + "AND P.id = E.idPaquete AND E.idDireccionOrigen = DIRO.id AND E.idDireccionOrigen = DIRD.id AND E.id = PAG.id");
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
                clienteE = new Cliente(resListadoEnvios.getInt("CedulaE"), resListadoEnvios.getString("NombreE"), resListadoEnvios.getString("ApellidoE"), null, resListadoEnvios.getString("CorreoE"));
                clienteR = new Cliente(resListadoEnvios.getInt("CedulaR"), resListadoEnvios.getString("NombreR"), resListadoEnvios.getString("ApellidoR"), null, resListadoEnvios.getString("CorreoR"));
                paquete = new Paquete(resListadoEnvios.getString("DescripcionPaquete"), 0, true, true, resListadoEnvios.getInt("IdPaquete"), null);
                direccionO = new Direccion(resListadoEnvios.getString("calleOrigen"), resListadoEnvios.getString("segundaCalleO"), null, resListadoEnvios.getInt("nroPuertaO"), 0, null, 0);
                direccionD = new Direccion(resListadoEnvios.getString("calleDestino"), null, null, 0, 0, null, 0);
                metodoPago = resListadoEnvios.getString("metodoPago") != null ? MetodoPago.valueOf(resListadoEnvios.getString("metodoPago")) : null;
                pago = new Pago(resListadoEnvios.getFloat("precio"), metodoPago, resListadoEnvios.getTimestamp("fechaPago"), resListadoEnvios.getInt("idPago"));
                listadoEnv.add(new Envio(resListadoEnvios.getInt("IdEnvio"), direccionD, direccionO, null, paquete, clienteE, clienteR, pago, estados, resListadoEnvios.getInt("codigoR")));
            }
        } catch (SQLException ex) {
            LOGGER.severe("Error en la consulta de obtener los usuarios" + ex);

        }
        return listadoEnv;
    }

    public ArrayList<Envio> listarEnviosSinRepetir() {
        Cliente clienteEmisor, clienteReceptor;
        Paquete paquete;
        Tarifa tarifa;
        Pago pago;
        Direccion direccionDestino, direccionOrigen;
        ArrayList<Estado> estados;
        ArrayList<Envio> listadoEnv = new ArrayList<Envio>();
        try {
            PreparedStatement listadoEnvios = conexion.prepareStatement("SELECT DISTINCT E.id as IdEnvio, E.codigoR AS codigoR, PG.id AS IdPago, "
                    + "PG.metodoPago AS Pago, PG.precio AS precio, PG.fechaPago AS fechaPago,T.id AS IdTarifa, T.nombre AS NombreTarifa, T.precioBase AS PrecioTarifa,\n"
                    + "C.cedula AS CedulaClienteEmisor,\n"
                    + "C2.cedula AS CedulaClienteReceptor, C.nombre AS NombreEmisor,C.apellido AS ApellidoEmisor, C.correo as CorreoEmisor, \n"
                    + "C2.nombre AS NombreReceptor, C2.apellido AS ApellidoReceptor, C2.correo as CorreoReceptor, P.id AS IdPaquete, P.peso AS peso, P.esEspecial AS esEspecial, P.esFragil AS esFragil,\n"
                    + "P.descripcion AS DescripcionPaquete, D.id AS idDireccionEmisor, D.calle AS CalleEmisor, D.calle2 AS Calle2Emisor,\n"
                    + "D.nroPuerta AS NroPuertaEmisor, D.apartamento AS ApartamentoEmisor, D2.id AS idDireccionReceptor, D2.calle AS CalleReceptor,\n"
                    + "D2.calle2 AS Calle2Receptor, D2.nroPuerta AS NroPuertaReceptor, D2.apartamento AS ApartamentoReceptor\n"
                    + "FROM envio AS E, envio_cliente AS EC, envio_cliente AS EC2, cliente AS C, cliente AS C2, paquete AS P,\n"
                    + "tarifa AS T, direccion AS D, direccion AS D2, pago AS PG\n"
                    + "WHERE EC.idEnvio = E.id AND EC2.idEnvio = E.id AND\n"
                    + "EC.cedulaCliente = C.cedula AND EC2.cedulaCliente = C2.cedula AND EC.tipoEntrega = \"Envio\" AND\n"
                    + "EC2.tipoEntrega = \"Recibe\" AND P.id = E.idPaquete AND C.cedula != C2.cedula AND D.id != D2.id AND\n"
                    + "E.idDireccionOrigen = D.id AND E.idDireccionDestino = D2.id AND T.id = E.idTarifa AND PG.id = E.idPago");
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
                direccionDestino = new Direccion(resListadoEnvios.getString("CalleReceptor"), resListadoEnvios.getString("Calle2Receptor"),
                        resListadoEnvios.getString("ApartamentoReceptor"), resListadoEnvios.getInt("NroPuertaReceptor"), resListadoEnvios.getInt("idDireccionReceptor"), null, 0);

                direccionOrigen = new Direccion(resListadoEnvios.getString("CalleEmisor"), resListadoEnvios.getString("Calle2Emisor"),
                        resListadoEnvios.getString("ApartamentoEmisor"), resListadoEnvios.getInt("NroPuertaEmisor"), resListadoEnvios.getInt("idDireccionEmisor"), null, 0);

                clienteEmisor = new Cliente(resListadoEnvios.getInt("CedulaClienteEmisor"), resListadoEnvios.getString("NombreEmisor"), resListadoEnvios.getString("ApellidoEmisor"), null, resListadoEnvios.getString("correoEmisor"));
                clienteReceptor = new Cliente(resListadoEnvios.getInt("CedulaClienteReceptor"), resListadoEnvios.getString("NombreReceptor"), resListadoEnvios.getString("ApellidoReceptor"), null, resListadoEnvios.getString("correoReceptor"));

                paquete = new Paquete(resListadoEnvios.getString("DescripcionPaquete"), resListadoEnvios.getFloat("peso"), resListadoEnvios.getBoolean("esFragil"), resListadoEnvios.getBoolean("esEspecial"), resListadoEnvios.getInt("IdPaquete"), null);
                pago = new Pago(resListadoEnvios.getInt("precio"), resListadoEnvios.getString("Pago") != null
                        ? MetodoPago.valueOf(resListadoEnvios.getString("pago")) : null, resListadoEnvios.getString("fechaPago") != null
                        ? resListadoEnvios.getTimestamp("fechaPago") : null, resListadoEnvios.getInt("IdPago"));
                tarifa = new Tarifa(resListadoEnvios.getInt("PrecioTarifa"), resListadoEnvios.getString("NombreTarifa"), resListadoEnvios.getInt("IdTarifa"));
                listadoEnv.add(new Envio(resListadoEnvios.getInt("IdEnvio"), direccionDestino, direccionOrigen, null, paquete, clienteEmisor, clienteReceptor, pago, estados, resListadoEnvios.getInt("codigoR")));
            }
        } catch (SQLException ex) {
            LOGGER.severe("Error en la consulta de obtener los usuarios" + ex);

        }
        return listadoEnv;
    }

    public ArrayList<Envio> listarEnviosFecha(String fechaInicio, String fechaFinal) {
        Cliente cliente;
        Paquete paquete;
        Direccion direccionD, direccionO;
        Pago pago;
        ArrayList<Estado> estados;
        ArrayList<Envio> listadoEnv = new ArrayList<Envio>();

        try {
            PreparedStatement listadoEnvios = conexion.prepareStatement("SELECT E.id as IdEnvio, E.codigoR AS codigoR, C.cedula AS Cedula,"
                    + " C.nombre AS Nombre, C.apellido AS Apellido, C.correo AS Correo, P.id AS IdPaquete, P.descripcion AS DescripcionPaquete, "
                    + "DIRO.calle AS calleOrigen, DIRD.calle AS calleDestino, PAG.fechaPago AS fechaPago, PAG.precio AS precio, PAG.metodoPago AS metodoPago, PAG.id AS idPago"
                    + " FROM envio AS E, envio_cliente AS EC, cliente AS C, paquete AS P , direccion AS DIRO, direccion AS DIRD, pago AS PAG"
                    + " WHERE EC.idEnvio = E.id AND EC.cedulaCliente = C.cedula AND EC.tipoEntrega = 'Envio' "
                    + "AND P.id = E.idPaquete AND E.idDireccionOrigen = DIRO.id AND"
                    + " E.idDireccionOrigen = DIRD.id AND E.id = PAG.id AND"
                    + " PAG.fechaPago >= '" + fechaInicio + " 00:00:00' AND PAG.fechaPago <= '" + fechaFinal + " 23:59:59';");
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
                cliente = new Cliente(resListadoEnvios.getInt("Cedula"), resListadoEnvios.getString("Nombre"), resListadoEnvios.getString("Apellido"), null, resListadoEnvios.getString("Correo"));
                paquete = new Paquete(resListadoEnvios.getString("DescripcionPaquete"), 0, true, true, resListadoEnvios.getInt("IdPaquete"), null);
                direccionO = new Direccion(resListadoEnvios.getString("calleOrigen"), null, null, 0, 0, null, 0);
                direccionD = new Direccion(resListadoEnvios.getString("calleDestino"), null, null, 0, 0, null, 0);
                pago = new Pago(resListadoEnvios.getFloat("precio"), MetodoPago.valueOf(resListadoEnvios.getString("metodoPago")), resListadoEnvios.getTimestamp("fechaPago"), resListadoEnvios.getInt("idPago"));
                listadoEnv.add(new Envio(resListadoEnvios.getInt("IdEnvio"), direccionD, direccionO, null, paquete, cliente, null, pago, estados, resListadoEnvios.getInt("codigoR")));
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return listadoEnv;
    }

    public Envio obtenerDetallesEnvio(int idEnvio) {
        Cliente clienteEmisor, clienteReceptor;
        Paquete paquete;
        Tarifa tarifa;
        Pago pago;
        Direccion direccionDestino, direccionOrigen;
        ArrayList<Estado> estados;
        Envio envioDetalles = null;
        try {
            PreparedStatement listadoEnvios = conexion.prepareStatement("SELECT DISTINCT E.id as IdEnvio, E.codigoR AS codigoR, PG.id AS IdPago, PG.metodoPago AS Pago, PG.precio AS precio, PG.fechaPago AS fechaPago,T.id AS IdTarifa, T.nombre AS NombreTarifa, T.precioBase AS PrecioTarifa,"
                    + " C.cedula AS CedulaClienteEmisor,"
                    + " C2.cedula AS CedulaClienteReceptor, C.nombre AS NombreEmisor,C.apellido AS ApellidoEmisor, C.correo as CorreoEmisor, "
                    + " C2.nombre AS NombreReceptor, C2.apellido AS ApellidoReceptor, C2.correo as CorreoReceptor, P.id AS IdPaquete, P.peso AS peso, P.esEspecial AS esEspecial, P.esFragil AS esFragil,"
                    + " P.descripcion AS DescripcionPaquete, D.id AS idDireccionEmisor, D.calle AS CalleEmisor, D.calle2 AS Calle2Emisor,"
                    + " D.nroPuerta AS NroPuertaEmisor, D.apartamento AS ApartamentoEmisor, D2.id AS idDireccionReceptor, D2.calle AS CalleReceptor,"
                    + " D2.calle2 AS Calle2Receptor, D2.nroPuerta AS NroPuertaReceptor, D2.apartamento AS ApartamentoReceptor"
                    + " FROM envio AS E, envio_cliente AS EC, envio_cliente AS EC2, cliente AS C, cliente AS C2, paquete AS P,"
                    + " tarifa AS T, direccion AS D, direccion AS D2, pago AS PG"
                    + " WHERE EC.idEnvio = E.id AND EC2.idEnvio = E.id AND"
                    + " EC.cedulaCliente = C.cedula AND EC2.cedulaCliente = C2.cedula AND EC.tipoEntrega = \"Envio\" AND"
                    + " EC2.tipoEntrega = \"Recibe\" AND P.id = E.idPaquete AND C.cedula != C2.cedula AND D.id != D2.id AND"
                    + " E.idDireccionOrigen = D.id AND E.idDireccionDestino = D2.id AND T.id = E.idTarifa AND PG.id = E.idPago AND E.id = " + idEnvio + ";");
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
                direccionDestino = new Direccion(resListadoEnvios.getString("CalleReceptor"), resListadoEnvios.getString("Calle2Receptor"),
                        resListadoEnvios.getString("ApartamentoReceptor"), resListadoEnvios.getInt("NroPuertaReceptor"), resListadoEnvios.getInt("idDireccionReceptor"), null, 0);

                direccionOrigen = new Direccion(resListadoEnvios.getString("CalleEmisor"), resListadoEnvios.getString("Calle2Emisor"),
                        resListadoEnvios.getString("ApartamentoEmisor"), resListadoEnvios.getInt("NroPuertaEmisor"), resListadoEnvios.getInt("idDireccionEmisor"), null, 0);

                clienteEmisor = new Cliente(resListadoEnvios.getInt("CedulaClienteEmisor"), resListadoEnvios.getString("NombreEmisor"), resListadoEnvios.getString("ApellidoEmisor"), null, resListadoEnvios.getString("correoEmisor"));
                clienteReceptor = new Cliente(resListadoEnvios.getInt("CedulaClienteReceptor"), resListadoEnvios.getString("NombreReceptor"), resListadoEnvios.getString("ApellidoReceptor"), null, resListadoEnvios.getString("correoReceptor"));

                paquete = new Paquete(resListadoEnvios.getString("DescripcionPaquete"), resListadoEnvios.getFloat("peso"), resListadoEnvios.getBoolean("esFragil"), resListadoEnvios.getBoolean("esEspecial"), resListadoEnvios.getInt("IdPaquete"), null);
                pago = new Pago(resListadoEnvios.getInt("precio"), resListadoEnvios.getString("Pago") != null
                        ? MetodoPago.valueOf(resListadoEnvios.getString("pago")) : null, resListadoEnvios.getString("fechaPago") != null
                        ? resListadoEnvios.getTimestamp("fechaPago") : null, resListadoEnvios.getInt("IdPago"));
                tarifa = new Tarifa(resListadoEnvios.getInt("PrecioTarifa"), resListadoEnvios.getString("NombreTarifa"), resListadoEnvios.getInt("IdTarifa"));
                envioDetalles = new Envio(idEnvio, direccionDestino, direccionOrigen, tarifa, paquete, clienteEmisor, clienteReceptor, pago, estados, resListadoEnvios.getInt("codigoR"));
            }
        } catch (SQLException ex) {
            LOGGER.severe("Error: " + ex);
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
            LOGGER.severe("Error: " + e);

        }

        return resultado;
    }

    public int crearUnPaquete(String desc, float peso, int fragil, int tipo) {
        int idGenerado = 0;
        try {
            PreparedStatement queryGuardarPaquete = conexion.prepareStatement(""
                    + "INSERT INTO paquete (descripcion, peso, esFragil, esEspecial) "
                    + "VALUES (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            queryGuardarPaquete.setString(1, desc);
            queryGuardarPaquete.setFloat(2, peso);
            queryGuardarPaquete.setInt(3, fragil);
            queryGuardarPaquete.setInt(4, tipo);
            queryGuardarPaquete.executeUpdate();
            ResultSet idPaquete = queryGuardarPaquete.getGeneratedKeys();
            if (idPaquete.next()) {
                idGenerado = idPaquete.getInt(1);
            }

        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return idGenerado;
    }

    public int crearUnaDireccion(String calle, String calle2, int puerta, String apartamento) {
        int idDireccion = 0;
        try {
            PreparedStatement queryGuardarDireccion = conexion.prepareStatement(""
                    + "INSERT INTO direccion (calle, calle2, nroPuerta, apartamento) "
                    + "VALUES (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            queryGuardarDireccion.setString(1, calle);
            queryGuardarDireccion.setString(2, calle2);
            queryGuardarDireccion.setInt(3, puerta);
            queryGuardarDireccion.setString(4, apartamento);
            queryGuardarDireccion.executeUpdate();
            ResultSet idD = queryGuardarDireccion.getGeneratedKeys();
            if (idD.next()) {
                idDireccion = idD.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return idDireccion;
    }

    public ArrayList<Localidad> listarLasLocalidades() {

        ArrayList<Localidad> listaLocalidades = new ArrayList<Localidad>();

        try {
            PreparedStatement queryListarLocali = conexion.prepareStatement("SELECT * FROM localidad");
            ResultSet listaLocali = queryListarLocali.executeQuery();
            while (listaLocali.next()) {
                int id = listaLocali.getInt("id");
                String nombre = listaLocali.getString("nombre");
                int codPostal = listaLocali.getInt("codigoPostal");
                listaLocalidades.add(new Localidad(nombre, codPostal, id, 0, 0, 0, 0));
            }

        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return listaLocalidades;
    }

    public ArrayList<Seccion> listarLasSecciones() {

        ArrayList<Seccion> listaSecciones = new ArrayList<Seccion>();

        try {
            PreparedStatement queryListarSecciones = conexion.prepareStatement("SELECT * FROM seccion");
            ResultSet listaS = queryListarSecciones.executeQuery();
            while (listaS.next()) {
                int id = listaS.getInt("id");
                int idLocalidad = listaS.getInt("idLocalidad");
                String nombre = listaS.getString("nombre");
                int cant = listaS.getInt("cantidad");

                listaSecciones.add(new Seccion(nombre, cant, id, null));
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return listaSecciones;
    }

    public void crearSeccion_Paquete(int idPaquete, int idSeccion) {

        try {
            PreparedStatement queryconexionS_P = conexion.prepareStatement("INSERT INTO seccion_paquete (idSeccion, idPaquete) VALUES (?,?)");
            queryconexionS_P.setInt(1, idSeccion);
            queryconexionS_P.setInt(2, idPaquete);
            queryconexionS_P.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }

    public ArrayList<Cliente> listarLosClientes() {
        ArrayList<Cliente> listaCE = new ArrayList<Cliente>();

        try {
            PreparedStatement queryListarClientesE = conexion.prepareStatement("SELECT * FROM cliente");
            ResultSet listaClienteE = queryListarClientesE.executeQuery();
            while (listaClienteE.next()) {
                int cedula = listaClienteE.getInt("cedula");
                String nombre = listaClienteE.getString("nombre");
                String apellido = listaClienteE.getString("apellido");
                String telefono = listaClienteE.getString("telefono");
                String correo = listaClienteE.getString("correo");
                listaCE.add(new Cliente(cedula, nombre, apellido, telefono, correo));
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }

        return listaCE;
    }

    public Cliente traerUnCliente(int cedula) {

        Cliente cliente = null;
        try {
            PreparedStatement queryTraerCliente = conexion.prepareStatement("SELECT * FROM cliente WHERE cedula = " + cedula + ";");
            ResultSet clienteSeleccionado = queryTraerCliente.executeQuery();
            while (clienteSeleccionado.next()) {
                cliente = new Cliente(clienteSeleccionado.getInt("cedula"),
                        clienteSeleccionado.getString("nombre"),
                        clienteSeleccionado.getString("apellido"),
                        clienteSeleccionado.getString("telefono"),
                        clienteSeleccionado.getString("correo"));
            }

        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return cliente;
    }

    public Direccion traerUnaDireccionSucursal() {

        Direccion dire = null;

        try {
            PreparedStatement queryTraerDireccionS = conexion.prepareStatement("SELECT * FROM direccion WHERE calle= 'Solano Garcia' AND nroPuerta= 1465 ;");
            ResultSet dirSucursal = queryTraerDireccionS.executeQuery();
            while (dirSucursal.next()) {
                dire = new Direccion(dirSucursal.getString("calle"),
                        dirSucursal.getString("calle2"),
                        "", dirSucursal.getInt("nroPuerta"),
                        1, "", 60000);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return dire;
    }

    public ArrayList<Tarifa> obtenerLasTarifasEspeciales() {

        ArrayList<Tarifa> listaTEspeciales = new ArrayList<Tarifa>();

        try {
            PreparedStatement queryListarTarifasEsp = conexion.prepareStatement("SELECT * FROM tarifa WHERE id > 3;");
            ResultSet listaTarifasEsp = queryListarTarifasEsp.executeQuery();
            while (listaTarifasEsp.next()) {
                int id = listaTarifasEsp.getInt("id");
                float precio = listaTarifasEsp.getFloat("precioBase");
                String nombre = listaTarifasEsp.getString("nombre");
                listaTEspeciales.add(new Tarifa(precio, nombre, id));
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return listaTEspeciales;
    }

    public Localidad traerLocalidadSucursal() {
        Localidad locali = null;
        try {
            PreparedStatement queryTraerLocalidadS = conexion.prepareStatement("SELECT * FROM localidad WHERE nombre= 'Barrio Este';");
            ResultSet localiSucursal = queryTraerLocalidadS.executeQuery();
            while (localiSucursal.next()) {
                locali = new Localidad(localiSucursal.getString("nombre"),
                        localiSucursal.getInt("codigoPostal"),
                        localiSucursal.getInt("id"), 0, 0, 0, 0);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return locali;
    }

    public void crearLocalidad_Direccion(int idLocalidad, int idDireccion) {

        try {
            PreparedStatement queryconexionL_D = conexion.prepareStatement("INSERT INTO localidad_direccion (idLocalidad, idDireccion) VALUES (?,?)");
            queryconexionL_D.setInt(1, idLocalidad);
            queryconexionL_D.setInt(2, idDireccion);
            queryconexionL_D.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }

    public int crearUnEnvio(int idPaquete, int idTarifa, int idDireOrigen, int idDireDestino, int idPago, int codigoR) {
        int idEnvio = 0;
        try {
            PreparedStatement queryCrearEnvio = conexion.prepareStatement(""
                    + "INSERT INTO envio (idPaquete, idTarifa, idDireccionOrigen,"
                    + " idDireccionDestino, idPago, codigoR) VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            queryCrearEnvio.setInt(1, idPaquete);
            queryCrearEnvio.setInt(2, idTarifa);
            queryCrearEnvio.setInt(3, idDireOrigen);
            queryCrearEnvio.setInt(4, idDireDestino);
            queryCrearEnvio.setInt(5, idPago);
            queryCrearEnvio.setInt(6, codigoR);
            queryCrearEnvio.executeUpdate();
            // OBTENGO EL ID GENERADO 
            ResultSet idE = queryCrearEnvio.getGeneratedKeys();
            if (idE.next()) {
                idEnvio = idE.getInt(1);
            }

        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return idEnvio;
    }

    public int crearUnEstado(int idEnvio, String tipo, String comentario) {
        int idEstado = 0;
        try {
            PreparedStatement queryCrearEstado = conexion.prepareStatement(" INSERT INTO estado (tipo, comentario) VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            queryCrearEstado.setString(1, tipo);
            queryCrearEstado.setString(2, comentario);
            queryCrearEstado.executeUpdate();
            ResultSet resultadoEstado = queryCrearEstado.getGeneratedKeys();
            if (resultadoEstado.next()) {
                idEstado = resultadoEstado.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        this.crearEnvio_Estado(idEnvio, idEstado);
        return idEstado;
    }

    public void crearEnvio_Cliente(int idEnvio, int cedulaCliente, String tipoEntrega) {
        try {
            PreparedStatement queryconexionE_C = conexion.prepareStatement("INSERT INTO envio_cliente (idEnvio, cedulaCliente, tipoEntrega) VALUES (?,?,?)");
            queryconexionE_C.setInt(1, idEnvio);
            queryconexionE_C.setInt(2, cedulaCliente);
            queryconexionE_C.setString(3, tipoEntrega);
            queryconexionE_C.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }

    }

    public void crearEnvio_Estado(int idEnvio, int idEstado) {
        try {
            PreparedStatement queryconexionE_E = conexion.prepareStatement("INSERT INTO envio_estado (idEnvio, idEstado) VALUES (?,?)");
            queryconexionE_E.setInt(1, idEnvio);
            queryconexionE_E.setInt(2, idEstado);
            queryconexionE_E.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }

    public void editarUnEnvio(int idEnvio, int idTarifa, int idDirOrigen, int idDirDestino, int idPago) {
        try {
            PreparedStatement queryEditarDireccion = conexion.prepareStatement("UPDATE envio SET idTarifa = ?, idDireccionOrigen = ?, idDireccionDestino = ? , idPago = ? "
                    + "WHERE id = " + idEnvio);
            queryEditarDireccion.setInt(1, idTarifa);
            queryEditarDireccion.setInt(2, idDirOrigen);
            queryEditarDireccion.setInt(3, idDirDestino);
            queryEditarDireccion.setInt(4, idPago);
            queryEditarDireccion.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }

    public Envio obtenerEnvioDeUnPaquete(int idPaquete) {
        int idEnvioSeleccionado = 0;
        try {
            PreparedStatement queryTraerIdEnvio = conexion.prepareStatement("SELECT "
                    + "id FROM envio WHERE idPaquete='" + idPaquete + "';");
            ResultSet resultadoDeLaQuery = queryTraerIdEnvio.executeQuery();
            while (resultadoDeLaQuery.next()) {
                idEnvioSeleccionado = resultadoDeLaQuery.getInt("id");
                return this.obtenerDetallesEnvio(idEnvioSeleccionado);
            }
        } catch (Exception e) {
            LOGGER.severe("Error: " + e);
        }
        return null;
    }

    public Envio obtenerUnCodigoRastreo(int codigoR) {
        int idEnvio = 0;
        try {
            PreparedStatement queryTraerIdEnvio = conexion.prepareStatement("SELECT "
                    + "id FROM envio WHERE codigoR='" + codigoR + "';");
            ResultSet resultadoDeLaQuery = queryTraerIdEnvio.executeQuery();
            while (resultadoDeLaQuery.next()) {
                idEnvio = resultadoDeLaQuery.getInt("id");
            }
            return this.obtenerDetallesEnvio(idEnvio);
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return null;
    }
}
