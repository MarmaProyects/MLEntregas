/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Envio;
import logica.interfaces.IEnvio;

/**
 *
 * @author MarmaduX
 */
public class ControladorDireccion implements IEnvio {
    private static ControladorDireccion instance;

    public ControladorDireccion() {
    }

    public static ControladorDireccion getInstancia() {
        if (instance == null) {
            instance = new ControladorDireccion();
        }
        return instance;
    }

    @Override
    public ArrayList<Envio> listaDeEnvios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Envio verDetallesDelEnvio(int idEnvio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
