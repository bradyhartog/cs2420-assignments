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
    HashMap<String,ArrayList<ArrayList<String>>> grammar;

    public GrammarReader()
    {
        grammar = new HashMap<String,ArrayList<ArrayList<String>>>();
    }

    /**
	 * Returns a list of the words contained in the specified file. (Note that
	 * symbols, digits, and spaces are ignored.)
	 * 
	 * @param file - the File to be read
	 * @return a List of the Strings in the input file
	 */
	private List<String> readFromFile(File file) 
	{
		ArrayList<String> words = new ArrayList<String>();

		try 
		{
			Scanner fileInput = new Scanner(file);

            boolean isClosed = false;


			while (fileInput.hasNext()) 
			{
				String s = fileInput.nextLine();
				if (s.equals("{")) 
				{
                    String key = fileInput.nextLine();
                    while(s != "}")
                    {
                        s = fileInput.nextLine();
                        s.split(" ");
                    }
                }
            }
            
			
    		fileInput.close();
        } 
        
        private void rule (String[] rule)
        {
            
        }
		// catch(FileNotFoundException e) 
		// {
		// 	System.err.println("File " + file + " cannot be found.");
		// }

		return words;
	}

}
