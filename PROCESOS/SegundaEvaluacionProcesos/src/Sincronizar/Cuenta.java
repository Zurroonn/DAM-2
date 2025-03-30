package Sincronizar;


public class Cuenta {
private int dinero;

public Cuenta() {
	super();
	this.dinero = 40;
}

public synchronized void retirarDinero(String nombre,int retirar) {
	
	if (retirar<=dinero) {
		try {
			Thread.sleep((int)(Math.random()*1000));
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int saldofinal=dinero-retirar;
		System.out.println("Antes tenia "+dinero +" y ahora tiene "+ saldofinal+" la cuenta "+ nombre);
		dinero=dinero-retirar;
	}else {
		System.out.println("No se puede retirar tanto dinero, tu saldo es: "+dinero);
	}
	
}
}
