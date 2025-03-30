/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colorcombobox;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Manana
 */
public class ColorComboBox extends JComboBox<Color>{

    public ColorComboBox() {
        this(new Color[] {Color.WHITE, Color.YELLOW, Color.ORANGE, Color.RED, Color.PINK, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.BLACK});
    }
    
    public ColorComboBox(Color[] colores) {
        super(colores);
        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) { 
                JLabel l = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                l.setBackground((Color) value);
                l.setText(" ");
                return l;
            }           
        });
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground((Color) getSelectedItem());
            }
        });
    }
    
    
 
}

