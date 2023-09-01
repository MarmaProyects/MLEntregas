/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.clases_customs.TableActionCellRender;
import logica.clases_customs.TableActionCellEditor;
import logica.clases.Tarifa;
import logica.fabrica.Fabrica;
import logica.interfaces.IAdministracion;
import logica.interfaces.ITableActionEvent;



/**
 *
 * @author MarmaduX
 */
public class ListaTarifas extends javax.swing.JFrame {

    private IAdministracion IA;

    /**
     * Creates new form ListaTarifas
     */
    public ListaTarifas() {
        initComponents();
        this.IA = Fabrica.getInstancia().getControladorTarifa();
        this.cargarTodasLasTarifas();
        ITableActionEvent event = new ITableActionEvent() {

            @Override
            public void onEdit(int id) {
                EditarTarifa editTarifa = new EditarTarifa(id);
                editTarifa.setVisible(true);
                setVisible(false);
            }

            @Override
            public void onDelete(int id, int row) {
                if (IA.eliminarTarifaSeleccionada(id)) {
                    JOptionPane.showMessageDialog(null, "La tarifa fue eliminada con exito", "Success", JOptionPane.DEFAULT_OPTION);
                    if (tableTarifa.isEditing()) {
                        tableTarifa.getCellEditor().stopCellEditing();
                    }
                    DefaultTableModel model = (DefaultTableModel) tableTarifa.getModel();
                    model.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(null, "La tarifa esta en uso por lo que no se puede eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void onView(int id) {
                EditarTarifa editTarifa = new EditarTarifa(id);
                editTarifa.setVisible(true);
                setVisible(false);
            }
        };
        this.tableTarifa.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        this.tableTarifa.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableTarifa = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableTarifa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Precio", "Acciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTarifa.setRowHeight(30);
        jScrollPane1.setViewportView(tableTarifa);
        if (tableTarifa.getColumnModel().getColumnCount() > 0) {
            tableTarifa.getColumnModel().getColumn(0).setMinWidth(0);
            tableTarifa.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableTarifa.getColumnModel().getColumn(0).setMaxWidth(0);
            tableTarifa.getColumnModel().getColumn(1).setResizable(false);
            tableTarifa.getColumnModel().getColumn(2).setResizable(false);
            tableTarifa.getColumnModel().getColumn(3).setResizable(false);
            tableTarifa.getColumnModel().getColumn(3).setPreferredWidth(23);
        }

        jButton3.setText("Crear tarifas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Volver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("TARIFAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CrearTarifa crearTarifa = new CrearTarifa();
        this.setVisible(false);
        crearTarifa.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ListaTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaTarifas().setVisible(true);
            }
        });
    }

    private void cargarTodasLasTarifas() {
        ArrayList<Tarifa> listaDeTarifas = this.IA.listarTarifas();

        DefaultTableModel modelo = (DefaultTableModel) this.tableTarifa.getModel();

        for (Tarifa tarifa : listaDeTarifas) {
            Object[] row = {tarifa.getIdTarifa(), tarifa.getNombre(), tarifa.getPrecio()};
            modelo.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTarifa;
    // End of variables declaration//GEN-END:variables
}
