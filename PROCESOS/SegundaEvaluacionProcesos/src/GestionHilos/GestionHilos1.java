package GestionHilos;

	public class GestionHilos1 extends Thread {
		private int repeticiones; // Número de repeticiones del mensaje
		

		public GestionHilos1(String nombre, int repeticiones) {
			super( nombre); // Asignar un nombre y grupo al hilo
			this.repeticiones = repeticiones;
			
		}

		@Override
		public void run() {
			for (int i = 0; i < repeticiones; i++) {
				System.out.println("Hola soy el " + getName() + " con id " + getId() + ", prioridad " + getPriority()
						+ " y en mi grupo hay " + getThreadGroup().activeCount() + " hilos");
			}
		}
	

	public static void main(String[] args) {
		// Crear un grupo de hilos
		ThreadGroup grupoHilos = new ThreadGroup("Grupo de Hilos");

		// Crear y lanzar 10 hilos
		for (int i = 1; i <= 10; i++) {
			String nombreHilo = "Hilo " + i;
			int repeticiones = i * 2;

			GestionHilos1 hilo = new GestionHilos1(nombreHilo, repeticiones);
			hilo.setPriority(Thread.NORM_PRIORITY); // Configurar prioridad
			hilo.start(); // Iniciar el hilo
		}
	}
}
