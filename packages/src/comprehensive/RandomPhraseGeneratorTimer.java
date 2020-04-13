package comprehensive;

/**
 * Timing
 * DO NOT SUBMIT
 * 
 * This is going to be painful, we have to generate grammar files of increasing nonterminals or rules or nonterminals per rule,
 * or  increases number of phrases generated
 */
public class RandomPhraseGeneratorTimer
{
    public static void main (String[] args)
    {
        int probSizeLower = 10000;
        int probSizeUpper = 200000;
        int incr = 10000;
        GrammarGenerator.rulesPerNonterminal(probSizeLower, probSizeUpper, incr);

        //int timesToLoop = 10;
        
        int name = 1;
        String vivekPath = "C:\\Users\\viviv\\Documents\\GitHub\\cs2420-assignments\\packages\\src\\comprehensive\\N_rules\\";
        for (int probSize = probSizeLower; probSize <= probSizeUpper; probSize += incr)
        {
            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.
            String[] args1 = new String[] {vivekPath + name + ".txt", "1"};

            long stopTime, midpointTime, startTime = System.nanoTime();

            while (System.nanoTime() - startTime < 1000000000)
            { // empty block
            }

            // Collect running times.
            startTime = System.nanoTime();
            // for (int i = 0; i < timesToLoop; i++)
            // {
            // }
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
            System.out.println(probSize + "  " + averageTime);
            name++;
		}
    }

}
