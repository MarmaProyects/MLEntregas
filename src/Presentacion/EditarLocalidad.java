/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.clases.Localidad;
import logica.fabrica.Fabrica;
import logica.interfaces.IProximidad;

/**
 *
 * @author leo
 */
public class EditarLocalidad extends javax.swing.JFrame {

    private IProximidad IP;
    int idDeLocalidad, codigoPostalLocalidad;
    String nombreLocalidad;

    /**
     * Creates new form EditarLocalidad
     */
    public EditarLocalidad(int idLocalidad) {
        initComponents();
        this.idDeLocalidad = idLocalidad;
        this.IP = Fabrica.getInstancia().getControladorLocalidad();
        Localidad localidad = null;
        ArrayList<Localidad> localidades = IP.obtenerLasLocalidades();
        for (Localidad L : localidades) {
            if (L.getIdLocalidad() == idLocalidad) {
                localidad = L;
            }
        }
        this.nombreLocalidad = localidad.getNombre();
        this.codigoPostalLocalidad = localidad.getCodigoPostal();
        this.campoNombre.setText(localidad.getNombre());
        this.campoCodigoPostal.setText(String.valueOf(localidad.getCodigoPostal()));
    }

    public void llamarAlertaLocalidadEditada() {
        JOptionPane.showMessageDialog(null, "Localidad editada", "Edición exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    public void llamarAlertaCodigoPostalIncompleto() {
        JOptionPane.showMessageDialog(null, "El código postal está incompleto", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void llamarAlertaCamposSinEditar() {
        JOptionPane.showMessageDialog(null, "Los campos no han sido modificados", "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoCodigoPostal = new javax.swing.JTextField();
        jLabelNombreLocalidad = new javax.swing.JLabel();
        jLabelCodigoPostal = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setText("Editar Localidad");

        campoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNombreFocusLost(evt);
            }
        });
        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });

        campoCodigoPostal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoCodigoPostalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCodigoPostalFocusLost(evt);
            }
        });
        campoCodigoPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCodigoPostalActionPerformed(evt);
            }
        });
        campoCodigoPostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCodigoPostalKeyTyped(evt);
            }
        });

        jLabelNombreLocalidad.setText("Nuevo nombre");

        jLabelCodigoPostal.setText("Código Postal");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNombreLocalidad)
                    .addComponent(jLabelCodigoPostal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfirmar))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombreLocalidad))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCodigoPostal))
                .addGap(26, 26, 26)
                .addComponent(jButtonConfirmar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if (!this.campoNombre.getText().trim().equals(this.nombreLocalidad) || !this.campoCodigoPostal.getText().trim().equals(String.valueOf(this.codigoPostalLocalidad))) {
            if (this.campoCodigoPostal.getText().trim().length() >= 5) {
                this.IP.editarLaLocalidad(this.idDeLocalidad, this.campoNombre.getText(), Integer.parseInt(this.campoCodigoPostal.getText()));
                llamarAlertaLocalidadEditada();
            } else {
                llamarAlertaCodigoPostalIncompleto();
            }
        } else {
            llamarAlertaCamposSinEditar();
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void campoCodigoPostalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCodigoPostalKeyTyped
        int key = evt.getKeyChar();
        if (!Character.isDigit(key)) {
            evt.consume();
        }

        if (campoCodigoPostal.getText().trim().length() == 5) {
            evt.consume();
        }
    }//GEN-LAST:event_campoCodigoPostalKeyTyped

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void campoCodigoPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCodigoPostalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCodigoPostalActionPerformed

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        int key = evt.getKeyChar();

        if (campoNombre.getText().trim().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreFocusGained
        if (campoNombre.getText().trim().equals(this.nombreLocalidad)) {
            campoNombre.setText(null);
            campoNombre.requestFocus();
        }
    }//GEN-LAST:event_campoNombreFocusGained

    private void campoNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreFocusLost
        if (campoNombre.getText().trim().length() == 0) {
            campoNombre.setText(this.nombreLocalidad);
        }
    }//GEN-LAST:event_campoNombreFocusLost

    private void campoCodigoPostalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCodigoPostalFocusLost
        if (campoCodigoPostal.getText().trim().length() == 0) {
            campoCodigoPostal.setText(String.valueOf(this.codigoPostalLocalidad));
        }
    }//GEN-LAST:event_campoCodigoPostalFocusLost

    private void campoCodigoPostalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCodigoPostalFocusGained
        if (campoCodigoPostal.getText().trim().equals(String.valueOf(this.codigoPostalLocalidad))) {
            campoCodigoPostal.setText(null);
            campoCodigoPostal.requestFocus();
        }
    }//GEN-LAST:event_campoCodigoPostalFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(int idLocalidad) {
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
            java.util.logging.Logger.getLogger(EditarLocalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarLocalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarLocalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarLocalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarLocalidad(idLocalidad).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoCodigoPostal;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelCodigoPostal;
    private javax.swing.JLabel jLabelNombreLocalidad;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}
