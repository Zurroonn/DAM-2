/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exameninterfaces2alejandrozurron;

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
public class Combobox extends JComboBox<String>{

       public Combobox(){
            super(new String[] {"Avila","Burgos","Leon","Palencia","Salamanca","Segovia","Soria","Valladolid","Zamora"});
            setRenderer(new PaisRenderer());
       }
       
       public class PaisRenderer extends DefaultListCellRenderer{
           
        ArrayList<ImageIcon> escudos = new ArrayList<>();
           
        public PaisRenderer(){
            escudos.add(new ImageIcon(getClass().getResource("Avila.png")));
            escudos.add(new ImageIcon(getClass().getResource("Burgos.png")));
            escudos.add(new ImageIcon(getClass().getResource("Leon.png")));
            escudos.add(new ImageIcon(getClass().getResource("Palencia.png")));
            escudos.add(new ImageIcon(getClass().getResource("Salamanca.png")));
            escudos.add(new ImageIcon(getClass().getResource("Segovia.png")));
            escudos.add(new ImageIcon(getClass().getResource("Soria.png")));
            escudos.add(new ImageIcon(getClass().getResource("Valladolid.png")));
            escudos.add(new ImageIcon(getClass().getResource("Zamora.png")));
        }
           
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel l=(JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            
            l.setIcon(escudos.get(index));
            
            
            return l;
        }

       }
}
