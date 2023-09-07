/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.interfaces;

import java.util.ArrayList;
import logica.clases.Localidad;
import logica.clases.Seccion;

/**
 *
 * @author MarmaduX
 */
public interface IProximidad {
    public abstract boolean eliminarSeccion(int id);
    public abstract boolean editarSeccionSeleccionada(int idSeccion, String nombre, int idLocalidad);
    public abstract Seccion traerSeccionSeleccionada(int id);
    public abstract void agregarUnaLocalidad(String nombre, int codigoPostal);
    public abstract void agregarUnaSeccion(String nombre, String localidad);
    public abstract ArrayList<Localidad> obtenerLasLocalidades();
    public abstract ArrayList<Seccion> obtenerLasSecciones();
    public abstract Boolean verificarSiExisteLocalidadNueva(String nombre, int codigoPostal);
    public abstract Seccion buscarUnaSeccion(int idSeccion);
    public abstract void editarLaLocalidad(int idLocalidad, String nombreLocalidad, int codigoPostal);
}
