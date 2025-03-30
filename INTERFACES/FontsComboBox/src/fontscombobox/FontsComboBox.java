/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fontscombobox;

import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Manana
 */
public class FontsComboBox extends JComboBox<Font> {

    public FontsComboBox() {
        super(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts());
        setRenderer(new FuentesRenderer());
    }
    
    public class FuentesRenderer extends DefaultListCellRenderer{

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel l= (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            Font f= (Font)value;
            
            l.setText(f.getName());
            l.setFont(f.deriveFont(16f));
            return l;
        }
        
        
        
        
        
    }
}