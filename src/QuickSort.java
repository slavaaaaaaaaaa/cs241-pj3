// QuickSort
// 
// Input: list of n comparable elements indexed 0 to n-1
// 
// Output: list of elements sorted in ascending order
// 
// 1. Call recursive quicksort procedure with left=0 and right=n-1 
// 
// Recursive quicksort(left, right)
// 
// 1. select pivot element in the range left to right
// 2. partition list in place so that all elements ²pivot precede those that are >pivot
// 3. let pos be the position of the pivot element after partitioning
// 4. recursively quicksort elements left to pos-1
// 5. recursively quicksort elements pos+1 to right
// 
// Partition(left, right, pivot index)
// 
// Input: list of elements from left to right and index of pivot element
// 
// Output: rearranged list: [²pivot, pivot, >pivot]; final index of pivot element
// 
// 1. swap pivot with element at position right
// 2. set pos to left; pos represents the boundary between small and large elements
// 3. for i = left to right-1
// 3.1. if element at i is ²pivot, swap it with element at pos and advance pos
// 4. at this point, leftmost element >pivot is at pos; swap pivot with this element
// 5. return pos

public class QuickSort implements Sort {
	public double[] sortMe(double[] array) {
		// 1. Call recursive quicksort procedure with left=0 and right=n-1
		return quickSort(array, 0, array.length - 1);
	}
	
	private double[] quickSort(double[] data, int left, int right) {
		// 1. select pivot element in the range left to right
		// 2. partition list in place so that all elements ²pivot precede those
		// that are >pivot
		// 3. let pos be the position of the pivot element after partitioning
		int pos = partition(data, left, right);
		// 4. recursively quicksort elements left to pos-1
		// 5. recursively quicksort elements pos+1 to right
		if (left < pos - 1)
			quickSort(data, left, pos - 1);
		if (pos < right)
			quickSort(data, pos, right);
		
		return data;
	}
	
	private int partition(double[] data, int left, int right) {
		int i = left, j = right;
		double pivot = data[(left + right) / 2];
		
		while (i <= j) {
			while (data[i] < pivot)
				i++;
			while (data[j] > pivot)
				j--;
			if (i <= j) {
				double temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				i++;
				j--;
			}
		}
		
		return i;
	}
}
