package interfaces;
import java.util.ArrayList;
import algoritmi.RandQuickSort;
import utility.*;

public abstract class SortInteger {
	
	public int numberOfTries;
	public int numberArrays;
	public String name;
	public ArrayList<ArrayList<Integer>> collection;
	
	public SortInteger(int n, int max) {
		setup(n, max);
	}
	
	public SortInteger(int n) {
		setup(n);
	}
	
	public SortInteger() {
		setup(100);
	}
	
	private void setup(int numberArrays) {
		this.numberArrays = numberArrays;
		
		if (this instanceof RandQuickSort) {
			this.numberOfTries = 10;
		} else {
			this.numberOfTries = 1;
		}
		
		this.collection = GetArraysInteger.getArrays(numberArrays);
	}
	
	private void setup(int numberArrays, int max) {
		this.numberArrays = numberArrays;
		
		if (this instanceof RandQuickSort) {
			this.numberOfTries = 10;
		} else {
			this.numberOfTries = 1;
		}
		
		this.collection = GetArraysInteger.getArrays(numberArrays, max);
	}
	
	public abstract void sort(ArrayList<Integer> a);
	
	public void doIt() throws InterruptedException {
		// pulizia del file
		Writefile.clean(name);
		
		for(int i = 0; i < numberArrays; ++i) {
			Worker w = new Worker(this, i);
			w.start();
		}
	}
	
	public class Worker extends Thread {
		SortInteger refer;
		int position;
		
		public Worker(SortInteger dad, int i) {
			refer = dad;
			position = i;
		}
		
		public void run() {
			int dim = refer.collection.get(position).size();
			ArrayList<Long> times = new ArrayList<Long>();
			
			// solo nel caso di RandQuickSort numberOfTries > 1
			for(int i = 0; i < numberOfTries; ++i) {
				long start = CPU.getCpuTime();
				refer.sort(refer.collection.get(position));
				long time = CPU.getCpuTime() - start;
				times.add(time);
			}
			
			// time è la media aritmetica dei times
			// se numberOfTries == 1, times.size() == 1 e time = times[0]
			long time = 0L;
			for(int i = 0; i < times.size(); ++i)
				time += times.get(i);
			time /= times.size();
			
			// Scrivi su file 'nomeClasse.txt': dimensione array e tempo in ms
			Writefile.write(refer.name, dim, time/1_000_000);
		}
	}
}
