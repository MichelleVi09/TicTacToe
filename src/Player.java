public abstract class Player {
    protected final String name;
    protected final Mark mark;
    private int score = 0;

    protected Player(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }

    public String name() {
        return name;
    }

    public Mark mark() {
        return mark;
    }

    public int score() {
        return score;
    }

    public void addWin() {
        score++;
    }

    public void resetScore() {
        score = 0;
    }

    public abstract int[] chooseMove(Board board);

    @Override
    public String toString() {
        return "Player{name='" + name + "', mark=" + mark + ", score=" + score + "}";
    }
}
