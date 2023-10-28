/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases;

/**
 *
 * @author Angelo
 */
public class Valoracion {
    private Envio envio;
    private int puntaje;
    private String comentario;

    public Valoracion(Envio envio, int puntaje, String comentario) {
        this.envio = envio;
        this.puntaje = puntaje;
        this.comentario = comentario;
    }

    public Envio getenvio() {
        return envio;
    }

    public void setIdEnvio(Envio envio) {
        this.envio = envio;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}

 

