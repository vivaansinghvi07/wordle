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
        String guess = this.in.nextLine().toLowerCase();

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
        if (this.word.equals(guess)) {
            // TODO: Code win
            return;
        }

    }

    // displays the game
    public String toString() {

        // creates output
        String output = new String();

        // goes through each guess and prints it
        for (String guess : guesses) {
            output += "\n" + this.getColoredWord(guess) + Colors.RESET;
        }

        return output;
    }
    
    // colors a guess according to the word
    public String getColoredWord(String guessIn) {

        // stores the colors
        String[] colors = new String[5];

        // converts guess and word to char arrays 
        char[] word = this.word.toCharArray();
        char[] guess = guessIn.toCharArray();

        // stores the counts of letters in the word
        int[] counts = new int[26];
        for (char c : word) {
            counts[c - 'a']++;
        }

        // checks for matches and makes the color green if so, otherwise if it's contained make it yellow, and if its not in make it white
        for (int i = 0; i < 5; i++) {

            // makes the color green and subtracts the count occurnece
            if (word[i] == guess[i]) {
                colors[i] = Colors.GREEN_BOLD_BRIGHT;
                counts[guess[i] - 'a']--;
            } 
            
            // limits the number of yellows (you cannot have two yellow a's when the original word only has one a)
            else if (counts[guess[i] - 'a'] > 0) {
                colors[i] = Colors.YELLOW_BOLD_BRIGHT;
                counts[guess[i] - 'a']--;
            } 
            
            // otherwise make it blank
            else {
                colors[i] = Colors.RESET;
            }
        }

        // fills output
        String output = new String();
        for (int i = 0; i < 5; i++) {
            output += colors[i] + guess[i];
        }
        return output;

    }
}
