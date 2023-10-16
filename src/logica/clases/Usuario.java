/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases;

import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author MarmaduX
 */
public class Usuario {

    private String correo;
    private String contrasenia;
    private byte[] keyGen;

    public Usuario(String correo, String contrasenia,  byte[] keyGen) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.keyGen = keyGen;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public  byte[] getKeyGen() {
        return keyGen;
    }

    public void setKeyGen(byte[] keyGen) {
        this.keyGen = keyGen;
    }

}
