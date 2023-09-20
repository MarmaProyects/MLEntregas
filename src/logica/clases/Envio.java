/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases;

import java.util.ArrayList;


/**
 *
 * @author MarmaduX
 */
public class Envio {
    private int idEnvio;
    private int codigoRastreo;
    private Direccion direccionDestino, direccionOrigen;
    private Tarifa tarifa;
    private Paquete paquete;
    private Cliente clienteEmisor, clienteReceptor;
    private Pago pago;
    private ArrayList<Estado> estados; 

    public Envio(int idEnvio, Direccion direccionDestino, Direccion direccionOrigen, 
            Tarifa tarifa, Paquete paquete, Cliente clienteEmisor, Cliente clienteReceptor, 
            Pago pago, ArrayList<Estado> estados, int codigoRastreo) {
        this.idEnvio = idEnvio;
        this.codigoRastreo = codigoRastreo;
        this.direccionDestino = direccionDestino;
        this.direccionOrigen = direccionOrigen;
        this.tarifa = tarifa;
        this.paquete = paquete;
        this.clienteEmisor = clienteEmisor;
        this.clienteReceptor = clienteReceptor;
        this.pago = pago;
        this.estados = estados;
    }

    public int getCodigoRastreo() {
        return codigoRastreo;
    }

    public void setCodigoRastreo(int codigoRastreo) {
        this.codigoRastreo = codigoRastreo;
    }

    
    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Direccion getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(Direccion direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public Direccion getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(Direccion direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Cliente getClienteEmisor() {
        return clienteEmisor;
    }

    public void setClienteEmisor(Cliente clienteEmisor) {
        this.clienteEmisor = clienteEmisor;
    }

    public Cliente getClienteReceptor() {
        return clienteReceptor;
    }

    public void setClienteReceptor(Cliente clienteReceptor) {
        this.clienteReceptor = clienteReceptor;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }
    
    
    
    public void añadirEstado(Estado estado){
        this.estados.add(estado);
    }
      
    public void quitarEstado(Estado estado){
        this.estados.remove(estado);
    }
    
}