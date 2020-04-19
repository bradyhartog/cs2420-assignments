package comprehensive;

import java.io.File;

/**
 * Takes user input to generate requisite number of random phrases. 
 * Calls RandomPhrase which calls GrammarReader.
 * 
 * User Input: file, number of phrases
 */
public class RandomPhraseGenerator
{
    /**
     * Runs the RandomPhraseGenerator, taking in user input.
     */
    public static void main (String[] args)
    {
        // User supplied grammar file
        File file = new File(args[0]);

        // User supplied requisited phrases
        int phrases = Integer.parseInt(args[1]);

        //This is for testing it in the main method itself (DELETE BEFORE FINAL SUBMISSION)

//        //String vivekPath = "C:\\Users\\viviv\\Documents\\GitHub\\cs2420-assignments\\packages\\src\\comprehensive\\";
//        String bradyPath = "/Users/bradyhartog/Library/Mobile Documents/com~apple~CloudDocs/iCloud Drive/Documents/School/University of Utah/04 Spring 2020/CS 2420/Shared Assignments/cs2420-assignments/packages/src/comprehensive/";
//        File file = new File(bradyPath + "poetic_sentence.g");
//        //File file = new File(bradyPath + "mathematical_expression.g");
//
//        int phrases = 10;

        //Makes the RandomPhraseGenerator from the user's file
        RandomPhrase generator = new RandomPhrase(file);

        //Prints random phrases the requisite number of times
        for (int i = 0; i < phrases; i++)
        {
            System.out.println(generator.print());
        }
    }
}
