/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolconatributos;

/**
 *
 * @author Manana
 */
public class Equipo {
    private String nombre;
    int jugadores;
    int aficionados;
    String estadio;

    public Equipo(String nombre, int jugadores, int aficionados, String estadio) {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.aficionados = aficionados;
        this.estadio = estadio;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
