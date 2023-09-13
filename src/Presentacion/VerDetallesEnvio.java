/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.clases.Direccion;
import logica.clases.Envio;
import logica.clases.Estado;
import logica.clases.Tarifa;
import logica.dataTypes.TipoEstado;
import logica.fabrica.Fabrica;
import logica.interfaces.IEnvio;

/**
 *
 * @author leo
 */
public class VerDetallesEnvio extends javax.swing.JFrame {

    private IEnvio IE;
    private Fabrica fb;
    private ListaEnvios listEnvios;
    private int idEnvio;
    private int idPaquete;
    private Envio envio;
    private ArrayList<Tarifa> tarifEspeciales = null;
    private ResumenMensualFacturacion vieneDeResumen = null;

    /**
     * Creates new form VerDetallesEnvio
     */
    public VerDetallesEnvio(int id, ListaEnvios listEnv) {
        initComponents();
        this.setTitle("MLEntregas");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.idEnvio = id;
        this.fb = Fabrica.getInstancia();
        this.IE = fb.getControladorEnvio();
        this.envio = IE.verDetallesDelEnvio(idEnvio);
        this.listEnvios = listEnv;
        AccederDetallesEnvio(id);
        if (this.envio.getPago().getPago() != null) {
            this.jButtonPagar.setEnabled(false);
            this.jLabelPago.setText("■ Pagado");
        }
    }

    public VerDetallesEnvio(int id, ResumenMensualFacturacion deResumen) {
        initComponents();
        this.setTitle("MLEntregas");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.idEnvio = id;
        this.fb = Fabrica.getInstancia();
        this.IE = fb.getControladorEnvio();
        this.envio = IE.verDetallesDelEnvio(idEnvio);
        this.vieneDeResumen = deResumen;
        AccederDetallesEnvio(id);
        this.jButtonPagar.setEnabled(false);
        this.jLabelPago.setText("■ Pagado");
    }

    public void llamarAlertaEnvioConfirmado() {
        JOptionPane.showMessageDialog(null, "Envio confirmado", "Confirmación exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    public void llamarAlertaEstadoNoEncontrado() {
        JOptionPane.showMessageDialog(null, "Estado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void llamarAlertaEstadoYaConfirmado() {
        JOptionPane.showMessageDialog(null, "El envío ya está confirmado", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void actualizarDetalleEnvio(int idTarifa, boolean esEspecial, boolean esFragil, float precio) {
        if (idTarifa < 4) {
            if (idTarifa == 1) {
                this.jTextFieldTarifa.setText("<5kg");
            } else if (idTarifa == 2) {
                this.jTextFieldTarifa.setText("5-10kg");
            } else {
                this.jTextFieldTarifa.setText("10-15kg");
            }
        } else {
            this.tarifEspeciales = this.fb.getControladorEnvio().obtenerTarifasEspeciales();
            for (Tarifa tarifEsp : this.tarifEspeciales) {
                if (tarifEsp.getIdTarifa() == idTarifa) {
                    this.jTextFieldTarifa.setText(tarifEsp.getNombre());
                    break;
                }
            }
        }
        this.envio.getPaquete().setEsEspecial(esEspecial);
        this.envio.getPaquete().setEsFragil(esFragil);
        this.envio.getPago().setPrecio(precio);
        this.jTextFieldPrecio.setText(String.valueOf(precio));
    }

    public void AccederDetallesEnvio(int idEnvio) {
        this.envio = this.fb.getControladorEnvio().verDetallesDelEnvio(idEnvio);
        idPaquete = envio.getPaquete().getIdPaquete();
        ArrayList<Estado> estados = envio.getEstados();
        int idUltimo = 0;
        for (Estado estado : estados) {
            if (estado.getIdEstado() > idUltimo) {
                idUltimo = estado.getIdEstado();
            }
        }
        Estado estadoFinal = Fabrica.getInstancia().getControladorEstado().obtenerElEstado(idUltimo, idEnvio);
        if (estadoFinal != null) {
            if (this.jComboBoxEstados.getItemCount() == 0) {
                this.jComboBoxEstados.addItem(estadoFinal.getTipo().getEstado());
            }
            this.jTextFieldPrecio.setText(String.valueOf(envio.getPago().getPrecio()));
            this.jTextFieldIDPaquete.setText(Integer.toString(envio.getPaquete().getIdPaquete()));
            this.jTextFieldTarifa.setText(envio.getTarifa().getNombre());
            this.jTextFieldCIEmisor.setText(Integer.toString(envio.getClienteEmisor().getCedula()));
            this.jTextFieldNombreEmisor.setText(envio.getClienteEmisor().getNombre());
            this.jTextFieldNombreReceptor.setText(envio.getClienteReceptor().getNombre());
            this.jTextFieldCIReceptor.setText(Integer.toString(envio.getClienteReceptor().getCedula()));
            this.jTextFieldCalle1Emisor.setText(envio.getDireccionOrigen().getCalle());
            this.jTextFieldCalle2Emisor.setText(envio.getDireccionOrigen().getSegunda_calle());
            this.jTextFieldApartamentoEmisor.setText(envio.getDireccionOrigen().getDatos_adicionales());
            this.jTextFieldNroPuertaEmisor.setText(Integer.toString(envio.getDireccionOrigen().getNro_puerta()));
            this.jTextFieldCalle1Receptor.setText(envio.getDireccionDestino().getCalle());
            this.jTextFieldCalle2Receptor.setText(envio.getDireccionDestino().getSegunda_calle());
            this.jTextFieldApartamentoReceptor.setText(envio.getDireccionDestino().getDatos_adicionales());
            this.jTextFieldNroPuertaReceptor.setText(Integer.toString(envio.getDireccionDestino().getNro_puerta()));
            //deshabilitar
            this.jTextFieldPrecio.setEditable(false);
            this.jTextFieldIDPaquete.setEditable(false);
            this.jTextFieldTarifa.setEditable(false);
            this.jTextFieldCIEmisor.setEditable(false);
            this.jTextFieldNombreEmisor.setEditable(false);
            this.jTextFieldNombreReceptor.setEditable(false);
            this.jTextFieldCIReceptor.setEditable(false);
            this.jTextFieldCalle1Emisor.setEditable(false);
            this.jTextFieldCalle2Emisor.setEditable(false);
            this.jTextFieldApartamentoEmisor.setEditable(false);
            this.jTextFieldNroPuertaEmisor.setEditable(false);
            this.jTextFieldCalle1Receptor.setEditable(false);
            this.jTextFieldCalle2Receptor.setEditable(false);
            this.jTextFieldApartamentoReceptor.setEditable(false);
            this.jTextFieldNroPuertaReceptor.setEditable(false);
            if (estadoFinal.getTipo().getEstado().equals("Cancelado") || estadoFinal.getTipo().getEstado().equals("Entregado")) {
                this.buttonConfirmarEnvio.setEnabled(false);
                this.buttonCancelarEnvio.setEnabled(false);
                this.jButtonEditarEnvio.setEnabled(false);
                this.jButtonEditarPaquete.setEnabled(false);
                this.jButtonPagar.setEnabled(false);
            }
        } else {
            llamarAlertaEstadoNoEncontrado();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldIDPaquete = new javax.swing.JTextField();
        jLabelIDDelPaquete = new javax.swing.JLabel();
        jLabelTarifa = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabelIDEnvio = new javax.swing.JLabel();
        jTextFieldTarifa = new javax.swing.JTextField();
        jButtonEditarEnvio = new javax.swing.JButton();
        buttonConfirmarEnvio = new javax.swing.JButton();
        buttonCancelarEnvio = new javax.swing.JButton();
        jComboBoxEstados = new javax.swing.JComboBox<>();
        jLabelEstado = new javax.swing.JLabel();
        jButtonEditarPaquete = new javax.swing.JButton();
        jLabelPago = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelEmisor = new javax.swing.JLabel();
        jLabelNombreEmisor = new javax.swing.JLabel();
        jLabelCalle1Emisor = new javax.swing.JLabel();
        jLabelApartamentoEmisor = new javax.swing.JLabel();
        jLabelNroPuertaEmisor = new javax.swing.JLabel();
        jTextFieldCIEmisor = new javax.swing.JTextField();
        jTextFieldNombreEmisor = new javax.swing.JTextField();
        jTextFieldCalle1Emisor = new javax.swing.JTextField();
        jTextFieldApartamentoEmisor = new javax.swing.JTextField();
        jTextFieldCalle2Emisor = new javax.swing.JTextField();
        jTextFieldNroPuertaEmisor = new javax.swing.JTextField();
        jLabelCalle2Emisor = new javax.swing.JLabel();
        jLabelCIEmisor = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelReceptor = new javax.swing.JLabel();
        jLabelCIReceptor = new javax.swing.JLabel();
        jTextFieldCalle2Receptor = new javax.swing.JTextField();
        jLabelCalle2Receptor = new javax.swing.JLabel();
        jLabelNombreReceptor = new javax.swing.JLabel();
        jTextFieldNroPuertaReceptor = new javax.swing.JTextField();
        jLabelCalle1Receptor = new javax.swing.JLabel();
        jLabelApartamentoReceptor = new javax.swing.JLabel();
        jLabelNroPuertaReceptor = new javax.swing.JLabel();
        jTextFieldCIReceptor = new javax.swing.JTextField();
        jTextFieldNombreReceptor = new javax.swing.JTextField();
        jTextFieldCalle1Receptor = new javax.swing.JTextField();
        jTextFieldApartamentoReceptor = new javax.swing.JTextField();
        panelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JToggleButton();
        jButtonPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1098, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextFieldIDPaquete.setText("-");
        jTextFieldIDPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDPaqueteActionPerformed(evt);
            }
        });

        jLabelIDDelPaquete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelIDDelPaquete.setText("ID del paquete");

        jLabelTarifa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelTarifa.setText("Tarifa");

        jTextFieldPrecio.setText("-");
        jTextFieldPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecioActionPerformed(evt);
            }
        });

        jLabelIDEnvio.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelIDEnvio.setText("Precio");

        jTextFieldTarifa.setText("-");
        jTextFieldTarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTarifaActionPerformed(evt);
            }
        });

        jButtonEditarEnvio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jButtonEditarEnvio.setText("Editar envío");
        jButtonEditarEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarEnvioActionPerformed(evt);
            }
        });

        buttonConfirmarEnvio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        buttonConfirmarEnvio.setText("Confirmar envío");
        buttonConfirmarEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarEnvioActionPerformed(evt);
            }
        });

        buttonCancelarEnvio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        buttonCancelarEnvio.setText("Cancelar envío");
        buttonCancelarEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarEnvioActionPerformed(evt);
            }
        });

        jComboBoxEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadosActionPerformed(evt);
            }
        });

        jLabelEstado.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelEstado.setText("Estado");

        jButtonEditarPaquete.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jButtonEditarPaquete.setText("Editar paquete");
        jButtonEditarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarPaqueteActionPerformed(evt);
            }
        });

        jLabelPago.setText("□ No pagado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelIDEnvio)
                            .addComponent(jLabelEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelPago)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelIDDelPaquete)
                            .addComponent(jLabelTarifa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIDPaquete, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(jTextFieldTarifa)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonConfirmarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCancelarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jButtonEditarPaquete)))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonEditarEnvio, jButtonEditarPaquete});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIDEnvio)
                            .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPago))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEstado)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIDDelPaquete)
                            .addComponent(jTextFieldIDPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTarifa))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonConfirmarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancelarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditarPaquete))
                .addGap(20, 20, 20))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonEditarEnvio, jButtonEditarPaquete});

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelEmisor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelEmisor.setText("Emisor");

        jLabelNombreEmisor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelNombreEmisor.setText("Nombre:");

        jLabelCalle1Emisor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelCalle1Emisor.setText("Calle 1:");

        jLabelApartamentoEmisor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelApartamentoEmisor.setText("Apartamento:");

        jLabelNroPuertaEmisor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelNroPuertaEmisor.setText("Nº Puerta:");

        jTextFieldCIEmisor.setText("-");
        jTextFieldCIEmisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCIEmisorActionPerformed(evt);
            }
        });

        jTextFieldNombreEmisor.setText("-");
        jTextFieldNombreEmisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreEmisorActionPerformed(evt);
            }
        });

        jTextFieldCalle1Emisor.setText("-");
        jTextFieldCalle1Emisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCalle1EmisorActionPerformed(evt);
            }
        });
        jTextFieldCalle1Emisor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCalle1EmisorKeyTyped(evt);
            }
        });

        jTextFieldApartamentoEmisor.setText("-");
        jTextFieldApartamentoEmisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApartamentoEmisorActionPerformed(evt);
            }
        });
        jTextFieldApartamentoEmisor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApartamentoEmisorKeyTyped(evt);
            }
        });

        jTextFieldCalle2Emisor.setText("-");
        jTextFieldCalle2Emisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCalle2EmisorActionPerformed(evt);
            }
        });
        jTextFieldCalle2Emisor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCalle2EmisorKeyTyped(evt);
            }
        });

        jTextFieldNroPuertaEmisor.setText("-");
        jTextFieldNroPuertaEmisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNroPuertaEmisorActionPerformed(evt);
            }
        });
        jTextFieldNroPuertaEmisor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNroPuertaEmisorKeyTyped(evt);
            }
        });

        jLabelCalle2Emisor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelCalle2Emisor.setText("Calle 2:");

        jLabelCIEmisor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelCIEmisor.setText("CI:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelApartamentoEmisor)
                            .addComponent(jLabelNroPuertaEmisor)
                            .addComponent(jLabelCalle2Emisor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldApartamentoEmisor, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(jTextFieldNroPuertaEmisor)
                            .addComponent(jTextFieldCalle2Emisor)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelCalle1Emisor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldCalle1Emisor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelNombreEmisor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jTextFieldNombreEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelCIEmisor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldCIEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelEmisor)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEmisor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCIEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCIEmisor))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombreEmisor))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCalle1Emisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCalle1Emisor))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCalle2Emisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCalle2Emisor))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldApartamentoEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApartamentoEmisor))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNroPuertaEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNroPuertaEmisor))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelReceptor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelReceptor.setText("Receptor");

        jLabelCIReceptor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelCIReceptor.setText("CI:");

        jTextFieldCalle2Receptor.setText("-");
        jTextFieldCalle2Receptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCalle2ReceptorActionPerformed(evt);
            }
        });
        jTextFieldCalle2Receptor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCalle2ReceptorKeyTyped(evt);
            }
        });

        jLabelCalle2Receptor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelCalle2Receptor.setText("Calle 2:");

        jLabelNombreReceptor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelNombreReceptor.setText("Nombre:");

        jTextFieldNroPuertaReceptor.setText("-");
        jTextFieldNroPuertaReceptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNroPuertaReceptorActionPerformed(evt);
            }
        });
        jTextFieldNroPuertaReceptor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNroPuertaReceptorKeyTyped(evt);
            }
        });

        jLabelCalle1Receptor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelCalle1Receptor.setText("Calle 1:");

        jLabelApartamentoReceptor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelApartamentoReceptor.setText("Apartamento:");

        jLabelNroPuertaReceptor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelNroPuertaReceptor.setText("Nº Puerta:");

        jTextFieldCIReceptor.setText("-");
        jTextFieldCIReceptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCIReceptorActionPerformed(evt);
            }
        });

        jTextFieldNombreReceptor.setText("-");
        jTextFieldNombreReceptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreReceptorActionPerformed(evt);
            }
        });

        jTextFieldCalle1Receptor.setText("-");
        jTextFieldCalle1Receptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCalle1ReceptorActionPerformed(evt);
            }
        });
        jTextFieldCalle1Receptor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCalle1ReceptorKeyTyped(evt);
            }
        });

        jTextFieldApartamentoReceptor.setText("-");
        jTextFieldApartamentoReceptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApartamentoReceptorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelApartamentoReceptor)
                    .addComponent(jLabelNroPuertaReceptor)
                    .addComponent(jLabelCalle2Receptor)
                    .addComponent(jLabelCalle1Receptor)
                    .addComponent(jLabelNombreReceptor)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelCIReceptor))
                    .addComponent(jLabelReceptor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNombreReceptor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jTextFieldCalle1Receptor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldCalle2Receptor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldApartamentoReceptor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldNroPuertaReceptor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldCIReceptor))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelReceptor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCIReceptor)
                    .addComponent(jTextFieldCIReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreReceptor)
                    .addComponent(jTextFieldNombreReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCalle1Receptor)
                    .addComponent(jTextFieldCalle1Receptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCalle2Receptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCalle2Receptor))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldApartamentoReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApartamentoReceptor))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNroPuertaReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNroPuertaReceptor))
                .addContainerGap())
        );

        labelTitulo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        labelTitulo.setText("DETALLES DEL ENVÍO");
        labelTitulo.setPreferredSize(new java.awt.Dimension(300, 300));
        labelTitulo.setRequestFocusEnabled(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo-sm.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonPagar.setText("Pagar envío");
        jButtonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 220, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 220, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCIReceptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCIReceptorActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldCIReceptorActionPerformed

    private void jTextFieldCIEmisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCIEmisorActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldCIEmisorActionPerformed

    private void jTextFieldNombreEmisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreEmisorActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldNombreEmisorActionPerformed

    private void jTextFieldCalle1EmisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCalle1EmisorActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldCalle1EmisorActionPerformed

    private void jTextFieldCalle2EmisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCalle2EmisorActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldCalle2EmisorActionPerformed

    private void jTextFieldApartamentoEmisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApartamentoEmisorActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldApartamentoEmisorActionPerformed

    private void jTextFieldNroPuertaEmisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNroPuertaEmisorActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldNroPuertaEmisorActionPerformed

    private void jTextFieldNombreReceptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreReceptorActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldNombreReceptorActionPerformed

    private void jTextFieldCalle1ReceptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCalle1ReceptorActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldCalle1ReceptorActionPerformed

    private void jTextFieldCalle2ReceptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCalle2ReceptorActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldCalle2ReceptorActionPerformed

    private void jTextFieldApartamentoReceptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApartamentoReceptorActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldApartamentoReceptorActionPerformed

    private void jTextFieldNroPuertaReceptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNroPuertaReceptorActionPerformed

    }//GEN-LAST:event_jTextFieldNroPuertaReceptorActionPerformed

    private void jTextFieldCalle1EmisorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCalle1EmisorKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if (jTextFieldCalle1Emisor.getText().length() >= 40) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldCalle1EmisorKeyTyped

    private void jTextFieldCalle2EmisorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCalle2EmisorKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if (jTextFieldCalle2Emisor.getText().length() >= 40) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldCalle2EmisorKeyTyped

    private void jTextFieldApartamentoEmisorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApartamentoEmisorKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if (jTextFieldApartamentoEmisor.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldApartamentoEmisorKeyTyped

    private void jTextFieldNroPuertaEmisorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNroPuertaEmisorKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if (!Character.isDigit(key)) {
            evt.consume();
        }
        if (jTextFieldNroPuertaEmisor.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldNroPuertaEmisorKeyTyped

    private void jTextFieldCalle1ReceptorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCalle1ReceptorKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if (jTextFieldCalle1Receptor.getText().length() >= 40) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldCalle1ReceptorKeyTyped

    private void jTextFieldCalle2ReceptorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCalle2ReceptorKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if (jTextFieldCalle2Receptor.getText().length() >= 40) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldCalle2ReceptorKeyTyped

    private void jTextFieldNroPuertaReceptorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNroPuertaReceptorKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if (!Character.isDigit(key)) {
            evt.consume();
        }
        if (jTextFieldNroPuertaReceptor.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldNroPuertaReceptorKeyTyped

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        Home home = new Home();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MousePressed

    private void jButtonEditarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarPaqueteActionPerformed
        EditarPaquete editPaquete = new EditarPaquete(idPaquete, envio, listEnvios, this);
        editPaquete.setVisible(true);
    }//GEN-LAST:event_jButtonEditarPaqueteActionPerformed

    private void jComboBoxEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadosActionPerformed

    }//GEN-LAST:event_jComboBoxEstadosActionPerformed

    private void buttonCancelarEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarEnvioActionPerformed
        if (!labelTitulo.getText().equals("    EDITAR ENVÍO")) {
            ArrayList<Estado> estados = envio.getEstados();
            Boolean existeEstado = false;
            for (Estado estado : estados) {
                if (estado.getTipo() == TipoEstado.Cancelado || estado.getTipo() == TipoEstado.Entregado || estado.getTipo() == TipoEstado.ListoParaRetirar) {
                    existeEstado = true;
                }
            }
            if (existeEstado == false) {
                int opt = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cancelar el envío?",
                        "Cancelar envío", JOptionPane.YES_NO_OPTION);
                if (opt == 0) {
                    this.IE.crearEstado(idEnvio, "Cancelado", "Paquete cancelado");
                    this.jComboBoxEstados.removeAllItems();
                    this.jComboBoxEstados.addItem("Cancelado");
                    JOptionPane.showMessageDialog(null, "El envío fue cancelado", "Success", JOptionPane.DEFAULT_OPTION);
                    if (this.listEnvios != null) {
                        this.listEnvios.actualizarListaDeEnvios();
                    }
                    this.buttonConfirmarEnvio.setEnabled(false);
                    this.buttonCancelarEnvio.setEnabled(false);
                    this.jButtonEditarEnvio.setEnabled(false);
                    this.jButtonEditarPaquete.setEnabled(false);
                    this.jButtonPagar.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede cancelar este envío", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            jButtonEditarEnvio.setEnabled(true);
            labelTitulo.setText("DETALLES DEL ENVÍO");
            buttonCancelarEnvio.setText("Cancelar envío");
            buttonConfirmarEnvio.setText("Confirmar envío");
            this.jComboBoxEstados.removeAllItems();
            this.AccederDetallesEnvio(idEnvio);
        }

    }//GEN-LAST:event_buttonCancelarEnvioActionPerformed

    private void buttonConfirmarEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarEnvioActionPerformed
        if (!labelTitulo.getText().equals("    EDITAR ENVÍO")) {
            ArrayList<Estado> estados = envio.getEstados();
            Boolean existeEstado = false;
            for (Estado estado : estados) {
                if (estado.getTipo() == TipoEstado.Entregado) {
                    existeEstado = true;
                }
            }
            if (existeEstado == false) {
                if (!this.jButtonPagar.isEnabled()) {
                    int opt = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea confirmar el envío?",
                            "Confirmar envío", JOptionPane.YES_NO_OPTION);
                    if (opt == 0) {
                        this.IE.crearEstado(idEnvio, "Entregado", "Paquete entregado");
                        llamarAlertaEnvioConfirmado();
                        this.jComboBoxEstados.removeAllItems();
                        this.jComboBoxEstados.addItem("Entregado");
                        this.buttonConfirmarEnvio.setEnabled(false);
                        this.buttonCancelarEnvio.setEnabled(false);
                        this.jButtonEditarEnvio.setEnabled(false);
                        this.jButtonEditarPaquete.setEnabled(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Para confirmar un envío debe haber sido pagado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                llamarAlertaEstadoYaConfirmado();
            }
        } else {
            if (this.jTextFieldCalle1Emisor.getText().trim().equals(this.jTextFieldCalle1Receptor.getText().trim())
                    && this.jTextFieldNroPuertaEmisor.getText().trim().equals(this.jTextFieldNroPuertaReceptor.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Las calles y números de puerta no pueden ser iguales", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (this.jTextFieldCalle1Emisor.getText().trim().isBlank() || this.jTextFieldApartamentoEmisor.getText().trim().isBlank()
                    || this.jTextFieldCalle1Receptor.getText().trim().isBlank() || this.jTextFieldApartamentoReceptor.getText().trim().isBlank()) {
                JOptionPane.showMessageDialog(null, "Las calles y números de puerta no pueden ser vacías", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                //Se edita la dirección origen
                Direccion dirOrigen = this.fb.getControladorDireccion().traerDireccion(envio.getDireccionOrigen().getIdDireccion());
                this.fb.getControladorDireccion().editarDireccion(dirOrigen.getIdDireccion(), this.jTextFieldCalle1Emisor.getText().trim(),
                        this.jTextFieldCalle2Emisor.getText().trim(), this.jTextFieldApartamentoEmisor.getText().trim(),
                        Integer.parseInt(this.jTextFieldNroPuertaEmisor.getText().trim()));
                //Se edita la dirección destino
                Direccion dirDestino = this.fb.getControladorDireccion().traerDireccion(envio.getDireccionDestino().getIdDireccion());
                this.fb.getControladorDireccion().editarDireccion(dirDestino.getIdDireccion(), this.jTextFieldCalle1Receptor.getText().trim(),
                        this.jTextFieldCalle2Receptor.getText().trim(), this.jTextFieldApartamentoReceptor.getText().trim(),
                        Integer.parseInt(this.jTextFieldNroPuertaReceptor.getText().trim()));
                //Se crea el estado nuevo
                ArrayList<Estado> estados = envio.getEstados();
                int idUltimo = 0;
                for (Estado estado : estados) {
                    if (estado.getIdEstado() > idUltimo) {
                        idUltimo = estado.getIdEstado();
                    }
                }
                Estado estadoFinal = Fabrica.getInstancia().getControladorEstado().obtenerElEstado(idUltimo, idEnvio);
                String estadoNuevo = "";
                if (!estadoFinal.getTipo().getEstado().equals(jComboBoxEstados.getSelectedItem().toString())) {
                    estadoNuevo = jComboBoxEstados.getSelectedItem().toString().equals("Listo para entregar") ? "ListoParaRetirar" : "EnCamino";
                    this.IE.crearEstado(idEnvio, estadoNuevo, "");
                }
                String comboBoxItem = jComboBoxEstados.getSelectedItem().toString();
                this.jComboBoxEstados.removeAllItems();
                this.jComboBoxEstados.getItemCount();
                this.jComboBoxEstados.addItem(comboBoxItem);
                JOptionPane.showMessageDialog(null, "Edición confirmada", "Edición exitosa", JOptionPane.INFORMATION_MESSAGE);
                jButtonEditarEnvio.setEnabled(true);
                labelTitulo.setText("DETALLES DEL ENVÍO");
                buttonCancelarEnvio.setText("Cancelar envío");
                buttonConfirmarEnvio.setText("Confirmar envío");
                this.AccederDetallesEnvio(idEnvio);
            }
        }
        if (this.listEnvios != null) {
            this.listEnvios.actualizarListaDeEnvios();
        }
    }//GEN-LAST:event_buttonConfirmarEnvioActionPerformed

    private void jButtonEditarEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarEnvioActionPerformed
        // TODO add your handling code here:
        jButtonEditarEnvio.setEnabled(false);
        labelTitulo.setText("    EDITAR ENVÍO");
        buttonCancelarEnvio.setText("Cancelar edición");
        buttonConfirmarEnvio.setText("Confirmar edición");
        //this.jTextAreaDescripcion.setEditable(true);
        this.jTextFieldCalle1Emisor.setEditable(true);
        this.jTextFieldCalle1Receptor.setEditable(true);
        this.jTextFieldCalle2Emisor.setEditable(true);
        this.jTextFieldCalle2Receptor.setEditable(true);
        this.jTextFieldApartamentoEmisor.setEditable(true);
        this.jTextFieldApartamentoReceptor.setEditable(true);
        this.jTextFieldNroPuertaEmisor.setEditable(true);
        this.jTextFieldNroPuertaReceptor.setEditable(true);
        if (jComboBoxEstados.getSelectedItem().toString().equals("En preparación")) {
            jComboBoxEstados.addItem("En camino");
            jComboBoxEstados.addItem("Listo para entregar");
        } else if (jComboBoxEstados.getSelectedItem().toString().equals("En camino")) {
            jComboBoxEstados.addItem("Listo para entregar");
        }
    }//GEN-LAST:event_jButtonEditarEnvioActionPerformed

    private void jTextFieldTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTarifaActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldTarifaActionPerformed

    private void jTextFieldPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecioActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldPrecioActionPerformed

    private void jTextFieldIDPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDPaqueteActionPerformed
        this.setEnabled(false);
    }//GEN-LAST:event_jTextFieldIDPaqueteActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        if (this.listEnvios != null) {
            ListaEnvios listadoEnvios = new ListaEnvios();
            listadoEnvios.setVisible(true);
        } else if (this.vieneDeResumen != null) {
            vieneDeResumen.limpiaListaDePagos();
            vieneDeResumen.listarPagos();
        } else {
            Home home = new Home();
            home.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagarActionPerformed
        PagarEnvio pagarEnvio = new PagarEnvio(this.idEnvio, envio.getPago().getPrecio(), this);
        pagarEnvio.setVisible(true);
    }//GEN-LAST:event_jButtonPagarActionPerformed

    public void actualizarJButtonPago() {
        this.jButtonPagar.setEnabled(false);
        this.jLabelPago.setText("■ Pagado");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(int id, ListaEnvios listEnv) {
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
            java.util.logging.Logger.getLogger(VerDetallesEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerDetallesEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerDetallesEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerDetallesEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerDetallesEnvio(id, listEnv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelarEnvio;
    private javax.swing.JButton buttonConfirmarEnvio;
    private javax.swing.JButton jButtonEditarEnvio;
    private javax.swing.JButton jButtonEditarPaquete;
    private javax.swing.JButton jButtonPagar;
    private javax.swing.JToggleButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBoxEstados;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelApartamentoEmisor;
    private javax.swing.JLabel jLabelApartamentoReceptor;
    private javax.swing.JLabel jLabelCIEmisor;
    private javax.swing.JLabel jLabelCIReceptor;
    private javax.swing.JLabel jLabelCalle1Emisor;
    private javax.swing.JLabel jLabelCalle1Receptor;
    private javax.swing.JLabel jLabelCalle2Emisor;
    private javax.swing.JLabel jLabelCalle2Receptor;
    private javax.swing.JLabel jLabelEmisor;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelIDDelPaquete;
    private javax.swing.JLabel jLabelIDEnvio;
    private javax.swing.JLabel jLabelNombreEmisor;
    private javax.swing.JLabel jLabelNombreReceptor;
    private javax.swing.JLabel jLabelNroPuertaEmisor;
    private javax.swing.JLabel jLabelNroPuertaReceptor;
    private javax.swing.JLabel jLabelPago;
    private javax.swing.JLabel jLabelReceptor;
    private javax.swing.JLabel jLabelTarifa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldApartamentoEmisor;
    private javax.swing.JTextField jTextFieldApartamentoReceptor;
    private javax.swing.JTextField jTextFieldCIEmisor;
    private javax.swing.JTextField jTextFieldCIReceptor;
    private javax.swing.JTextField jTextFieldCalle1Emisor;
    private javax.swing.JTextField jTextFieldCalle1Receptor;
    private javax.swing.JTextField jTextFieldCalle2Emisor;
    private javax.swing.JTextField jTextFieldCalle2Receptor;
    private javax.swing.JTextField jTextFieldIDPaquete;
    private javax.swing.JTextField jTextFieldNombreEmisor;
    private javax.swing.JTextField jTextFieldNombreReceptor;
    private javax.swing.JTextField jTextFieldNroPuertaEmisor;
    private javax.swing.JTextField jTextFieldNroPuertaReceptor;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTarifa;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}
