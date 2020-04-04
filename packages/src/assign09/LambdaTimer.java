package assign09;

import java.util.ArrayList;

public class LambdaTimer
{
    public static void main (String[] args)
    {
        int incr = 1000;
        for (int probSize = 1000; probSize <= 40000; probSize += incr)
        {
            HashTable<String, Integer> hash = new HashTable<>();
            
            // Vary lambda value
            hash.setLambda(25.0);
//            hash.setLambda(50.0);
//            hash.setLambda(100.0);
//            hash.setLambda(1000.0);
            
            ArrayList<String> keyList = new ArrayList<>();
    		
    		//Puts random values between 0 to 1 (exclusive) as strings. Number of values inserted requires two doublings of our HashTable
    		for (int i = 0; i < probSize; i++) {
    			keyList.add(Math.random() + "");
    		}
    		
    		long stopTime, midpointTime, startTime = System.nanoTime();

            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize

            while (System.nanoTime() - startTime < 1000000000)
            {
            	// empty block
            }

            // Collect running times.
            startTime = System.nanoTime();
            for (int i = 0; i < probSize; i++)
            {
                 hash.put(keyList.get(i), i);
            }

            midpointTime = System.nanoTime();

            // Capture the cost of running the loop and any other operations done
            // above that are not the essential method call being timed.
            for (int i = 0; i < probSize; i++)
            {
            	
            }

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and searching.
            // Average it over the problem size.
            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) probSize;
            System.out.println(probSize + "  " + averageTime);
        }
    }
}