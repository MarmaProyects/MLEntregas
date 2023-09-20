/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.interfaces;

import java.util.ArrayList;
import logica.clases.Envio;
import logica.clases.Paquete;
import logica.clases.Cliente;
import logica.clases.Direccion;
import logica.clases.Estado;
import logica.clases.Localidad;
import logica.clases.Seccion;
import logica.clases.Tarifa;

/**
 *
 * @author MarmaduX
 */
public interface IEnvio {

    public abstract ArrayList<Paquete> listarPaquetesPorSeccion(int idSeccion);
    public abstract void moverPaqueteASeccion(int idPaquete, int idSeccionAMover);
    public abstract ArrayList<Envio> listaDeEnvios();
    public abstract Envio verDetallesDelEnvio(int idEnvio);
    public abstract int crearPaquete(String desc, float peso, int fragil, int tipo);
    public abstract void editarPaquete(int idPaquete, float peso, String descripcion, int esFragil, int esEspecial); 
    public abstract Paquete traerPaquete(int idPaquete);
    public abstract ArrayList<Paquete> obtenerPaquetesNoAsociados();
    public abstract int crearDireccion(String calle, String calle2, int puerta, String apartamento); 
    public abstract void editarDireccion(int idDireccion, String calle1, String calle2, String apartamento,  int nroPuerta); 
    public abstract Direccion traerDireccion(int idDireccion);
    public abstract ArrayList<Direccion> traerDirecciones();
    public abstract ArrayList<Localidad> listarLocalidades();
    public abstract ArrayList<Seccion> listarSecciones();
    public abstract void conexionSeccion_Paquete(int idPaquete, int idSeccion);
    public abstract ArrayList<Cliente> listarClientes();
    public abstract Cliente traerCliente(int cedula);
    public abstract Direccion traerDireccionSucursal();
    public abstract ArrayList<Tarifa> obtenerTarifasEspeciales();
    public abstract Localidad traerIdLocalidadSucursal();
    public abstract void conexionLocalidad_Direccion(int idLocalidad, int idDireccion);
    public abstract int crearEnvio(int idPaquete, int idTarifa, int idDireOrigen, int idDireDestino, int idPago, int codigoR); 
    public abstract void editarEnvio(int idEnvio, int idTarifa, int idDirOrigen, int idDirDestino, int idPago);
    public abstract Envio obtenerCodigoRastreo(int codigoR);
    public abstract void conexionEnvio_Cliente(int idEnvio, int cedulaCliente, String tipoEntrega);
    public abstract void conexionEnvio_Estado(int idEnvio, int idEstado);
    public abstract int crearEstado(int idEnvio, String tipo, String comentario); 
    public abstract Estado obtenerElEstado(int idEstado, int idEnvio);
    public abstract ArrayList<Envio> listarEnviosFechaSeleccionadas(String fechaInicio, String fechaFinal);
    public abstract Envio obtenerEnvioPaquete(int idPaquete);
}
