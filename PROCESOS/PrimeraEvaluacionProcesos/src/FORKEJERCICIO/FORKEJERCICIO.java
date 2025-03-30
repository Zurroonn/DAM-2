package FORKEJERCICIO;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class FORKEJERCICIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForkJoinPool pool= new ForkJoinPool();
		Random rd= new Random();
		try {
			int[] arr= new int[100];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=rd.nextInt(0,100);
			} 
			FORKLLAMADA llamada= new FORKLLAMADA(arr,0,arr.length);
			
			int resultado=pool.invoke(llamada);
			System.out.println("El resultado es :"+resultado);
			
		}catch (Exception e) {
        	System.out.println("Ha fallado" + e.getMessage());
        }finally {
        	pool.close();
        }
	}

}
