import java.util.*;

public class Game {

    // stores the word
    private String word;

    // stores all the possible words (dictionary)
    private boolean[] dict;

    // stores the words which have been guessed
    private ArrayList<String> guesses;

    // stores an input source
    private Input in;

    // constructor
    public Game(String[] words, Input in) {
        // assigns a random word to be the word that is played with
        this.word = words[(int) (Math.random() * words.length)];

        // loads the dictionary with words
        this.dict = new boolean[wordToInt("zzzzz") + 1];
        for (String word : words) {
            this.dict[wordToInt(word)] = true;
        }

        // creates the arraylist for guesses
        this.guesses = new ArrayList<String>();

        // assigns the input
        this.in = in;
    }

    // ASSUMES WORDS ARE 5 CHARACTERS LONG - returns a unique integer for each word
    public static int wordToInt(String word) {
        // creates an array of characters
        char[] characters = word.toLowerCase().toCharArray();

        // creates the integer which will be returned
        int sum = 0;

        // creates a unique integer for the word
        for (int i = 0; i < 5; i++) {
            sum += (characters[i] - 'a') * Math.pow(26, 4 - i); // creates a base 26 number with the most weight given to the first character
        }

        // returns the integer
        return sum;
    }

    // gets the guess from the player
    public void getGuess() {

        // gets the guess
        String guess = this.in.nextLine();

        // returns if the length is not 5
        if (guess.length() != 5) {
            // TODO: Make it print something
            return;
        }

        // checks if the guess is a valid one
        if (this.dict[wordToInt((guess))] == false) {
            // TODO: Make it print something
            return;
        }

        // adds to the guesses
        this.guesses.add(guess);

        // checks for a win
        if (this.word.toLowerCase().equals(guess.toLowerCase())) {
            // TODO: Code win
            return;
        }

    }
}
