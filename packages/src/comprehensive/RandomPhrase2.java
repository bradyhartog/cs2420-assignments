package comprehensive;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Uses a grammar file to generate random rhrases
 */
public class RandomPhrase2 {
    /** The HashMap form of the grammar */
    private Graph grammar;

    /**
     * Constructs the RandomPhrase by setting the grammar to the output of
     * GrammarReader from a file
     * 
     * @param file
     */
    public RandomPhrase2(File file)
    {
        this.grammar = new GrammarReader2(file).getGrammar();
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
    	//ArrayList<String> rules = grammar.get(nonTerminal); //Gets all of the production rules associated with a nonterminal
    	
    	HashMap<String, Vertex> vertices = grammar.getVertices();
    	
    	Vertex rules = vertices.get(nonTerminal);
    	
    	StringBuilder rule = new StringBuilder(rules.getEdges().get(rng.nextInt(rules.getEdges().size())).getOtherVertex().getElement());
        
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
