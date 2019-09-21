package interfaces;
import java.util.ArrayList;
import utility.*;

public abstract class SortDouble {
	
	public int numberOfTries = 1;
	public int numberArrays;
	public String name;
	public ArrayList<ArrayList<Double>> collection;
	
	public SortDouble(int n) {
		setup(n);
	}
	
	public SortDouble() {
		setup(100);
	}
	
	private void setup(int numberArrays) {
		this.numberArrays = numberArrays;
		this.collection = GetArraysDouble.getArrays(numberArrays);
	}
	
	public abstract void sort(ArrayList<Double> a);
	
	public void doIt() throws InterruptedException {				
		// pulizia del file
		Writefile.clean(name);
		
		for(int i = 0; i < numberArrays; ++i) {
			Worker w = new Worker(this, i);
			w.start();
		}
	}
	
	public class Worker extends Thread {
		SortDouble refer;
		int position;
		
		public Worker(SortDouble dad, int i) {
			refer = dad;
			position = i;
		}
		
		public void run() {
			int dim = refer.collection.get(position).size();
			ArrayList<Long> times = new ArrayList<Long>();
			
			for(int i = 0; i < numberOfTries; ++i) {
				long start = CPU.getCpuTime();
				refer.sort(refer.collection.get(position));
				long time = CPU.getCpuTime() - start;
				times.add(time);
			}
			
			// time è la media aritmetica dei times
			long time = 0L;
			for(int i = 0; i < times.size(); ++i)
				time += times.get(i);
			time /= times.size();
			
			Writefile.write(refer.name, dim, time/1_000_000);
		}
	}
}
