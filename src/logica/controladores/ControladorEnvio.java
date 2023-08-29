/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Envio;
import logica.clases.Cliente;
import logica.clases.Localidad;
import logica.clases.Seccion;
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
    
    public Envio verDetallesDelEnvio(int idEnvio){
        Envio envio = this.servicioEnvio.obtenerDetallesEnvio(idEnvio);
        return envio;
    }

    public ArrayList<Envio> listaDeEnvios() {
        return this.servicioEnvio.listarEnvios();
    }

    public int crearPaquete(String desc, float peso, int fragil, int tipo) {
        return this.servicioEnvio.crearPaquete(desc, peso, fragil, tipo);

    }

    public void crearDireccion(String calle, String calle2, int puerta, String apartamento) {
        this.servicioEnvio.crearDireccion(calle, calle2, puerta, apartamento);

    }

    public ArrayList<Localidad> listarLocalidades() {
        return this.servicioEnvio.listarLocalidades();

    }

    public ArrayList<Seccion> listarSecciones() {
        return this.servicioEnvio.listarSecciones();

    }
    public void conexionSeccion_Paquete(int idPaquete, int idSeccion){
        this.servicioEnvio.conexionSeccion_Paquete(idPaquete, idSeccion);
    }
    public ArrayList<Cliente> listarClientesEmisor(){
    return this.servicioEnvio.listarClientesEmisor();
    }

}
