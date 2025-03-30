/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clubdeportivo.modelo;

/**
 *
 * @author Manana
 */
public class Jugadores extends Personal{
    String posicion;
    String Fechanacimiento;
    int NumeroGoles;
    int Partidosganados;
    int sueldo;

    public Jugadores(String nombre, String DNI, String direccion, int Telefono, int Sueldo,String posicion,int Partidosganados,int NumeroGoles,String Fechanacimiento) {
        super(nombre, DNI, direccion, Telefono);
        this.posicion=posicion;
        this.Partidosganados=Partidosganados;
        this.NumeroGoles=NumeroGoles;
        this.Fechanacimiento=Fechanacimiento;
    }
    
 

    @Override
    public String toString() {
        return "Jugadores:"+ super.toString() + "posicion=" + posicion + ", Fechanacimiento=" + Fechanacimiento + ", NumeroGoles=" + NumeroGoles + ", Plus por partido=" + Partidosganados+", sueldo final= "+calcularsueldo();
    }
    
    
    public int calcularsueldo(){
    return sueldo+NumeroGoles*50+Partidosganados*300;
    }
    
    

    
}
