/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases;

/**
 *
 * @author leo
 */
public class paquete {
    private String codigo, descripcion;
    private float peso;
    private boolean esFragil, esEspecial;
    private int idPaquete;

    public paquete(String codigo, String descripcion, float peso, boolean esFragil, boolean esEspecial) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.esFragil = esFragil;
        this.esEspecial = esEspecial;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public boolean isEsFragil() {
        return esFragil;
    }

    public void setEsFragil(boolean esFragil) {
        this.esFragil = esFragil;
    }

    public boolean isEsEspecial() {
        return esEspecial;
    }

    public void setEsEspecial(boolean esEspecial) {
        this.esEspecial = esEspecial;
    }
    
    
}
