/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases_customs;

import Presentacion.PanelAction;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author MarmaduX
 */
public class TableActionCellRender extends DefaultTableCellRenderer {

    public TableActionCellRender(){
        setHorizontalAlignment(JLabel.CENTER);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        PanelAction action = new PanelAction();
        if (isSelected == false ) {
            action.setBackground(com.getBackground());
        }
        return action;
    }

}
