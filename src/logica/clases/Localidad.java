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
    private String zona;
    private int codigoPostal;
    private int idLocalidad;
    private List <Direccion> listaDirecciones;

    public Localidad(String zona, int codigoPostal, int idLocalidad) {
        this.zona = zona;
        this.codigoPostal = codigoPostal;
        this.idLocalidad = idLocalidad;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
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

    public List<Direccion> getListaDirecciones() {
        return listaDirecciones;
    }
    
    public void agregarDireccion(Direccion direccion) {
        listaDirecciones.add(direccion);
    }
    
}
