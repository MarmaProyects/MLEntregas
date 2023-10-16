/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.interfaces;

import java.util.ArrayList;
import logica.clases.Cliente;
import logica.clases.Pago;
import logica.clases.Tarifa;

/**
 *
 * @author MarmaduX
 */
public interface IAdministracion {

    public abstract ArrayList<Tarifa> listarTarifas();
    public abstract void crearUnaTarifa(String nombre, float precioBase);
    public abstract void agregarCliente(int cedula, String nombre ,String apellido, int telefono, String correo);
    public abstract ArrayList<Cliente> obtenerLosClientes();
    public abstract Boolean verificarExisteClienteNuevo(int cedula);
    public abstract Boolean verificarExisteCorreoCliente(String correo);
    public abstract boolean eliminarTarifaSeleccionada(int id);
    public abstract Tarifa traerTarifaSeleccionada(int id);
    public abstract boolean editarTarifaSeleccionada(int id, String nombre, float precio);
    public abstract Cliente traerClienteSeleccionado(int cedula);
    public abstract Cliente traerClientePorNomApe(String nomApe);
    public abstract void editarClienteSeleccionado(int cedula, String nombre, String apellido, int telefono, String correo);
    public abstract int crearPago(int idTarifa, int obtenerLocalidad);
    public abstract void pagarEnvio(int idPago, String metodo);
    public abstract void editarPago(int idPago, float precio);
    public abstract ArrayList<Pago> traerPagosNoAsociados();
}
