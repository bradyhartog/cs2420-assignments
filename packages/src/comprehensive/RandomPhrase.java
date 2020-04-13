package comprehensive;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Uses a grammar file to generate random rhrases
 */
public class RandomPhrase
{
    /**The HashMap form of the grammar */
    private HashMap<String, ArrayList<String[]>> grammar; 

    /**
     * Constructs the RandomPhrase by setting the grammar to the output of GrammarReader from a file
     * @param file
     */
    public RandomPhrase (File file)
    {
        GrammarReader grammar = new GrammarReader(file);
        this.grammar = grammar.getGrammar();
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
            String token = rule[i];
            
            //FIX: Iterate through each character in the token
                //for abc.g, the will be multiple nonterminals in a token, but the loop iterates 1 per token
                //token.indexOf(str, fromIndex) <- Using this, we don't actually have to iterate ourselves
            
            //Search for a "<" (Indicates a nonterminal)
            int leftBracketIndex = token.indexOf("<");

            //token.indexOf(str, fromIndex)

            //If nonterminal found
            if (leftBracketIndex != -1)
            {
                //Determine its length by getting the ">"
                int rightBracketIndex = token.indexOf(">");
                
                //New StringBuilder to allow modification of the token
                StringBuilder newToken = new StringBuilder(token);

                //Replaced the nonterminal with the output phrase froma nonterminal (recursive)
                newToken.replace(leftBracketIndex, rightBracketIndex+1, print(token.substring(leftBracketIndex, rightBracketIndex+1)));

                //Reassigns the actual toke to the modifed form of the token
                token = newToken.toString();
            }

            //Since tokens are delimited by a space, the phrase added the token with a space
            string.append(token + " ");      
        }

        //Removes the last space to as there is never a space at the end of a phrase
        string.deleteCharAt(string.length()-1);
        
        //Returns the phrase
        return string.toString();   
     }
}
