import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Player p1 = null, p2 = null;
        int lastChoice = -1; // 1 = PvP, 2 = PvAI, -1 = none yet

        while (true) {
            System.out.println("Choose one of the following:");
            System.out.println("1. Player vs. Player");
            System.out.println("2. Player vs. AI");
            System.out.print("Enter 1 or 2 (or type anything else to default to AI): ");

            String token = in.next().trim();

            int rawChoice;
            boolean invalid = false;
            try {
                rawChoice = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                rawChoice = -1;
                invalid = true;
            }

            //normalize first; only 1 or 2 are valid; default to 2
            int normalizedChoice = (rawChoice == 1 || rawChoice == 2) ? rawChoice : 2;

            // optional message
            if (invalid || (rawChoice != 1 && rawChoice != 2)) {
                System.out.println("Invalid choice, defaulting to Player vs. AI.");
            }

            //only reset if the normalized mode actually changed
            if (normalizedChoice != lastChoice) {
                if (p1 != null) p1.resetScore();
                if (p2 != null) p2.resetScore();

                switch (normalizedChoice) {
                    case 1 -> {
                        p1 = new HumanPlayer("Player 1", Mark.x, in);
                        p2 = new HumanPlayer("Player 2", Mark.o, in);
                        System.out.println("Switched to PvP. ");
                    }
                    case 2 -> {
                        p1 = new HumanPlayer("You", Mark.x, in);
                        p2 = new AIPlayer("Computer", Mark.o, new RandomStrategy());
                        System.out.println("Switched to PvAI.");
                    }
                }
                lastChoice = normalizedChoice;
            } else {
                // mode unchanged; do NOT reset or recreate players
                if (invalid) {
                    System.out.println("Keeping current mode; scores preserved.");
                }
            }

            // Play one round with current players
            Game game = new Game(p1, p2);
            game.play();

            System.out.print("Play again? (y/n): ");
            if (!in.next().trim().equalsIgnoreCase("y")) {
                System.out.println("\nFinal scores:");
                System.out.println(p1); // uses Player.toString(): name/mark/score
                System.out.println(p2);
                System.out.println("Thanks for playing!");
                break;
            }
            System.out.println();
        }
    }
}
