/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import logica.interfaces.IEnvio;
import logica.servicios.ServicioEnvio;

/**
 *
 * @author MarmaduX
 */
public class ControladorEnvio implements IEnvio {
    private static ControladorEnvio instance;
    private ServicioEnvio servicio;
    
    public ControladorEnvio() {
        this.servicio = new ServicioEnvio();
    }

    public static ControladorEnvio getInstancia() {
        if (instance == null) {
            instance = new ControladorEnvio();
        }
        return instance;
    }
    
    public void facturarEnvio(float precio, String metodoPago) {
        this.servicio.facturarEnvio(precio, metodoPago);
    }
    
    

}
