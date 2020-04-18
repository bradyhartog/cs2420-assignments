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
    private HashMap<String, ArrayList<BinaryTree>> grammar; 

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
    	ArrayList<BinaryTree> rules = grammar.get(nonTerminal); //Gets all of the production rules associated with a nonterminal
    	BinaryTree rule = grammar.get(nonTerminal).get(new Random().nextInt(rules.size())); //Stores the tokenized form of a single production rule
        
        StringBuilder phrase = new StringBuilder();

        //phrase.append(//use in order traversal);

        //Returns the phrase
        return phrase.toString();   
    }
}
