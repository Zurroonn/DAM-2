package Ejercicio1;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Ejercicio1AlejandroZurron {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el rango (2 numeros)");//Establecemos el rango de numeros
		int num1= sc.nextInt();
		int num2=sc.nextInt();
		ForkJoinPool pool= new ForkJoinPool();
		Sumar suma= new Sumar(num1,num2,num1,num2);//Le paso num1,num2 como start end ya que el rango lo marca los numeros que haya introducido el usuario
		int result=pool.invoke(suma);//Nos devuelve el integer de la clase Sumar y lo almacenamos en un int
		System.out.println(result);
		
		pool.close();
	}

}
