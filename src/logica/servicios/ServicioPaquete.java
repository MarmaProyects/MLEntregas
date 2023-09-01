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
import logica.clases.Paquete;
import logica.interfaces.IEnvio;

/**
 *
 * @author franc
 */
public class ServicioPaquete {

    private Connection conexion = new Conexion().getConexion();
    private IEnvio IE;

    public ArrayList<Paquete> obtenerListaPaquetesPorSeccion(int idSeccion) {
        ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
        ArrayList<Integer> idDePaquetes = new ArrayList<Integer>();
        try {
            PreparedStatement querySeccion_paquete = conexion.prepareStatement("SELECT * FROM seccion_paquete WHERE idSeccion = " + idSeccion);
            ResultSet resultadoQuerySeccion_paquete = querySeccion_paquete.executeQuery();
            while (resultadoQuerySeccion_paquete.next()) {
                int idPaquete = resultadoQuerySeccion_paquete.getInt("idPaquete");
                idDePaquetes.add(idPaquete);
            }
            for (int idPaquete : idDePaquetes) {
                try {
                    PreparedStatement query = conexion.prepareStatement("SELECT id, peso, esFragil, esEspecial, COALESCE(descripcion, ' ') AS descripcion"
                            + " FROM `paquete` WHERE id = " + idPaquete);
                    ResultSet resultadoDeLaQuery = query.executeQuery();
                    while (resultadoDeLaQuery.next()) {
                        int id = resultadoDeLaQuery.getInt("id");
                        String descripcion = resultadoDeLaQuery.getString("descripcion");
                        float peso = resultadoDeLaQuery.getFloat("peso");
                        boolean esFragil = resultadoDeLaQuery.getBoolean("esFragil");
                        boolean esEspecial = resultadoDeLaQuery.getBoolean("esEspecial");
                        paquetes.add(new Paquete(descripcion, peso, esFragil, esEspecial, idPaquete));
                    }
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return paquetes;
    }
    
    public void moverPaquteDeSeccion (int idPaquete, int idSeccionAMover) {
        try {
            PreparedStatement queryDelete= conexion.prepareStatement("DELETE FROM seccion_paquete WHERE idPaquete = " + idPaquete);
            queryDelete.executeUpdate();
            PreparedStatement queryInsert = conexion.prepareStatement("INSERT INTO seccion_paquete VALUES (" + idSeccionAMover + "," + idPaquete + ")");
            queryInsert.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
