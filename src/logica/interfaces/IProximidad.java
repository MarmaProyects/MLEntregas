/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.interfaces;

import java.util.ArrayList;
import logica.clases.Localidad;

/**
 *
 * @author MarmaduX
 */
public interface IProximidad {
    public abstract void agregarLocalidad(String nombre, int codigoPostal);
    public abstract void agregarSeccion(String nombre, String localidad);
    public abstract ArrayList<Localidad> obtenerLocalidades();
    public abstract Boolean verificarExisteLocalidadNueva(String nombre, int codigoPostal);
}
