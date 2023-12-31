/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.clases.Localidad;
import logica.clases.Paquete;
import logica.clases.Seccion;
import logica.clases_customs.CenterRenderer;
import logica.fabrica.Fabrica;

/**
 *
 * @author franc
 */
public class EditarSeccion extends javax.swing.JFrame {

    private Fabrica fb;
    private int id = -1;
    private Seccion seccion = null;
    ArrayList<Seccion> secciones = new ArrayList<Seccion>();
    ArrayList<Localidad> localidades = new ArrayList<Localidad>();
    private ListarSecciones listarSecciones = null;
    int localidadSelect = 0;
    private ListarPaquetesEnSecciones listaPaquete = null;

    /**
     * Creates new form EditarSeccion
     */
    public EditarSeccion(int id, ListarSecciones listarSecciones) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Crear Seccion");
        this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Images/logo.png")).getImage());
        this.listarSecciones = listarSecciones;
        this.fb = Fabrica.getInstancia();
        this.id = id;
        if (id != -1) {
            this.seccion = this.fb.getControladorSeccion().traerSeccionSeleccionada(id);
            this.localidades = this.fb.getControladorLocalidad().obtenerLasLocalidades();
            this.localidadComboBox.addItem(" ");
            for (Localidad loc : localidades) {
                this.localidadComboBox.addItem(loc.getNombre());
            }
            this.nombreField.setText(seccion.getNombre());
            this.localidadComboBox.setSelectedIndex(seccion.getIdLocalidad());
            this.localidadSelect = seccion.getIdLocalidad() - 1;
            this.secciones = this.fb.getControladorSeccion().obtenerLasSecciones();
            ArrayList<Localidad> localidades = this.fb.getControladorLocalidad().obtenerLasLocalidades();
            this.comboBoxSecciones.addItem(" ");
            for (Seccion sec : secciones) {
                if (sec.getIdLocalidad() != -1) {
                    for (Localidad loc : localidades) {
                        if (sec.getIdLocalidad() == loc.getIdLocalidad()) {
                            this.comboBoxSecciones.addItem(sec.getNombre() + " - " + loc.getNombre());
                            break;
                        }
                    }
                } else {
                    this.comboBoxSecciones.addItem(sec.getNombre());
                }
            }
            this.cargarDatosSeccion();
        } else {
            this.editButton.setVisible(false);
        }
        this.tablaPaquetes.getTableHeader().setReorderingAllowed(false);
    }

    public EditarSeccion(int id, ListarPaquetesEnSecciones listaPaquete) {
        initComponents();
        this.setResizable(false);
        this.listaPaquete = listaPaquete;
        this.setLocationRelativeTo(null);
        this.setTitle("Crear Seccion");
        this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Images/logo.png")).getImage());
        this.fb = Fabrica.getInstancia();
        this.id = id;
        if (id != -1) {
            this.seccion = this.fb.getControladorSeccion().traerSeccionSeleccionada(id);
            this.localidades = this.fb.getControladorLocalidad().obtenerLasLocalidades();
            this.localidadComboBox.addItem(" ");
            for (Localidad loc : localidades) {
                this.localidadComboBox.addItem(loc.getNombre());
            }
            this.nombreField.setText(seccion.getNombre());
            this.localidadComboBox.setSelectedIndex(seccion.getIdLocalidad());
            this.localidadSelect = seccion.getIdLocalidad() - 1;
            this.secciones = this.fb.getControladorSeccion().obtenerLasSecciones();
            ArrayList<Localidad> localidades = this.fb.getControladorLocalidad().obtenerLasLocalidades();
            this.comboBoxSecciones.addItem(" ");
            for (Seccion sec : secciones) {
                if (sec.getIdLocalidad() != -1) {
                    for (Localidad loc : localidades) {
                        if (sec.getIdLocalidad() == loc.getIdLocalidad()) {
                            this.comboBoxSecciones.addItem(sec.getNombre() + " - " + loc.getNombre());
                            break;
                        }
                    }
                } else {
                    this.comboBoxSecciones.addItem(sec.getNombre());
                }
            }
            this.cargarDatosSeccion();
        } else {
            this.editButton.setVisible(false);
        }
        this.tablaPaquetes.getTableHeader().setReorderingAllowed(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaquetes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        localidadComboBox = new javax.swing.JComboBox<>();
        nombreField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        comboBoxSecciones = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        moverPaqueteButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(null);

        tablaPaquetes.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tablaPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripción", "Peso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPaquetes);
        if (tablaPaquetes.getColumnModel().getColumnCount() > 0) {
            tablaPaquetes.getColumnModel().getColumn(0).setResizable(false);
            tablaPaquetes.getColumnModel().getColumn(1).setResizable(false);
            tablaPaquetes.getColumnModel().getColumn(2).setResizable(false);
        }

        localidadComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        nombreField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombreField.setMaximumSize(new java.awt.Dimension(64, 26));
        nombreField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreFieldKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Localidad:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(localidadComboBox, 0, 206, Short.MAX_VALUE)
                    .addComponent(nombreField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(localidadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboBoxSecciones.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        comboBoxSecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSeccionesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Mover a:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboBoxSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        moverPaqueteButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        moverPaqueteButton.setText("Mover paquete");
        moverPaqueteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverPaqueteButtonActionPerformed(evt);
            }
        });

        volverButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        editButton.setText("Editar sección");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volverButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(moverPaqueteButton)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {editButton, moverPaqueteButton, volverButton});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moverPaqueteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(volverButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel1.setText("SECCIÓN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 43, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo-sm-extra.png"))); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        if (this.listaPaquete != null) {
            this.setVisible(false);
            listaPaquete.actualizarDatosSeccion();
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_volverButtonActionPerformed

    private void comboBoxSeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSeccionesActionPerformed

    }//GEN-LAST:event_comboBoxSeccionesActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        int idLocalidad = 0;
        if (!this.localidadComboBox.getSelectedItem().toString().equals(" ")) {
            for (Localidad loc : localidades) {
                if (loc.getNombre().equals(localidadComboBox.getSelectedItem().toString())) {
                    idLocalidad = loc.getIdLocalidad();
                    break;
                }
            }
        }
        if (this.fb.getControladorSeccion().editarSeccionSeleccionada(seccion.getIdSeccion(), this.nombreField.getText().trim(), idLocalidad)) {
            JOptionPane.showMessageDialog(null, "La sección fue editada con exito", "Success", JOptionPane.DEFAULT_OPTION);
            if (this.listarSecciones != null) {
                this.listarSecciones.actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un error inesperado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void moverPaqueteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverPaqueteButtonActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea mover el paquete?",
                "Mover paquete", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            int row = this.tablaPaquetes.getSelectedRow();
            int idSeccion = 0;
            String sec = "";
            String seccionSeleccionada = this.comboBoxSecciones.getSelectedItem().toString();
            if (row != -1 && !seccionSeleccionada.equals(" ")) {
                int idPaquete = Integer.parseInt(this.tablaPaquetes.getValueAt(row, 0).toString());
                if (seccionSeleccionada.contains(" - ")) {
                    int indiceGuion = seccionSeleccionada.indexOf(" - ");
                    sec = seccionSeleccionada.substring(0, indiceGuion);
                } else {
                    sec = seccionSeleccionada;
                }
                for (Seccion secc : this.secciones) {
                    if (secc.getNombre().equals(sec)) {
                        idSeccion = secc.getIdSeccion();
                        break;
                    }
                }
                this.fb.getControladorPaquete().moverPaqueteASeccion(idPaquete, idSeccion);
                DefaultTableModel model = (DefaultTableModel) tablaPaquetes.getModel();
                model.removeRow(tablaPaquetes.getSelectedRow());
                if (this.listarSecciones != null) {
                    this.listarSecciones.actualizarTabla();
                }
                JOptionPane.showMessageDialog(null, "El paquete fue movido con éxito", "Success", JOptionPane.DEFAULT_OPTION);
            } else {
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un paquete para poder moverlo", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (seccionSeleccionada.equals(" ")) {
                        JOptionPane.showMessageDialog(null, "Ingrese una sección a la cual mover el paquete", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_moverPaqueteButtonActionPerformed

    private void nombreFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreFieldKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        if (key == '-') {
            evt.consume();
        }
        if (nombreField.getText().trim().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_nombreFieldKeyTyped

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed

    }//GEN-LAST:event_jLabel5MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[], ListarSecciones listarSecciones) {
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
            java.util.logging.Logger.getLogger(EditarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarSeccion(-1, listarSecciones).setVisible(true);
            }
        });
    }

    private void cargarDatosSeccion() {
        ArrayList<Paquete> paquetes = this.fb.getControladorPaquete().listarPaquetesPorSeccion(seccion.getIdSeccion());
        DefaultTableModel modelo = (DefaultTableModel) this.tablaPaquetes.getModel();
        for (Paquete paq : paquetes) {
            Object[] row = {paq.getIdPaquete(), paq.getDescripcion(), paq.getPeso()};
            modelo.addRow(row);
        }
        this.tablaPaquetes.getColumnModel().getColumn(0).setCellRenderer(new CenterRenderer());
        this.tablaPaquetes.getColumnModel().getColumn(1).setCellRenderer(new CenterRenderer());
        this.tablaPaquetes.getColumnModel().getColumn(2).setCellRenderer(new CenterRenderer());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxSecciones;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> localidadComboBox;
    private javax.swing.JButton moverPaqueteButton;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTable tablaPaquetes;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
