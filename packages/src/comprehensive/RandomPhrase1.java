package comprehensive;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Uses a grammar file to generate random rhrases
 */
public class RandomPhrase1
{
    /**The HashMap form of the grammar */
    private HashMap<String, ArrayList<String[]>> grammar; 

    /**
     * Constructs the RandomPhrase by setting the grammar to the output of GrammarReader from a file
     * @param file
     */
    public RandomPhrase1 (File file)
    {
        this.grammar = new GrammarReader1(file).getGrammar();
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
    	StringBuilder string = new StringBuilder(); //Constructs the phrase
    	ArrayList<String[]> rules = grammar.get(nonTerminal); //Gets all of the production rules associated with a nonterminal
    	String[] rule = rules.get(rng.nextInt(rules.size())); //Stores the tokenized form of a single production rule
        
        //For the number of tokens in a rule
    	for (int i = 0; i < rule.length; i++)
    	{
            //Get the token
            StringBuilder token = new StringBuilder(rule[i]);
            
            //Search for a "<" (Indicates a nonterminal)
            int leftBracketIndex = token.indexOf("<");
            
            while (leftBracketIndex != -1)
            {     
                //Determine its length by getting the ">"
                int rightBracketIndex = token.indexOf(">");

                //Replaced the nonterminal with the output phrase froma nonterminal (recursive)
                token.replace(leftBracketIndex, rightBracketIndex+1, print(token.substring(leftBracketIndex, rightBracketIndex+1)));

                //Search for a "<" (Indicates a nonterminal)
                leftBracketIndex = token.indexOf("<");
            }

            //Since tokens are delimited by a space, the phrase added the token with a space
            string.append(token.toString() + " ");      
        }

        //Removes the last space to as there is never a space at the end of a phrase
        string.deleteCharAt(string.length()-1);
        
        //Returns the phrase
        return string.toString();   
     }
}
