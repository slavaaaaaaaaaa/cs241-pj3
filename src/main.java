// Project 3: Scaling behavior of sorting algorithms 
// Due Mon May 20
//
// Implement Selection, Heap, Merge and QuickSort. 
//		SelectionSort, HeapSort, MergeSort, QuickSort classes
//		Done.
//
// Test them on random arrays of increasing orders of magnitude to examine their scaling behavior. 
// 		main class
//		TODO
//
// Graph your results. 
//		attached project description
//		TODO
//
// Extrapolate your results and experimentally verify the accuracy of your estimates. 
//		TODO
//
// Here are the details:
//
// 1. Construct a class for each sort method using the algorithms on the course web site. Test your code to verify that all the 
// sort methods work properly. Construct a main driver class that uses a switch statement and inheritance to run different sort methods.
//	Done.
//
// 2. Instrument each algorithm to count comparisons, moves and elapsed time by constructing a SortTimer class as discussed in class. 
// Use System.nanoTime() and divide by 1,000 to get the clock time in microseconds.
//
// 3. Run your code on random arrays of size n = 10^i, i = 1. . .4. Run five instances of each sample size and take the average 
// of each measure.
//
// 4. Plot the elapsed time and comparison count against n using a decimal logarithmic scale on each axis.
//
// 5. Use the information obtained to estimate the time and count for n = 10^5 and 10^6.
//
// 6. Now run Selection sort for n = 5 and the other three methods for n = 6 and calculate 
// the relative error of your estimates. Report your results in a table.
//
// 7. Submit a project report that includes all tables, graphs, code and output.

public class main {
	// 1. Construct a main driver class that uses a switch statement and
	// inheritance to run different sort methods.
	public static boolean	DEBUG	= false;
	private static double	array[];
	private static Sort		sortMachine;
	private static int		arraySize;
	
	public static void main(String[] args) {
		if (DEBUG) {
			array = new double[] { 45, 32, 12, 19, 40, 9, 56, 23, 3, 22, 18,
					48, 49, 33, 11, 7 };
			// Sort is = new InsertionSort(); // completed & tested
			// Sort is = new HeapSort(); // completed & tested
			// Sort is = new MergeSort(); // completed & tested
			// Sort is = new QuickSort(); // completed & tested
			// Sort is = new SelectionSort(); // completed & tested
			// double sorted[] = is.sortMe(array);
			// for (int i = 0; i < array.length; i++) {
			// System.out.print(sorted[i] + ", ");
			// }
		} else {
			try {
				arraySize = Integer.parseInt(args[1]);
			} catch (Exception e) {
				System.out
						.println("Wrong input. Should be of type \"java main [q/s/h/m] [1...4]\"");
				System.exit(1);
			}
			
			switch (args[0]) {
				case "s":
					System.out.println("Selection Sort");
					sortMachine = new SelectionSort();
					break;
				case "h":
					System.out.println("Heap Sort");
					sortMachine = new HeapSort();
					break;
				case "m":
					System.out.println("Merge Sort");
					sortMachine = new MergeSort();
					break;
				case "q":
					System.out.println("Quick Sort");
					sortMachine = new QuickSort();
					break;
			}
			System.out.print("\tn\tMicrosecs\tComparisons\tMoves\n");
			for (int j = 0; j < arraySize; j++) {
				array = new double[(int) Math.pow(10, j)];
				for (int i = 0; i < array.length; i++) {
					array[i] = Math.random();
				}
				sortMachine.st.reset();
				System.out.print("\t" + (int) Math.pow(10, j) + "\t"
						+ sortMachine.sortMe(array));
			}
		}
		// TODO main
	}
}
