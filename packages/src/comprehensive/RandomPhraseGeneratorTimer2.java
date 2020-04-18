package comprehensive;

import java.util.ArrayList;

public class RandomPhraseGeneratorTimer2 
{

    public static void main (String[] args)
    {
        int probSizeLower = 1000;
        int probSizeUpper = 20000;
        int incr = 1000;


        ArrayList<Double> times = new ArrayList<Double>();
        
        //int timesToLoop = 10;
        String vivekPath = "C:\\Users\\viviv\\Documents\\GitHub\\cs2420-assignments\\packages\\src\\comprehensive\\";
        for (int probSize = probSizeLower; probSize <= probSizeUpper; probSize += incr)
        {
            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.
            String[] args1 = new String[] {vivekPath + "poetic_sentence.g" , "" + probSize};

            long stopTime,startTime = System.nanoTime();

            while (System.nanoTime() - startTime < 1000000000)
            { // empty block
            }

            // Collect running times.
            startTime = System.nanoTime();
            
            RandomPhraseGenerator.main(args1);

            stopTime = System.nanoTime();
            //midpointTime = System.nanoTime();

            // Capture the cost of running the loop and any other operations done
            // above that are not the essential method call being timed.
            // for (int i = 0; i < timesToLoop; i++)
            // { // empty block
            // }

            

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and searching.
            // Average it over the number of runs.
            double averageTime = ((stopTime) - (startTime));
            //System.out.println(probSize + "  " + averageTime);
            times.add(averageTime);
        }

        for (Double time : times)
        {
            System.out.println(probSizeLower + "  " + time);
            probSizeLower += incr;
        }
    }

}