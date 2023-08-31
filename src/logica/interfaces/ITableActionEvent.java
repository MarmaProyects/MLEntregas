/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.interfaces;

/**
 *
 * @author MarmaduX
 */
public interface ITableActionEvent {
    public abstract void onEdit(int id);
    public abstract void onDelete(int id, int row);
    public abstract void onView(int id);
}
