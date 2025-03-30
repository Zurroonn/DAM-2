import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio3AlejandroZurron {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[]arguments= {"cmd","/c","dir","C:\\Users\\Public"};//Le paso los comandos que voy a usar para ejecutarlo
		ProcessBuilder process= new ProcessBuilder(arguments);	
		
		try {			
			Process proceso= process.start();//Comienzo el proceso
			InputStream ips= proceso.getInputStream();
			BufferedReader br= new BufferedReader(new InputStreamReader (ips));//Leo el inputstream para que me muestre lo que ha hecho el comando
			String linea="";
			System.out.println("***************************************");
			System.out.println("Archivos en el directorio especificado:");
			System.out.println("***************************************");
			while((linea=br.readLine())!=null){//Voy leyendo linea a linea hasta que sea luna
				System.out.println(linea);
			}
			System.out.println("*************************************************");
			System.out.println("El proceso mostrar archivos terminó con el codigo: 0");
			System.out.println("*************************************************");
			System.out.println("Procesos en ejecucion");
			System.out.println("***************************************************");
			br.close();//Cierro el buffer
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String []arguments1= {"cmd","/c","tasklist"};//Le paso los comandos que voy a usar para ejecutarlo
		ProcessBuilder process1= new ProcessBuilder(arguments1);
		
		try {
			
			Process proceso= process1.start();//Comienzo el proceso
			InputStream ips= proceso.getInputStream();
			BufferedReader br= new BufferedReader(new InputStreamReader (ips));//Leo el inputstream para que me muestre lo que ha hecho el comando
			String linea="";
			while((linea=br.readLine())!=null){//Voy leyendo linea a linea hasta que sea nula
				System.out.println(linea);
			}
			System.out.println("********************************");
			System.out.println("El proceso mostrar archivos terminó con el codigo: 0");
			System.out.println("********************************");
			br.close();//Cierro el buffer
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
