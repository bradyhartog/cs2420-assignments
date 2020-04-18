package comprehensive;



import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test multiple grammar files
 * DO NOT SUBMIT
 */
class RandomPhraseGeneratorTester
{

    //Possible tests
        //Multiple start rules
        //Multiple nonterminals w/ no space - abc.g
        //Start has no nonterminals - hello world.g
        //All nonterminals have terminals only - super_simple.g
        //Inaccessible nonterminals - file with unused non terminals
        //Very cyclic grammar - Test overflow
        //TerminalNonterminal - Self explanatory
        //Only a start - hello world.g
        //Only two starts - Two starts and nothing else

    
    
    @BeforeEach
    void setUp () throws Exception
    {
    }

    @Test
    void testGrammar ()
    {
        // File file = new File("/Users/bradyhartog/Library/Mobile Documents/com~apple~CloudDocs/iCloud Drive/Documents/School/University of Utah/04 Spring 2020/CS 2420/Shared Assignments/cs2420-assignments/packages/src/comprehensive/poetic_sentence.g");
    	
    	// GrammarReader g = new GrammarReader(file);
    	
    	// HashMap<String, ArrayList<String[]>> grammar = g.getGrammar();
    	
    	// System.out.println();
    }

    @Test
    void testRandomPhrase ()
    {
        File file = new File("C:\\Users\\viviv\\Documents\\GitHub\\cs2420-assignments\\packages\\src\\comprehensive\\super_simple.g");
    	
    	GrammarReader g = new GrammarReader(file);
    	
    	//HashMap<String, ArrayList<String>> grammar = g.getGrammar();
    	
        //RandomPhrase generator = new RandomPhrase(grammar);
        
        //String phrase = generator.print();
        
    }

    

}
