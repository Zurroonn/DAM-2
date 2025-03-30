/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package blackjack;

import CA.CA;
import Menu.Menu;
import Menu.UsuarioDAO;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author aazur
 */
public class BlackJack extends javax.swing.JFrame {

    private static int dinerousuario = 0;
    private static String usuario;
    private static int comprobaciondinero=0;
    
    private static UsuarioDAO userdao = new UsuarioDAO();

    private List<String[]> cartasJugadorValores = new ArrayList<>(); // Guarda el nombre y la imagen de la carta
    private List<String[]> cartasDealerValores = new ArrayList<>(); // Guarda el nombre y la imagen de cada carta

    private List<JLabel> cartasJugador = new ArrayList<>();
    private List<JLabel> cartasDealer = new ArrayList<>();
    private int contases = 0;

    private static Baraja baraja = new Baraja();


    private static int apuestaenvivo = 0;
    
    ImageIcon imagen = new ImageIcon(getClass().getResource("/Dados/fichicas.png"));

    FondoPanel panel = new FondoPanel();
    
    enum Apostar {
        cinco,
        diez,
        veinticinco,
        cincuenta,
        setentaycinco,
        cien,
        cero

    }
    Apostar apostador = Apostar.cero;

    /**
     * Creates new form WhiteJack
     */
    public BlackJack() {
        comprobaciondinero=dinerousuario;
        this.setContentPane(panel);
        initComponents();

    }

    public BlackJack(String jugador, int dinero) {
        usuario = jugador;
        dinerousuario = dinero;
        comprobaciondinero=dinerousuario;
        this.setContentPane(panel);
        initComponents();
    }

    public boolean verificarBlackJack(int sumajugador, int sumadealer, ImageIcon imagen) {
        if (sumajugador == 21 && sumadealer != 21) {
            D2.setIcon(imagen);
            JOptionPane.showMessageDialog(this, "GANASTE!");
            ganarapuesta();
            reseteo();
            return true;
        }

        if (sumajugador == 21 && sumadealer == 21) {
            D2.setIcon(imagen);
            JOptionPane.showMessageDialog(this, "EMPATASTE!");
            reseteo();
            return true;
        }

        return false;
    }

    public int turnoJugador(int sumajugador) {
        String[] cartaElegida = baraja.robarCarta();
        ImageIcon imagenCarta = new ImageIcon(getClass().getResource(cartaElegida[1]));

        JLabel nuevaCarta = new JLabel();
        nuevaCarta.setIcon(imagenCarta);

        cartasJugador.add(nuevaCarta);
        cartasJugadorValores.add(cartaElegida);

        cartasjugador.add(nuevaCarta);
        cartasjugador.revalidate();
        cartasjugador.repaint();

        sumajugador += comprobarNumero(cartaElegida[0], sumajugador);
        sumajugador = ajustarAses(sumajugador, cartasJugadorValores);

        return sumajugador;
    }

    public int turnoDealer(int sumadealer, int sumajugador) {
        while (sumadealer < 17 || (sumadealer < sumajugador && sumadealer <= 21)) {
            String[] cartaElegida = baraja.robarCarta();
            ImageIcon imagenCarta = new ImageIcon(getClass().getResource(cartaElegida[1]));

            JLabel nuevaCarta = new JLabel();
            nuevaCarta.setIcon(imagenCarta);

            cartasdealer.add(nuevaCarta);  // Agregar la carta al panel del dealer
            cartasdealer.revalidate();
            cartasdealer.repaint();

            cartasDealer.add(nuevaCarta);
            cartasDealerValores.add(cartaElegida);

            sumadealer += comprobarNumero(cartaElegida[0], sumadealer);
            sumadealer = ajustarAses(sumadealer, cartasDealerValores);
            System.out.println(sumadealer);
        }

        return sumadealer;
    }

    private int ajustarAses(int suma, List<String[]> cartas) {
        for (String[] carta : cartas) {
            if (carta[0].matches(".*_1_.*") && suma > 21) {
                suma -= 10; // Convierte As de 11 a 1
            }
        }
        return suma;
    }

    public void determinarGanador(int sumajugador, int sumadealer) {
        if (sumadealer > 21) {
            JOptionPane.showMessageDialog(this, "El dealer se pasó ganaste");
            ganarapuesta();
            reseteo();
        } else if (sumadealer == sumajugador) {
            JOptionPane.showMessageDialog(this, "Empate");
            reseteo();
        } else if (sumadealer > sumajugador) {
            JOptionPane.showMessageDialog(this, "El dealer ganó");
            perdidaapuesta();
            reseteo();
        } else {
            JOptionPane.showMessageDialog(this, "Ganaste");
            ganarapuesta();
            reseteo();
        }
    }

    public int comprobarNumero(String numero, int suma) {

        if (numero.matches(".*(2|3|4|5|6|7|8|9|10).*")) {
            return Integer.parseInt(numero.replaceAll("\\D", ""));
        }
        if (numero.matches(".*_1_.*")) {
            contases++;
            return (suma + 11 > 21) ? 1 : 11;
        }
        return 10; // J, Q, K valen 10
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        todo = new FondoPanel();
        mazo = new javax.swing.JLabel();
        jugar = new javax.swing.JButton();
        cartasdealer = new javax.swing.JPanel();
        D2 = new javax.swing.JLabel();
        D1 = new javax.swing.JLabel();
        cartasjugador = new FondoPanel();
        J1 = new javax.swing.JLabel();
        J2 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        retroceder = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        money = new javax.swing.JLabel();
        cinco = new javax.swing.JLabel();
        diez = new javax.swing.JLabel();
        veinticinco = new javax.swing.JLabel();
        setentaycinco = new javax.swing.JLabel();
        cien = new javax.swing.JLabel();
        cincuenta = new javax.swing.JLabel();
        apuest = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 800));

        todo.setBackground(new java.awt.Color(0, 204, 0));

        mazo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Different-BikeBack.png"))); // NOI18N

        jugar.setText("Empezar a jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        cartasdealer.setBackground(new java.awt.Color(0, 0, 0));
        cartasdealer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        D2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Different-BikeBack.png"))); // NOI18N
        cartasdealer.add(D2);

        D1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Different-BikeBack.png"))); // NOI18N
        cartasdealer.add(D1);

        cartasjugador.setBackground(new java.awt.Color(0, 204, 0));
        cartasjugador.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        J1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Different-BikeBack.png"))); // NOI18N
        cartasjugador.add(J1);

        J2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Different-BikeBack.png"))); // NOI18N
        cartasjugador.add(J2);

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 0, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("BLACKJACK");

        retroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dados/return.png"))); // NOI18N
        retroceder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retrocederMouseClicked(evt);
            }
        });

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/close.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        money.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/mony2.png"))); // NOI18N
        money.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moneyMouseClicked(evt);
            }
        });

        cinco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/monedas/monedaza5.png"))); // NOI18N
        cinco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cincoMouseClicked(evt);
            }
        });

        diez.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/monedas/monedaza10.png"))); // NOI18N
        diez.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diezMouseClicked(evt);
            }
        });

        veinticinco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/monedas/monedaza25.png"))); // NOI18N
        veinticinco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                veinticincoMouseClicked(evt);
            }
        });

        setentaycinco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/monedas/moneda75 (2).png"))); // NOI18N
        setentaycinco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setentaycincoMouseClicked(evt);
            }
        });

        cien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/monedas/monedaza100.png"))); // NOI18N
        cien.setToolTipText("");
        cien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cienMouseClicked(evt);
            }
        });

        cincuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/monedas/monedaza50.png"))); // NOI18N
        cincuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cincuentaMouseClicked(evt);
            }
        });

        apuest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apuestMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout todoLayout = new javax.swing.GroupLayout(todo);
        todo.setLayout(todoLayout);
        todoLayout.setHorizontalGroup(
            todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todoLayout.createSequentialGroup()
                .addGroup(todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(todoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(retroceder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270)
                        .addComponent(money))
                    .addGroup(todoLayout.createSequentialGroup()
                        .addGroup(todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(todoLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(mazo)
                                .addGap(79, 79, 79))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, todoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(apuest, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(todoLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jugar))
                            .addGroup(todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cartasdealer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cartasjugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(todoLayout.createSequentialGroup()
                        .addComponent(cerrar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, todoLayout.createSequentialGroup()
                        .addGroup(todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cincuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cien, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(setentaycinco, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(diez, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(veinticinco, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cinco, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(17, 17, 17))))
        );
        todoLayout.setVerticalGroup(
            todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(todoLayout.createSequentialGroup()
                        .addGroup(todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cerrar)
                            .addGroup(todoLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(titulo)
                                    .addComponent(money))))
                        .addGroup(todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(todoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cartasdealer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jugar)
                                .addGap(80, 80, 80)
                                .addComponent(cartasjugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(todoLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(cinco)
                                .addGap(18, 18, 18)
                                .addComponent(veinticinco)
                                .addGap(18, 18, 18)
                                .addComponent(diez)
                                .addGap(18, 18, 18)
                                .addComponent(cincuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(setentaycinco)
                                .addGap(18, 18, 18)
                                .addComponent(cien)
                                .addContainerGap(88, Short.MAX_VALUE))))
                    .addGroup(todoLayout.createSequentialGroup()
                        .addComponent(retroceder)
                        .addGap(37, 37, 37)
                        .addComponent(mazo)
                        .addGap(92, 92, 92)
                        .addComponent(apuest, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(todo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(todo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        // TODO add your handling code here:

        for (JLabel carta : cartasJugador) {
            cartasjugador.remove(carta);
        }
        for (JLabel carta : cartasDealer) {
            cartasdealer.remove(carta);
        }
        cartasJugador.clear(); // Limpiar la lista
        ImageIcon icon = new ImageIcon("Different-BikeBack.png");
        J1.setIcon(icon);
        J2.setIcon(icon);
        D1.setIcon(icon);
        D2.setIcon(icon);

        baraja.reiniciarBaraja();
        contases = 0;

        int sumajugador = 0;
        JLabel[] etiquetasCartas = {J1, J2};
        for (int i = 0; i < 2; i++) {               //CARTAS INICIALES JUGADOR
            String[] cartaElegida = baraja.robarCarta();
            sumajugador += comprobarNumero(cartaElegida[0], sumajugador);
            // Cargar la imagen en un ImageIcon
            ImageIcon imagenCarta = new ImageIcon(getClass().getResource(cartaElegida[1]));
            // Asignar la imagen a la etiqueta correspondiente
            etiquetasCartas[i].setIcon(imagenCarta);
        }

        int sumadealer = 0;         //CARTAS INICIALES DEALER
        JLabel[] etiquetasCartasDealer = {D1, D2};
        ImageIcon cartasinrevelar = new ImageIcon();
        for (int i = 0; i < 2; i++) {
            String[] cartaElegida = baraja.robarCarta();
            sumadealer += comprobarNumero(cartaElegida[0], sumadealer);
            ImageIcon imagenCarta = new ImageIcon(getClass().getResource(cartaElegida[1]));
            if (i == 0) {
                etiquetasCartasDealer[i].setIcon(imagenCarta);
            } else {
                //Guardo la carta sin revelar del dealer
                etiquetasCartasDealer[i].setIcon(icon);
                cartasinrevelar = new ImageIcon(getClass().getResource(cartaElegida[1]));
            }

        }
        System.out.println("Jugador: suma = " + sumajugador);
        System.out.println("Dealer: suma = " + sumadealer);
        if (verificarBlackJack(sumajugador, sumadealer, cartasinrevelar)) {
            return;
        }

        do {
            int respuesta = JOptionPane.showConfirmDialog(this, "Robar", "¿Quieres robar?", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {

                sumajugador = turnoJugador(sumajugador);
                System.out.println(sumajugador);

            } else {
                break;
            }
        } while (sumajugador < 21);

        D2.setIcon(cartasinrevelar);
        if (sumajugador > 21) {
            JOptionPane.showMessageDialog(this, "PERDISTE!");
            perdidaapuesta();
            reseteo();
            return;
        }
        if (verificarBlackJack(sumajugador, sumadealer, cartasinrevelar)) {
            reseteo();
            return;
        }

        sumadealer = turnoDealer(sumadealer, sumajugador);

        determinarGanador(sumajugador, sumadealer);
        reseteo();
        return;
    }//GEN-LAST:event_jugarActionPerformed
    private void reseteo(){
            apuestaenvivo = 0;
        apuest.setIcon(null);
        comprobaciondinero=dinerousuario;
    }
    private void perdidaapuesta() {
        dinerousuario = dinerousuario - apuestaenvivo;
        userdao.actualizarDinero(usuario, dinerousuario);
    }

    private void ganarapuesta() {
        dinerousuario = dinerousuario + apuestaenvivo;
        userdao.actualizarDinero(usuario, dinerousuario);

    }    private void apostando() {
    int nuevaApuesta = 0;

    switch (apostador) {
        case cinco:
            nuevaApuesta = 5;
            break;
        case diez:
            nuevaApuesta = 10;
            break;
        case veinticinco:
            nuevaApuesta = 25;
            break;
        case cincuenta:
            nuevaApuesta = 50;
            break;
        case setentaycinco:
            nuevaApuesta = 75;
            break;
        case cien:
            nuevaApuesta = 100;
            break;
    }

    // Verificar si la nueva apuesta excede los fondos disponibles
    if (apuestaenvivo + nuevaApuesta > comprobaciondinero) {
        JOptionPane.showMessageDialog(this, "No tienes suficientes fondos para esta apuesta.");
        return;
    }

    // Sumar la nueva apuesta a la apuesta en vivo
    apuestaenvivo += nuevaApuesta;

    // Actualizar la imagen de la apuesta
    apuest.setIcon(imagen);
}

    private void retrocederMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retrocederMouseClicked
        // TODO add your handling code here:

        this.setVisible(false); // Oculta la ventana actual
        new Menu().setVisible(true); // Crea y muestra el menú principal con el dinero actual
        this.dispose(); // Libera los recursos de la ventana actual


    }//GEN-LAST:event_retrocederMouseClicked

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "¿ESTAS SEGURO?", "SALIR", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_cerrarMouseClicked

    private void moneyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moneyMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this,"Tu saldo es de $"+dinerousuario);
    }//GEN-LAST:event_moneyMouseClicked

    private void cincoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cincoMouseClicked
        // TODO add your handling code here:
        apostador = Apostar.cinco;
        apostando();
    }//GEN-LAST:event_cincoMouseClicked

    private void diezMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diezMouseClicked
        // TODO add your handling code here:
        apostador = Apostar.diez;
        apostando();
    }//GEN-LAST:event_diezMouseClicked

    private void veinticincoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_veinticincoMouseClicked
        // TODO add your handling code here:
        apostador = Apostar.veinticinco;
        apostando();
    }//GEN-LAST:event_veinticincoMouseClicked

    private void setentaycincoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setentaycincoMouseClicked
        // TODO add your handling code here:
        apostador = Apostar.setentaycinco;
        apostando();
    }//GEN-LAST:event_setentaycincoMouseClicked

    private void cienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cienMouseClicked
        // TODO add your handling code here:
        apostador = Apostar.cien;
        apostando();
    }//GEN-LAST:event_cienMouseClicked

    private void cincuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cincuentaMouseClicked
        // TODO add your handling code here:
        apostador = Apostar.cincuenta;
        apostando();
    }//GEN-LAST:event_cincuentaMouseClicked

    private void apuestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apuestMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Estas apostando " + apuestaenvivo);
    }//GEN-LAST:event_apuestMouseClicked

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
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlackJack().setVisible(true);
            }
        });
    }
    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/blackjack/fondobj.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel D1;
    private javax.swing.JLabel D2;
    private javax.swing.JLabel J1;
    private javax.swing.JLabel J2;
    private javax.swing.JLabel apuest;
    private javax.swing.JPanel cartasdealer;
    private javax.swing.JPanel cartasjugador;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel cien;
    private javax.swing.JLabel cinco;
    private javax.swing.JLabel cincuenta;
    private javax.swing.JLabel diez;
    private javax.swing.JButton jugar;
    private javax.swing.JLabel mazo;
    private javax.swing.JLabel money;
    private javax.swing.JLabel retroceder;
    private javax.swing.JLabel setentaycinco;
    private javax.swing.JLabel titulo;
    private javax.swing.JPanel todo;
    private javax.swing.JLabel veinticinco;
    // End of variables declaration//GEN-END:variables
}
