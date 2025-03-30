package Sincronizar;

public class HiloSacarDinero extends Thread{
	Cuenta cuenta;

	public HiloSacarDinero(String nombre,Cuenta cuenta) {
		super(nombre);
		this.cuenta = cuenta;
	}
	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (Exception e) {
				// TODO: handle exception
			}
			cuenta.retirarDinero(getName(),10);
		}
	}
}
