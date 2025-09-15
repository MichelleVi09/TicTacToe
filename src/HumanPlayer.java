import java.util.Scanner;
public class HumanPlayer extends Player {
    private final Scanner in;

    public HumanPlayer(String name, Mark mark, Scanner in) {
        super(name, mark);
        this.in = in;
    }

    @Override
    public int[] chooseMove(Board board) {
        while (true) {
            System.out.printf("%s (%s), enter row and col [1-3 1-3] or 'exit': ", name, mark);

            //checks input for break case
            String input = in.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println(name + " chose to exit the game.");
                System.exit(0); // end program
            }
            int r, c;
            try {
                r = Integer.parseInt(input) - 1;  // convert first input
                c = in.nextInt() - 1;
                if (board.isEmpty(r, c)) return new int[]{r, c};
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid input or enter 'exit' to leave.");
                in.nextLine();
                continue;
            }

            if (board.isEmpty(r, c)) return new int[]{r, c};
            System.out.println("Invalid move, try again.");
        }
    }
}