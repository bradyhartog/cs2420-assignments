package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Parses through a grammar file
 */
public class GrammarReader 
{
    private HashMap<String, ArrayList<String[]>> grammar;

    public GrammarReader(File file)
    {
        this.grammar = new HashMap<String, ArrayList<String[]>>();
    	this.grammar = readFromFile(file);
    }
    
    public HashMap<String, ArrayList<String[]>> getGrammar()
    {
    	return this.grammar;
    }

    /**
	 * Returns a list of the words contained in the specified file. (Note that
	 * symbols, digits, and spaces are ignored.)
	 * 
	 * @param file - the File to be read
	 * @return a List of the Strings in the input file
	 */
	private HashMap<String, ArrayList<String[]>> readFromFile(File file) 
	{
		try 
		{
			Scanner fileInput = new Scanner(file);

			while (fileInput.hasNext()) 
			{
				String s = fileInput.nextLine();
				
				if (s.equals("{")) 
				{
					String nonTerminal = fileInput.nextLine();
					ArrayList<String[]> productions = new ArrayList<>();
					
					s = fileInput.nextLine();
                    
                    while (!s.equals("}"))
                    {
                        productions.add(s.split(" "));
                        s = fileInput.nextLine();
                    }
                    
                    this.grammar.put(nonTerminal, productions);
                }
            }
			
    		fileInput.close();
		}
		catch(FileNotFoundException e) 
		{
			// Blank by assumption of correct input files.
		}

		return grammar;
	}
}