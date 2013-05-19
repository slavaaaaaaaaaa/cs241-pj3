// 2. Instrument each algorithm to count comparisons, moves and elapsed time
// by constructing a SortTimer class as discussed in class.
//
// Use System.nanoTime() and divide by 1,000 to get the clock time in
// microseconds.
//
public class SortTimer {
	private long	comparisons, moves, time;
	
	void reset() {
		time = System.nanoTime();
		comparisons = 0;
		moves = 0;
	}
	
	void addComparison() {
		comparisons++;
	}
	
	void addComparisons(int n) {
		comparisons += n;
	}
	
	void addMove() {
		moves++;
	}
	
	void addMoves(int n) {
		moves += n;
	}
	
	long getComparisons() {
		return comparisons;
	}
	
	long getMoves() {
		return moves;
	}
	
	long getElapsedTime() {
		return System.nanoTime() - time;
	}
}
