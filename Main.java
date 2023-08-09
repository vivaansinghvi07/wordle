import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // gets a list of all possible wordle words
        String[] words = getWords("wordlewords.txt");

        // creates the input object
        Input in = new Input();

        // creates a game
        Game game = new Game(words, in);

        // plays game sequence
        while (true) {
            // displays game and gets move
            Text.clear();
            System.out.println(game);
            game.getGuess();

            // checks for the game being over
            if (game.gameOver != 0) {
                break;
            }
        }

        // winning and losing sequences
        if (game.gameOver == 1) { 
            Text.clear();
            System.out.println(game + "\n\n" + "You won! Thanks for playing!");
        } else {
            Text.clear();
            System.out.println(game);
            System.out.println("\nYou lost! The word was " + Colors.GREEN_BOLD_BRIGHT + game.getWord() + Colors.RESET + ". Thanks for playing!");
        }
        
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
