import java.util.Scanner;
import java.util.Random;
public class numberGuessGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int answer = r.nextInt(100) + 1;
        double guess;

        do {
            System.out.println("Guess the number from (0-100): ");
            guess = s.nextDouble();
            if (guess > answer)
                System.out.println("Guess is too high, try again!");
            else if (guess < answer)
                System.out.println("Guess is too low, try again!");

            else {
                System.out.println("You got it!");
            }
        } while (guess != answer);

    }
}
