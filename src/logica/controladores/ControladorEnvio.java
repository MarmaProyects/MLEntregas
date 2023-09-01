/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Envio;
import logica.clases.Cliente;
import logica.clases.Direccion;
import logica.clases.Localidad;
import logica.clases.Seccion;
import logica.clases.Tarifa;
import logica.interfaces.IEnvio;
import logica.servicios.ServicioEnvio;

/**
 *
 * @author MarmaduX
 */
public class ControladorEnvio implements IEnvio {

    private static ControladorEnvio instance;
    private ServicioEnvio servicioEnvio;

    public ControladorEnvio() {
        this.servicioEnvio = new ServicioEnvio();
    }

    public static ControladorEnvio getInstancia() {
        if (instance == null) {
            instance = new ControladorEnvio();
        }
        return instance;
    }
    
    public Envio verDetallesDelEnvio(int idEnvio){
        Envio envio = this.servicioEnvio.obtenerDetallesEnvio(idEnvio);
        return envio;
    }

    public ArrayList<Envio> listaDeEnvios() {
        return this.servicioEnvio.listarEnvios();
    }

    public int crearPaquete(String desc, float peso, int fragil, int tipo) {
        return this.servicioEnvio.crearPaquete(desc, peso, fragil, tipo);

    }

    public int crearDireccion(String calle, String calle2, int puerta, String apartamento) {
        return this.servicioEnvio.crearDireccion(calle, calle2, puerta, apartamento);

    }

    public ArrayList<Localidad> listarLocalidades() {
        return this.servicioEnvio.listarLocalidades();

    }

    public ArrayList<Seccion> listarSecciones() {
        return this.servicioEnvio.listarSecciones();

    }

    public void conexionSeccion_Paquete(int idPaquete, int idSeccion) {
        this.servicioEnvio.conexionSeccion_Paquete(idPaquete, idSeccion);
    }

    public ArrayList<Cliente> listarClientes() {
        return this.servicioEnvio.listarClientes();
    }

    public Cliente traerCliente(int cedula) {
        return this.servicioEnvio.traerCliente(cedula);
    }

    public Direccion traerDireccionSucursal() {
        return this.servicioEnvio.traerDireccionSucursal();
    }

    public ArrayList<Tarifa> obtenerTarifasEspeciales() {
        return this.servicioEnvio.obtenerTarifasEspeciales();
    }

    public Localidad traerIdLocalidadSucursal() {
        return this.servicioEnvio.traerIdLocalidadSucursal();
    }

    public void conexionLocalidad_Direccion(int idLocalidad, int idDireccion) {
        this.servicioEnvio.conexionLocalidad_Direccion(idLocalidad, idDireccion);
    }

    public int crearEnvio(int idPaquete, int idTarifa, int idDireOrigen, int idDireDestino, int idPago) {
        return this.servicioEnvio.crearEnvio(idPaquete, idTarifa, idDireOrigen, idDireDestino, idPago);
    }

    public void conexionEnvio_Cliente(int idEnvio, int cedulaCliente, String tipoEntrega) {
        this.servicioEnvio.conexionEnvio_Cliente(idEnvio, cedulaCliente, tipoEntrega);
    }

    public void conexionEnvio_Estado(int idEnvio, int idEstado) {
        this.servicioEnvio.conexionEnvio_Estado(idEnvio, idEstado);
    }

    public int crearEstado(int idEnvio, String tipo, String comentario) {
        return this.servicioEnvio.crearEstado(idEnvio, tipo, comentario);
    }

}
