package comprehensive;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Uses a grammar file to generate random phrases
 * 
 * @authors Vivek Vankayalapati & Brady Hartog
 * @version April 21, 2020
 */
public class RandomPhrase 
{
    /** The HashMap form of the grammar */
    private HashMap<String, ArrayList<String>> grammar;
    
    /**Random number generator */
    Random rng = new Random();

    /**
     * Constructs the RandomPhrase by setting the grammar to the output of
     * GrammarReader from a file
     * 
     * @param file
     */
    public RandomPhrase(File file)
    {
        this.grammar = new GrammarReader(file).getGrammar();
    }
    
    /**
     * Driver method to print a random phrase
     */
    public String print()
    {
    	return print("<start>");
    }
    
    /**
     * Helper method to print a random phrase starting from a nonTerminal
     */
    private String print(String nonTerminal)
    {
        //Stores a single random production rule from a terminal
    	StringBuilder rule = new StringBuilder(grammar.get(nonTerminal).get(rng.nextInt(grammar.get(nonTerminal).size())));
        
        //Search for a "<" (Indicates a nonterminal)
        int leftBracketIndex = rule.indexOf("<");
        
        //While a nonterminal exists
        while (leftBracketIndex != -1)
        {     
            //Determine its length by getting the ">"
            int rightBracketIndex = rule.indexOf(">");

            //Replaced the nonterminal with the output phrase from a nonterminal (recursive)
            rule.replace(leftBracketIndex, rightBracketIndex+1, print(rule.substring(leftBracketIndex, rightBracketIndex+1)));

            //Search for a "<" (Indicates a nonterminal)
            leftBracketIndex = rule.indexOf("<");
        }

        //Returns the phrase
        return rule.toString();   
     }
}
