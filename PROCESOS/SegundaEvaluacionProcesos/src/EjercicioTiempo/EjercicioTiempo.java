package EjercicioTiempo;

import java.util.Timer;
import java.util.TimerTask;

public class EjercicioTiempo extends TimerTask {

	@Override
	public void run() {
		System.out.println("Es momento de levantarse.");
	}
	public static void main(String[] args) {
		 Timer timer = new Timer();
		 timer.schedule(new EjercicioTiempo(), 1000, 2000);

	}
}