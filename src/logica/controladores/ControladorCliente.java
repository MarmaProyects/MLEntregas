/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Cliente;
import logica.clases.Tarifa;
import logica.interfaces.IAdministracion;
import logica.servicios.ServicioCliente;

/**
 *
 * @author MarmaduX
 */
public class ControladorCliente implements IAdministracion {
    private static ControladorCliente instance;
    private ServicioCliente ServicioCliente;

    public ControladorCliente() {
        this.ServicioCliente = new ServicioCliente();
    }
    
    public void agregarCliente(int cedula, String nombre ,String apellido, int telefono) {
            this.ServicioCliente.insertarCliente(cedula, nombre, apellido, telefono);
    }
    
    public Boolean verificarExisteClienteNuevo(int cedula){
        Boolean resultado = false;
        ArrayList<Cliente> clientes = this.ServicioCliente.obtenerClientes();
        for(Cliente cliente:clientes){
            if (cliente.getCedula() == cedula) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public static ControladorCliente getInstancia() {
        if (instance == null) {
            instance = new ControladorCliente();
        }
        return instance;
    }
    
    public ArrayList<Cliente> obtenerCliente() {
        return this.ServicioCliente.obtenerClientes();
    }
    

    @Override
    public void crearTarifa(String nombre, float precioBase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Tarifa> listarTarifas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
