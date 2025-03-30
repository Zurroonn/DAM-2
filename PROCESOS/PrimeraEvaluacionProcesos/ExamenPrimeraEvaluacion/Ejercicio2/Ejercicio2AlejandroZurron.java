package Ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2AlejandroZurron {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ruta="C:/Users/Public/";
	File archivo= new File(ruta+"Ejercicio2Parte2.txt");
	Scanner sc= new Scanner(System.in);
	System.out.println("Introduce un texto para escribir en el archivo");
	String texto=sc.nextLine();
	try {
		BufferedWriter bw= new BufferedWriter(new FileWriter(archivo));//Escribimos el texto en archivo
		bw.write(texto);								
		bw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ProcessBuilder process= new ProcessBuilder("notepad","C:/Users/Public/Ejercicio2Parte2.txt");//Le paso la aplicacion para abrir la ruta que le doy
	try {
		process.start();//Ejecuta el processbuilder
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
