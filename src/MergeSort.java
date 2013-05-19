// Merge Sort
// 
// Input: list of n comparable elements indexed 0 to n-1
// 
// Output: list of elements sorted in ascending order
// 
// 1. Call recursive mergesort procedure with left=0 and right=n-1 
// 
// Recursive mergesort(left, right)
// 1. set mid to the middle index in range left to right
// 2. recursively mergesort elements left..mid
// 3. recursively mergesort elements mid+1 to right
// 4. merge the two sorted lists and return result
// 
// Merge method
// 
// Input: two sorted lists
// 
// Output: new sorted list obtained by merging the two lists
// 
// 1. initalize cursors a and b to the two list heads
// 2. while both lists have elements left
// 2.1. if element at cursor a is less than element at b, move it to new list and advance a
// 2.2. if element at cursor a is equal to element at b, move it to new list and advance a & b
// 2.3. if element under cursor b is less than element at a, move it to new list and advance b
// 3. at this point, at most one list has elements left; move them all to the end of new list
// 4. return new list

public class MergeSort implements Sort {
	public double[] sortMe(double[] array) {
		// 1. Call recursive mergesort procedure with left=0 and right=n-1
		return mergeSort(array, 0, array.length);
	}
	
	public double[] mergeSort(double[] data, int left, int right) {
		// 1. set mid to the middle index in range left to right
		if (right - left == 1)
			return new double[] { data[left] };
		int mid = (right + left) / 2;
		// 2. recursively mergesort elements left..mid
		// 3. recursively mergesort elements mid+1 to right
		// 4. merge the two sorted lists and return result
		double[] array1 = mergeSort(data, left, mid);
		double[] array2 = mergeSort(data, mid, right);
		return merge(array1, array2);
	}
	
	public double[] merge(double[] dataLeft, double[] dataRight) {
		// 1. initalize cursors a and b to the two list heads
		int a = 0, b = 0, c = 0;
		double[] temp = new double[dataLeft.length + dataRight.length];
		// 2. while both lists have elements left
		while (a < dataLeft.length && b < dataRight.length) {
			// 2.1. if element at cursor a is less than element at b, move it to
			// new list and advance a
			if (dataLeft[a] < dataRight[b]) {
				temp[c] = dataLeft[a];
				a++;
			}
			// 2.2. if element at cursor a is equal to element at b, move it to
			// new list and advance a & b
			else if (dataLeft[a] == dataRight[b]) {
				temp[c] = dataLeft[a];
				a++;
				b++;
			}
			// 2.3. if element under cursor b is less than element at a, move it
			// to new list and advance b
			else if (dataLeft[a] > dataRight[b]) {
				temp[c] = dataRight[b];
				b++;
			}
			c++;
		}
		// 3. at this point, at most one list has elements left; move them all
		// to the end of new list
		while (a < dataLeft.length) {
			temp[c] = dataLeft[a];
			a++;
			c++;
		}
		while (b < dataRight.length) {
			temp[c] = dataRight[b];
			b++;
			c++;
		}
		
		// 4. return new list
		return temp;
	}
}
