import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    void rowWin_isDetected() {
        Board b = new Board();
        assertTrue(b.place(0,0, Mark.x));
        assertTrue(b.place(0,1, Mark.x));
        assertTrue(b.place(0,2, Mark.x));
        assertEquals(Mark.x, b.winner(), "Top row of x should win");
    }

    @Test
    void columnWin_isDetected() {
        Board b = new Board();
        assertTrue(b.place(0,1, Mark.o));
        assertTrue(b.place(1,1, Mark.o));
        assertTrue(b.place(2,1, Mark.o));
        assertEquals(Mark.o, b.winner(), "Middle column of o should win");
    }

    @Test
    void diagonalWin_isDetected() {
        Board b = new Board();
        assertTrue(b.place(0,0, Mark.x));
        assertTrue(b.place(1,1, Mark.x));
        assertTrue(b.place(2,2, Mark.x));
        assertEquals(Mark.x, b.winner(), "Main diagonal of x should win");
    }

    @Test
    void antiDiagonalWin_isDetected() {
        Board b = new Board();
        assertTrue(b.place(0,2, Mark.o));
        assertTrue(b.place(1,1, Mark.o));
        assertTrue(b.place(2,0, Mark.o));
        assertEquals(Mark.o, b.winner(), "Anti-diagonal of o should win");
    }

    @Test
    void fullBoardDraw_hasNoWinner() {
        Board b = new Board();
        // fill with no three-in-a-row: x o x / x o o / o x x
        assertTrue(b.place(0,0, Mark.x));
        assertTrue(b.place(0,1, Mark.o));
        assertTrue(b.place(0,2, Mark.x));
        assertTrue(b.place(1,0, Mark.x));
        assertTrue(b.place(1,1, Mark.o));
        assertTrue(b.place(1,2, Mark.o));
        assertTrue(b.place(2,0, Mark.o));
        assertTrue(b.place(2,1, Mark.x));
        assertTrue(b.place(2,2, Mark.x));

        assertTrue(b.isFull(), "Board should be full");
        assertEquals(Mark.EMPTY, b.winner(), "Full board with no line should be no winner");
    }
}
