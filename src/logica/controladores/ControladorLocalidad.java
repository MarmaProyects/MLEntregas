/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Localidad;
import logica.clases.Seccion;
import logica.interfaces.IProximidad;
import logica.servicios.ServicioLocalidad;



/**
 *
 * @author MarmaduX
 */
public class ControladorLocalidad implements IProximidad {

    private static ControladorLocalidad instance;
    private ServicioLocalidad servicioLocalidad;

    public ControladorLocalidad() {
        this.servicioLocalidad = new ServicioLocalidad();
    }

    public static ControladorLocalidad getInstancia() {
        if (instance == null) {
            instance = new ControladorLocalidad();
        }
        return instance;
    }

    public void agregarUnaLocalidad(String nombre, int codigoPostal) {
        this.servicioLocalidad.insertarLocalidad(nombre, codigoPostal);
    }
    
    public void editarLaLocalidad(int idLocalidad, String nombreLocalidad, int codigoPostal) {
        this.servicioLocalidad.editarLocalidad(idLocalidad, nombreLocalidad, codigoPostal);
    }

    public ArrayList<Localidad> obtenerLasLocalidades() {
        return this.servicioLocalidad.obtenerLasLocalidades();
    }

    public Boolean verificarSiExisteLocalidadNueva(String nombre, int codigoPostal) {
        Boolean resultado = false;
        ArrayList<Localidad> localidades = this.servicioLocalidad.obtenerLasLocalidades();
        for (Localidad localidad : localidades) {
            if (localidad.getNombre().equals(nombre) && localidad.getCodigoPostal() == codigoPostal) {

                resultado = true;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void agregarUnaSeccion(String nombre, String localidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Seccion> obtenerLasSecciones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarSeccion(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Seccion traerSeccionSeleccionada(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean editarSeccionSeleccionada(int idSeccion, String nombre, int idLocalidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Seccion buscarUnaSeccion(int idSeccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
