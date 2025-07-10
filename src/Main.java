import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int die1, die2, sum, point = 0;
        String continueYN = "";

        do {
            die1 = rand.nextInt(6) + 1;
            die2 = rand.nextInt(6) + 1;
            sum = die1 + die2;

            System.out.printf("\nYou rolled: %d + %d = %d\n", die1, die2, sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out and lost");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win");
            } else {
                point = sum;
                System.out.println("Point is set to " + point + ". Try to make your point before rolling a 7");
                boolean pointPhase = true;
                while (pointPhase) {
                    die1 = rand.nextInt(6) + 1;
                    die2 = rand.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.printf("You rolled: %d + %d = %d\n", die1, die2, sum);
                    if (sum == point) {
                        System.out.println("You made your point. You win!");
                        pointPhase = false;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7. You lose");
                        pointPhase = false;
                    } else {
                        System.out.println("Keep rolling...");
                    }
                }
            }
            do {
                System.out.print("Play again? [Y/N]: ");
                continueYN = in.nextLine();
                if (!continueYN.equalsIgnoreCase("Y") && !continueYN.equalsIgnoreCase("N")) {
                    System.out.println("Please enter Y or N.");
                }
            } while (!continueYN.equalsIgnoreCase("Y") && !continueYN.equalsIgnoreCase("N"));

        } while (continueYN.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing Craps!");
    }
}