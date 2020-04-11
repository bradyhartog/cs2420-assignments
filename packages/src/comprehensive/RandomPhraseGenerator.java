package comprehensive;

/**
 * Takes user input to generate requisite number of random phrases.
 * Calls RandomPhrase which calls GrammarReader.
 */
public class RandomPhraseGenerator
{
    public static void main (String[] args)
    {
        RandomPhrase generator = new RandomPhrase(Integer.parseInt(args[0]));
    }
}
