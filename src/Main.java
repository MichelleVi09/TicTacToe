import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Choose one of the following:\n ");
        System.out.print("1. Player vs. Player\n 2. Player vs. AI\n");
        int choice = in.nextInt();
        Player p1;
        Player p2;

        switch (choice){
            case 1 ->{
                p1 = new HumanPlayer("Player 1", Mark.x, in);
                p2 = new HumanPlayer("Player 2", Mark.o, in);
            }
            case 2 ->{
                p1 = new HumanPlayer("You", Mark.x, in);
                p2 = new AIPlayer("Computer", Mark.o, new RandomStrategy());
            }
            default -> {
                System.out.println("Invalid choice, defaulting to Player vs AI.");
                p1 = new HumanPlayer("You", Mark.x, in);
                p2 = new AIPlayer("Computer", Mark.o, new RandomStrategy());
            }

        }

        Game game = new Game(p1, p2);
        do {
            game.play();
            System.out.print("Play again? (y/n): ");
        } while (in.next().trim().equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");
    }

}

