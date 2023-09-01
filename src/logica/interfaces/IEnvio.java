/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.interfaces;

import java.util.ArrayList;
import logica.clases.Envio;
import logica.clases.Paquete;

/**
 *
 * @author MarmaduX
 */
public interface IEnvio {
    public abstract ArrayList<Envio> listaDeEnvios();
    public abstract ArrayList<Paquete> listarPaquetesPorSeccion(int idSeccion);
    public abstract void moverPaqueteASeccion(int idPaquete, int idSeccionAMover);
}
