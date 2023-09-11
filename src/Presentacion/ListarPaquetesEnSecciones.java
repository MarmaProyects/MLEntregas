/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.clases.Paquete;
import logica.clases.Seccion;
import logica.clases_customs.CenterRenderer;
import logica.fabrica.Fabrica;

/**
 *
 * @author leo
 */
public class ListarPaquetesEnSecciones extends javax.swing.JFrame {

    private Fabrica fb;

    /**
     * Creates new form ListarPaquetesEnSecciones
     */
    public ListarPaquetesEnSecciones() {
        initComponents();
        this.setTitle("MLEntregas");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.fb = Fabrica.getInstancia();
        this.cargarDatosSeccion();
    }

    private void cargarDatosSeccion() {
        ArrayList<Seccion> secciones = fb.getControladorSeccion().obtenerLasSecciones();
        for (Seccion seccion : secciones) {
            ArrayList<Paquete> paquetes = this.fb.getControladorPaquete().listarPaquetesPorSeccion(seccion.getIdSeccion());
            DefaultTableModel modelo = (DefaultTableModel) this.tablaPaquetes.getModel();
            for (Paquete paq : paquetes) {
                Object[] row = {paq.getIdPaquete(), paq.getPeso(), paq.getDescripcion(), seccion.getNombre(), seccion.getIdSeccion()};
                modelo.addRow(row);
            }
        }
        this.tablaPaquetes.getColumnModel().getColumn(0).setCellRenderer(new CenterRenderer());
        this.tablaPaquetes.getColumnModel().getColumn(1).setCellRenderer(new CenterRenderer());
        this.tablaPaquetes.getColumnModel().getColumn(2).setCellRenderer(new CenterRenderer());
        this.tablaPaquetes.getColumnModel().getColumn(3).setCellRenderer(new CenterRenderer());
    }

    public void actualizarDatosSeccion() {
        DefaultTableModel model = (DefaultTableModel) tablaPaquetes.getModel();
        int i = tablaPaquetes.getRowCount();
        while (i != 0) {
            model.removeRow(0);
            i--;
        }
        this.cargarDatosSeccion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaquetes = new javax.swing.JTable();
        jButtonVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonVerSeccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1098, 700));

        tablaPaquetes.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tablaPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Peso", "Descripción", "Seccion", "IdSeccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            tablaPaquetes.getColumnModel().getColumn(0).setPreferredWidth(4);
            tablaPaquetes.getColumnModel().getColumn(1).setResizable(false);
            tablaPaquetes.getColumnModel().getColumn(1).setPreferredWidth(2);
            tablaPaquetes.getColumnModel().getColumn(2).setPreferredWidth(150);
            tablaPaquetes.getColumnModel().getColumn(3).setPreferredWidth(90);
            tablaPaquetes.getColumnModel().getColumn(4).setMinWidth(0);
            tablaPaquetes.getColumnModel().getColumn(4).setPreferredWidth(0);
            tablaPaquetes.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jButtonVolver.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("LISTADO DE PAQUETES");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo-sm.png"))); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo-sm.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        botonVerSeccion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        botonVerSeccion.setText("Ver Seccion");
        botonVerSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerSeccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 110, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(589, 589, 589)
                                .addComponent(botonVerSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 110, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonVerSeccion, jButtonVolver});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVerSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botonVerSeccion, jButtonVolver});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        Home home = new Home();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MousePressed

    private void botonVerSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerSeccionActionPerformed
        int row = tablaPaquetes.getSelectedRow();
        if (row != -1) {
            int idSeccion = Integer.parseInt(this.tablaPaquetes.getValueAt(row, 4).toString());
            EditarSeccion verSeccionSeleccionada = new EditarSeccion(idSeccion, this);
            verSeccionSeleccionada.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún paquete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonVerSeccionActionPerformed

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
            java.util.logging.Logger.getLogger(ListarPaquetesEnSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarPaquetesEnSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarPaquetesEnSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarPaquetesEnSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarPaquetesEnSecciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonVerSeccion;
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPaquetes;
    // End of variables declaration//GEN-END:variables
}
