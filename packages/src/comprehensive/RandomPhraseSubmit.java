package comprehensive;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Uses a grammar file to generate random rhrases
 */
public class RandomPhraseSubmit {
    /** The HashMap form of the grammar */
    private HashMap<String, ArrayList<String>> grammar;

    /**
     * Constructs the RandomPhrase by setting the grammar to the output of
     * GrammarReader from a file
     * 
     * @param file
     */
    public RandomPhraseSubmit(File file)
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
    	Random rng = new Random(); //Random number generator
    	//StringBuilder string = new StringBuilder(); //Constructs the phrase
    	ArrayList<String> rules = grammar.get(nonTerminal); //Gets all of the production rules associated with a nonterminal
    	StringBuilder rule = new StringBuilder(rules.get(rng.nextInt(rules.size()))); //Stores the tokenized form of a single production rule
        
        
        //Search for a "<" (Indicates a nonterminal)
        int leftBracketIndex = rule.indexOf("<");
        
        while (leftBracketIndex != -1)
        {     
            //Determine its length by getting the ">"
            int rightBracketIndex = rule.indexOf(">");

            //Replaced the nonterminal with the output phrase froma nonterminal (recursive)
            rule.replace(leftBracketIndex, rightBracketIndex+1, print(rule.substring(leftBracketIndex, rightBracketIndex+1)));

            //Search for a "<" (Indicates a nonterminal)
            leftBracketIndex = rule.indexOf("<");
        }

        //Returns the phrase
        return rule.toString();   
     }
}
