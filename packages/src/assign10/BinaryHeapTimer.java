package assign10;

import java.util.Random;

/**
 * This class collects running times for methods of BinaryMaxHeap.
 * 
 * @author Erin Parker & Brady Hartog & Vivek Vankayalapati
 * @version April 9, 2020
 */
public class BinaryHeapTimer
{
	public static void main(String[] args)
	{
		Random rng = new Random();

		int timesToLoop = 1000000;

		int incr = 400000;
		for (int probSize = 200000; probSize <= 10000000; probSize += incr)
		{
			BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();

			for (int i = 0; i < probSize; i++)
			{
				heap.add(rng.nextInt(probSize));
			}

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			long stopTime, midpointTime, startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000)
			{ // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++)
			{
				// Uncomment when timing add()
				// heap.add(probSize/2);
				
				// Uncomment when timing peek()
				// heap.peek();
				
				// Uncomment when timing extractMax()
				// heap.extractMax();
			}

			midpointTime = System.nanoTime();

			// Capture the cost of running the loop and any other operations done
			// above that are not the essential method call being timed.
			for (int i = 0; i < timesToLoop; i++)
			{ // empty block
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and searching.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
			System.out.println(probSize + "  " + averageTime);
		}
	}
}