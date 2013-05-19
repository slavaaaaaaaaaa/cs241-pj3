// Selection Sort
// 
// Input: list of n comparable elements indexed 0 to n-1
// 
// Output: list of elements sorted in ascending order
// 
// 1. for i = n-1 down to 1
// 1.1. set max to the index of largest element in the range 0 to i
// 1.2. swap elements at positions i and max

public class SelectionSort implements Sort {
	public long sortMe(double[] array) {
		st.reset();
		int max = 0;
		// 1. for i = n-1 down to 1
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				// 1.1. set max to the index of largest element in the range 0
				// to i
				st.addComparison();
				if (array[j] > array[max])
					max = j;
			}
			// 1.2. swap elements at positions i and max
			st.addMoves(2);
			double temp = array[i];
			array[i] = array[max];
			array[max] = temp;
		}
		// return array;
		return st.getElapsedTime();
	}
}
