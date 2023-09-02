/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Envio;
import logica.clases.Paquete;
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

    @Override
    public ArrayList<Paquete> listarPaquetesPorSeccion(int idSeccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moverPaqueteASeccion(int idPaquete, int idSeccionAMover) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      public int crearPaquete(String desc, float peso, int fragil, int tipo) {
        return this.servicioEnvio.crearUnPaquete(desc, peso, fragil, tipo);

    }

    public int crearDireccion(String calle, String calle2, int puerta, String apartamento) {
        return this.servicioEnvio.crearUnaDireccion(calle, calle2, puerta, apartamento);

    }

    public ArrayList<Localidad> listarLocalidades() {
        return this.servicioEnvio.listarLasLocalidades();

    }

    public ArrayList<Seccion> listarSecciones() {
        return this.servicioEnvio.listarLasSecciones();

    }

    public void conexionSeccion_Paquete(int idPaquete, int idSeccion) {
        this.servicioEnvio.crearSeccion_Paquete(idPaquete, idSeccion);
    }

    public ArrayList<Cliente> listarClientes() {
        return this.servicioEnvio.listarLosClientes();
    }

    public Cliente traerCliente(int cedula) {
        return this.servicioEnvio.traerUnCliente(cedula);
    }

    public Direccion traerDireccionSucursal() {
        return this.servicioEnvio.traerUnaDireccionSucursal();
    }

    public ArrayList<Tarifa> obtenerTarifasEspeciales() {
        return this.servicioEnvio.obtenerLasTarifasEspeciales();
    }

    public Localidad traerIdLocalidadSucursal() {
        return this.servicioEnvio.traerLocalidadSucursal();
    }

    public void conexionLocalidad_Direccion(int idLocalidad, int idDireccion) {
        this.servicioEnvio.crearLocalidad_Direccion(idLocalidad, idDireccion);
    }

    public int crearEnvio(int idPaquete, int idTarifa, int idDireOrigen, int idDireDestino, int idPago) {
        return this.servicioEnvio.crearUnEnvio(idPaquete, idTarifa, idDireOrigen, idDireDestino, idPago);
    }

    public void conexionEnvio_Cliente(int idEnvio, int cedulaCliente, String tipoEntrega) {
        this.servicioEnvio.crearEnvio_Cliente(idEnvio, cedulaCliente, tipoEntrega);
    }

    public void conexionEnvio_Estado(int idEnvio, int idEstado) {
        this.servicioEnvio.crearEnvio_Estado(idEnvio, idEstado);
    }

    public int crearEstado(int idEnvio, String tipo, String comentario) {
        return this.servicioEnvio.crearUnEstado(idEnvio, tipo, comentario);
    }

}
