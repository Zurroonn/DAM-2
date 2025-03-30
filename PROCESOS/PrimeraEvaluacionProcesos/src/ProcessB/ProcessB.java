package ProcessB;

import java.io.IOException;

public class ProcessB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String ruta="https://www.educa.jcyl.es/";
		ProcessBuilder process= new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",ruta);
		
		 try {
			process.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
