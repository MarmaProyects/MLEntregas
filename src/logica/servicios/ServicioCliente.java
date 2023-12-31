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
import java.util.Properties;
import java.util.logging.Level;
import logica.clases.Cliente;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import logica.clases.Envio;
import logica.clases.Estado;
import logica.clases.Usuario;
import logica.fabrica.Fabrica;

/**
 *
 * @author leo
 */
public class ServicioCliente {

    private Connection conexion = new Conexion().getConnection();
    private static final Logger LOGGER = Logger.getLogger(ServicioEnvio.class.getName());
    //Variables para enviar mail
    private Fabrica fab = Fabrica.getInstancia();
    private static String emailFrom = "mlentregasweb@gmail.com"; //Correo que envía 
    private static String passwordFrom = "zjeg ozmv kktd wjvq"; //Contraseña de aplicacion
    private Properties mProperties = new Properties();
    private Session mSession;
    private MimeMessage mCorreo;

    public boolean crearUnEmail(Cliente client, Envio envio, int idEstado) {
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);
        ArrayList<String> resp = this.generarContenido_Asunto(client, envio, idEstado);
        String asunto = resp.get(0);
        String contenido = resp.get(1);

        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(client.getCorreo()));
            mCorreo.setSubject(asunto);
            mCorreo.setContent(contenido, "text/html");
            return true;
        } catch (AddressException ex) {
            Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void enviarUnEmail() {
        Transport mTransport;
        try {
            mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<String> generarContenido_Asunto(Cliente client, Envio envio, int idEstado) {
        Estado estadoNuevo = fab.getControladorEstado().obtenerElEstado(idEstado, envio.getIdEnvio());
        ArrayList<String> asunto0_contenido1 = new ArrayList<String>();
        if (estadoNuevo.getTipo().getEstado().equals("En preparación")) {
            String asunto = "Tu orden " + envio.getCodigoRastreo() + " está en preparación.";
            String contenido = """
                            <html>
                                <head>
                                    <style>
                                        button {
                                            background-color: white;
                                            border: none;
                                            text-decoration: underline;
                                            color: blue;
                                            padding: 0px;                     
                                        }
                                        button:hover {
                                            cursor: pointer;
                                        }                 
                                    </style>
                                </head>
                                <body>
                                    Hola %s, <br>
                                    <form method="post" action="http://localhost:8081/Seguimiento">     
                                        <input type="hidden" name="codigoRastreo" value="%s" />
                                        <lable>Tu paquete</label>
                                        <button type="submit">%d</button>
                                        <lable>está en preparación.</label>
                                    </form>
                                    ¡Gracias por confiar en nosotros!
                                </body>
                            </html>
                           """.formatted(client.getNombre(), envio.getCodigoRastreo(), envio.getCodigoRastreo()).stripIndent();
            asunto0_contenido1.add(asunto);
            asunto0_contenido1.add(contenido);
        } else if (estadoNuevo.getTipo().getEstado().equals("En camino")) {
            String asunto = "Tu orden " + envio.getCodigoRastreo() + " está en camino.";
            String contenido = """
                            <html>
                                <head>
                                    <style>
                                        button {
                                            background-color: white;
                                            border: none;
                                            text-decoration: underline;
                                            color: blue;
                                            padding: 0px;                     
                                        }
                                        button:hover {
                                            cursor: pointer;
                                        }                 
                                    </style>
                                </head>
                                <body>
                                    Hola %s, <br>
                                    <form method="post" action="http://localhost:8081/Seguimiento">     
                                        <input type="hidden" name="codigoRastreo" value="%s" />
                                        <lable>Tu paquete</label>
                                        <button type="submit">%d</button>
                                        <lable>está en camino.</label>
                                    </form>
                                    Clickea en el código de rastreo para dirigirte a tu seguimiento. <br>
                                    ¡Gracias por confiar en nosotros!
                                </body>
                            </html>
                           """.formatted(client.getNombre(), envio.getCodigoRastreo(), envio.getCodigoRastreo()).stripIndent();
            asunto0_contenido1.add(asunto);
            asunto0_contenido1.add(contenido);
        } else if (estadoNuevo.getTipo().getEstado().equals("Listo para entregar")) {
            String asunto = "Tu orden " + envio.getCodigoRastreo() + " está lista para entregar.";
            String contenido = """
                            <html>
                                <head>
                                    <style>
                                        button {
                                            background-color: white;
                                            border: none;
                                            text-decoration: underline;
                                            color: blue;
                                            padding: 0px;                     
                                        }
                                        button:hover {
                                            cursor: pointer;
                                        }
                                    </style>
                                </head>
                                <body>
                                    Hola %s, <br>
                                    <form method="post" action="http://localhost:8081/Seguimiento">     
                                        <input type="hidden" name="codigoRastreo" value="%s" />
                                        <lable>Tu paquete</label>
                                        <button type="submit">%d</button>
                                        <lable>está listo para entregar.</label>
                                    </form>
                                    Clickea en el código de rastreo para dirigirte a tu seguimiento. <br>
                                    ¡Gracias por confiar en nosotros!
                                </body>
                            </html>
                           """.formatted(client.getNombre(), envio.getCodigoRastreo(), envio.getCodigoRastreo()).stripIndent();
            asunto0_contenido1.add(asunto);
            asunto0_contenido1.add(contenido);
        } else if (estadoNuevo.getTipo().getEstado().equals("Cancelado")) {
            String asunto = "Tu orden " + envio.getCodigoRastreo() + " fue cancelada.";
            String contenido = """
                           <html>
                                <head>
                                    <style>
                                        button {
                                            background-color: white;
                                            border: none;
                                            text-decoration: underline;
                                            color: blue;
                                            padding: 0px;                     
                                        }
                                        button:hover {
                                            cursor: pointer;
                                        }
                                    </style>
                                </head>
                                <body>
                                    Hola %s, <br>
                                    <form method="post" action="http://localhost:8081/Seguimiento">     
                                        <input type="hidden" name="codigoRastreo" value="%s" />
                                        <lable>Tu paquete</label>
                                        <button type="submit">%d</button>
                                        <lable>fue cancelado.</label>
                                    </form>
                                    Clickea en el código de rastreo para dirigirte a tu seguimiento. <br>
                                    ¡Gracias por confiar en nosotros!
                                </body>
                            </html>
                           """.formatted(client.getNombre(), envio.getCodigoRastreo(), envio.getCodigoRastreo()).stripIndent();
            asunto0_contenido1.add(asunto);
            asunto0_contenido1.add(contenido);
        } else {
            String asunto = "Tu orden " + envio.getCodigoRastreo() + " fue entregada.";
            String contenido = """
                           <html>
                               <head>
                                    <style>
                                        button {
                                            background-color: white;
                                            border: none;
                                            text-decoration: underline;
                                            color: blue;
                                            padding: 0px;                     
                                        }
                                        button:hover {
                                            cursor: pointer;
                                        }   
                                    </style>
                                </head>
                           <body>
                                Hola %s, <br>
                                <form method="post" action="http://localhost:8081/Seguimiento">     
                                    <input type="hidden" name="codigoRastreo" value="%s" />
                                    <lable>Tu paquete</label>
                                    <button type="submit">%d</button>
                                    <lable>fue entregado.</label>
                                </form>
                                ¡Gracias por confiar en nosotros! <br>
                                ¡Valora nuestro servicio 
                                <a href="http://localhost:8081/Valoracion?idEnvio=%d">aquí!</a>
                           </body>
                           </html>
                           """.formatted(client.getNombre(), envio.getCodigoRastreo(), envio.getCodigoRastreo(), envio.getIdEnvio()).stripIndent();
            asunto0_contenido1.add(asunto);
            asunto0_contenido1.add(contenido);
        }
        return asunto0_contenido1;  
    }

    public void cambiarNotisDeEmail(String correo, boolean notisEmail) {
        try {
            PreparedStatement queryCambiarNotisEmail = conexion.prepareStatement("UPDATE usuario SET notisEmail= " + notisEmail + " WHERE correo = '" + correo + "'");
            queryCambiarNotisEmail.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }

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

    public Cliente traerUnClientePorCorreo(String correo) {
        Cliente cliente = null;
        try {
            PreparedStatement queryTraerCliente = conexion.prepareStatement("SELECT * FROM cliente WHERE correo= '" + correo + "'");
            ResultSet resultadoCliente = queryTraerCliente.executeQuery();
            if (resultadoCliente.next()) {
                int ced = resultadoCliente.getInt("cedula");
                String nom = resultadoCliente.getString("nombre");
                String ape = resultadoCliente.getString("apellido");
                int t = resultadoCliente.getInt("telefono");
                String tel = String.valueOf(t);
                cliente = new Cliente(ced, nom, ape, tel, correo);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
        return cliente;
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

    public void editarCliente(int cedula, int cedulaVieja, String nombre, String apellido, int telefono, String correo) {
        try {
            PreparedStatement queryEditarCliente = conexion.prepareStatement("UPDATE cliente SET cedula= '" + cedula + "', nombre= '" + nombre + "',"
                    + " apellido= '" + apellido + "', telefono= '" + telefono + "', correo= '" + correo + "' WHERE cedula= '" + cedulaVieja + "'");
            queryEditarCliente.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e);
        }
    }

    public void editarUsuario(String correo, String idFoto, String correoViejo) {
        try {
            PreparedStatement queryEditarUsuario = conexion.prepareStatement("UPDATE usuario SET correo = '" + correo + "', idFoto= '"
                    + idFoto + "' WHERE correo = '" + correoViejo + "'");
            queryEditarUsuario.executeUpdate();
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
                String idFoto = resultadoUser.getString("idFoto");
                String correoBD = resultadoUser.getString("correo");
                Blob keyBlob = resultadoUser.getBlob("keyGen");
                int admin = resultadoUser.getInt("admin");
                boolean notisEmail = resultadoUser.getBoolean("notisEmail");
                int keyLength = (int) keyBlob.length();
                byte[] key = keyBlob.getBytes(1, keyLength);

                user = new Usuario(correoBD, password, key, admin, idFoto, notisEmail);
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
