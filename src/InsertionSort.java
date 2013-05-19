// Insertion Sort
// 
// Input: list of n comparable elements indexed 0 to n-1
// 
// Output: list of elements sorted in ascending order
//
// 1. for i = 1 to n-1
// 1.1. compare the current value with elements i-1 down to 0
// 1.2. shift each element that is greater than the current value one position to the right
// 1.3. insert current value into its correct position relative to other elements in range

public class InsertionSort implements Sort {
	public double[] sortMe(double[] array) {
		// 1. for i = 1 to n-1
		for (int i = 0; i < array.length; i++) {
			double current = array[i];
			int j = i;
			// 1.1. compare the current value with elements i-1 down to 0
			while (j > 0 && array[j - 1] > current) {
				// 1.2. shift each element that is greater than the current
				// value one position to the right
				array[j] = array[j - 1];
				j--;
			}
			// 1.3. insert current value into its correct position relative to
			// other elements in range
			array[j] = current;
		}
		return array;
	}
}