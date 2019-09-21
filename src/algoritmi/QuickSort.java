package algoritmi;
import java.util.*;
import interfaces.*;

public class QuickSort extends SortInteger {
	
	public QuickSort() {
		super();
		name = "QuickSort";
	}
	
	public void sort(ArrayList<Integer> A) {
		quickSort(A, 0, A.size());
	}
	
	public void quickSort(ArrayList<Integer> A, int p, int r) {
		// come mergeSort, suddivido l'array in base ad un pivot
		// però ordino sul posto
		if (p < r) {
			// q posizione del pivot
			int q = partition(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}
	}
	
	static public int partition(ArrayList<Integer> A, int p, int r) {
		// partition con scelta fissa del pivot
		// quindi abbiamo determinismo nella scelta e nel tempo di esecuzione
		
		// pivot = ultimo elemento dell'array
		int x = A.get(r-1);
		
		int i = p-1; // inizialmente i = 0-1 = -1
		
		for (int j = p; j < r-1; ++j) {
			if (A.get(j) <= x) {
				++i;
				int temp = A.get(i);
				A.set(i, A.get(j));
				A.set(j, temp);
			}
		}
		
		int temp = A.get(i+1);
		A.set(i+1, A.get(r-1));
		A.set(r-1, temp);
		
		return i+1;
	}
	
	public static void main(String[] args) throws InterruptedException {
		SortInteger sorting = new QuickSort();
		sorting.doIt();
	}
}
