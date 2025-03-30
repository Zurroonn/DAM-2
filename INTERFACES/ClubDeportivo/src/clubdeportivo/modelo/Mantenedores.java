/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clubdeportivo.modelo;

/**
 *
 * @author Manana
 */
public class Mantenedores extends Personal{
    int Fijo;
    int sueldo;
    public Mantenedores(String nombre, String DNI, String direccion, int Telefono, int Sueldo,int Fijo) {
        super(nombre, DNI, direccion, Telefono);
        this.Fijo=Fijo;
    }


    @Override
    public String toString() {
        return "Mantenedores"+ super.toString() + "Fijo=" + Fijo+", sueldo final= "+sueldo ;
    }
    
}
