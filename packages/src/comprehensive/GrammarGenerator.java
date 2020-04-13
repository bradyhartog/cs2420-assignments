package comprehensive;

import java.io.FileWriter;
import java.io.IOException;

public class GrammarGenerator 
{
    public static void rulesPerNonterminal(int probSizeLower, int probSizeUpper, int incr)
    {
        int name = 0;
        for (int probSize = probSizeLower; probSize <= probSizeUpper; probSize += incr)
        {
            try 
            {
                FileWriter writer = new FileWriter("/N_rules/" + name + ".txt", true);
                    
                writer.write("{");
                writer.write("<start>");
                writer.write("<nonterminal>");
                writer.write("}");
                writer.write("{");
                writer.write("<nonterminal>");
               
                for (int i = 0; i< probSize; i++)
                {
                    writer.write("lorem ipsum dolor");
                }
                writer.write("}");
                writer.close();
            } 
        
            catch (IOException e) 
            {
                e.printStackTrace();
            }

            name++;
        }
        
    }
    

}