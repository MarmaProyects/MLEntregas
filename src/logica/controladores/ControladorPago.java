/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Cliente;
import logica.clases.Pago;
import logica.clases.Tarifa;
import logica.clases.Usuario;
import logica.interfaces.IAdministracion;
import logica.servicios.ServicioPago;

/**
 *
 * @author MarmaduX
 */
public class ControladorPago implements IAdministracion {

    private static ControladorPago instance;
    private ServicioPago servicioPago;

    public ControladorPago() {
        this.servicioPago = new ServicioPago();
    }

    public static ControladorPago getInstancia() {
        if (instance == null) {
            instance = new ControladorPago();
        }
        return instance;
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
    public void agregarCliente(int cedula, String nombre, String apellido, int telefono, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean verificarExisteClienteNuevo(int cedula) {
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

    @Override
    public Cliente traerClienteSeleccionado(int cedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarClienteSeleccionado(int cedula, String nombre, String apellido, int telefono, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int crearPago(int idTarifa, int idLocalidad) {
        return this.servicioPago.createPago(idTarifa, idLocalidad);
    }

    @Override
    public ArrayList<Cliente> obtenerLosClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void pagarEnvio(int idPago, String metodo) {
       this.servicioPago.pagarUnEnvio(idPago, metodo);
    }

    public ArrayList<Pago> traerPagosNoAsociados() {
        return this.servicioPago.traerLosPagosNoAsociados();
    }

    public void editarPago(int idPago, float precio) {
        this.servicioPago.editarUnPago(idPago, precio);
    }

    @Override
    public Boolean verificarExisteCorreoCliente(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void crearUsuario(String correo, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario obtenerUsuario(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
