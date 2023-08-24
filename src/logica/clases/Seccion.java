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
    private String codigo;
    private int cantidad, idSeccion;
    private List <Paquete> listaPaquetes;
    
    public Seccion(String codigo, int cantidad, int idSeccion) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.idSeccion = idSeccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    
    public void agregarPaquete(Paquete paquete){
        listaPaquetes.add(paquete);
    }
    
    public void quitarPaquete(Paquete paquete){
        listaPaquetes.remove(paquete);
    }
}
