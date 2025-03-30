package GestionHilosvs2;


import java.util.Random;

public class GestionHilo extends Thread {
    
    public GestionHilo(String nombre) {
        super(nombre); // Asigna un nombre al hilo
    }

    @Override
    public void run() {
        Random random = new Random();
        
        while (true) { // Bucle infinito
            System.out.println("Soy el bucle " + getName() + " y estoy trabajando.");

            // Esperar un tiempo aleatorio entre 1 y 10 segundos
            try {
                Thread.sleep((1 + random.nextInt(10)) * 1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " ha sido interrumpido.");
                break; // Salir del bucle si el hilo es interrumpido
            }
        }
    }
}
