/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package logica.dataTypes;

/**
 *
 * @author leo
 */
public enum TipoEstado {
    Entregado("Entregado"), 
    EnCamino("En camino"), 
    Preparando("En preparación"), 
    ListoParaRetirar("Listo para entregar");
    
    private final String estado;

    private TipoEstado(String estado) {
        this.estado = estado;
    }
    
    public String getEstado() {
        return estado;
    }
}
