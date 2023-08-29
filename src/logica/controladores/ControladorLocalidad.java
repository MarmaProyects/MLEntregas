/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Localidad;
import logica.interfaces.IProximidad;
import logica.servicios.servicioLocalidad;

/**
 *
 * @author MarmaduX
 */
public class ControladorLocalidad implements IProximidad {
    private static ControladorLocalidad instance;
    private servicioLocalidad servicioLocalidad;

    public ControladorLocalidad() {
        this.servicioLocalidad = new servicioLocalidad();
    }

    public static ControladorLocalidad getInstancia() {
        if (instance == null) {
            instance = new ControladorLocalidad();
        }
        return instance;
    }

    public void agregarLocalidad(String nombre, int codigoPostal) {
            this.servicioLocalidad.insertarLocalidad(nombre, codigoPostal);
    }
    
    public Boolean verificarExisteLocalidadNueva(String nombre, int codigoPostal){
        Boolean resultado = false;
        ArrayList<Localidad> localidades = this.servicioLocalidad.obtenerLocalidades();
        for(Localidad localidad:localidades){
            if (localidad.getZona().equals(nombre) && localidad.getCodigoPostal() == codigoPostal) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }
}
