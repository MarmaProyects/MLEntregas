/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.fabrica;

import logica.controladores.ControladorCliente;
import logica.controladores.ControladorDireccion;
import logica.controladores.ControladorEnvio;
import logica.controladores.ControladorEstado;
import logica.controladores.ControladorLocalidad;
import logica.controladores.ControladorPago;
import logica.controladores.ControladorPaquete;
import logica.controladores.ControladorSeccion;
import logica.controladores.ControladorTarifa;
import logica.interfaces.IAdministracion;
import logica.interfaces.IEnvio;
import logica.interfaces.IProximidad;

/**
 *
 * @author MarmaduX
 */
public class Fabrica {
    
    private static Fabrica instance;

    public Fabrica() {
    }

    public static Fabrica getInstancia() {
        if (instance == null) {
            instance = new Fabrica();
        }
        return instance;
    }
    
    public IAdministracion getControladorCliente() {
        IAdministracion controladorCliente = ControladorCliente.getInstancia();
        return controladorCliente;
    }
    
    public IAdministracion getControladorPago() {
        IAdministracion controladorPago = ControladorPago.getInstancia();
        return controladorPago;
    }
    
    public IAdministracion getControladorTarifa() {
        IAdministracion controladorTarifa = ControladorTarifa.getInstancia();
        return controladorTarifa;
    }
    
    public IEnvio getControladorEnvio() {
        IEnvio controladorEnvio = ControladorEnvio.getInstancia();
        return controladorEnvio;
    }
    
    public IEnvio getControladorPaquete() {
        IEnvio controladorPaquete = ControladorPaquete.getInstancia();
        return controladorPaquete;
    }
    
    public IEnvio getControladorEstado() {
        IEnvio controladorEstado = ControladorEstado.getInstancia();
        return controladorEstado;
    }
    
    public IEnvio getControladorDireccion() {
        IEnvio controladorDireccion = ControladorDireccion.getInstancia();
        return controladorDireccion;
    }
    
    public IProximidad getControladorLocalidad() {
        IProximidad controladorLocalidad = ControladorLocalidad.getInstancia();
        return controladorLocalidad;
    }
    
    public IProximidad getControladorSeccion() {
        IProximidad controladorSeccion = ControladorSeccion.getInstancia();
        return controladorSeccion;
    }
}
