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
public class ControladorLocalidad implements IProximidad {
    private static ControladorLocalidad instance;

    public ControladorLocalidad() {
    }

    public static ControladorLocalidad getInstancia() {
        if (instance == null) {
            instance = new ControladorLocalidad();
        }
        return instance;
    }
    
}
