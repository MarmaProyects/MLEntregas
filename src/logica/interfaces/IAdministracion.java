/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.interfaces;

import java.util.ArrayList;
import logica.clases.Tarifa;

/**
 *
 * @author MarmaduX
 */
public interface IAdministracion {
    public ArrayList<Tarifa> listarTarifas();
    public void crearTarifa(String nombre, float precioBase);
}
