package algoritmi;
import java.util.ArrayList;
import interfaces.SortDouble;

public class InsertionSortDouble extends SortDouble {
	
	public InsertionSortDouble(int n) {
		super(n);
		name = "InsertionSortDouble";
	}

	public InsertionSortDouble() {
		super();
		name = "InsertionSortDouble";
	}
	
	public void sort(ArrayList<Double> A) {
		insertionSort(A);
	}
	
	static public void insertionSort(ArrayList<Double> A) {
		// partiamo dal secondo elemento dell'array
		for (int j = 1; j < A.size(); ++j) {
			// estraiamo l'elemento j-esimo
			double key = A.get(j);
			// i è l'elemento subito antecedente la chiave
			int i = j-1;
			
			// fin quando i è una pos valida e la chiave è minore 
			// degli elementi ad essa antecedenti, swappa e porta i
			// ancora più a sx
			while (i > -1 && key < A.get(i)) {
				A.set(i+1, A.get(i)); // A[i+1] = A[i]
				--i; // sto effettuando uno shift a sinistra
			}
			
			// se sono qui, o ho scorso tutto l'array (i=-1) oppure
			// la chiave è >= di un elemento ad essa precedente;
			// prendi quindi la chiave e stabiliscila dove sei arrivato
			A.set(i+1, key); // A[i+1] = key
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final short numberArrays = 30;
		SortDouble sorting = new InsertionSortDouble(numberArrays);
		sorting.doIt();
	}
}
