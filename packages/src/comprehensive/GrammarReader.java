package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Parses through a grammar file
 * 
 * @authors Vivek Vankayalapati & Brady Hartog
 * @version April 21, 2020
 */
public class GrammarReader 
{
	/** The HashMap form of the grammar */
	private HashMap<String, ArrayList<String>> grammar;

	/**
	 * Constructs the HashMap form of the grammar
	 * 
	 * @param file
	 */
	public GrammarReader(File file)
    {
        this.grammar = new HashMap<String, ArrayList<String>>();
    	this.grammar = readFromFile(file);
    }
	
	/**
	 * Gets the HashMap form of the grammar
	 * @return grammar (HashMap)
	 */
    public HashMap<String, ArrayList<String>> getGrammar()
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
	private HashMap<String, ArrayList<String>> readFromFile(File file)
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
					ArrayList<String> productions = new ArrayList<>();
					
					//Gets the first rule
					s = fileInput.nextLine();
					
					//Checks to see if this set of rules ends
                    while (!s.equals("}"))
                    {
						//Split each production rule into space-delimited tokens
						productions.add(s);
						
						//Gets the next line
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
}