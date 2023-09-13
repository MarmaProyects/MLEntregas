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
import logica.clases.Estado;
import logica.clases.Localidad;
import logica.clases.Seccion;
import logica.clases.Tarifa;
import logica.interfaces.IEnvio;
import logica.servicios.ServicioDireccion;

/**
 *
 * @author MarmaduX
 */
public class ControladorDireccion implements IEnvio {

    private static ControladorDireccion instance;
    private ServicioDireccion servicioDireccion;
    
    public ControladorDireccion() {
        this.servicioDireccion = new ServicioDireccion();
    }

    public static ControladorDireccion getInstancia() {
        if (instance == null) {
            instance = new ControladorDireccion();
        }
        return instance;
    }

    public void editarDireccion(int idDireccion, String calle1, String calle2, String apartamento, int nroPuerta) {
        this.servicioDireccion.editarUnaDireccion(idDireccion, calle1, calle2, nroPuerta, apartamento);
    }
    
    public Direccion traerDireccion(int idDireccion) {
        return this.servicioDireccion.traerDireccionPorId(idDireccion);
    }
    
    @Override
    public ArrayList<Envio> listaDeEnvios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Paquete> listarPaquetesPorSeccion(int idSeccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Envio verDetallesDelEnvio(int idEnvio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moverPaqueteASeccion(int idPaquete, int idSeccionAMover) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int crearPaquete(String desc, float peso, int fragil, int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int crearDireccion(String calle, String calle2, int puerta, String apartamento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Localidad> listarLocalidades() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Seccion> listarSecciones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void conexionSeccion_Paquete(int idPaquete, int idSeccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> listarClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente traerCliente(int cedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Direccion traerDireccionSucursal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Tarifa> obtenerTarifasEspeciales() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Localidad traerIdLocalidadSucursal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void conexionLocalidad_Direccion(int idLocalidad, int idDireccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int crearEnvio(int idPaquete, int idTarifa, int idDireOrigen, int idDireDestino, int idPago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void conexionEnvio_Cliente(int idEnvio, int cedulaCliente, String tipoEntrega) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void conexionEnvio_Estado(int idEnvio, int idEstado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int crearEstado(int idEnvio, String tipo, String comentario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Estado obtenerElEstado(int idEstado, int idEnvio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarPaquete(int idPaquete, float peso, String descripcion, int esFragil, int esEspecial) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Paquete traerPaquete(int idPaquete) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarEnvio(int idEnvio, int idTarifa, int idDirOrigen, int idDirDestino, int idPago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Envio> listarEnviosFechaSeleccionadas(String fechaInicio, String fechaFinal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Paquete> obtenerPaquetesNoAsociados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Direccion> traerDirecciones() {
        return this.servicioDireccion.traerLasDirecciones();
    }

    @Override
    public Envio obtenerEnvioPaquete(int idPaquete) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
