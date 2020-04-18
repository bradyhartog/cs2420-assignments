package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Parses through a grammar file
 */
public class GrammarReader2 {
	
	Graph grammar;
	
	/**
	 * Constructs the HashMap form of the grammar
	 * 
	 * @param file
	 */
	public GrammarReader2(File file)
    {
        this.grammar = new Graph();
    	this.grammar = readFromFile(file);
    }
	
	/**
	 * Gets the HashMap form of the grammar
	 * @return grammar (HashMap)
	 */
    public Graph getGrammar()
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
	private Graph readFromFile(File file)
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
					
					//grammar.addEdge(src, dst);

					//Prepares to get the production rules
					//ArrayList<String> productions = new ArrayList<>();
					
					//Gets the first rule
					s = fileInput.nextLine();
					
					//Checks to see if this set of rules ends
                    while (!s.equals("}"))
                    {
						grammar.addEdge(nonTerminal, s);
                    	
                    	String[] rule = s.split(" ");
						
						for (String token : rule)
						{
							grammar.addEdge(s, token);
						}
						
						//Gets the next line
                        s = fileInput.nextLine();
                    }
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
}