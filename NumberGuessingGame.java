import java.util.Scanner;
import java.util.ResourceBundle;

public class NumberGuessingGame {
    // Variables declared here instead of in blocks to make the code simpler
    static Scanner scanner;
    static int numOfAttempts = 0; // Declared on 0 for the first loop
    static int numberToGuess;
    static String playerUsername;

    // Internationalization
    /*
    When it is .printf because it needs variables in the string it is necessary to put \n at the end of
    the string in the .properties file because otherwise it does not make a line break
     */
    static final ResourceBundle i18n = ResourceBundle.getBundle("i18n.translations");

    public static void guessingNumberGame(){
        scanner = new Scanner(System.in);
        System.out.println(i18n.getString("WELCOME"));
        getUsername();
        System.out.printf(i18n.getString("GAMEINFO"), playerUsername);
        getAttempts();
        generateRandomNumber();
        startGame();
    }

    public static void startGame(){
        int guess;
        int attempt;

        for (attempt = 1; attempt <= numOfAttempts; attempt++) {
            System.out.printf(i18n.getString("ASKGUESS"), attempt);
            guess = getNum();
            if (guess == numberToGuess) {
                System.out.printf(i18n.getString("CONGRATS"), playerUsername);
                break;
            } else if (guess > numberToGuess) {
                System.out.printf(i18n.getString("SMALLER"), guess);
            } else {
                System.out.printf(i18n.getString("GREATER"), guess);
            }
        }

        if (attempt == numOfAttempts + 1){
            System.out.printf(i18n.getString("LOSE"), numberToGuess);
        }

    }

    public static void generateRandomNumber(){
        numberToGuess = (int)(Math.random()*100+1);
    }

    public static void getAttempts(){
        while (numOfAttempts < 1) {
            System.out.println(i18n.getString("ASKATTEMPTS"));
            numOfAttempts = getNum();
            if (numOfAttempts == 0) System.out.printf(i18n.getString("TRYONCE"), playerUsername);
            if (numOfAttempts < 0) System.out.println(i18n.getString("NOTNEGATIVES"));
        }
    }

    public static void getUsername(){
        System.out.println(i18n.getString("ASKUSERNAME"));
        playerUsername = scanner.next();
    }

    public static int getNum(){
        try{
            return scanner.nextInt();
        }catch (Exception e){
            System.out.println(i18n.getString("HONESTPLAYERS"));
            System.exit(1);
        }
        return -1; // Let's assume it doesn't get here
    }

    public static void main(String[] args){
        guessingNumberGame();
    }
}