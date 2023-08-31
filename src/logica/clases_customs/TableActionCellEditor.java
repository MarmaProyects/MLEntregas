package logica.clases_customs;

import Presentacion.PanelAction;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import logica.interfaces.ITableActionEvent;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MarmaduX
 */
public class TableActionCellEditor extends DefaultCellEditor {
    
    private ITableActionEvent event;
    
    public TableActionCellEditor(ITableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction action = new PanelAction();
        action.initEvent(event, Integer.parseInt(table.getValueAt(row, 0).toString()), row);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
    
    
}
