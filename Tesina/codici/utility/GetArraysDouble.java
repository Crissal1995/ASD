package utility;
import java.util.*;

public class GetArraysDouble {
	
	final public static ArrayList<ArrayList<Double>> getArrays(int n){
		int base = 10_000;
		ArrayList<ArrayList<Double>> arrayCollection = new ArrayList<ArrayList<Double>>();
		arrayCollection.ensureCapacity(n);
		
		for(int i = 0; i <= n; ++i) {
			arrayCollection.add(i, PopulateDouble.populate(base * (i+1)));
		}
		
		return arrayCollection;
	}
	
	// non abbiamo il secondo metodo, getArrays(int n, Double max)
	// perché bucketSort ordina elementi compresi fra 0 (inc) e 1 (esc), 
	// e la funzione rand.nextDouble() ci restituisce double compresi in questo intervallo
}
