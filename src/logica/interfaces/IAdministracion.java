/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.interfaces;

import java.util.ArrayList;
import logica.clases.Tarifa;

/**
 *
 * @author MarmaduX
 */
public interface IAdministracion {
    public abstract ArrayList<Tarifa> listarTarifas();
    public abstract void crearTarifa(String nombre, float precioBase);
    public abstract void agregarCliente(int cedula, String nombre ,String apellido, int telefono);
    public abstract Boolean verificarExisteClienteNuevo(int cedula);
    public abstract boolean eliminarTarifaSeleccionada(int id);
    public abstract Tarifa traerTarifaSeleccionada(int id);
    public abstract boolean editarTarifaSeleccionada(int id, String nombre, float precio);
}
