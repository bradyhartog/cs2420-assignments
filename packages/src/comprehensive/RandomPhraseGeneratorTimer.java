package comprehensive;

/**
 * Timing
 * DO NOT SUBMIT
 * 
 * This is going to be painful, we have to generate grammar files of increasing nonterminals or rules or nonterminals per rule,
 * or  increases number of phrases generated
 */
public class RandomPhraseGeneratorTimer
{
    public static void main (String[] args)
    {
       GrammarGenerator.rulesPerNonterminal(1, 20, 1);
    }

}
