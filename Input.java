import java.util.*;

public class Input {
    
    // assigns a Scanner
    private Scanner scan;

    // constructor
    public Input() {
        // creates a new scanner
        scan = new Scanner(System.in);
    }

    // gets the next line
    public String nextLine() {
        return this.scan.nextLine();
    }
}
