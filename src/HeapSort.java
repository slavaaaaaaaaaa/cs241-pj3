// Heap Sort
// 
// Input: list of n comparable elements
// 
// Output: list of elements sorted in ascending order
// 
// 1. Convert list into heap
// 2. for i = 1 to n
// 2.1. delete minimum element and add it to end of new list
// 3. return new list

public class HeapSort implements Sort {
	private int			size	= 0;
	private double[]	heap;
	
	public long sortMe(double[] array) {
		heap = array;
		size = heap.length;
		// 1. Convert list into heap
		// 2. for i = 1 to n
		for (int i = size(); i > -1; i--) {
			if (hasChild(i))
				siftDown(i);
		}
		
		if (main.DEBUG)
			System.out.println(verifySorted(0));
		// 3. return new list
		// return heap;
		return st.getElapsedTime();
	}
	
	public void swap(int a, int b) {
		double temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	public boolean verifySorted(int parent) {
		int childOne = parent * 2 + 1;
		int childTwo = parent * 2 + 2;
		if (hasChild(parent))
			if (childTwo < size()) {
				if (heap[parent] <= heap[childTwo]) {
					if (!verifySorted(childTwo))
						return false;
				} else
					return false;
			} else
				return verifySorted(childOne);
		return true;
	}
	
	public void siftDown(int parent) {
		if (hasChild(parent)) {
			int smallerChild = smallerChild(parent);
			// 2.1. delete minimum element and add it to end of new list
			if (heap[parent] > heap[smallerChild]) {
				swap(parent, smallerChild);
				siftDown(smallerChild);
			}
		}
	}
	
	public int smallerChild(int parent) {
		if (parent * 2 + 2 < size()) {
			if (heap[parent * 2 + 1] < heap[parent * 2 + 2])
				return parent * 2 + 1;
			else
				return parent * 2 + 2;
		} else if (parent * 2 + 1 < size())
			return parent * 2 + 1;
		else
			return -1;
	}
	
	public int size() {
		return size;
	}
	
	// Returns true if parent has at least one child:
	public boolean hasChild(int parent) {
		if (parent * 2 + 1 >= size())
			return false;
		return true;
	}
}
