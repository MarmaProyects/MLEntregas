/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import logica.interfaces.IProximidad;

/**
 *
 * @author MarmaduX
 */
public class ControladorSeccion implements IProximidad {
    private static ControladorSeccion instance;

    public ControladorSeccion() {
    }

    public static ControladorSeccion getInstancia() {
        if (instance == null) {
            instance = new ControladorSeccion();
        }
        return instance;
    }

    @Override
    public void agregarLocalidad(String nombre, int codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean verificarExisteLocalidadNueva(String nombre, int codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
