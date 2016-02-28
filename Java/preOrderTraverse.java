/*
* intial commit
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class HeapSort {
	List<Integer> list = new ArrayList<Integer>();
	int i;
	
	public HeapSort (List<Integer> list) {
		this.list = list;
		this.i = (int)Math.floor(list.size()/2) - 1; 
	}
	
	protected int parent(int index) {
		return index/2;
	}
	
	protected int left (int index) {
		return 2*index + 1;
	}
	
	protected int right (int index) {
		return 2*index + 2;
	}
	
	protected List<Integer> getList() {
		return this.list;
	}
	
	private List<Integer> MaxHeapify (List<Integer> list, int i) {
		int l = this.left(i);
		int r = this.right(i);
		int heapSize = list.size();
		int largest = i;
		int temp;
		
//		System.out.println("i = " + i);
//		System.out.println("l = " + l);
//		System.out.println("r = " + r);
		
		if (l <= heapSize && list.get(l) > list.get(i)) {
			largest = l;
		}
		
		if (r <= heapSize && list.get(r) > list.get(largest)) {
			largest = r;
		}
		//System.out.println("largest= " + largest);
		
		if (largest != i) {
			temp = list.get(i);
			list.set(i, list.get(largest));
			list.set(largest, temp);
//			System.out.println("exchange: ");
//			System.out.println(list);
			MaxHeapify(list, largest);
		}
		return list;		
	}
	
	public List<Integer> BuildMaxHeap () {
		List<Integer> heap = this.list;
		int start = this.i;
		while (start >= 0) {
			//System.out.println("start: " + start);
			heap = this.MaxHeapify(list, start);
			//System.out.println(this.MaxHeapify(list, start));
			start--;
		}
		System.out.println("heap: ");
		System.out.println(heap);
		return heap;
	}
	
	public List<Integer> SortHeap (List<Integer> heap) {
		List<Integer> stack = new ArrayList<Integer>();
		int count = heap.size();
		
		for (int i = 9; i >= 0; i--) {
			// push heap[0] to stack
			stack.add(0, heap.get(0));
			// replace heap[0] with heap[i]
			heap.set(0, heap.get(i));
			// get sublist of heap [0, heapsize - 2]
			//heap = heap.subList(0, heap.size()-1);
			heap.set(i, 0);
			//System.out.println(stack);
			this.MaxHeapify(heap, 0);
			
		}
		System.out.println("stack: ");
		return stack;
	}
	
	public static void main(String[] args) {
		//Integer[] A = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		Integer[] A = {1, 10, 4, 14, 7, 9 ,3, 2, 16, 8, 0, 0, 0, 0, 0};
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(A));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(A));
		//new HeapSort().MaxHeapify(list, 1);
		
//		for (Object ele : new HeapSort().MaxHeapify(list, 1).toArray()) {
//			System.out.println((Integer)ele);
//		}
		
		//HeapSort heapsort = new HeapSort(list);
		//int start = list.size()/2 - 2;
//		int start = (int)Math.floor(list.size()/2) - 1;
//		while (start >= 0) {
//			//System.out.println("start: " + start);
//			heapsort.MaxHeapify(list, start);
//			start--;
//		}
		
		System.out.println("list: ");
		System.out.println(list);
		HeapSort heapsort = new HeapSort(list);
		System.out.println(heapsort.SortHeap(heapsort.BuildMaxHeap()));
		
//		List<Integer> sublist = list2.subList(0, list2.size()-1);
//		System.out.println("sublist: ");
//		System.out.println(sublist);
		
	}
}

