public class Game {
    private final Board board = new Board();
    private final Player p1;
    private final Player p2;

    public Game(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    public void play() {
        Player current = p1;
        while (true) {
            board.print();
            int[] move = current.chooseMove(board);
            board.place(move[0], move[1], current.mark());
            if (board.winner() != Mark.EMPTY) {
                board.print();
                System.out.println("Winner: " + current.name());
                current.addWin();
                printScoreboard();
                break;
            }
            if (board.isFull()) {
                board.print();
                System.out.println("Draw!");
                printScoreboard();
                break;
            }
            current = (current == p1) ? p2 : p1;

        }
    }
        private void printScoreboard() {
            System.out.println("\n=== Scoreboard ===");
            System.out.printf("%s (%s): %d%n", p1.name(), p1.mark(), p1.score());
            System.out.printf("%s (%s): %d%n", p2.name(), p2.mark(), p2.score());
            System.out.println("==================\n");
    }
}

