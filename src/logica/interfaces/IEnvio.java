/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.interfaces;

import java.util.ArrayList;
import logica.clases.Envio;
import logica.clases.Cliente;
import logica.clases.Localidad;
import logica.clases.Seccion;

/**
 *
 * @author MarmaduX
 */
public interface IEnvio {
    public abstract ArrayList<Envio> listaDeEnvios() ;
    public abstract Envio verDetallesDelEnvio(int idEnvio);
    public abstract int crearPaquete(String desc, float peso, int fragil, int tipo);
    public abstract void crearDireccion(String calle, String calle2, int puerta, String apartamento);
    public abstract ArrayList<Localidad> listarLocalidades();
    public abstract ArrayList<Seccion> listarSecciones();
    public abstract void conexionSeccion_Paquete(int idPaquete, int idSeccion);
    public ArrayList<Cliente> listarClientesEmisor();
}
