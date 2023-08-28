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
    public void agregarLocalidad(String nombre, int codigoPostal);
    public Boolean verificarExisteLocalidadNueva(String nombre, int codigoPostal);
}
