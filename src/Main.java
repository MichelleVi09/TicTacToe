import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Choose one of the following:");
            System.out.println("1. Player vs. Player");
            System.out.println("2. Player vs. AI");
            System.out.print("Enter 1 or 2 (or type anything else to default to AI): ");

            // Read as String first
            String token = in.next().trim();
            int choice;
            try {
                choice = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                choice = 3;
            }

            Player p1;
            Player p2;

            switch (choice) {
                case 1 -> {
                    p1 = new HumanPlayer("Player 1", Mark.x, in);
                    p2 = new HumanPlayer("Player 2", Mark.o, in);
                }
                case 2 -> {
                    p1 = new HumanPlayer("You", Mark.x, in);
                    p2 = new AIPlayer("Computer", Mark.o, new RandomStrategy());
                }
                default -> {
                    System.out.println("Invalid choice, defaulting to Player vs. AI.");
                    p1 = new HumanPlayer("You", Mark.x, in);
                    p2 = new AIPlayer("Computer", Mark.o, new RandomStrategy());
                }
            }

            Game game = new Game(p1, p2);
            game.play();

            System.out.print("Play again? (y/n): ");
            if (!in.next().trim().equalsIgnoreCase("y")) {
                System.out.println("Thanks for playing!");
                break;
            }
            System.out.println();
        }
    }
}
