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
    private String idFoto;
    private byte[] keyGen;
    private int admin;

    public Usuario(String correo, String contrasenia, byte[] keyGen, int admin, String idFoto) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.keyGen = keyGen;
        this.admin = admin;
        this.idFoto = idFoto;
    }

    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
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

    public byte[] getKeyGen() {
        return keyGen;
    }

    public void setKeyGen(byte[] keyGen) {
        this.keyGen = keyGen;
    }

}
