package ForkJoin3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int opc=0;
		
		do {
			System.out.println("1.Buscar palabra en texto introducido por ti");
			System.out.println("2.Buscar palabra en texto de un fichero");
			System.out.println("3.Salir");
			opc=sc.nextInt();
			switch(opc) {
			case 1:
				buscartexto();
				break;
			case 2:
				System.out.println("Introduce una palabra a buscar");
				String palabrafich=sc.next();				
				buscarfichero(palabrafich);
				
				
				break;
			case 3:
				
				break;
			
			}
			
			
		}while(opc!=3);
		sc.close();
	}
	public static void buscarfichero(String palabra) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Introduce la ruta donde esta el fichero");
		String ruta= sc.nextLine(); 
		
		int cont=0;
		
		try {
			BufferedReader bos= new BufferedReader(new FileReader(ruta));
			String linea="";
			linea = bos.readLine();
			StringBuilder texto= new StringBuilder();
			while (linea != null) {
				texto.append(linea).append("\n");
	            linea = bos.readLine();
	            
	        }
			ForkJoinPool pool= new ForkJoinPool();
			String [] palabrasarr=texto.toString().split("\\s");
			ForkJoinLlamada3 fll= new ForkJoinLlamada3(palabrasarr,palabra);		
			String resultado=pool.invoke(fll);
			System.out.println(resultado);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void buscartexto() {
		Scanner sc= new Scanner(System.in);
		ForkJoinPool pool= new ForkJoinPool();
		System.out.println("Introduce un texto");
		String texto=sc.nextLine();	
		System.out.println("Introduce una palabra a buscar");
		String palabra=sc.nextLine();
		String [] palabrasarr=texto.split("\\s");
		ForkJoinLlamada3 fll= new ForkJoinLlamada3(palabrasarr,palabra);		
		String resultado=pool.invoke(fll);
		System.out.println(resultado);
	}

}
