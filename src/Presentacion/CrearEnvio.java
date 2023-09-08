/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import logica.clases.Cliente;
import logica.clases.Localidad;
import logica.clases.Seccion;
import logica.fabrica.Fabrica;
import logica.interfaces.IEnvio;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
    private final IEnvio iE;
    private final IAdministracion iA;
    private final IAdministracion iAP;
    private ArrayList<Seccion> listaSecciones = null;
    private ArrayList<Localidad> listaLocalidades = null;
    private ArrayList<Tarifa> listaTarifasEsp = null;
    private int idTarifa = 0;

    public CrearEnvio() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("MLEntregas");
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Images/logo.png")).getImage());
        this.setResizable(false);
        labelTipo.setVisible(false);
        checkboxEspecial.setVisible(false);
        this.iE = Fabrica.getInstancia().getControladorEnvio();
        this.iA = Fabrica.getInstancia().getControladorCliente();
        this.iAP = Fabrica.getInstancia().getControladorPago();
        listaLocalidades = this.iE.listarLocalidades();
        this.cargarListaLocalidades();
        listaSecciones = this.iE.listarSecciones();
        this.cargarListaSecciones();
        listaTarifasEsp = this.iE.obtenerTarifasEspeciales();
        this.cargarListaTarifasEspeciales();
        botonCrearTarifaEsp.setVisible(false);
        labelTarifasEspeciales.setVisible(false);
        comboTarifasEspeciales.setVisible(false);
    }

    public void actualizarTarifasEspeciales() {
        this.limpiarTarifasEspeciales();
        this.cargarListaTarifasEspeciales();
    }

    //LISTAR OBJETOS DE TIPO SECCION
    private void cargarListaLocalidades() {
        listaLocalidades = this.iE.listarLocalidades();
        for (Localidad localidad : this.listaLocalidades) {
            comboLocalidadDestino.addItem(localidad.getNombre());
            comboLocalidadOrigen.addItem(localidad.getNombre());
        }

    }

    //LISTAR OBJETOS DE TIPO SECCION
    private void cargarListaSecciones() {
        listaSecciones = this.iE.listarSecciones();
        for (Seccion seccion : this.listaSecciones) {
            comboSecciones.addItem(seccion.getNombre());
        }

    }

    private void cargarListaTarifasEspeciales() {
        listaTarifasEsp = this.iE.obtenerTarifasEspeciales();
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
        } else {
            return 3;
        }
    }
    
    private int obtenerLocalidad(String nombrelocalidad){
        for (Localidad localidad : listaLocalidades) {
            if (nombrelocalidad.equals(localidad.getNombre())) {
                return localidad.getIdLocalidad();
            }
        }
        return 0;
    }
    
    private void insertarLocalidadDireccion(int idDireccion, String nombreLocalidad) {
        int idLocalidad = obtenerLocalidad(nombreLocalidad);
        this.iE.conexionLocalidad_Direccion(idLocalidad, idDireccion);
    }

    private void insertarSeccionPaquete(int idPaquete) {
        int idSeccion = 0;
        String nombreSeccion;
        nombreSeccion = comboSecciones.getSelectedItem().toString();
        for (Seccion seccion : listaSecciones) {
            if (nombreSeccion.equals(seccion.getNombre())) {
                idSeccion = seccion.getIdSeccion();
                break;
            }
        }
        this.iE.conexionSeccion_Paquete(idPaquete, idSeccion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanelGeneral = new javax.swing.JScrollPane();
        panelGeneral = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        botonCrearEnvio = new javax.swing.JButton();
        panelPaquete = new javax.swing.JPanel();
        panelFragil = new javax.swing.JPanel();
        labelFragil = new javax.swing.JLabel();
        checkBoxFragil = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        labelPeso = new javax.swing.JLabel();
        campoPesoPaquete = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        scrollPaneDescrp = new javax.swing.JScrollPane();
        campoDescPaquete = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        labelSecciones = new javax.swing.JLabel();
        comboSecciones = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        labelTarifasEspeciales = new javax.swing.JLabel();
        comboTarifasEspeciales = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        botonCrearTarifaEsp = new javax.swing.JButton();
        labelTipo = new javax.swing.JLabel();
        checkboxEspecial = new javax.swing.JCheckBox();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        panelDireccionDestino = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        labelLocalidadD = new javax.swing.JLabel();
        comboLocalidadDestino = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        labelCalleD = new javax.swing.JLabel();
        campoCalleDireccion = new javax.swing.JTextField();
        campoCalle2Direccion = new javax.swing.JTextField();
        labelCalle2D = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        labelPuertaD = new javax.swing.JLabel();
        labelApartD = new javax.swing.JLabel();
        campoApartDireccion = new javax.swing.JTextField();
        campoPuertaDireccion = new javax.swing.JTextField();
        panelDireccionOrigen = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        labelPuertaO = new javax.swing.JLabel();
        campoPuertaDireccionO = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        labelApartO = new javax.swing.JLabel();
        campoApartDireccionO = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        labelApartD1 = new javax.swing.JLabel();
        checkSucursal = new javax.swing.JCheckBox();
        jPanel20 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        campoCalleDireccionO = new javax.swing.JTextField();
        labelCalleO = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        labelCalle2O = new javax.swing.JLabel();
        campoCalle2DireccionO = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        labelLocalidadO = new javax.swing.JLabel();
        comboLocalidadOrigen = new javax.swing.JComboBox<>();
        botonCancelarEnvio = new javax.swing.JButton();
        panelClienteReceptor = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        labelApellidoR = new javax.swing.JLabel();
        labelNombreR = new javax.swing.JLabel();
        labelCedulaR = new javax.swing.JLabel();
        labelTelefonoR = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        campoCedulaR = new javax.swing.JTextField();
        campoNombreR = new javax.swing.JTextField();
        campoApellidoR = new javax.swing.JTextField();
        campoTelefonoR = new javax.swing.JTextField();
        panelClienteEmisor = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        labelApellidoR1 = new javax.swing.JLabel();
        labelNombreR1 = new javax.swing.JLabel();
        labelCedulaR1 = new javax.swing.JLabel();
        labelTelefonoR1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        campoCedulaE = new javax.swing.JTextField();
        campoNombreE = new javax.swing.JTextField();
        campoApellidoE = new javax.swing.JTextField();
        campoTelefonoE = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1098, 700));

        scrollPanelGeneral.setBorder(null);
        scrollPanelGeneral.setMaximumSize(null);
        scrollPanelGeneral.setMinimumSize(new java.awt.Dimension(1100, 580));
        scrollPanelGeneral.setName(""); // NOI18N

        panelGeneral.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelGeneral.setMaximumSize(new java.awt.Dimension(0, 0));
        panelGeneral.setMinimumSize(new java.awt.Dimension(0, 0));
        panelGeneral.setPreferredSize(new java.awt.Dimension(985, 900));

        labelTitle.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        labelTitle.setText("CREAR ENVIO");

        botonCrearEnvio.setText("CREAR ENVIO");
        botonCrearEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearEnvioActionPerformed(evt);
            }
        });

        panelPaquete.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DEL PAQUETE:"));

        labelFragil.setText("Fragil:");

        checkBoxFragil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxFragilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFragilLayout = new javax.swing.GroupLayout(panelFragil);
        panelFragil.setLayout(panelFragilLayout);
        panelFragilLayout.setHorizontalGroup(
            panelFragilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFragilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFragil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkBoxFragil)
                .addContainerGap())
        );
        panelFragilLayout.setVerticalGroup(
            panelFragilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFragilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFragilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxFragil)
                    .addComponent(labelFragil))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelPeso.setText("Peso:");

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoPesoPaqueteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoPesoPaqueteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPesoPaqueteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPeso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(campoPesoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPeso)
                    .addComponent(campoPesoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 204, 204))); // NOI18N

        campoDescPaquete.setColumns(20);
        campoDescPaquete.setRows(5);
        scrollPaneDescrp.setViewportView(campoDescPaquete);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneDescrp, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneDescrp, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        );

        labelSecciones.setText("Secciones:");

        comboSecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSeccionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSecciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSecciones)
                    .addComponent(comboSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

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

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTarifasEspeciales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboTarifasEspeciales, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTarifasEspeciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTarifasEspeciales))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonCrearTarifaEsp.setText("Crear Tarifa Especial");
        botonCrearTarifaEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearTarifaEspActionPerformed(evt);
            }
        });

        labelTipo.setText("Especial: ");

        checkboxEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxEspecialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTipo)
                .addGap(18, 18, 18)
                .addComponent(checkboxEspecial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCrearTarifaEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearTarifaEsp)
                    .addComponent(checkboxEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPaqueteLayout = new javax.swing.GroupLayout(panelPaquete);
        panelPaquete.setLayout(panelPaqueteLayout);
        panelPaqueteLayout.setHorizontalGroup(
            panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPaqueteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPaqueteLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelFragil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelPaqueteLayout.setVerticalGroup(
            panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPaqueteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPaqueteLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelFragil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDireccionDestino.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DIRECCION DE DESTINO:"));

        labelLocalidadD.setText("Localidad:");

        comboLocalidadDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLocalidadDestinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLocalidadD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboLocalidadDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboLocalidadDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLocalidadD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelCalleD.setText("Calle:");

        campoCalle2Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCalle2DireccionActionPerformed(evt);
            }
        });

        labelCalle2D.setText("Calle 2:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCalleD)
                    .addComponent(labelCalle2D))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoCalleDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(campoCalle2Direccion))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCalleDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCalleD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCalle2D)
                    .addComponent(campoCalle2Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        labelPuertaD.setText("N° Puerta:");

        labelApartD.setText("Apartamento:");

        campoPuertaDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPuertaDireccionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelApartD)
                    .addComponent(labelPuertaD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoPuertaDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(campoApartDireccion))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPuertaDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPuertaD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApartD)
                    .addComponent(campoApartDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout panelDireccionDestinoLayout = new javax.swing.GroupLayout(panelDireccionDestino);
        panelDireccionDestino.setLayout(panelDireccionDestinoLayout);
        panelDireccionDestinoLayout.setHorizontalGroup(
            panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDireccionDestinoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDireccionDestinoLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDireccionDestinoLayout.setVerticalGroup(
            panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDireccionDestinoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDireccionDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        panelDireccionOrigen.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DIRECCION DE ORIGEN:"));

        labelPuertaO.setText("N° Puerta:");

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

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPuertaO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoPuertaDireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPuertaDireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPuertaO))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelApartO.setText("Apartamento:");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelApartO, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoApartDireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoApartDireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelApartO))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelApartD1.setText("Sucursal:");

        checkSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSucursalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelApartD1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 355, Short.MAX_VALUE)
                .addComponent(checkSucursal)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkSucursal)
                    .addComponent(labelApartD1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        labelCalleO.setText("Calle:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCalleO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoCalleDireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCalleDireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCalleO))
                .addContainerGap())
        );

        labelCalle2O.setText("Calle 2:");

        campoCalle2DireccionO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCalle2DireccionOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCalle2O)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoCalle2DireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCalle2O)
                    .addComponent(campoCalle2DireccionO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        labelLocalidadO.setText("Localidad:");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLocalidadO, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(comboLocalidadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboLocalidadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLocalidadO))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelDireccionOrigenLayout = new javax.swing.GroupLayout(panelDireccionOrigen);
        panelDireccionOrigen.setLayout(panelDireccionOrigenLayout);
        panelDireccionOrigenLayout.setHorizontalGroup(
            panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDireccionOrigenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDireccionOrigenLayout.setVerticalGroup(
            panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDireccionOrigenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDireccionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonCancelarEnvio.setText("CANCELAR");
        botonCancelarEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarEnvioActionPerformed(evt);
            }
        });

        panelClienteReceptor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CLIENTE RECEPTOR:"));

        labelApellidoR.setText("Apellido:");

        labelNombreR.setText("Nombre:");

        labelCedulaR.setText("Cedula:");

        labelTelefonoR.setText("Teléfono:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelApellidoR)
                    .addComponent(labelNombreR)
                    .addComponent(labelCedulaR)
                    .addComponent(labelTelefonoR))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCedulaR)
                .addGap(18, 18, 18)
                .addComponent(labelNombreR)
                .addGap(18, 18, 18)
                .addComponent(labelApellidoR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTelefonoR)
                .addGap(14, 14, 14))
        );

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

        campoNombreR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreRActionPerformed(evt);
            }
        });

        campoTelefonoR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefonoRKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCedulaR, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(campoNombreR)
                    .addComponent(campoApellidoR)
                    .addComponent(campoTelefonoR))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoCedulaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNombreR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoApellidoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTelefonoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelClienteReceptorLayout = new javax.swing.GroupLayout(panelClienteReceptor);
        panelClienteReceptor.setLayout(panelClienteReceptorLayout);
        panelClienteReceptorLayout.setHorizontalGroup(
            panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteReceptorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelClienteReceptorLayout.setVerticalGroup(
            panelClienteReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelClienteEmisor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CLIENTE EMISOR:"));

        labelApellidoR1.setText("Apellido:");

        labelNombreR1.setText("Nombre:");

        labelCedulaR1.setText("Cedula:");

        labelTelefonoR1.setText("Teléfono:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTelefonoR1)
                    .addComponent(labelApellidoR1)
                    .addComponent(labelNombreR1)
                    .addComponent(labelCedulaR1))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCedulaR1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(labelNombreR1)
                .addGap(18, 18, 18)
                .addComponent(labelApellidoR1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTelefonoR1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        campoTelefonoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefonoEActionPerformed(evt);
            }
        });
        campoTelefonoE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefonoEKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoCedulaE, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(campoNombreE)
                    .addComponent(campoApellidoE)
                    .addComponent(campoTelefonoE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoCedulaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoApellidoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTelefonoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelClienteEmisorLayout = new javax.swing.GroupLayout(panelClienteEmisor);
        panelClienteEmisor.setLayout(panelClienteEmisorLayout);
        panelClienteEmisorLayout.setHorizontalGroup(
            panelClienteEmisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteEmisorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelClienteEmisorLayout.setVerticalGroup(
            panelClienteEmisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteEmisorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(panelClienteReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(panelClienteEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                        .addComponent(botonCancelarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCrearEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelPaquete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDireccionDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDireccionOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelClienteReceptor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelClienteEmisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelDireccionDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelDireccionOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrollPanelGeneral.setViewportView(panelGeneral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPesoPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesoPaqueteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPesoPaqueteActionPerformed

    private void botonCrearEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearEnvioActionPerformed
        if (this.validacionCamposVacios() && this.validacionDeClientes()) {

            int idDireccionOrigen, idDireccionDestino = 0;
            int fragil = this.checkBoxFragil.isSelected() ? 1 : 0;
            int especial = this.checkboxEspecial.isSelected() ? 1 : 0;
            if (especial == 1) {
                idTarifa = this.obtenerIdTarifaEspecial();
            }
            int idP = this.iE.crearPaquete(campoDescPaquete.getText(), Float.parseFloat(campoPesoPaquete.getText()), fragil, especial);
            if (this.validacionCamposVacios()) {
                idDireccionDestino = this.iE.crearDireccion(campoCalleDireccion.getText(), campoCalle2Direccion.getText(),
                        Integer.parseInt(campoPuertaDireccion.getText()), campoApartDireccion.getText());
            }

            if (checkSucursal.isSelected()) { //Se toma la sucursal
                Direccion sucursal = this.iE.traerDireccionSucursal();
                idDireccionOrigen = sucursal.getIdDireccion();
            } else {
                //CREACION DE LA DIRECCION ORIGEN
                idDireccionOrigen = this.iE.crearDireccion(campoCalleDireccionO.getText(), campoCalle2DireccionO.getText(),
                        Integer.parseInt(campoPuertaDireccionO.getText()), campoApartDireccionO.getText());
                this.insertarLocalidadDireccion(idDireccionOrigen, comboLocalidadOrigen.getSelectedItem().toString());
            }
            
            //SECCION-PAQUETE
            this.insertarSeccionPaquete(idP);
            this.insertarLocalidadDireccion(idDireccionDestino, comboLocalidadDestino.getSelectedItem().toString());
            //Crear pago
            int idPago = this.iAP.crearPago(this.idTarifa, obtenerLocalidad(this.comboLocalidadDestino.getSelectedItem().toString()));
            //ENVIO
            int idEnvio = this.iE.crearEnvio(idP, idTarifa, idDireccionOrigen, idDireccionDestino, idPago);
            //CLIENTES
            if (!this.iA.verificarExisteClienteNuevo(Integer.parseInt(campoCedulaE.getText()))) {
                this.iA.agregarCliente(Integer.parseInt(campoCedulaE.getText()), campoNombreE.getText(),
                        campoApellidoE.getText(), Integer.parseInt(campoTelefonoE.getText()));
            }
            if (!this.iA.verificarExisteClienteNuevo(Integer.parseInt(campoCedulaR.getText()))) {
                this.iA.agregarCliente(Integer.parseInt(campoCedulaR.getText()),
                        campoNombreR.getText(), campoApellidoR.getText(),
                        Integer.parseInt(campoTelefonoR.getText().trim()));
            }
            //CONEXION ENVIO Y CLIENTE
            this.iE.conexionEnvio_Cliente(idEnvio, Integer.parseInt(campoCedulaE.getText()), "Envio");
            this.iE.conexionEnvio_Cliente(idEnvio, Integer.parseInt(campoCedulaR.getText()), "Recibe");
            //CONEXION ENVIO Y ESTADO
            this.iE.crearEstado(idEnvio, "Preparando", "Creacion del envio");

            JOptionPane.showMessageDialog(null, "El envio fue ingresado con éxito", "Success", JOptionPane.DEFAULT_OPTION);
            this.setVisible(false);
            Home home = new Home();
            home.setVisible(true);
        } else if (!this.validacionTarifas()) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar la tarifa", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!this.validacionSecciones()) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar la seccion", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!this.validacionCamposVacios()) {
            JOptionPane.showMessageDialog(null, "Para registrar el envio tiene que completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Los clientes tienen que ser diferentes", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonCrearEnvioActionPerformed

    private void campoCalle2DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCalle2DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCalle2DireccionActionPerformed

    private void comboSeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSeccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSeccionesActionPerformed

    private void campoCedulaEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCedulaEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCedulaEActionPerformed

    private void campoCedulaEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCedulaEFocusLost
        this.completarDatosCliente(this.campoCedulaE, this.campoNombreE, this.campoApellidoE, this.campoTelefonoE);
    }//GEN-LAST:event_campoCedulaEFocusLost

    private void campoCedulaRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCedulaRFocusLost
        this.completarDatosCliente(this.campoCedulaR, this.campoNombreR, this.campoApellidoR, this.campoTelefonoR);
    }//GEN-LAST:event_campoCedulaRFocusLost

    private void completarDatosCliente(JTextField campoCedula, JTextField campoNombre, JTextField campoApellido, JTextField campoTelefono) {
        Cliente cliente = !campoCedula.getText().isBlank()
                ? this.iE.traerCliente(Integer.parseInt(campoCedula.getText())) : null;
        if (cliente != null) {
            campoCedula.setText(String.valueOf(cliente.getCedula()));
            campoNombre.setText(cliente.getNombre());
            campoApellido.setText(cliente.getApellido());
            campoTelefono.setText(cliente.getTelefono());
        } else {
            campoNombre.setText("");
            campoApellido.setText("");
            campoTelefono.setText("");
        }
    }

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
            comboLocalidadOrigen.setEnabled(true);

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

        if (!Character.isDigit(key) && key != '.' || key == '.' && campoPesoPaquete.getText().contains(".") || campoPesoPaquete.getText().length() >= 6) {
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
        if (!Character.isDigit(key) || campoPuertaDireccionO.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_campoPuertaDireccionOKeyTyped

    private void campoPuertaDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPuertaDireccionKeyTyped
        // TODO add your handling code here:
        //METODO PARA NO ACEPTAR LA ENTRADA DE LETRAS
        int key = evt.getKeyChar();
        if (!Character.isDigit(key) || campoPuertaDireccion.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_campoPuertaDireccionKeyTyped

    private void campoCedulaEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCedulaEKeyTyped
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

    private boolean validacionCamposVacios() {
        return this.validacionCamposDireccionD() && this.validacionCamposDireccionO()
                && this.validacionCamposClienteE() && this.validacionCamposClienteR() && !this.campoPesoPaquete.getText().isBlank()
                && this.validacionTarifas() && this.validacionSecciones();
    }

    private boolean validacionCamposDireccionD() {
        return !this.campoCalleDireccion.getText().isBlank() && !this.campoPuertaDireccion.getText().isBlank();
    }

    private boolean validacionCamposDireccionO() {
        return this.checkSucursal.isSelected() || (!this.campoCalleDireccion.getText().isBlank()
                && !this.campoPuertaDireccion.getText().isBlank());
    }

    private boolean validacionCamposClienteR() {
        return !this.campoCedulaR.getText().isBlank() && !this.campoNombreR.getText().isBlank()
                && !this.campoApellidoR.getText().isBlank() && !this.campoTelefonoR.getText().isBlank();
    }

    private boolean validacionCamposClienteE() {
        return !this.campoCedulaE.getText().isBlank() && !this.campoNombreE.getText().isBlank()
                && !this.campoApellidoE.getText().isBlank() && !this.campoTelefonoE.getText().isBlank();
    }
    
    private boolean validacionDeClientes() {
        return !(this.campoCedulaE.getText().equals(this.campoCedulaR.getText()));
    }

    private boolean validacionTarifas() {
        return this.idTarifa != 0;
    }

    private boolean validacionSecciones() {
        return this.comboSecciones.getSelectedItem() != null;
    }

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

    }//GEN-LAST:event_checkboxEspecialActionPerformed

    private void campoPesoPaqueteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesoPaqueteFocusLost

    }//GEN-LAST:event_campoPesoPaqueteFocusLost

    private void comboLocalidadDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLocalidadDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboLocalidadDestinoActionPerformed

    private void campoCedulaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCedulaRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCedulaRActionPerformed

    private void comboTarifasEspecialesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboTarifasEspecialesFocusLost

    }//GEN-LAST:event_comboTarifasEspecialesFocusLost

    private void campoNombreRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreRActionPerformed

    private void campoTelefonoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefonoEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelefonoEActionPerformed

    private void botonCancelarEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarEnvioActionPerformed
        Home home = new Home();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonCancelarEnvioActionPerformed

    private void checkBoxFragilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxFragilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxFragilActionPerformed

    private void campoPesoPaqueteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesoPaqueteKeyPressed
    }//GEN-LAST:event_campoPesoPaqueteKeyPressed

    private void campoPesoPaqueteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesoPaqueteKeyReleased
        if (!campoPesoPaquete.getText().isBlank()) {
            float peso = Float.parseFloat(campoPesoPaquete.getText());
            if (checkboxEspecial.isSelected() && peso > 15) {
                this.labelTipo.setVisible(true);
                this.checkboxEspecial.setVisible(true);
                this.checkboxEspecial.setSelected(true);
                this.checkboxEspecial.setEnabled(false);
                this.botonCrearTarifaEsp.setVisible(true);
                this.comboTarifasEspeciales.setVisible(true);
                this.labelTarifasEspeciales.setVisible(true);
            } else {
                this.labelTipo.setVisible(false);
                this.checkboxEspecial.setVisible(false);
                this.checkboxEspecial.doClick();
                this.botonCrearTarifaEsp.setVisible(false);
                this.labelTarifasEspeciales.setVisible(false);
                this.comboTarifasEspeciales.setVisible(false);
                this.idTarifa = this.obtenerIdTarifasNormales(peso);
            }
        }
    }//GEN-LAST:event_campoPesoPaqueteKeyReleased

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
            java.util.logging.Logger.getLogger(CrearEnvio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearEnvio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearEnvio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearEnvio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTextField campoApartDireccion;
    private javax.swing.JTextField campoApartDireccionO;
    private javax.swing.JTextField campoApellidoE;
    private javax.swing.JTextField campoApellidoR;
    private javax.swing.JTextField campoCalle2Direccion;
    private javax.swing.JTextField campoCalle2DireccionO;
    private javax.swing.JTextField campoCalleDireccion;
    private javax.swing.JTextField campoCalleDireccionO;
    private javax.swing.JTextField campoCedulaE;
    private javax.swing.JTextField campoCedulaR;
    private javax.swing.JTextArea campoDescPaquete;
    private javax.swing.JTextField campoNombreE;
    private javax.swing.JTextField campoNombreR;
    private javax.swing.JTextField campoPesoPaquete;
    private javax.swing.JTextField campoPuertaDireccion;
    private javax.swing.JTextField campoPuertaDireccionO;
    private javax.swing.JTextField campoTelefonoE;
    private javax.swing.JTextField campoTelefonoR;
    private javax.swing.JCheckBox checkBoxFragil;
    private javax.swing.JCheckBox checkSucursal;
    private javax.swing.JCheckBox checkboxEspecial;
    private javax.swing.JComboBox<String> comboLocalidadDestino;
    private javax.swing.JComboBox<String> comboLocalidadOrigen;
    private javax.swing.JComboBox<String> comboSecciones;
    private javax.swing.JComboBox<String> comboTarifasEspeciales;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelApartD;
    private javax.swing.JLabel labelApartD1;
    private javax.swing.JLabel labelApartO;
    private javax.swing.JLabel labelApellidoR;
    private javax.swing.JLabel labelApellidoR1;
    private javax.swing.JLabel labelCalle2D;
    private javax.swing.JLabel labelCalle2O;
    private javax.swing.JLabel labelCalleD;
    private javax.swing.JLabel labelCalleO;
    private javax.swing.JLabel labelCedulaR;
    private javax.swing.JLabel labelCedulaR1;
    private javax.swing.JLabel labelFragil;
    private javax.swing.JLabel labelLocalidadD;
    private javax.swing.JLabel labelLocalidadO;
    private javax.swing.JLabel labelNombreR;
    private javax.swing.JLabel labelNombreR1;
    private javax.swing.JLabel labelPeso;
    private javax.swing.JLabel labelPuertaD;
    private javax.swing.JLabel labelPuertaO;
    private javax.swing.JLabel labelSecciones;
    private javax.swing.JLabel labelTarifasEspeciales;
    private javax.swing.JLabel labelTelefonoR;
    private javax.swing.JLabel labelTelefonoR1;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel panelClienteEmisor;
    private javax.swing.JPanel panelClienteReceptor;
    private javax.swing.JPanel panelDireccionDestino;
    private javax.swing.JPanel panelDireccionOrigen;
    private javax.swing.JPanel panelFragil;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelPaquete;
    private javax.swing.JScrollPane scrollPaneDescrp;
    private javax.swing.JScrollPane scrollPanelGeneral;
    // End of variables declaration//GEN-END:variables
}
