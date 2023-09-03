/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import BaseDeDatos.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import logica.clases.Cliente;
import logica.clases.Localidad;
import logica.clases.Seccion;
import logica.fabrica.Fabrica;
import logica.interfaces.IEnvio;
import javax.swing.JOptionPane;
import logica.clases.Direccion;
import logica.clases.Tarifa;
import logica.interfaces.IAdministracion;

/**
 *
 * @author Angelo
 */
public class CrearEnvio extends javax.swing.JFrame {

    /**
     * Creates new form CrearEnvio
     */
    private Connection connection = new Conexion().getConnection();
    private IEnvio iEnvio; //CREO EL OBJETO INTERFAZ
    private IAdministracion iAdmin;
    private ArrayList<Seccion> listaSecciones = null;
    private ArrayList<Localidad> listaLocalidades = null;
    private ArrayList<Tarifa> listaTarifasEsp = null;
    private int idTarifa = 0;

    public void actualizarTarifasEspeciales() {
        this.limpiarTarifasEspeciales();
        this.cargarListaTarifasEspeciales();
    }

    public CrearEnvio() {
        initComponents();
        labelTipo.setVisible(false);
        checkboxEspecial.setVisible(false);
        this.iEnvio = Fabrica.getInstancia().getControladorEnvio();
        this.iAdmin = Fabrica.getInstancia().getControladorCliente();
        listaLocalidades = this.iEnvio.listarLocalidades();
        this.cargarListaLocalidades();
        listaSecciones = this.iEnvio.listarSecciones();
        this.cargarListaSecciones();
        listaTarifasEsp = this.iEnvio.obtenerTarifasEspeciales();
        this.cargarListaTarifasEspeciales();
        botonCrearTarifaEsp.setVisible(false);
        labelTarifasEspeciales.setVisible(false);
        comboTarifasEspeciales.setVisible(false);
    }

    //LISTAR OBJETOS DE TIPO SECCION
    private void cargarListaLocalidades() {
        listaLocalidades = this.iEnvio.listarLocalidades();
        for (Localidad localidad : this.listaLocalidades) {
            comboLocalidadDestino.addItem(localidad.getNombre());
            comboLocalidadOrigen.addItem(localidad.getNombre());
        }

    }

    //LISTAR OBJETOS DE TIPO SECCION
    private void cargarListaSecciones() {
        listaSecciones = this.iEnvio.listarSecciones();
        for (Seccion seccion : this.listaSecciones) {
            comboSecciones.addItem(seccion.getNombre());
        }

    }

    private void cargarListaTarifasEspeciales() {
        listaTarifasEsp = this.iEnvio.obtenerTarifasEspeciales();
        for (Tarifa tarifa : this.listaTarifasEsp) {
            comboTarifasEspeciales.addItem(tarifa.getNombre());
        }

    }

    private int obtenerIdTarifaEspecial() {
        for (Tarifa tarifaEspecial : this.listaTarifasEsp) {
            if (comboTarifasEspeciales.getSelectedItem().equals(tarifaEspecial.getNombre())) {
                idTarifa = tarifaEspecial.getIdTarifa();
                break;
            }
        }
        return idTarifa;
    }

    private void limpiarTarifasEspeciales() {
        for (Tarifa tarifa : this.listaTarifasEsp) {
            comboTarifasEspeciales.removeItem(tarifa.getNombre());
        }
    }

    private int obtenerIdTarifasNormales(float pesoPaquete) {
        if (pesoPaquete > 0 && pesoPaquete <= 5) {
            return 1;
        } else if (pesoPaquete > 5 && pesoPaquete <= 10) {
            return 2;
        } else if (pesoPaquete > 10 && pesoPaquete <= 15) {
            return 3;
        }
        return 0;
    }

    private void insertarLocalidadDireccion(int idDireccion, String nombreLocalidad) {
        int idLocalidad = 0;

//BUSCA LA LOCALIDAD SELECCIONADA EN LA LISTA DE OBJETOS LOCALIDAD
        for (Localidad localidad : listaLocalidades) {
            if (nombreLocalidad.equals(localidad.getNombre())) {
                idLocalidad = localidad.getIdLocalidad();
                break;
            }
        }

        this.iEnvio.conexionLocalidad_Direccion(idLocalidad, idDireccion);
    }

    private void insertarSeccionPaquete(int idPaquete) {
        int idSeccion = 0;
        //TOMO EL NOMBRE DE LA SECCION QUE QUIERA EL USUARIO
        String nombreSeccion;
        nombreSeccion = comboSecciones.getSelectedItem().toString();

//BUSCA LA SECCION SELECCIONADA EN LA LISTA DE OBJETOS SECCION
        for (Seccion seccion : listaSecciones) {
            if (nombreSeccion.equals(seccion.getNombre())) {
                idSeccion = seccion.getIdSeccion();
                break;
            }
        }
        this.iEnvio.conexionSeccion_Paquete(idPaquete, idSeccion);
    }

    //hacer lo mismo que el listar pero con los 9 objetos
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonCrearEnvio = new javax.swing.JButton();
        botonVolverCrearEnvio = new javax.swing.JButton();
        panelPaquete = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescPaquete = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        campoPesoPaquete = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboFragilPaquete = new javax.swing.JComboBox<>();
        labelTipo = new javax.swing.JLabel();
        comboSecciones = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        botonCrearTarifaEsp = new javax.swing.JButton();
        labelTarifasEspeciales = new javax.swing.JLabel();
        comboTarifasEspeciales = new javax.swing.JComboBox<>();
        checkboxEspecial = new javax.swing.JCheckBox();
        panelDireccionDestino = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        campoCalleDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campoCalle2Direccion = new javax.swing.JTextField();
        campoPuertaDireccion = new javax.swing.JTextField();
        campoApartDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboLocalidadDestino = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        panelClienteEmisor = new javax.swing.JPanel();
        campoCedulaE = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        campoNombreE = new javax.swing.JTextField();
        campoApellidoE = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoTelefonoE = new javax.swing.JTextField();
        panelClienteReceptor = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        campoCedulaR = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        campoNombreR = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        campoApellidoR = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoTelefonoR = new javax.swing.JTextField();
        panelDireccionOrigen = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        campoCalleDireccionO = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        campoCalle2DireccionO = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        campoPuertaDireccionO = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        campoApartDireccionO = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        comboLocalidadOrigen = new javax.swing.JComboBox<>();
        panelOrigenEnvio = new javax.swing.JPanel();
        checkSucursal = new javax.swing.JCheckBox();
        botonCancelarEnvio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("CREAR ENVIO");

        botonCrearEnvio.setText("CREAR ENVIO");
        botonCrearEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearEnvioActionPerformed(evt);
            }
        });

        botonVolverCrearEnvio.setText("Volver");
        botonVolverCrearEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverCrearEnvioActionPerformed(evt);
            }
        });

        panelPaquete.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DEL PAQUETE:"));

        campoDescPaquete.setColumns(20);
        campoDescPaquete.setRows(5);
        jScrollPane1.setViewportView(campoDescPaquete);

        jLabel4.setText("Descripción:");

        campoPesoPaquete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoPesoPaqueteFocusLost(evt);
            }
        });
        campoPesoPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPesoPaqueteActionPerformed(evt);
            }
        });
        campoPesoPaquete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPesoPaqueteKeyTyped(evt);
            }
        });

        jLabel5.setText("Peso:");

        jLabel6.setText("Fragil:");

        comboFragilPaquete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        labelTipo.setText("Tipo:");

        comboSecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSeccionesActionPerformed(evt);
            }
        });

        jLabel13.setText("Secciones:");

        botonCrearTarifaEsp.setText("Crear Tarifa Especial");
        botonCrearTarifaEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearTarifaEspActionPerformed(evt);
            }
        });

        labelTarifasEspeciales.setText("Tarifas Especiales:");

        comboTarifasEspeciales.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboTarifasEspecialesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboTarifasEspecialesFocusLost(evt);
            }
        });
        comboTarifasEspeciales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTarifasEspecialesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboTarifasEspecialesMousePressed(evt);
            }
        });
        comboTarifasEspeciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTarifasEspecialesActionPerformed(evt);
            }
        });

        checkboxEspecial.setText("Especial");
        checkboxEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxEspecialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPaqueteLayout = new javax.swing.GroupLayout(panelPaquete);
        panelPaquete.setLayout(panelPaqueteLayout);
        panelPaqueteLayout.setHorizontalGroup(
            panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPaqueteLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPaqueteLayout.createSequentialGroup()
                        .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboFragilPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPesoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPaqueteLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
            .addGroup(panelPaqueteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPaqueteLayout.createSequentialGroup()
                        .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPaqueteLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(comboSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPaqueteLayout.createSequentialGroup()
                                .addComponent(labelTarifasEspeciales)
                                .addGap(18, 18, 18)
                                .addComponent(comboTarifasEspeciales, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelPaqueteLayout.createSequentialGroup()
                        .addComponent(labelTipo)
                        .addGap(18, 18, 18)
                        .addComponent(checkboxEspecial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCrearTarifaEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        panelPaqueteLayout.setVerticalGroup(
            panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPaqueteLayout.createSequentialGroup()
                .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPaqueteLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPaqueteLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoPesoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFragilPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(39, 39, 39)
                .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipo)
                    .addComponent(botonCrearTarifaEsp)
                    .addComponent(checkboxEspecial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTarifasEspeciales)
                    .addComponent(comboTarifasEspeciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(comboSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        panelDireccionDestino.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DIRECCION DE DESTINO:"));

        jLabel8.setText("Calle:");

        jLabel9.setText("Calle2:");

        campoCalle2Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCalle2DireccionActionPerformed(evt);
            }
        });

        campoPuertaDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPuertaDireccionKeyTyped(evt);
            }
        });

        jLabel11.setText("Apartamento:");

        jLabel10.setText("N° Puerta:");

        comboLocalidadDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLocalidadDestinoActionPerformed(evt);
            }
        });

        jLabel12.setText("Localidad:");

        javax.swing.GroupLayout panelDireccionDestinoLayout = new javax.swing.GroupLayout(panelDireccionDestino);
        panelDireccionDestino.setLayout(panelDireccionDestinoLayout);
        panelDireccionDestinoLayout.setHorizontalGroup(
            panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDireccionDestinoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDireccionDestinoLayout.createSequentialGroup()
                        .addGroup(panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDireccionDestinoLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(campoCalleDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDireccionDestinoLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoCalle2Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88)
                        .addGroup(panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDireccionDestinoLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoPuertaDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDireccionDestinoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoApartDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelDireccionDestinoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboLocalidadDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDireccionDestinoLayout.setVerticalGroup(
            panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDireccionDestinoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(campoCalleDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(campoPuertaDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(campoApartDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(campoCalle2Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboLocalidadDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        panelClienteEmisor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CLIENTE EMISOR:"));

        campoCedulaE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCedulaEFocusLost(evt);
            }
        });
        campoCedulaE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCedulaEActionPerformed(evt);
            }
        });
        campoCedulaE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCedulaEKeyTyped(evt);
            }
        });

        jLabel15.setText("Cedula:");

        jLabel20.setText("Nombre:");

        jLabel21.setText("Apellido:");

        jLabel2.setText("Teléfono:");

        campoTelefonoE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefonoEKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelClienteEmisorLayout = new javax.swing.GroupLayout(panelClienteEmisor);
        panelClienteEmisor.setLayout(panelClienteEmisorLayout);
        panelClienteEmisorLayout.setHorizontalGroup(
            panelClienteEmisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteEmisorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClienteEmisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelClienteEmisorLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoApellidoE))
                    .addGroup(panelClienteEmisorLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNombreE))
                    .addGroup(panelClienteEmisorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTelefonoE, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelClienteEmisorLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCedulaE, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panelClienteEmisorLayout.setVerticalGroup(
            panelClienteEmisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteEmisorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelClienteEmisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(campoCedulaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelClienteEmisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(campoNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelClienteEmisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(campoApellidoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelClienteEmisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoTelefonoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        panelClienteReceptor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CLIENTE RECEPTOR:"));

        jLabel19.setText("Cedula:");

        campoCedulaR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCedulaRFocusLost(evt);
            }
        });
        campoCedulaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCedulaRActionPerformed(evt);
            }
        });
        campoCedulaR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCedulaRKeyTyped(evt);
            }
        });

        jLabel16.setText("Nombre:");

        jLabel17.setText("Apellido:");

        jLabel3.setText("Teléfono:");

        campoTelefonoR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefonoRKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelClienteReceptorLayout = new javax.swing.GroupLayout(panelClienteReceptor);
        panelClienteReceptor.setLayout(panelClienteReceptorLayout);
        panelClienteReceptorLayout.setHorizontalGroup(
            panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteReceptorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelClienteReceptorLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(campoCedulaR, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelClienteReceptorLayout.createSequentialGroup()
                        .addGroup(panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoApellidoR, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombreR, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelClienteReceptorLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoTelefonoR)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelClienteReceptorLayout.setVerticalGroup(
            panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteReceptorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(campoCedulaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClienteReceptorLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(campoNombreR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelClienteReceptorLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoApellidoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoTelefonoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        panelDireccionOrigen.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DIRECCION DE ORIGEN:"));

        jLabel14.setText("Calle:");

        campoCalleDireccionO.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoCalleDireccionOFocusGained(evt);
            }
        });
        campoCalleDireccionO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCalleDireccionOActionPerformed(evt);
            }
        });

        jLabel18.setText("Calle2:");

        campoCalle2DireccionO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCalle2DireccionOActionPerformed(evt);
            }
        });

        jLabel22.setText("N° Puerta:");

        campoPuertaDireccionO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPuertaDireccionOActionPerformed(evt);
            }
        });
        campoPuertaDireccionO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPuertaDireccionOKeyTyped(evt);
            }
        });

        jLabel23.setText("Apartamento:");

        jLabel25.setText("Localidad:");

        javax.swing.GroupLayout panelDireccionOrigenLayout = new javax.swing.GroupLayout(panelDireccionOrigen);
        panelDireccionOrigen.setLayout(panelDireccionOrigenLayout);
        panelDireccionOrigenLayout.setHorizontalGroup(
            panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDireccionOrigenLayout.createSequentialGroup()
                .addGroup(panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDireccionOrigenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDireccionOrigenLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoCalleDireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDireccionOrigenLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCalle2DireccionO)))
                        .addGap(42, 42, 42)
                        .addGroup(panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoPuertaDireccionO)
                            .addComponent(campoApartDireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDireccionOrigenLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboLocalidadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDireccionOrigenLayout.setVerticalGroup(
            panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDireccionOrigenLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDireccionOrigenLayout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addGap(31, 31, 31)
                            .addComponent(jLabel23))
                        .addGroup(panelDireccionOrigenLayout.createSequentialGroup()
                            .addGroup(panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(campoCalleDireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(23, 23, 23)
                            .addGroup(panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(campoCalle2DireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelDireccionOrigenLayout.createSequentialGroup()
                        .addComponent(campoPuertaDireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campoApartDireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(comboLocalidadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        panelOrigenEnvio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ORIGEN DE ENVIO:"));

        checkSucursal.setText("Sucursal");
        checkSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSucursalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOrigenEnvioLayout = new javax.swing.GroupLayout(panelOrigenEnvio);
        panelOrigenEnvio.setLayout(panelOrigenEnvioLayout);
        panelOrigenEnvioLayout.setHorizontalGroup(
            panelOrigenEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrigenEnvioLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(checkSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelOrigenEnvioLayout.setVerticalGroup(
            panelOrigenEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOrigenEnvioLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(checkSucursal)
                .addGap(15, 15, 15))
        );

        botonCancelarEnvio.setText("CANCELAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonVolverCrearEnvio)
                        .addGap(298, 298, 298)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(panelPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panelDireccionDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelDireccionOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(panelOrigenEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(panelClienteEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(43, 43, 43)
                                    .addComponent(panelClienteReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonCancelarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(botonCrearEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonVolverCrearEnvio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDireccionDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(panelOrigenEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(panelDireccionOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelClienteReceptor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelClienteEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonCancelarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCrearEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPesoPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesoPaqueteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPesoPaqueteActionPerformed

    private void botonCrearEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearEnvioActionPerformed
//---------CREACION DEL PAQUETE-----------------------------------------------------------------------------------------------------------------------
        // VERFICACION PARA EL PAQUETE
        int fragil = 0, especial = 0, idSeccion = 0, idLocalidadDestino = 0, idLocalidadOrigen = 0, idDireccionOrigen = 0, idDireccionDestino = 0;
        boolean tipoEntrega;

        if (comboFragilPaquete.getSelectedItem().toString() == "Si") {
            fragil = 1;
        }
        if (checkboxEspecial.isSelected()) {
            especial = 1;
        }
        int idP = this.iEnvio.crearPaquete(campoDescPaquete.getText(), Float.parseFloat(campoPesoPaquete.getText()),
                fragil, especial);

//--------CREACION DE LA DIRECCION DESTINO---------------------------------------------------------------------------------------------------------
        idDireccionDestino = this.iEnvio.crearDireccion(campoCalleDireccion.getText(), campoCalle2Direccion.getText(),
                Integer.parseInt(campoPuertaDireccion.getText()), campoApartDireccion.getText());
        //IDLOCALIDADDESTINO
//----------CREACION DE LA DIRECCION SUCURSAL-----------------------------------------------------------------------------------------------
        if (checkSucursal.isSelected()) {
            Direccion sucursal = this.iEnvio.traerDireccionSucursal();
            idDireccionOrigen = sucursal.getIdDireccion();

        } else {
//------CREACION DE LA DIRECCION ORIGEN-----------------------------------------------------------------------------------------------------
            idDireccionOrigen = this.iEnvio.crearDireccion(campoCalleDireccionO.getText(), campoCalle2DireccionO.getText(),
                    Integer.parseInt(campoPuertaDireccionO.getText()), campoApartDireccionO.getText());
            this.insertarLocalidadDireccion(idDireccionOrigen, comboLocalidadOrigen.getSelectedItem().toString());
        }
//----------------SECCION-PAQUETE------------------------------------------------------------------------------------------
        this.insertarSeccionPaquete(idP);
//-----------------------------------------------------------------------------------------------------------------------------
        this.insertarLocalidadDireccion(idDireccionDestino, comboLocalidadDestino.getSelectedItem().toString());
//----------------------------------------------------------------------------------------------------------------------------
        //ENVIO

        int idEnvio = this.iEnvio.crearEnvio(idP, idTarifa, idDireccionOrigen, idDireccionDestino, -1);
        System.out.println(" " + idTarifa);

//----------CLIENTES-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        if (!this.iAdmin.verificarExisteClienteNuevo(Integer.parseInt(campoCedulaE.getText()))) {
            this.iAdmin.agregarCliente(Integer.parseInt(campoCedulaE.getText()), campoNombreE.getText(),
                    campoApellidoE.getText(), Integer.parseInt(campoTelefonoE.getText()));
        }
        if (!this.iAdmin.verificarExisteClienteNuevo(Integer.parseInt(campoCedulaR.getText()))) {
            this.iAdmin.agregarCliente(Integer.parseInt(campoCedulaR.getText()),
                    campoNombreR.getText(), campoApellidoR.getText(),
                    Integer.parseInt(campoTelefonoR.getText().trim()));
        }
//-----CONEXION ENVIO Y CLIENTE------------------------------------------------------------------------------------
        this.iEnvio.conexionEnvio_Cliente(idEnvio, Integer.parseInt(campoCedulaE.getText()), "Envio");
        this.iEnvio.conexionEnvio_Cliente(idEnvio, Integer.parseInt(campoCedulaR.getText()), "Recibe");
//---CONEXION ENVIO Y ESTADO-------------------------------------------------------------------------------------

        this.iEnvio.crearEstado(idEnvio, "Preparando", "Creacion del envio");

        JOptionPane.showMessageDialog(null, "El envio fue ingresado con éxito", "Success", JOptionPane.DEFAULT_OPTION);


    }//GEN-LAST:event_botonCrearEnvioActionPerformed

    private void campoCalle2DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCalle2DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCalle2DireccionActionPerformed

    private void comboSeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSeccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSeccionesActionPerformed

    private void botonVolverCrearEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverCrearEnvioActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_botonVolverCrearEnvioActionPerformed

    private void campoCedulaEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCedulaEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCedulaEActionPerformed

    private void campoCedulaEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCedulaEFocusLost
        // TODO add your handling code here:

        Cliente cliente = !campoCedulaE.getText().isBlank()
                ? this.iEnvio.traerCliente(Integer.parseInt(campoCedulaE.getText())) : null;
        if (cliente != null) {
            campoCedulaE.setText(String.valueOf(cliente.getCedula()));
            campoNombreE.setText(cliente.getNombre());
            campoApellidoE.setText(cliente.getApellido());
            campoTelefonoE.setText(cliente.getTelefono());
        } else {
            campoNombreE.setText(" ");
            campoApellidoE.setText(" ");
            campoTelefonoE.setText(" ");
        }

    }//GEN-LAST:event_campoCedulaEFocusLost

    private void campoCedulaRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCedulaRFocusLost
        // TODO add your handling code here:
        Cliente cliente = !campoCedulaR.getText().isBlank()
                ? this.iEnvio.traerCliente(Integer.parseInt(campoCedulaR.getText())) : null;
        if (cliente != null) {
            campoCedulaR.setText(String.valueOf(cliente.getCedula()));
            campoNombreR.setText(cliente.getNombre());
            campoApellidoR.setText(cliente.getApellido());
            campoTelefonoR.setText(cliente.getTelefono());
        } else {
            campoNombreR.setText(" ");
            campoApellidoR.setText(" ");
            campoTelefonoR.setText(" ");
        }
    }//GEN-LAST:event_campoCedulaRFocusLost

    private void checkSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSucursalActionPerformed
        // TODO add your handling code here:
        if (checkSucursal.isSelected()) {
            campoCalleDireccionO.setEnabled(false);
            campoCalleDireccionO.setText(" ");
            campoCalle2DireccionO.setEnabled(false);
            campoCalle2DireccionO.setText(" ");
            campoPuertaDireccionO.setEnabled(false);
            campoPuertaDireccionO.setText(" ");
            campoApartDireccionO.setEnabled(false);
            campoApartDireccionO.setText(" ");
            comboLocalidadOrigen.setEnabled(false);
        } else {
            campoCalleDireccionO.setEnabled(true);
            campoCalle2DireccionO.setEnabled(true);
            campoPuertaDireccionO.setEnabled(true);
            campoApartDireccionO.setEnabled(true);

        }
    }//GEN-LAST:event_checkSucursalActionPerformed

    private void campoCalleDireccionOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCalleDireccionOActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_campoCalleDireccionOActionPerformed

    private void campoCalleDireccionOFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCalleDireccionOFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_campoCalleDireccionOFocusGained

    private void campoCalle2DireccionOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCalle2DireccionOActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_campoCalle2DireccionOActionPerformed

    private void campoPesoPaqueteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesoPaqueteKeyTyped
        // TODO add your handling code here:
        //METODO PARA NO ACEPTAR LA ENTRADA DE LETRAS
        int key = evt.getKeyChar();

        if (!Character.isDigit(key) && key != '.' || key == '.' && campoPesoPaquete.getText().contains(".")) {
            evt.consume();
        }

    }//GEN-LAST:event_campoPesoPaqueteKeyTyped

    private void campoPuertaDireccionOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPuertaDireccionOActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_campoPuertaDireccionOActionPerformed

    private void campoPuertaDireccionOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPuertaDireccionOKeyTyped
        // TODO add your handling code here:
        //METODO PARA NO ACEPTAR LA ENTRADA DE LETRAS
        int key = evt.getKeyChar();

        if (!Character.isDigit(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_campoPuertaDireccionOKeyTyped

    private void campoPuertaDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPuertaDireccionKeyTyped
        // TODO add your handling code here:
        //METODO PARA NO ACEPTAR LA ENTRADA DE LETRAS
        int key = evt.getKeyChar();

        if (!Character.isDigit(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_campoPuertaDireccionKeyTyped

    private void campoCedulaEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCedulaEKeyTyped
        // TODO add your handling code here:
        //METODO PARA NO ACEPTAR LA ENTRADA DE LETRAS
        int key = evt.getKeyChar();

        if (!Character.isDigit(key) || campoCedulaE.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_campoCedulaEKeyTyped

    private void campoCedulaRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCedulaRKeyTyped
        // TODO add your handling code here:
        //METODO PARA NO ACEPTAR LA ENTRADA DE LETRAS
        int key = evt.getKeyChar();

        if (!Character.isDigit(key) || campoCedulaR.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_campoCedulaRKeyTyped

    private void campoTelefonoEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefonoEKeyTyped
        // TODO add your handling code here:
        //METODO PARA NO ACEPTAR LA ENTRADA DE LETRAS
        int key = evt.getKeyChar();

        if (!Character.isDigit(key) || campoTelefonoE.getText().length() >= 9) {
            evt.consume();
        }
    }//GEN-LAST:event_campoTelefonoEKeyTyped

    private void campoTelefonoRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefonoRKeyTyped
        // TODO add your handling code here:
        //METODO PARA NO ACEPTAR LA ENTRADA DE LETRAS
        int key = evt.getKeyChar();

        if (!Character.isDigit(key) || campoTelefonoR.getText().length() >= 9) {
            evt.consume();
        }
    }//GEN-LAST:event_campoTelefonoRKeyTyped

    private void botonCrearTarifaEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearTarifaEspActionPerformed
        // TODO add your handling code here:
        CrearTarifa Vcreartarifa = new CrearTarifa(this);
        Vcreartarifa.setVisible(true);
    }//GEN-LAST:event_botonCrearTarifaEspActionPerformed

    private void comboTarifasEspecialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTarifasEspecialesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTarifasEspecialesActionPerformed

    private void comboTarifasEspecialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTarifasEspecialesMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_comboTarifasEspecialesMouseClicked

    private void comboTarifasEspecialesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboTarifasEspecialesFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_comboTarifasEspecialesFocusGained

    private void comboTarifasEspecialesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTarifasEspecialesMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTarifasEspecialesMousePressed

    private void checkboxEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxEspecialActionPerformed
        // TODO add your handling code here:
        float peso = Float.parseFloat(campoPesoPaquete.getText());
        if (checkboxEspecial.isSelected() && peso > 15) {
            botonCrearTarifaEsp.setVisible(true);
            labelTarifasEspeciales.setVisible(true);
            comboTarifasEspeciales.setVisible(true);
        } else {
            botonCrearTarifaEsp.setVisible(false);
            labelTarifasEspeciales.setVisible(false);
            comboTarifasEspeciales.setVisible(false);
        }
    }//GEN-LAST:event_checkboxEspecialActionPerformed

    private void campoPesoPaqueteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesoPaqueteFocusLost
        // TODO add your handling code here:
        if (!campoPesoPaquete.getText().isBlank()) {
            float peso = Float.parseFloat(campoPesoPaquete.getText());

            if (peso > 15) {
                labelTipo.setVisible(true);
                checkboxEspecial.setVisible(true);
                checkboxEspecial.doClick();
            } else {
                labelTipo.setVisible(false);
                checkboxEspecial.setVisible(false);
                checkboxEspecial.doClick();
                botonCrearTarifaEsp.setVisible(false);
                labelTarifasEspeciales.setVisible(false);
                comboTarifasEspeciales.setVisible(false);
                idTarifa = this.obtenerIdTarifasNormales(peso);

            }
        }
    }//GEN-LAST:event_campoPesoPaqueteFocusLost

    private void comboLocalidadDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLocalidadDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboLocalidadDestinoActionPerformed

    private void campoCedulaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCedulaRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCedulaRActionPerformed

    private void comboTarifasEspecialesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboTarifasEspecialesFocusLost
        // TODO add your handling code here:
        idTarifa = this.obtenerIdTarifaEspecial();
    }//GEN-LAST:event_comboTarifasEspecialesFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearEnvio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarEnvio;
    private javax.swing.JButton botonCrearEnvio;
    private javax.swing.JButton botonCrearTarifaEsp;
    private javax.swing.JButton botonVolverCrearEnvio;
    private javax.swing.JTextField campoApartDireccion;
    private javax.swing.JTextField campoApartDireccionO;
    public static javax.swing.JTextField campoApellidoE;
    private javax.swing.JTextField campoApellidoR;
    private javax.swing.JTextField campoCalle2Direccion;
    private javax.swing.JTextField campoCalle2DireccionO;
    private javax.swing.JTextField campoCalleDireccion;
    private javax.swing.JTextField campoCalleDireccionO;
    public static javax.swing.JTextField campoCedulaE;
    private javax.swing.JTextField campoCedulaR;
    private javax.swing.JTextArea campoDescPaquete;
    public static javax.swing.JTextField campoNombreE;
    private javax.swing.JTextField campoNombreR;
    private javax.swing.JTextField campoPesoPaquete;
    private javax.swing.JTextField campoPuertaDireccion;
    private javax.swing.JTextField campoPuertaDireccionO;
    public static javax.swing.JTextField campoTelefonoE;
    private javax.swing.JTextField campoTelefonoR;
    private javax.swing.JCheckBox checkSucursal;
    private javax.swing.JCheckBox checkboxEspecial;
    private javax.swing.JComboBox<String> comboFragilPaquete;
    private javax.swing.JComboBox<String> comboLocalidadDestino;
    private javax.swing.JComboBox<String> comboLocalidadOrigen;
    private javax.swing.JComboBox<String> comboSecciones;
    private javax.swing.JComboBox<String> comboTarifasEspeciales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTarifasEspeciales;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JPanel panelClienteEmisor;
    private javax.swing.JPanel panelClienteReceptor;
    private javax.swing.JPanel panelDireccionDestino;
    private javax.swing.JPanel panelDireccionOrigen;
    private javax.swing.JPanel panelOrigenEnvio;
    private javax.swing.JPanel panelPaquete;
    // End of variables declaration//GEN-END:variables
}
