/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases;

/**
 *
 * @author MarmaduX
 */
public class Direccion {
    private String calle, segunda_calle, datos_adicionales;
    private int nro_puerta, idDireccion;

    public Direccion(String calle, String segunda_calle, String datos_adicionales, int nro_puerta, int idDireccion) {
        this.calle = calle;
        this.segunda_calle = segunda_calle;
        this.datos_adicionales = datos_adicionales;
        this.nro_puerta = nro_puerta;
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getSegunda_calle() {
        return segunda_calle;
    }

    public void setSegunda_calle(String segunda_calle) {
        this.segunda_calle = segunda_calle;
    }

    public String getDatos_adicionales() {
        return datos_adicionales;
    }

    public void setDatos_adicionales(String datos_adicionales) {
        this.datos_adicionales = datos_adicionales;
    }

    public int getNro_puerta() {
        return nro_puerta;
    }

    public void setNro_puerta(int nro_puerta) {
        this.nro_puerta = nro_puerta;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }
    
}
