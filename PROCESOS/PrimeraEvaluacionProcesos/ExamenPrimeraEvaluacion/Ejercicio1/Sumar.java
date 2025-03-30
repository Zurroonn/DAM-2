package Ejercicio1;

import java.util.concurrent.RecursiveTask;

public class Sumar extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	private int start, end;
	private static final int UMBRAL = 1000;
	private int num1, num2;

	public Sumar(int num1, int num2,int start, int end) {
		super();
		this.start = start;
		this.end = end;
		this.num1 = num1;
		this.num2 = num2;
	}

	private boolean esPrimo(int number) {

		if (number <= 1)//El numero 1 no es considerado primo
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {//Calcula si el numero es primo o no
			if (number % i == 0)
				return false;
		}
		return true;
	}

	@Override
	protected Integer compute() {
		int contador = 0;
		if (end - start <= UMBRAL) {
		int cont = num1;
		
		while (cont <= num2) {//Hago un while para que recorra todos los numeros que hay entre los dos numeros introducidos por el usuario
			if (esPrimo(cont)) {//Compruebo si es primo
				contador = contador + cont;//Si es primo se va sumando a los demas numeros
			}
			cont++;

		}
			return contador;
		} else {
			int middle= (end+start)/2;
			Sumar subtask1= new Sumar(num1,num2,num1,middle);//El start es el primer numero dado y el end es la mitad
			Sumar subtask2= new Sumar(num1,num2,middle,num2);//El end es el segundo numero dado y el start es la mitad
			
			subtask1.fork();
			subtask2.fork();
			
			return subtask1.join()+subtask2.join();//Junto los resultados en una suma que va a devolver un entero
		}

	}
}
