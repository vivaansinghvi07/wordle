public class Text {
    
    // clears the console
    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
