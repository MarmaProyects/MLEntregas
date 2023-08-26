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
public class ControladorCliente implements IAdministracion {
    private static ControladorCliente instance;

    public ControladorCliente() {
    }

    public static ControladorCliente getInstancia() {
        if (instance == null) {
            instance = new ControladorCliente();
        }
        return instance;
    }
}
