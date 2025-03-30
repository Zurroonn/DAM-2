package GestionHilos;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class GestionHilos3 extends Thread {
    private static final AtomicInteger contadorHilos = new AtomicInteger(0); // Contador de hilos activos
    private int repeticiones; // Número de veces que imprime el mensaje

    public GestionHilos3(String nombre, int repeticiones) {
        super(nombre);
        this.repeticiones = repeticiones;
    }

    @Override
    public void run() {
        contadorHilos.incrementAndGet(); // Incrementar el contador al iniciar el hilo

        Random random = new Random();
        for (int i = 0; i < repeticiones; i++) {
            System.out.println(getName() + ": Ejecutando mensaje " + (i + 1));

            // Esperar un número aleatorio de 1 a 3 segundos
            try {
                Thread.sleep((1 + random.nextInt(3)) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Decrementar el contador al finalizar el hilo
        int hilosRestantes = contadorHilos.decrementAndGet();
        if (hilosRestantes == 1) {
            System.out.println(getName() + ": ¡Soy el último superviviente!");
        }
    }

    public static void main(String[] args) {
        // Crear y ejecutar al menos 5 hilos
        GestionHilos3 hilo1 = new GestionHilos3("Hilo 1", 5);
        GestionHilos3 hilo2 = new GestionHilos3("Hilo 2", 5);
        GestionHilos3 hilo3 = new GestionHilos3("Hilo 3", 5);
        GestionHilos3 hilo4 = new GestionHilos3("Hilo 4", 5);
        GestionHilos3 hilo5 = new GestionHilos3("Hilo 5", 5);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

        // Esperar a que todos los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mensaje final del main
        System.out.println("¡Programa finalizado!");
    }
}
