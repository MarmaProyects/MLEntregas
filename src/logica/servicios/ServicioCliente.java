/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import BaseDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.clases.Cliente;
import java.util.logging.Logger;
import logica.clases.Usuario;

/**
 *
 * @author leo
 */
public class ServicioCliente {

    private Connection conexion = new Conexion().getConnection();
    private static final Logger LOGGER = Logger.getLogger(ServicioEnvio.class.getName());

    public void insertarCliente(int cedula, String nombre, String apellido, int telefono, String correo) {
        try {
            PreparedStatement query = conexion.prepareStatement("INSERT INTO `cliente` (`cedula`,`nombre`, `apellido`,`telefono`,`correo`) VALUES ('" + cedula + "','" + nombre + "', '" + apellido + "', '" + telefono + "', '" + correo + "');");
            query.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
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
                String correo = resultadoDeLaQuery.getString("correo");
                int telefono = resultadoDeLaQuery.getInt("telefono");
                resultado.add(new Cliente(ci, nombre, apellido, Integer.toString(telefono), correo));
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
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
                String correo = resultadoCliente.getString("correo");
                String tel = String.valueOf(t);
                cliente = new Cliente(ced, nom, ape, tel, correo);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return cliente;
    }

    public Cliente traerClientePorNombreApellido(String nomApe) {
        Cliente cliente = null;

        try {
            PreparedStatement queryTraerCliente = conexion.prepareStatement("SELECT * FROM cliente WHERE nombre = " + nomApe);
            ResultSet resultadoCliente = queryTraerCliente.executeQuery();
            if (resultadoCliente.next()) {
                int ced = resultadoCliente.getInt("cedula");
                String nom = resultadoCliente.getString("nombre");
                String ape = resultadoCliente.getString("apellido");
                int t = resultadoCliente.getInt("telefono");
                String correo = resultadoCliente.getString("correo");
                String tel = String.valueOf(t);
                cliente = new Cliente(ced, nom, ape, tel, correo);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }

        if (cliente == null) {
            try {
                PreparedStatement queryTraerCliente = conexion.prepareStatement("SELECT * FROM cliente WHERE apellido = " + nomApe);
                ResultSet resultadoCliente = queryTraerCliente.executeQuery();
                if (resultadoCliente.next()) {
                    int ced = resultadoCliente.getInt("cedula");
                    String nom = resultadoCliente.getString("nombre");
                    String ape = resultadoCliente.getString("apellido");
                    int t = resultadoCliente.getInt("telefono");
                    String correo = resultadoCliente.getString("correo");
                    String tel = String.valueOf(t);
                    cliente = new Cliente(ced, nom, ape, tel, correo);
                }
            } catch (SQLException e) {
                LOGGER.severe("Error: " + e);
            }
        }

        return cliente;
    }

    public void editarCliente(int cedula, String nombre, String apellido, int telefono, String correo) {
        try {
            PreparedStatement queryEditarCliente = conexion.prepareStatement("UPDATE cliente SET nombre= '" + nombre + "',"
                    + " apellido= '" + apellido + "', telefono= '" + telefono + "', correo= '" + correo + "' WHERE cedula= '" + cedula + "'");
            queryEditarCliente.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }

    public Usuario obtenerUsuario(String correo) {
        Usuario user = null;
        try {
            PreparedStatement queryObtenerUser = conexion.prepareStatement("SELECT * FROM `usuario` WHERE correo = '" + correo + "'");
            ResultSet resultadoUser = queryObtenerUser.executeQuery();
            if (resultadoUser.next()) {
                String password = resultadoUser.getString("password");
                String correoBD = resultadoUser.getString("correo");
                Blob keyBlob = resultadoUser.getBlob("keyGen");
                int admin = resultadoUser.getInt("admin");
                int keyLength = (int) keyBlob.length();
                byte[] key = keyBlob.getBytes(1, keyLength);
                user = new Usuario(correoBD, password, key, admin);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return user;
    }

    public void crearUser(String correo, String clave, byte[] key) {
        try {
            Blob blob = conexion.createBlob();
            blob.setBytes(1, key);
            
            String query = "INSERT INTO usuario (correo, password, keyGen) VALUES (?, ?, ?)";
            PreparedStatement queryCrearUser = conexion.prepareStatement(query);
            queryCrearUser.setString(1, correo);
            queryCrearUser.setString(2, clave);
            queryCrearUser.setBlob(3, blob);
            
            queryCrearUser.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }

}
