/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Envio;
import logica.clases.Paquete;
import logica.interfaces.IEnvio;
import logica.servicios.ServicioEnvio;

/**
 *
 * @author MarmaduX
 */
public class ControladorEnvio implements IEnvio {
    private static ControladorEnvio instance;
    private ServicioEnvio servicioEnvio;

    public ControladorEnvio() {
        this.servicioEnvio = new ServicioEnvio();
    }

    public static ControladorEnvio getInstancia() {
        if (instance == null) {
            instance = new ControladorEnvio();
        }
        return instance;
    }

    @Override
    public ArrayList<Envio> listaDeEnvios() {
        return this.servicioEnvio.listarEnvios();
    }

    @Override
    public ArrayList<Paquete> listarPaquetesPorSeccion(int idSeccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moverPaqueteASeccion(int idPaquete, int idSeccionAMover) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
