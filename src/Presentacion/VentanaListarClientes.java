/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logica.clases.Cliente;
import logica.fabrica.Fabrica;
import logica.interfaces.IEnvio;
import Presentacion.CrearEnvio;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Angelo
 */
public class VentanaListarClientes extends javax.swing.JFrame {

    private IEnvio iEnvio;

    public VentanaListarClientes() {
        initComponents();
        this.iEnvio = Fabrica.getInstancia().getControladorEnvio();
        this.cargarTablaClientesE();
        this.limpiarTabla();
        this.cargarTablaClientesE();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientesE = new javax.swing.JTable();
        botonSeleccionar = new javax.swing.JButton();
        botonVolverClienteE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("LISTA DE CLIENTES:");

        tablaClientesE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaClientesE);

        botonSeleccionar.setText("Seleccionar");
        botonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarActionPerformed(evt);
            }
        });

        botonVolverClienteE.setText("Volver");
        botonVolverClienteE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverClienteEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(botonVolverClienteE)
                .addGap(182, 182, 182)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(botonVolverClienteE))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botonSeleccionar)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
        // TODO add your handling code here:
        
        if (tablaClientesE.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun cliente", "ERROR AL SELECCIONAR CLIENTE EMISOR", JOptionPane.WARNING_MESSAGE);
        } else {
                CrearEnvio.campoCedulaE.setText(tablaClientesE.getValueAt(tablaClientesE.getSelectedRow(), 0).toString());
                CrearEnvio.campoNombreE.setText(tablaClientesE.getValueAt(tablaClientesE.getSelectedRow(), 1).toString());
                CrearEnvio.campoApellidoE.setText(tablaClientesE.getValueAt(tablaClientesE.getSelectedRow(), 2).toString());
                this.setVisible(false);
        }
        
    }//GEN-LAST:event_botonSeleccionarActionPerformed

    private void botonVolverClienteEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverClienteEActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_botonVolverClienteEActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaListarClientes().setVisible(true);
            }
        });
    }

    //LISTAR OBJETOS DE TIPO CLIENTE
    private void cargarTablaClientesE() {

        ArrayList<Cliente> listaClientesE = this.iEnvio.listarClientes();

        DefaultTableModel modeloTablaClienteE = (DefaultTableModel) this.tablaClientesE.getModel();
        for (Cliente clienteE : listaClientesE) {
            Object[] row = {clienteE.getCedula(), clienteE.getNombre(), clienteE.getApellido(), clienteE.getTelefono()};
            modeloTablaClienteE.addRow(row);
        }
    }

    private void limpiarTabla() {
        DefaultTableModel modeloTablaClienteE = (DefaultTableModel) this.tablaClientesE.getModel();
        int filas = modeloTablaClienteE.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTablaClienteE.removeRow(0);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JButton botonVolverClienteE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientesE;
    // End of variables declaration//GEN-END:variables
}