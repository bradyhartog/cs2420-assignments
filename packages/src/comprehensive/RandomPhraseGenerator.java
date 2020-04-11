package comprehensive;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Takes user input to generate requisite number of random phrases. Calls
 * RandomPhrase which calls GrammarReader.
 */
public class RandomPhraseGenerator
{
    public static void main (String[] args)
    {
        File file = new File(args[0]);

        int phrases = Integer.parseInt(args[1]);

        // File file = new File("C:\\Users\\viviv\\Documents\\GitHub\\cs2420-assignments\\packages\\src\\comprehensive\\assignment_extension_request.g");

        // int phrases = 1;

        GrammarReader grammar = new GrammarReader(file);
        RandomPhrase generator = new RandomPhrase(grammar.getGrammar());

        for (int i = 0; i < phrases; i++)
        {
            System.out.println(generator.print());
        }
    }
}
