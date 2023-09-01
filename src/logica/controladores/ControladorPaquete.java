/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Envio;
import logica.clases.Paquete;
import logica.interfaces.IEnvio;
import logica.servicios.ServicioPaquete;

/**
 *
 * @author MarmaduX
 */
public class ControladorPaquete implements IEnvio {
    private static ControladorPaquete instance;
    private ServicioPaquete servicioPaq;
    
    public ControladorPaquete() {
        this.servicioPaq = new ServicioPaquete();
    }

    public static ControladorPaquete getInstancia() {
        if (instance == null) {
            instance = new ControladorPaquete();
        }
        return instance;
    }

    @Override
    public ArrayList<Envio> listaDeEnvios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Paquete> listarPaquetesPorSeccion(int idSeccion) {
        return this.servicioPaq.obtenerListaPaquetesPorSeccion(idSeccion);
    }

    public void moverPaqueteASeccion(int idPaquete, int idSeccionAMover) {
        this.servicioPaq.moverPaquteDeSeccion(idPaquete, idSeccionAMover);
    }
    
}
