package GestionHilosvs2;

public class Main {
	public static void main(String[] args) {
        // Crear y ejecutar 5 hilos
        for (int i = 1; i <= 5; i++) {
            new GestionHilo("Hilo " + i).start();
        }
    }
}
