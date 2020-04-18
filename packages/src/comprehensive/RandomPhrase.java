package comprehensive;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomPhrase {
    private HashMap<String, Integer[]> map;
    private ArrayList<String> grammar;

    Random rng = new Random();

    public RandomPhrase(File file) {
        GrammarReader grammarReader = new GrammarReader(file);

        this.map = grammarReader.getMap();
        this.grammar = grammarReader.getGrammar();
    }

    public String print() {
        return print("<start>");
    }

    private String print(String nonTerminal) {
        int loc = map.get(nonTerminal)[0];
        int size = map.get(nonTerminal)[1];

        StringBuilder rule = new StringBuilder(grammar.get(loc + rng.nextInt(size)));

        int leftBracketIndex = rule.indexOf("<");

        while (leftBracketIndex != -1) {
            int rightBracketIndex = rule.indexOf(">");

            rule.replace(leftBracketIndex, rightBracketIndex + 1, print(rule.substring(leftBracketIndex, rightBracketIndex + 1)));

            leftBracketIndex = rule.indexOf("<");
        }

        return rule.toString();
    }
}
