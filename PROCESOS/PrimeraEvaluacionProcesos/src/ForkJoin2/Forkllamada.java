package ForkJoin2;

import java.util.concurrent.RecursiveTask;

import FORKEJERCICIO.FORKLLAMADA;

public class Forkllamada extends RecursiveTask<Integer>{
String [] palabrastotales;
String palabrabusc;
private int start,end;
private int umbral=50;

	
	public Forkllamada(String[] palabrastotales, String palabrabusc) {
	super();
	this.palabrastotales = palabrastotales;
	this.palabrabusc = palabrabusc;
	this.start=0;
	this.end=palabrastotales.length;
}

	public Forkllamada(String[] palabrastotales, String palabrabusc, int start, int end) {
		super();
		this.palabrastotales = palabrastotales;
		this.palabrabusc = palabrabusc;
		this.start = start;
		this.end = end;

	}

	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		int contador=0;
		if (end-start<=umbral) {		
			//String [] tex= {hola,alex,alex};
		for (int i = 0; i < palabrastotales.length; i++) {
			if (palabrastotales[i].equals(palabrabusc)) {
				contador++;			
			}
			
		}
		return contador;
		}else {
			int middle=(start+end)/2;
			Forkllamada fjs1= new Forkllamada(palabrastotales,palabrabusc,start,middle);
			Forkllamada fjs2= new Forkllamada(palabrastotales,palabrabusc,middle,end);
			 
			fjs1.fork();
			fjs2.fork();
			int uno=fjs1.join();
			
			int dos=fjs2.join();
					
			return uno+dos;
			}
				
		}
			
		}
		 
	   
	


