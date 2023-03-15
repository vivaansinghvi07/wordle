import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // gets a list of all possible wordle words
        String[] words = getWords("wordlewords.txt");

        // creates a game
        Game game = new Game(words);
        
    }

    public static String[] getWords(String filename) throws FileNotFoundException {

        // array for output
        ArrayList<String> words = new ArrayList<String>();

        // creates a scanner for the file
        Scanner wordScanner = new Scanner(new FileInputStream(filename));

        // adds all the words to the scanner
        while (wordScanner.hasNextLine()) {
            words.add(wordScanner.nextLine());
        }   

        // closes scanner
        wordScanner.close();

        // returns output in array form
        String[] output = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            output[i] = words.get(i);
        }
        return output;
    }
}
