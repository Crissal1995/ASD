package utility;
import java.util.*;

public class PopulateDouble {
	
	final public static ArrayList<Double> populate(long dim){
		ArrayList<Double> arr = new ArrayList<Double>();
		
		Random rnd = new Random(Calendar.getInstance().getTimeInMillis());
		
		for(int i = 0; i < dim; ++i) {
			arr.add(rnd.nextDouble());
		}
		
		return arr;
	}
}
