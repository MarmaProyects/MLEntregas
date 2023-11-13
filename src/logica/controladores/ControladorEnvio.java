/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.clases.Envio;
import logica.clases.Paquete;
import logica.clases.Cliente;
import logica.clases.Direccion;
import logica.clases.Estado;
import logica.clases.Localidad;
import logica.clases.Seccion;
import logica.clases.Tarifa;
import logica.dataTypes.TipoEstado;
import logica.fabrica.Fabrica;
import logica.interfaces.IEnvio;
import logica.servicios.ServicioEnvio;

/**
 *
 * @author MarmaduX
 */
public class ControladorEnvio implements IEnvio {

    private static ControladorEnvio instance;
    private ServicioEnvio servicioEnvio;
    private Fabrica fab;

    public ControladorEnvio() {
        this.servicioEnvio = new ServicioEnvio();
    }

    public static ControladorEnvio getInstancia() {
        if (instance == null) {
            instance = new ControladorEnvio();
        }
        return instance;
    }
    
    public ArrayList<Envio> listarEnviosPorCorreo(String correo) {
        ArrayList<Envio> resultado = new ArrayList<Envio>();
        ArrayList<Envio> envios = this.servicioEnvio.listarEnviosSinRepetir();
        for (int i = 0; i < envios.size(); i++) {
            if ((envios.get(i).getClienteEmisor().getCorreo().equals(correo)) || (envios.get(i).getClienteReceptor().getCorreo().equals(correo))) {
                resultado.add(envios.get(i));
            }
        }
        return resultado;
    }   
    
    public Envio verDetallesDelEnvio(int idEnvio) {
        Envio envio = this.servicioEnvio.obtenerDetallesEnvio(idEnvio);
        return envio;
    }

    public ArrayList<Envio> listaDeEnvios() {
        return this.servicioEnvio.listarEnvios();
    }
    
    public ArrayList<Envio> listaDeEnviosSinRepetir() {
        return this.servicioEnvio.listarEnviosSinRepetir();
    }

    public ArrayList<Envio> listaDeEnviosEnCamino() {
        ArrayList<Envio> envios = this.servicioEnvio.listarEnviosSinRepetir();
        ArrayList<Envio> enviosEnCamino = new ArrayList<>();;
        Boolean estaEnCamino = false;
        for (Envio envio : envios) {
            ArrayList<Estado> estados = envio.getEstados();
            for (Estado estado : estados) {
                if (estado.getTipo() == TipoEstado.EnCamino) {
                    estaEnCamino = true;
                }
                else {
                    estaEnCamino = false;
                }
            }
            if (estaEnCamino == true) {
                enviosEnCamino.add(envio);
            }
        }
        return enviosEnCamino;
    }

    public void editarEnvio(int idEnvio, int idTarifa, int idDirOrigen, int idDirDestino, int idPago) {
        this.servicioEnvio.editarUnEnvio(idEnvio, idTarifa, idDirOrigen, idDirDestino, idPago);
    }

    @Override
    public ArrayList<Paquete> listarPaquetesPorSeccion(int idSeccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moverPaqueteASeccion(int idPaquete, int idSeccionAMover) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int crearPaquete(String desc, float peso, int fragil, int tipo) {
        return this.servicioEnvio.crearUnPaquete(desc, peso, fragil, tipo);

    }

    public int crearDireccion(String calle, String calle2, int puerta, String apartamento) {
        return this.servicioEnvio.crearUnaDireccion(calle, calle2, puerta, apartamento);

    }

    public ArrayList<Localidad> listarLocalidades() {
        return this.servicioEnvio.listarLasLocalidades();

    }

    public ArrayList<Seccion> listarSecciones() {
        return this.servicioEnvio.listarLasSecciones();

    }

    public void conexionSeccion_Paquete(int idPaquete, int idSeccion) {
        this.servicioEnvio.crearSeccion_Paquete(idPaquete, idSeccion);
    }

    public ArrayList<Cliente> listarClientes() {
        return this.servicioEnvio.listarLosClientes();
    }

    public Cliente traerCliente(int cedula) {
        return this.servicioEnvio.traerUnCliente(cedula);
    }

    public Direccion traerDireccionSucursal() {
        return this.servicioEnvio.traerUnaDireccionSucursal();
    }

    public ArrayList<Tarifa> obtenerTarifasEspeciales() {
        return this.servicioEnvio.obtenerLasTarifasEspeciales();
    }

    public Localidad traerIdLocalidadSucursal() {
        return this.servicioEnvio.traerLocalidadSucursal();
    }

    public void conexionLocalidad_Direccion(int idLocalidad, int idDireccion) {
        this.servicioEnvio.crearLocalidad_Direccion(idLocalidad, idDireccion);
    }

    public int crearEnvio(int idPaquete, int idTarifa, int idDireOrigen, int idDireDestino, int idPago, int codigoR) {
        return this.servicioEnvio.crearUnEnvio(idPaquete, idTarifa, idDireOrigen, idDireDestino, idPago, codigoR);
    }

    public void conexionEnvio_Cliente(int idEnvio, int cedulaCliente, String tipoEntrega) {
        this.servicioEnvio.crearEnvio_Cliente(idEnvio, cedulaCliente, tipoEntrega);
    }

    public void conexionEnvio_Estado(int idEnvio, int idEstado) {
        this.servicioEnvio.crearEnvio_Estado(idEnvio, idEstado);
    }

    public int crearEstado(int idEnvio, String tipo, String comentario) {
        return this.servicioEnvio.crearUnEstado(idEnvio, tipo, comentario);
    }

    public Envio obtenerCodigoRastreo(int codigoR) {
        return this.servicioEnvio.obtenerUnCodigoRastreo(codigoR);
    }

    @Override
    public Estado obtenerElEstado(int idEstado, int idEnvio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarPaquete(int idPaquete, float peso, String descripcion, int esFragil, int esEspecial) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarDireccion(int idDireccion, String calle1, String calle2, String apartamento, int nroPuerta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Direccion traerDireccion(int idDireccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Paquete traerPaquete(int idPaquete) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Envio> listarEnviosFechaSeleccionadas(String fechaInicio, String fechaFinal) {
        return this.servicioEnvio.listarEnviosFecha(fechaInicio, fechaFinal);
    }

    @Override
    public ArrayList<Paquete> obtenerPaquetesNoAsociados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Direccion> traerDirecciones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Envio obtenerEnvioPaquete(int idPaquete) {
        return this.servicioEnvio.obtenerEnvioDeUnPaquete(idPaquete);
    }

}
