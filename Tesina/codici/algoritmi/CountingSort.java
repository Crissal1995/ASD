package algoritmi;
import java.util.*;
import interfaces.*;

public class CountingSort extends SortInteger {
		
	public CountingSort(int n, int max) {
		super(n, max);
		name = "CountingSort";
	}
	
	public void sort(ArrayList<Integer> A) {
		countingSort(A);
	}
	
	// Algoritmo in versione generale, per min diverso da 0
	// e max diverso da k
	void countingSort(ArrayList<Integer> A) {
		// inizializza variabili
		int max = A.get(0), min = A.get(0), dim_a = A.size(), dim_c;
		int i, j;
		
		// ottieni minimo e massimo dall'array A
		for(i = 1; i < dim_a; ++i) {
			if (A.get(i) > max)
				max = A.get(i);
			else if (A.get(i) < min)
				min = A.get(i);
		}
		
		// inizializza il vettore C a zero (dim_c elementi)
		dim_c = max-min+1;
		ArrayList<Integer> C = new ArrayList<Integer>();
		for(i = 0; i < dim_c; ++i)
			C.add(0);
		
		// Aumenta il numero di volte che si è incontrato il valore
		// es: position = A[0] - min = 50 - 10 = 40
		//     temp = C[40] = 0
		//     C[40] = 0+1 = 1
		for(i = 0; i < dim_a; ++i) {
			int position = A.get(i) - min;
			int temp = C.get(position);
			C.set(position, temp+1);
		}
		
		//Ordinamento in base al contenuto dell'array delle frequenze C
		j = 0;
		for(i = 0; i < dim_c; ++i) {
			// Scrive C[i] volte il valore (i+min) nell'array A
			// C[40] = 10 -> ho trovato 10 volte il valore 50 nell'array A
			// while C[40] > 0
			// A[j] = 40+min = 40+10 = 50
			// ++j e C[40]--
			// quindi scrivo per C[40] volte il valore 40+min in pos A[j]
			while(C.get(i) > 0){
				A.set(j, i+min);
				++j;
				int temp = C.get(i);
				C.set(i, temp-1);
		    }
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final int numberArrays = 100;
		final int max = 800;
		SortInteger sorting = new CountingSort(numberArrays, max);
		sorting.doIt();
	}
}
