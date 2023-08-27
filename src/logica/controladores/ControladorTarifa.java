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
        this.servicioTarifa.crearTarifa(nombre, precioBase);
    }

    @Override
    public ArrayList<Tarifa> listarTarifas() {
        return this.servicioTarifa.listarTarifas();
    }
}
