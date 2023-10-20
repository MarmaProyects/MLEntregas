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
    private float precio;
    private float latitud;
    private float longitud;
    private float zoom;

    public Localidad(String nombre, int codigoPostal, int idLocalidad, float precio, float latitud ,float longitud, float zoom) {
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.idLocalidad = idLocalidad;
        this.precio = precio;
        this.longitud = longitud;
        this.latitud = latitud;
        this.zoom = zoom;
    }
   
    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
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
