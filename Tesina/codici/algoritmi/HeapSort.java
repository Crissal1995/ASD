package algoritmi;
import java.util.*;
import interfaces.SortInteger;

public class HeapSort extends SortInteger {
	
	private int heapSize;
	
	public HeapSort() {
		super();
		heapSize = 0;
		name = "HeapSort";
	}
	
	public void sort(ArrayList<Integer> A) {
		heapSort(A);
	}
	
	public void heapSort(ArrayList<Integer> A) {
		buildMaxHeap(A);
		
		for (int i = A.size()-1; i > 2; --i) {
			int temp = A.get(1);
			A.set(1, A.get(i));
			A.set(i, temp);
			
			heapSize--;
			
			maxHeapify(A,1);
		}
	}
	
	public void buildMaxHeap(ArrayList<Integer> A) {
		heapSize = A.size();
		
		for (int i = (int) Math.floor(A.size()/2); i > 1; --i) {
			maxHeapify(A, i);
		}
	}
	
	public void maxHeapify(ArrayList<Integer> A, int node) {
		int l = left(node);
		int r = right(node);
		int max = node;
		
		if (l < heapSize && A.get(l) > A.get(node))
			max = l;
		if (r < heapSize && A.get(r) > A.get(max))
			max = r;
		
		if (max != node) {
			int temp = A.get(max);
			A.set(max, A.get(node));
			A.set(node, temp);
			
			maxHeapify(A,max);
		}
	}
	
	public int parent(int node) { return (int) Math.floor(node/2); }
	public int left(int node) { return 2*node; }
	public int right(int node) { return 2*node + 1; }
	
	public static void main(String[] args) throws InterruptedException {
		SortInteger sorting = new HeapSort();
		sorting.doIt();
	}
}
