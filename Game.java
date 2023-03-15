public class Game {

    // stores the word
    private String word;

    // stores all the possible words (dictionary)
    public boolean[] dict;

    // constructor
    public Game(String[] words) {
        // assigns a random word to be the word that is played with
        this.word = words[(int) (Math.random() * words.length)];

        // loads the dictionary with words
        this.dict = new boolean[wordToInt("zzzzz") + 1];
        for (String word : words) {
            this.dict[wordToInt(word)] = true;
        }

    }

    // ASSUMES WORDS ARE 5 CHARACTERS LONG - returns a unique integer for each word
    public static int wordToInt(String word) {
        // creates an array of characters
        char[] characters = word.toLowerCase().toCharArray();

        // creates the integer which will be returned
        int sum = 0;

        // creates a unique integer for the word
        for (int i = 0; i < 5; i++) {
            sum += (characters[i] - 'a') * Math.pow(26, i);
        }

        // returns the integer
        return sum;

    }
}
