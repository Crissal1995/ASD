package utility;
import java.util.*;

public class PopulateInt {
	
	final public static ArrayList<Integer> populate(long dim){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		Random rnd = new Random(Calendar.getInstance().getTimeInMillis());
		
		for(int i = 0; i < dim; ++i) {
			arr.add(rnd.nextInt());
		}
		
		return arr;
	}
	
	final public static ArrayList<Integer> populate(long dim, int max){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		Random rnd = new Random(Calendar.getInstance().getTimeInMillis());
		
		for(int i = 0; i < dim; ++i) {
			arr.add(rnd.nextInt(max));
		}
		
		return arr;
	}
}
