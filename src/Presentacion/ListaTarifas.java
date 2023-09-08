/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logica.clases_customs.TableActionCellRender;
import logica.clases_customs.TableActionCellEditor;
import logica.clases.Tarifa;
import logica.clases_customs.CenterRenderer;
import logica.fabrica.Fabrica;
import logica.interfaces.IAdministracion;
import logica.interfaces.ITableActionEvent;



/**
 *
 * @author MarmaduX
 */
public class ListaTarifas extends javax.swing.JFrame {

    private IAdministracion IA;
    private ITableActionEvent event = null;
    private DefaultTableCellRenderer centerRenderer = null;
    private ListaTarifas listaTarifas = null;
    /**
     * Creates new form ListaTarifas
     */
    public ListaTarifas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("MLEntregas");
        this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Images/logo.png")).getImage());
        this.IA = Fabrica.getInstancia().getControladorTarifa();
        this.setResizable(false);
        this.cargarTodasLasTarifas();
        this.centerRenderer = new CenterRenderer();
        this.listaTarifas = this;
        this.event = new ITableActionEvent() {

            @Override
            public void onEdit(int id) {
                EditarTarifa editTarifa = new EditarTarifa(id, listaTarifas);
                editTarifa.setVisible(true);
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
                EditarTarifa editTarifa = new EditarTarifa(id, listaTarifas);
                editTarifa.setVisible(true);
            }
        };
        this.tableTarifa.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        this.tableTarifa.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(this.event));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        volverButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1098, 700));

        tableTarifa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
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
                true, false, false, true
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

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("LISTADO DE TARIFAS");

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

        volverButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton3.setText("Crear tarifas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton3, volverButton});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton3, volverButton});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CrearTarifa crearTarifa = new CrearTarifa(this);
        crearTarifa.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        Home home = new Home();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MousePressed

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        Home home = new Home();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_volverButtonActionPerformed

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
        this.tableTarifa.getColumnModel().getColumn(1).setCellRenderer(new CenterRenderer());
        this.tableTarifa.getColumnModel().getColumn(2).setCellRenderer(new CenterRenderer());
    }
    
    private void limpiarTabla(){
        DefaultTableModel model = (DefaultTableModel) tableTarifa.getModel();
        int i = tableTarifa.getRowCount();
        while (i != 0) {
            model.removeRow(0);
            i--;
        }
    }
    
    public void actualizarTabla(){
        this.limpiarTabla();
        this.cargarTodasLasTarifas();
        this.tableTarifa.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        this.tableTarifa.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(this.event));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTarifa;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
