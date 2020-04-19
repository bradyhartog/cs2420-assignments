package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GrammarReader {
    HashMap<String, Integer[]> map;
    ArrayList<String> grammar;
    
    int loc;
    int size;

    public GrammarReader(File file) {
        this.map = new HashMap<>();
        this.grammar = new ArrayList<>();
        this.grammar = readFromFile(file);
    }

    public ArrayList<String> getGrammar() {
        return this.grammar;
    }

    public HashMap<String, Integer[]> getMap() {
        return this.map;
    }

    private ArrayList<String> readFromFile(File file) {
        try {
            Scanner fileInput = new Scanner(file);

            loc = 0;

            while (fileInput.hasNextLine()) {
                String s = fileInput.nextLine();

                if (s.equals("{")) {
                    String nonTerminal = fileInput.nextLine();

                    s = fileInput.nextLine();

                    size = 0;

                    while (!s.equals("}")) {
                        grammar.add(s);

                        loc++;
                        size++;

                        s = fileInput.nextLine();
                    }

                    this.map.put(nonTerminal, new Integer[] {loc - size, size});
                }
            }

            fileInput.close();
        }

        catch (FileNotFoundException e) {}

        return grammar;
    }
}