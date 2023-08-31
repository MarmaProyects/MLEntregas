/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases;

import java.sql.Timestamp;
import logica.dataTypes.TipoEstado;

/**
 *
 * @author leo
 */
public class Estado {
    private String comentario;
    private TipoEstado tipo;
    private Timestamp fecha;
    private int idEstado;

    public Estado(String comentario, TipoEstado tipo, Timestamp fecha, int idEstado) {
        this.comentario = comentario;
        this.tipo = tipo;
        this.fecha = fecha;
        this.idEstado = idEstado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
    
}
