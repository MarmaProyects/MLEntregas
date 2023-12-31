/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Cliente;
import logica.clases.Envio;
import logica.clases.Pago;
import logica.clases.Tarifa;
import logica.clases.Usuario;
import logica.interfaces.IAdministracion;
import logica.servicios.ServicioCliente;

/**
 *
 * @author MarmaduX
 */
public class ControladorCliente implements IAdministracion {

    private static ControladorCliente instance;
    private ServicioCliente servicioCliente;

    public ControladorCliente() {
        this.servicioCliente = new ServicioCliente();
    }

    public static ControladorCliente getInstancia() {
        if (instance == null) {
            instance = new ControladorCliente();
        }
        return instance;
    }
    
    public boolean crearMail(Cliente client, Envio envio, int idEstado) {
        return this.servicioCliente.crearUnEmail(client, envio, idEstado);
    }
    
    public void enviarMail(){
        this.servicioCliente.enviarUnEmail();
    }
    
    public void agregarCliente(int cedula, String nombre, String apellido, int telefono, String correo) {
        this.servicioCliente.insertarCliente(cedula, nombre, apellido, telefono, correo);

    }

    public Boolean verificarExisteClienteNuevo(int cedula) {
        Boolean resultado = false;
        ArrayList<Cliente> clientes = this.servicioCliente.obtenerCliente();
        for (Cliente cliente : clientes) {
            if (cliente.getCedula() == cedula) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public Boolean verificarExisteCorreoCliente(String correo) {
        Boolean resultado = false;
        ArrayList<Cliente> clientes = this.servicioCliente.obtenerCliente();
        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equals(correo)) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public Boolean verificarCorrespondenciaCorreoCliente(String correo, int cedula) {
        Boolean resultado = false;
        ArrayList<Cliente> clientes = this.servicioCliente.obtenerCliente();
        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equals(correo)) {
                if (cliente.getCedula() == cedula) {
                    resultado = true;
                    break;
                }
            }
        }
        return resultado;
    }

    public ArrayList<Cliente> obtenerLosClientes() {
        return this.servicioCliente.obtenerCliente();
    }

    public Cliente traerClientePorCorreo(String correo) {
        return this.servicioCliente.traerUnClientePorCorreo(correo);
    }

    @Override
    public void crearUnaTarifa(String nombre, float precioBase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Tarifa> listarTarifas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarTarifaSeleccionada(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Tarifa traerTarifaSeleccionada(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean editarTarifaSeleccionada(int id, String nombre, float precio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Cliente traerClienteSeleccionado(int cedula) {
        return this.servicioCliente.traerCliente(cedula);
    }

    public void editarClienteSeleccionado(int cedula, String nombre, String apellido, int telefono, String correo) {
        this.servicioCliente.editarCliente(cedula, nombre, apellido, telefono, correo);
    }

    @Override
    public int crearPago(int idTarifa, int obtenerLocalidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void pagarEnvio(int idPago, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Pago> traerPagosNoAsociados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarPago(int idPago, float precio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Cliente traerClientePorNomApe(String nomApe) {
        return this.servicioCliente.traerClientePorNombreApellido(nomApe);
    }

    public void crearUsuario(String correo, String contrasenia, byte[] key) {
        this.servicioCliente.crearUser(correo, contrasenia, key);
    }

    public Usuario obtenerUsuario(String correo) {
        return this.servicioCliente.obtenerUsuario(correo);
    }

    @Override
    public void editarUsuario(String correo, String idImage, String correoviejo) { 
        this.servicioCliente.editarUsuario(correo, idImage, correoviejo);
    }
    
    public void cambiarNotisEmail(String correo, boolean notisEmail) {
        this.servicioCliente.cambiarNotisDeEmail(correo, notisEmail);
    }

    @Override
    public void editarClienteSeleccionado(int cedula, int cedulaVieja, String nombre, String apellido, int telefono, String correo) {
        this.servicioCliente.editarCliente(cedula, cedulaVieja, nombre, apellido, telefono, correo);
    }
}
