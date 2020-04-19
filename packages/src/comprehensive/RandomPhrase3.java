package comprehensive;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomPhrase3 {
    private HashMap<String, Integer[]> map;
    private ArrayList<String> grammar;
    
    int leftBracketIndex;
    int rightBracketIndex;

    Random rng = new Random();

    public RandomPhrase3(File file) {
        GrammarReader3 grammarReader = new GrammarReader3(file);

        this.map = grammarReader.getMap();
        this.grammar = grammarReader.getGrammar();
    }

    public String print() {
        return print("<start>");
    }

    private String print(String nonTerminal) {
    	StringBuilder rule = new StringBuilder(grammar.get(map.get(nonTerminal)[0] + rng.nextInt(map.get(nonTerminal)[1])));

        leftBracketIndex = rule.indexOf("<");

        while (leftBracketIndex != -1) {
            rightBracketIndex = rule.indexOf(">");

            rule.replace(leftBracketIndex, rightBracketIndex + 1, print(rule.substring(leftBracketIndex, rightBracketIndex + 1)));

            leftBracketIndex = rule.indexOf("<");
        }

        return rule.toString();
    }
}
