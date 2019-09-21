package utility;
import java.util.*;

public class GetArraysInteger {
	
	final public static ArrayList<ArrayList<Integer>> getArrays(int n, int max){
		int base = 10_000;
		ArrayList<ArrayList<Integer>> arrayCollection = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < n; ++i) {
			arrayCollection.add(i, PopulateInt.populate(base * (i+1), max));
		}
		
		return arrayCollection;
	}	
	
	final public static ArrayList<ArrayList<Integer>> getArrays(int n){
		return GetArraysInteger.getArrays(n, Integer.MAX_VALUE);
	}
}
