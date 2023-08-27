/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Tarifa;
import logica.interfaces.IAdministracion;

/**
 *
 * @author MarmaduX
 */
public class ControladorPago implements IAdministracion {
    private static ControladorPago instance;

    public ControladorPago() {
    }

    public static ControladorPago getInstancia() {
        if (instance == null) {
            instance = new ControladorPago();
        }
        return instance;
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
