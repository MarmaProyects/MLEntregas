/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import BaseDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.clases.Cliente;

/**
 *
 * @author leo
 */
public class ServicioCliente {

    private Connection conexion = new Conexion().getConnection();

    public void insertarCliente(int cedula, String nombre, String apellido, int telefono) {
        try {
            PreparedStatement query = conexion.prepareStatement("INSERT INTO `cliente` (`cedula`,`nombre`, `apellido`,`telefono`) VALUES ('" + cedula + "','" + nombre + "', '" + apellido + "', '" + telefono + "');");
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public ArrayList<Cliente> obtenerCliente() {
        ArrayList<Cliente> resultado = new ArrayList<Cliente>();
        try {

            PreparedStatement query = conexion.prepareStatement("SELECT * FROM Cliente");
            ResultSet resultadoDeLaQuery = query.executeQuery();
            while (resultadoDeLaQuery.next()) {
                int ci = resultadoDeLaQuery.getInt("cedula");
                String nombre = resultadoDeLaQuery.getString("nombre");
                String apellido = resultadoDeLaQuery.getString("apellido");
                int telefono = resultadoDeLaQuery.getInt("telefono");
                resultado.add(new Cliente(ci, nombre, apellido, Integer.toString(telefono)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return resultado;
    }

    public Cliente traerCliente(int cedula) {

        Cliente cliente = null;

        try {
            PreparedStatement queryTraerCliente = conexion.prepareStatement("SELECT * FROM cliente WHERE cedula= " + cedula);
            ResultSet resultadoCliente = queryTraerCliente.executeQuery();
            if (resultadoCliente.next()) {
                int ced = resultadoCliente.getInt("cedula");
                String nom = resultadoCliente.getString("nombre");
                String ape = resultadoCliente.getString("apellido");
                int t = resultadoCliente.getInt("telefono");
                String tel = String.valueOf(t);
                cliente = new Cliente(ced, nom, ape, tel);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Error traer cliente:");
        }
        return cliente;
    }

    public void editarCliente(int cedula, String nombre, String apellido, int telefono) {
        try {
            PreparedStatement queryEditarCliente = conexion.prepareStatement("UPDATE cliente SET nombre= '" + nombre + "',"
                    + " apellido= '" + apellido + "', telefono= '" + telefono + "' WHERE cedula= '" + cedula + "'");
            queryEditarCliente.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se editó el cliente correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "No se logró actualizar los datos");
        }
    }
}
