/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package widgetshechos;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Manana
 */
public class TablaColores extends DefaultTableCellRenderer {
    public TablaColores() {
    }
    
    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component celda = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        if (!isSelected) {
            if (row % 2 == 0) {
                celda.setBackground(Color.LIGHT_GRAY); 
            } else {
                celda.setBackground(Color.WHITE); 
            }
        } else {
            celda.setBackground(Color.BLUE); // fila seleccionada
            celda.setForeground(Color.WHITE);
        }
        return celda;
    }
}
