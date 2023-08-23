/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases;

import logica.dataTypes.DtFecha;
import logica.dataTypes.MetodoPago;

/**
 *
 * @author leo
 */
public class pago {
    private float precio;
    private MetodoPago pago;
    private DtFecha fecha;

    public pago(float precio, MetodoPago pago, DtFecha fecha) {
        this.precio = precio;
        this.pago = pago;
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public MetodoPago getPago() {
        return pago;
    }

    public void setPago(MetodoPago pago) {
        this.pago = pago;
    }

    public DtFecha getFecha() {
        return fecha;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }
    
    
}
