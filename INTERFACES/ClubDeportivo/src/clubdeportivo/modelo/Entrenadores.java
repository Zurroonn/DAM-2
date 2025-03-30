/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clubdeportivo.modelo;

/**
 *
 * @author Manana
 */
public class Entrenadores extends Personal{
    int PartidoGanado;
    int sueldo;
    public Entrenadores(String nombre, String DNI, String direccion, int Telefono, int Sueldo,int PartidoGanado) {
        super(nombre, DNI, direccion, Telefono);
        this.PartidoGanado=PartidoGanado;
    }



    @Override
    public String toString() {
        return "Entrenadores"+ super.toString() + "PartidoGanado=" + PartidoGanado +", sueldo final= "+calcularsueldo();
    }
    
    public int calcularsueldo(){
    return sueldo+PartidoGanado*300;
    }
    
}
