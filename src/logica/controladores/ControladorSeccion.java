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
    private ServicioSeccion servicioSeccion;

    public ControladorSeccion() {
        this.servicioSeccion = new ServicioSeccion();
    }

    public static ControladorSeccion getInstancia() {
        if (instance == null) {
            instance = new ControladorSeccion();
        }
        return instance;
    }

    public Seccion buscarUnaSeccion(int idSeccion) {
        ArrayList<Seccion> Secciones = this.servicioSeccion.obtenerLasSecciones();
        Seccion resultado = null;
        for (Seccion seccion : Secciones) {
            if (idSeccion == seccion.getIdSeccion()) {
                resultado = seccion;
            }
        }
        return resultado;
    }

    public boolean eliminarSeccion(int id) {
        return this.servicioSeccion.eliminarUnaSeccion(id);
    }

    public void agregarUnaSeccion(String nombre, String localidad) {
        this.servicioSeccion.agregarUnaSeccion(nombre, localidad);
    }

    public ArrayList<Seccion> obtenerLasSecciones() {
        return this.servicioSeccion.obtenerListaSeccion();
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

    public Seccion traerSeccionSeleccionada(int id) {
        return this.servicioSeccion.traerSeccion(id);
    }

    public boolean editarSeccionSeleccionada(int idSeccion, String nombre, int idLocalidad) {
        return this.servicioSeccion.editarSeccion(idSeccion, nombre, idLocalidad);
    }

    @Override
    public void editarLaLocalidad(int idLocalidad, String nombreLocalidad, int codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Localidad obtenerLaLocalidad(String nombreLocalidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float obtenerPrecioLocalidad(int idLocalidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
