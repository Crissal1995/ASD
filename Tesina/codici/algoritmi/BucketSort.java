package algoritmi;
import java.util.*;
import interfaces.SortDouble;

public class BucketSort extends SortDouble {
	
	public BucketSort() {
		super();
		name = "BucketSort";
	}
	
	public void sort(ArrayList<Double> A) {
		bucketSort(A);
	}
		
	// ordina array con elementi compresi fra 0 e k
	public void bucketSort(ArrayList<Double> A) {
		ArrayList<ArrayList<Double>> B = new ArrayList<ArrayList<Double>>();
		int n = A.size();
		
		// inizializziamo B
		for (int i = 0; i < n; ++i) {
			B.add(new ArrayList<Double>());
		}
		
		for (int i = 0; i < n; ++i) {
			// determina l'indice
			int index = (int) Math.floor(n*A.get(i));
			
			// nella lista index-esima di B aggiungo A[i]
			B.get(index).add(A.get(i));
		}
		
		for (int i = 0; i < n; ++i)
			InsertionSortDouble.insertionSort(B.get(i));
		
		int k = 0;
		for (int i = 0; i < n; ++i) {
			// n_i lunghezza i-esima lista concatenata di B
			int n_i = B.get(i).size();
			// scorri ogni lista i-esima e prendi l'elemento j-esimo
			for (int j = 0; j < n_i; ++j) {
				A.set(k, B.get(i).get(j));
				++k;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		SortDouble sorting = new BucketSort();
		sorting.doIt();
	}
}
