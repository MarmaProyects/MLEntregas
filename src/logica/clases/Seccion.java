/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases;

import java.util.List;

/**
 *
 * @author MarmaduX
 */
public class Seccion {

    private String nombre;
    private int cantidad, idSeccion, idLocalidad;
    private List<Paquete> listaPaquetes;

    public Seccion(String nombre, int cantidad, int idSeccion, List<Paquete> listaPaquetes) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.idSeccion = idSeccion;
        this.listaPaquetes = listaPaquetes;
    }

    public Seccion(String nombre, int cantidad, int idSeccion, int idLocalidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.idSeccion = idSeccion;
        this.idLocalidad = idLocalidad;
    }

    public Seccion(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public List<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<Paquete> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }
    
    public void añadirPaquete(Paquete paquete){
        listaPaquetes.add(paquete);
    }

    public void quitarPaquete(Paquete paquete) {
        listaPaquetes.remove(paquete);
    }
}
