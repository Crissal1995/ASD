package algoritmi;
import java.util.*;
import interfaces.*;

public class MergeSort extends SortInteger {
	
	public MergeSort() {
		super();
		name = "MergeSort";
	}
	
	public void sort(ArrayList<Integer> A) {
		mergeSort(A, 0, A.size());
	}
	
	public void mergeSort(ArrayList<Integer> A, int p, int r) {
		// fin quando l'indice di sinistra è minore di quello di destra
		// se p==r, l'array è di un solo elemento
		if (p < r) {
			// q = parte intera di (p+r)/2
			// es q = floor[(0+6)/2] = 3
			// array di 6 elementi, perché chiamiamo
			// mergeSort(A, 0, A.size() )
			int q = (int) Math.floor((p+r)/2);
			// da 0 a 3
			mergeSort(A, p, q);
			// da 4 a 6
			mergeSort(A, q+1, r);
			// fonde le parti con indici 0, 3, 6
			merge(A, p, q, r);
		}
	}
	
	public void merge(ArrayList<Integer> A, int p, int q, int r) {
		// 3-0 = 3 elementi sx
		int n1 = q-p;
		// 6-3 = 3 elementi dx
		int n2 = r-q;
		ArrayList<Integer> L = new ArrayList<Integer>();
		ArrayList<Integer> R = new ArrayList<Integer>();
		
		// il -1 in A(..) è dato dal fatto che l'ultimo valore di 
		// i è n1-1 quindi p+i = p+q-p-1 = q-1
		// stesso discorso per i e n2
		for (int i = 0; i < n1; ++i)
			L.add(i, A.get(p+i)); // L = A(0..q-p+p-1) = A(0..q-1)
		for (int i = 0; i < n2; ++i)
			R.add(i, A.get(q+i)); // R = A(q..r-q+q-1) = A(q..r-1)
		
		L.add(n1, Integer.MAX_VALUE); // elemento sentinella
		R.add(n2, Integer.MAX_VALUE); // "quasi" +inf
		
		int i = 0, j = 0;		
		// inserimento ordinato in A di L[i] e R[j]
		for (int k = p; k < r; ++k) {
			int left = L.get(i);
			int right = R.get(j);
			if (left < right) {
				A.set(k, left);
				++i;
			} else {
				A.set(k, right);
				++j;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		SortInteger sorting = new MergeSort();
		sorting.doIt();
	}
}
