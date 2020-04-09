package assign10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class collects running times for methods of FindKLargest.
 * 
 * @author Erin Parker & Brady Hartog & Vivek Vankayalapati
 * @version April 9, 2020
 */
public class FindKLargestTimer
{
	public static void main(String[] args)
	{
		Random rng = new Random();

		int timesToLoop = 10;

		int incr = 10000;
		for (int probSize = 10000; probSize <= 200000; probSize += incr)
		{
			List<Integer> list = new ArrayList<Integer>();
			
			int k = 10; // Change to 1,10, probSize/2, or probSize
			
			for (int i = 0; i < probSize; i++)
			{
				list.add(rng.nextInt(probSize));
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
				// Uncomment when timing HeapSort
				//FindKLargest.findKLargestHeap(list, k);

				// Uncomment when timing Java's sort
				FindKLargest.findKLargestSort(list, k);
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
