package FORKEJERCICIO;

import java.util.concurrent.RecursiveTask;

public class FORKLLAMADA extends RecursiveTask<Integer> {
private int [] arr;
private int start,end;
private int umbral=50;

public FORKLLAMADA(int[] arr, int start, int end) {
	super();
	this.arr = arr;
	this.start = start;
	this.end = end;

}

@Override
protected Integer compute() {
	// TODO Auto-generated method stub
	if (end-start<=umbral) {
	int cont=0;
	for (int i = 0; i < arr.length; i++) {
		if(arr[i]>cont) {
			cont=arr[i];
			
		}
	}
	return cont;
	
	}else {
		
		int middle=(start+end)/2;
		FORKLLAMADA fjs1= new FORKLLAMADA(arr,start,middle);
		FORKLLAMADA fjs2= new FORKLLAMADA(arr,middle,end);
		
		fjs1.fork();
		fjs2.fork();
		int uno=fjs1.join();
		int dos=fjs2.join();
				
		if (uno>dos) {
			return uno;
		}else {
			return dos;
		}
			
	}
	
	
}

}
