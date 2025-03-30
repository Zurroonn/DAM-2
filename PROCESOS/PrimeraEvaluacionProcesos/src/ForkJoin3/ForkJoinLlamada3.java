package ForkJoin3;

import java.util.Iterator;
import java.util.concurrent.RecursiveTask;

import ForkJoin2.Forkllamada;

public class ForkJoinLlamada3 extends RecursiveTask<String>{
String arr[];
String palabra;
private int start,end;
private int umbral=50;
public ForkJoinLlamada3(String[] arr, String palabra, int start, int end) {
	super();
	this.arr = arr;
	this.palabra = palabra;
	this.start = start;
	this.end = end;
}
public ForkJoinLlamada3(String[] arr, String palabra) {
	super();
	this.arr = arr;
	this.palabra = palabra;
	this.start=0;
	this.end=arr.length;
}
@Override
protected String compute() {
	int cont=0;
	if (end-start<=umbral) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(palabra)) {
				cont++;
			}
		}
		return ("Hay "+cont+" palabras");
	}else {
		int middle=(start+end)/2;
		Forkllamada fjs1= new Forkllamada(arr,palabra,start,middle);
		Forkllamada fjs2= new Forkllamada(arr,palabra,middle,end);
		 
		fjs1.fork();
		fjs2.fork();
		int uno=fjs1.join();
		
		int dos=fjs2.join();
				
		 return ("Hay "+uno+dos+"palabras");
		}
		
	}
	

}

