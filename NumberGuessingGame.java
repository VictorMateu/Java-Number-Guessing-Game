import java.util.Scanner;

public class NumberGuessingGame {
    // Variables declared here instead of in blocks to make the code simpler
    static Scanner scanner;
    static int numOfAttempts = 0; // Declared on 0 for the first loop
    static int numberToGuess;
    static String playerUsername;

    public static void guessingNumberGame(){
        scanner = new Scanner(System.in);
        System.out.println("Welcome player");
        getUsername();
        System.out.println(playerUsername + ", you have to guess a number between 0 and 100");
        getAttempts();
        generateRandomNumber();
        startGame();
    }

    public static void startGame(){
        int guess;
        int attempt;

        for (attempt = 1; attempt <= numOfAttempts; attempt++) {
            System.out.println("Attempt " + attempt + ", what do you think the number is?");
            guess = getNum();
            if (guess == numberToGuess) {
                System.out.println("Congratulations" + playerUsername + "! You got the number right!");
                break;
            } else if (guess > numberToGuess) {
                System.out.println("The number is smaller than " + guess);
            } else {
                System.out.println("the number is greater than " + guess);
            }
        }

        if (attempt == numOfAttempts + 1){
            System.out.println("Wow... looks like you've run out of tries. the number was " + numberToGuess);
        }

    }

    public static void generateRandomNumber(){
        numberToGuess = (int)(Math.random()*100+1);
    }

    public static void getAttempts(){
        while (numOfAttempts < 1) {
            System.out.println("How many attempts do you want to do?");
            numOfAttempts = getNum();
            if (numOfAttempts == 0) System.out.println("At least try once " + playerUsername + "!");
            if (numOfAttempts < 0) System.out.println("I don't think negative attempts can be made...");
        }
    }

    public static void getUsername(){
        System.out.println("Enter your username for the game: ");
        playerUsername = scanner.next();
    }

    public static int getNum(){
        try{
            return scanner.nextInt();
        }catch (Exception e){
            System.out.println("We want honest players... and who don't play the fool so much!");
            System.exit(1);
        }
        return -1; // Let's assume it doesn't get here
    }

    public static void main(String[] args){
        guessingNumberGame();
    }
}