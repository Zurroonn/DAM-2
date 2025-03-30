package Ejercicio4;

import java.util.Iterator;
import java.util.concurrent.RecursiveTask;

public class Sumarnumeros extends RecursiveTask<Integer>{
	private static final long serialVersionUID = 1L;
private int start,end;
private static final int UMBRAL=1000;
private int array[];

public Sumarnumeros( int[] array,int start, int end) {
	super();
	this.start = start;
	this.end = end;
	this.array = array;
}

@Override
protected Integer compute() {
	// TODO Auto-generated method stub
	int cont=0;
	if (end-start<=UMBRAL) {
		for (int i = 0; i < array.length; i++) {
			cont=cont+array[i]*array[i];
		}
		return cont;
	}else {
		int middle=(end+start)/4;
		int middle2=middle*2;
		int middle3=middle*3;
		Sumarnumeros subtask1=new Sumarnumeros(array,start,middle);
		Sumarnumeros subtask2=new Sumarnumeros(array,middle,middle2);
		Sumarnumeros subtask3=new Sumarnumeros(array,middle2,middle3);
		Sumarnumeros subtask4= new Sumarnumeros(array,middle3,end);
		
		subtask1.fork();
		subtask2.fork();
		subtask3.fork();
		subtask4.fork();
		
		return subtask1.join()+subtask2.join()+subtask3.join()+subtask4.join();
	}
	
	
}

}
