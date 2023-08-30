/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import logica.interfaces.IEnvio;

/**
 *
 * @author MarmaduX
 */
public class ControladorDireccion implements IEnvio {
    private static ControladorDireccion instance;

    public ControladorDireccion() {
    }

    public static ControladorDireccion getInstancia() {
        if (instance == null) {
            instance = new ControladorDireccion();
        }
        return instance;
    }

    @Override
    public void facturarEnvio(float precio, String metodoPago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
