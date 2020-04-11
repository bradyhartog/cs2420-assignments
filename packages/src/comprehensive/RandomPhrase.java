package comprehensive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Uses the output from GrammarReader to generate Random Phrases
 */
public class RandomPhrase
{
    private HashMap<String, ArrayList<String[]>> grammar; //Just checking to make sure we can inception this, feel free to delete
        //O(1) nonterminal access
            //O(1) rule access (after nonterminal acccess)
                //O(length of the rule)?
        //My optimistic prediction is a high constant time (after grammar parsing)
            //This means the big O would be determined by the cost of the parsing

    public RandomPhrase (HashMap<String, ArrayList<String[]>> grammar)
    {
        this.grammar = grammar;
    }
    
    public String print()
    {
    	return print("<start>");
    }
    
    private String print(String nonTerminal)
    {
    	Random rng = new Random();
    	
    	ArrayList<String[]> rules = grammar.get(nonTerminal);
    	String[] rule = rules.get(rng.nextInt(rules.size()));
    	
    	for (int i = 0; i < rule.length; i++)
    	{
    		//
    	}
    }
}
