package ForkJoin2;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class ForkJoin_contar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForkJoinPool pool= new ForkJoinPool();
		Scanner sc= new Scanner (System.in);
		System.out.println("Introduce el texto a leer");
		String texto=sc.nextLine();
		System.out.println("Introduce la palabra que quieres buscar");
		String palabrabuscar=sc.nextLine();				
		
		
		String[] palabras= texto.split("\\s");
		Forkllamada fll= new Forkllamada(palabras,palabrabuscar);		
		int resultado=pool.invoke(fll);
		System.out.println(resultado);
		
	}

}
