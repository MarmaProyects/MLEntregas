/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases;
//lista de direcciones
//en seccion lista de paquetes

import java.util.List;

/**
 *
 * @author MarmaduX
 */
public class Localidad {

    private String nombre;
    private int codigoPostal;
    private int idLocalidad;
    private List<Direccion> listaDirecciones;

    public Localidad(String nombre, int codigoPostal, int idLocalidad) {
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.idLocalidad = idLocalidad;
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public void añadirDireccion(Direccion direccion) {
        this.listaDirecciones.add(direccion);
    }

    public void quitarDireccion(Direccion direccion) {
        this.listaDirecciones.remove(direccion);
    }
}
