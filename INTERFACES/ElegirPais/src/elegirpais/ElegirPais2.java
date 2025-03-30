/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package elegirpais;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Manana
 */
public class ElegirPais2 extends JComboBox<String>{

       public ElegirPais2(){
            super(new String[] {"España","Argentina","Italia","Alemania"});
            setRenderer(new PaisRenderer());
       }
       
       public class PaisRenderer extends DefaultListCellRenderer{
           
        ArrayList<ImageIcon> banderas = new ArrayList<>();
           
        public PaisRenderer(){
            banderas.add(new ImageIcon(getClass().getResource("resources/nf.png")));
            banderas.add(new ImageIcon(getClass().getResource("resources/ng.png")));
            banderas.add(new ImageIcon(getClass().getResource("resources/no.png")));
            banderas.add(new ImageIcon(getClass().getResource("resources/pe.png")));
        
        }
           
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel l=(JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            
            l.setIcon(banderas.get(index));
            
            
            return l;
        }

       }
}
