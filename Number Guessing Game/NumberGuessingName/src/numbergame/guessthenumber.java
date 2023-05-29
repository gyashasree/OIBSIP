package numbergame;

import java.util.Random;
import java.util.Scanner;

public class guessthenumber {

    public static void main(String[] args) {
        int min = 1;
        int max = 1000;
        int numofattempts = 10;
        int totalscore = 0;

        Random rand = new Random();
        int numbertoguess = rand.nextInt(max - min + 1) + min;

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= numofattempts; i++) {
            System.out.println("Guess the number (between " + min + " and " + max + "):");
            int guess = scanner.nextInt();

            if (guess == numbertoguess) {
                System.out.println("Congratulations, you guessed the number in " + i + " attempt(s)!");
                int score = numofattempts - i + 1;
                totalscore += score;
                break;
            } else if (guess < numbertoguess) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            }

            if (i == numofattempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + numbertoguess + ".");
            }
        }

        System.out.println("Your total score is " + totalscore + ".");
    }

}

