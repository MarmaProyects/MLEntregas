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
    private ServicioSeccion ServicioSeccion;

    public ControladorSeccion() {
        this.ServicioSeccion = new ServicioSeccion();
    }

    public static ControladorSeccion getInstancia() {
        if (instance == null) {
            instance = new ControladorSeccion();
        }
        return instance;
    }

    public Seccion buscarUnaSeccion(int idSeccion) {
        ArrayList<Seccion> Secciones = this.ServicioSeccion.obtenerLasSecciones();
        Seccion resultado = null;
        for (Seccion seccion : Secciones) {
            if (idSeccion == seccion.getIdSeccion()) {
                resultado = seccion;
            }
        }
        return resultado;
    }

    public void agregarUnaSeccion(String nombre, String localidad) {
        this.ServicioSeccion.agregarUnaSeccion(nombre, localidad);
    }

    public ArrayList<Seccion> obtenerLasSecciones() {
        return this.ServicioSeccion.obtenerListaSeccion();
    }

    @Override
    public void agregarUnaLocalidad(String nombre, int codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Localidad> obtenerLasLocalidades() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean verificarSiExisteLocalidadNueva(String nombre, int codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
