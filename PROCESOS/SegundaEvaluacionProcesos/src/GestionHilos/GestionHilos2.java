package GestionHilos;

public class GestionHilos2 extends Thread {
	private int tipo; // Atributo "tipo"

	public GestionHilos2(String nombre, int tipo) {
		super(nombre); // Asignar un nombre al hilo
		this.tipo = tipo;
	}

	@Override
	public void run() {
		if (tipo == 1) {
			// Mostrar números del 1 al 30
			for (int i = 1; i <= 30; i++) {
				System.out.println(getName() + ": " + i);
			}
		} else if (tipo == 2) {
			// Mostrar letras de la 'a' a la 'z'
			for (char c = 'a'; c <= 'z'; c++) {
				System.out.println(getName() + ": " + c);
			}
		}
	}

	public static void main(String[] args) {
		// Crear y lanzar un hilo de tipo 1
		GestionHilos2 hiloTipo1 = new GestionHilos2("Hilo Tipo 1", 1);
		hiloTipo1.start();

		// Crear y lanzar un hilo de tipo 2
		GestionHilos2 hiloTipo2 = new GestionHilos2("Hilo Tipo 2", 2);
		hiloTipo2.start();

		// Esperar a que ambos hilos terminen
		try {
			hiloTipo1.join();
			hiloTipo2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Mensaje final
		System.out.println("¡Programa finalizado!");
	}
}
