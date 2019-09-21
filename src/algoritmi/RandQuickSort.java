package algoritmi;
import java.util.*;
import interfaces.SortInteger;

public class RandQuickSort extends SortInteger {
	
	public RandQuickSort() {
		super();
		name = "RandQuickSort";
	}
	
	public void sort(ArrayList<Integer> A) {
		randQuickSort(A, 0, A.size());
	}
	
	// Non cambia nulla
	public void randQuickSort(ArrayList<Integer> A, int p, int r) {
		// come mergeSort, suddivido l'array in base ad un pivot
		// però ordino sul posto
		if (p < r) {
			// q posizione del pivot
			int q = randPartition(A, p, r);
			randQuickSort(A, p, q-1);
			randQuickSort(A, q+1, r);
		}
	}
	
	// ottengo in maniera random un intero compreso fra p (incluso) ed r (escluso)
	// e swappo A[r-1] con A[i] per ottenere aleatorità ed evitare che partiziono sempre
	// in maniera critica
	public int randPartition(ArrayList<Integer> A, int p, int r) {
		Random rnd = new Random(Calendar.getInstance().getTimeInMillis());
		
		// 0..r-p -> p..r (estremo sup escluso)
		int i = rnd.nextInt(r-p) + p; 
		
		// swap A[r-1] e A[i]
		int temp = A.get(i);
		A.set(i, A.get(r-1));
		A.set(r-1, temp);
		
		// pivot
		return QuickSort.partition(A, p, r);
	}
	
	public static void main(String[] args) throws InterruptedException {
		SortInteger sorting = new RandQuickSort();
		sorting.doIt();
	}
}
