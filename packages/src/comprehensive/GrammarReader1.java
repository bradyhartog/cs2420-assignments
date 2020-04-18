package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.internal.builders.NullBuilder;

/**
 * Parses through a grammar file
 */
public class GrammarReader1 
{
	/**The HashMap form of the grammar */
    HashMap<String,ArrayList<BinaryTree>> grammar;

	/**
	 * Constructs the HashMap form of the grammar
	 * @param file
	 */
    public GrammarReader1(File file)
    {
        this.grammar = new HashMap<String,ArrayList<BinaryTree>>();
    	this.grammar = readFromFile(file);
    }
	
	/**
	 * Gets the HashMap form of the grammar
	 * @return grammar (HashMap)
	 */
    public HashMap<String,ArrayList<BinaryTree>> getGrammar()
    {
    	return this.grammar;
    }

    /**
	 * Returns a HashMap containing nonterminals mapped to their production rules, each of which contained their
	 * tokenized description.
	 * 
	 * @param file - The file to be read
	 * @return HashMap form of the grammar
	 */
	private HashMap<String,ArrayList<BinaryTree>> readFromFile(File file)
	{
		try 
		{
			//Scans the file
			Scanner fileInput = new Scanner(file);

			while (fileInput.hasNextLine()) 
			{
				//Get the next line
				String s = fileInput.nextLine();
				
				//If nonterminal with its rules is found
				if (s.equals("{")) 
				{
					//Gets the nonterminal (always the line after "{")
					String nonTerminal = fileInput.nextLine();

					//Prepares to get the production rules
					ArrayList<BinaryTree> productions = new ArrayList<>();
					
					//Gets the first rule
					s = fileInput.nextLine();
					
					//Checks to see if this set of rules ends
                    while (!s.equals("}"))
                    {
						//Construct a tree for each production rule
						
						productions.add(treeBuilder(s));
                        s = fileInput.nextLine();
                    }
					
					//Adds the nonterminal with its rules into the HashMap form of the grammar
                    this.grammar.put(nonTerminal, productions);
                }
			}
			
    		fileInput.close();
		}

		//The scanner forces us to the something with exception handling, so we do nothing
		catch(FileNotFoundException e)
		{
		}

		return grammar;
	}

	private BinaryNode treeBuilder(String rule)
	{
		int leftBracketIndex = rule.indexOf("<");

		BinaryNode tree;
		if (leftBracketIndex != -1)
		{
			int rightBracketIndex = rule.indexOf(">");

			BinaryNode leftChild = new BinaryNode(rule.substring(0,leftBracketIndex),null,null);

			BinaryNode rightChild = treeBuilder(rule.substring(rightBracketIndex));

			rule = rule.substring(leftBracketIndex, rightBracketIndex+1);

			tree = new BinaryNode(rule,leftChild,rightChild);
		}
		else
		{
			tree = new BinaryNode(rule,null,null);
		}


		//Split string by first < > call method on leftover

		return tree;
	}
}