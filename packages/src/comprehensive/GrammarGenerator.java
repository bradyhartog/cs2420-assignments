package comprehensive;

import java.io.FileWriter;
import java.io.IOException;

public class GrammarGenerator 
{
    public static void rulesPerNonterminal(int probSizeLower, int probSizeUpper, int incr)
    {
        int name = 1;
        String vivekPath = "C:\\Users\\viviv\\Documents\\GitHub\\cs2420-assignments\\packages\\src\\comprehensive\\N_rules\\";
        for (int probSize = probSizeLower; probSize <= probSizeUpper; probSize += incr)
        {
            try 
            {
                FileWriter writer = new FileWriter(vivekPath + name + ".txt", false);
                writer.write("{\n");
                writer.write("<start>\n");
                writer.write("<nonterminal>\n");
                writer.write("}\n");
                writer.write("{\n");
                writer.write("<nonterminal>\n");
               
                for (int i = 1; i<= probSize; i++)
                {
                    writer.write("lorem ipsum dolor\n");
                }
                writer.write("}\n");
                writer.close();
            } 
        
            catch (IOException e) 
            {
                e.printStackTrace();
            }

            name++;
        }
        
    }

    public static void nonterminalsPerRule(int probSizeLower, int probSizeUpper, int incr)
    {
        int name = 1;
        String vivekPath = "C:\\Users\\viviv\\Documents\\GitHub\\cs2420-assignments\\packages\\src\\comprehensive\\N_nonterminals\\";
        for (int probSize = probSizeLower; probSize <= probSizeUpper; probSize += incr)
        {
            try 
            {
                FileWriter writer = new FileWriter(vivekPath + name + ".txt", false);
                writer.write("{\n");
                writer.write("<start>\n");
                for (int i = 1; i <= probSize; i++)
                {
                    writer.write("<" + i + ">");
                }
                writer.write("}\n");

                for (int i = 1; i <= probSize; i++)
                {
                    writer.write("{\n");
                    writer.write("<" + i + ">"+"\n");
                    writer.write("" + i + "\n");
                    writer.write("}\n");
                }
                
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