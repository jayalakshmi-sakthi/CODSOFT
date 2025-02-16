import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        int val = random.nextInt(101);
        //System.out.println(val);
        int count = 0;

        for (int i = 0; i < 10; i++) {
            String choice = "yes";
            while (choice.equals("yes")) {
                System.out.print("Guess the Number Between (0 to 100): ");

                int num;
                try {
                    num = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input. Please enter a number.");
                    continue;
                }

                if (num < 0 || num > 100) {
                    System.out.println("Wrong Input. Please enter a number between 0 and 100.");
                    continue;
                }

                if (val > num) {
                    System.out.println("Guess a little Higher!");
                } else if (val < num) {
                    System.out.println("Guess a little Lower!");
                } else {
                    count++;
                    System.out.println("Congratulations! You guessed the correct Number!");
                    System.out.println("Your Score: " + count);
                    System.out.println("Do you want to play again? (Yes/No)");

                    choice = reader.readLine().toLowerCase();
                    while (!choice.equals("yes") && !choice.equals("no")) {
                        System.out.print("Enter the Correct Input (Yes/No): ");
                        choice = reader.readLine().toLowerCase();
                    }

                    if (choice.equals("no")) {
                        System.out.println("Thanks for playing!");
                        return;
                    }

                    val = random.nextInt(101);
                    //System.out.println(val);
                }
            }
        }
    }
}
