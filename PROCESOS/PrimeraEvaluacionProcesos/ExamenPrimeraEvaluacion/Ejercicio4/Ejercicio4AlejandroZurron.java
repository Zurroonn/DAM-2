package Ejercicio4;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Ejercicio4AlejandroZurron {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce tamaño array");
		int tamaño=sc.nextInt();
		int array[]=new int[tamaño];//Creamos el array
		for (int i = 0; i < array.length; i++) {//Le doy valor a cada posicion del array
			array[i]=(int) (Math.random()*100);		//Como he puesto int los numeros añadidos en el array siempre van a ser enteros	
			
		}
		ForkJoinPool pool= new ForkJoinPool();
		Sumarnumeros sum= new Sumarnumeros(array,0,array.length);//Llamamos a la otra clase y le enviamos parametros 
		int result=pool.invoke(sum);//Nos devuelve un integer de la clase Sumarnumeros y lo almacenamos en int
		System.out.println("La suma de los cuadrados es: "+result);
		pool.close();//Cerramos el ForkJoinPool 
	}

}
