/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases;

import logica.dataTypes.DtFecha;
import logica.dataTypes.TipoEstado;

/**
 *
 * @author leo
 */
public class estado {
    private String comentario;
    private TipoEstado tipo;
    private DtFecha fecha;
    private int idEstado;

    public estado(String comentario, TipoEstado tipo, DtFecha fecha) {
        this.comentario = comentario;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public TipoEstado getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstado tipo) {
        this.tipo = tipo;
    }

    public DtFecha getFecha() {
        return fecha;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }
    
    
}
