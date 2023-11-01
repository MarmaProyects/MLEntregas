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
import logica.servicios.ServicioTarifa;

/**
 *
 * @author MarmaduX
 */
public class ControladorTarifa implements IAdministracion {
    private static ControladorTarifa instance;
    private ServicioTarifa servicioTarifa;

    public ControladorTarifa() {
         this.servicioTarifa = new ServicioTarifa();
    }

    public static ControladorTarifa getInstancia() {
        if (instance == null) {
            instance = new ControladorTarifa();
        }
        return instance;
    } 

    @Override
    public void crearUnaTarifa(String nombre, float precioBase) {
        this.servicioTarifa.crearLaTarifa(nombre, precioBase);
    }

    @Override
    public ArrayList<Tarifa> listarTarifas() {
        return this.servicioTarifa.listarLasTarifas();
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
        return this.servicioTarifa.eliminarTarifa(id);
    }

    @Override
    public Tarifa traerTarifaSeleccionada(int id) {
        return this.servicioTarifa.traerTarifa(id);
    }

    @Override
    public boolean editarTarifaSeleccionada(int id, String nombre, float precio) {
        return this.servicioTarifa.editarTarifa(id, nombre, precio);
    }

    @Override
    public Cliente traerClienteSeleccionado(int cedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarClienteSeleccionado(int cedula, String nombre, String apellido, int telefono, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public int crearPago(int idTarifa, int obtenerLocalidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> obtenerLosClientes() {
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

    @Override
    public Boolean verificarExisteCorreoCliente(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente traerClientePorNomApe(String nomApe) {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void crearUsuario(String correo, String contrasenia, byte[] key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario obtenerUsuario(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override

    public Cliente traerClientePorCorreo(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean verificarCorrespondenciaCorreoCliente(String correo, int cedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  @Override
    public void editarUsuario(String correo, String idImage, String correoViejo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarClienteSeleccionado(int cedula, int cedulaVieja, String nombre, String apellido, int telefono, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
