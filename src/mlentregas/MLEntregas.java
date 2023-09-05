/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mlentregas;

import Presentacion.AutenticacionUsuario;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.logging.Logger;
import logica.servicios.ServicioEstado;

/**
 *
 * @author MarmaduX
 */
public class MLEntregas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
           FlatDarkLaf.setup();
        } catch(Exception ex){
            Logger.getLogger("Error:" + ex);
        }
        AutenticacionUsuario autenticacion = new AutenticacionUsuario();
        autenticacion.setVisible(true);
        
    }
}
