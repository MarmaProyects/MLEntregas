/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Tarifa;
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
    public void crearTarifa(String nombre, float precioBase) {
        this.servicioTarifa.crearLaTarifa(nombre, precioBase);
    }

    @Override
    public ArrayList<Tarifa> listarTarifas() {
        return this.servicioTarifa.listarLasTarifas();
    }

    @Override
    public void agregarCliente(int cedula, String nombre, String apellido, int telefono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean verificarExisteClienteNuevo(int cedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
