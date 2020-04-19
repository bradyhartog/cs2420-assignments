package comprehensive;

import java.io.File;

/**
 * Takes user input to generate requisite number of random phrases. 
 * Calls RandomPhrase which calls GrammarReader.
 * 
 * User Input: file, number of phrases
 * 
 * @authors Vivek Vankayalapati & Brady Hartog
 * @version April 21, 2020
 */
public class RandomPhraseGenerator
{
    /**
     * Runs the RandomPhraseGenerator, taking in user input.
     */
    public static void main (String[] args)
    {
    	// User supplied requisited phrases
        int phrases = Integer.parseInt(args[1]);

        //Makes the RandomPhraseGenerator from the user's file
        RandomPhrase generator = new RandomPhrase(new File(args[0]));

        //Prints random phrases the requisite number of times
        for (int i = 0; i < phrases; i++)
        {
            System.out.println(generator.print());
        }
    }
}
