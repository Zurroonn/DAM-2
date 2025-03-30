package procesoPrincipal;

public class Principal {
	public static void main(String[] args) {
	try {
	String[] infoProceso ={"notepad.exe" , "gordito.txt"};
		 Process proceso = Runtime.getRuntime().exec(infoProceso);
		 int valorRetorno = proceso.waitFor();
	 if (valorRetorno==0) {
		 System.out.println("El proceso se ha completado satisfactoriamente");
		 } else {
	  System.out.println("El proceso ha fallado.Código de error:" + valorRetorno);
		 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
}
}