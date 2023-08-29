/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Localidad;
import logica.clases.Seccion;
import logica.interfaces.IProximidad;
import logica.servicios.ServicioSeccion;

/**
 *
 * @author MarmaduX
 */
public class ControladorSeccion implements IProximidad {
    private static ControladorSeccion instance;
    private ServicioSeccion servicio;
    
    public ControladorSeccion() {
        this.servicio = new ServicioSeccion();
    }

    public static ControladorSeccion getInstancia() {
        if (instance == null) {
            instance = new ControladorSeccion();
        }
        return instance;
    }

    public void agregarSeccion(String nombre, String localidad) {
        this.servicio.agregarSeccion(nombre, localidad);
    }
    
    public ArrayList<Seccion> obtenerSecciones(){
        return this.servicio.obtenerListaSeccion();
    }
    
    @Override
    public void agregarLocalidad(String nombre, int codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean verificarExisteLocalidadNueva(String nombre, int codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Localidad> obtenerLocalidades() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
