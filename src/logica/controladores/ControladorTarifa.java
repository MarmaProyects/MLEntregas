/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import logica.interfaces.IAdministracion;

/**
 *
 * @author MarmaduX
 */
public class ControladorTarifa implements IAdministracion {
    private static ControladorTarifa instance;

    public ControladorTarifa() {
    }

    public static ControladorTarifa getInstancia() {
        if (instance == null) {
            instance = new ControladorTarifa();
        }
        return instance;
    } 
}
