import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int guess;
            int attempts = 0;
            int maxAttempts = 10;
            int maxScore = 100;
            int score = maxScore; 
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess a number between 1 and 100:");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else if (guess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    break;
                }

                score = maxScore - (attempts * 10);

                if (attempts == maxAttempts) {
                    System.out.println("Sorry! You've reached the maximum attempts. The number was " + randomNumber);
                    score = 0; 
                }
            }

            System.out.println("Your score: " + score);
            System.out.println("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
