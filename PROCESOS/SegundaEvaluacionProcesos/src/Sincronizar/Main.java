package Sincronizar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cuenta c= new Cuenta();
		
		HiloSacarDinero h1= new HiloSacarDinero("Juan", c);
		HiloSacarDinero h2= new HiloSacarDinero("Juan", c);
		
		h1.start();
		h2.start();
		
	}

}
