package board;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardSolvedTests {
    private static final List<Integer> nullList = new ArrayList<>(
            Arrays.asList(null, null, null, null, null, null, null, null, null)
    );

    @Test
    public void testPartialBoard() {
        Board board = new Board(Arrays.asList(
                Arrays.asList(5, null, null, null, null, 7, null, null, 1),
                Arrays.asList(9, 6, null, null, 8, 4, 5, null, null),
                Arrays.asList(null, 7, 8, null, 5, null, null, 9, null),
                Arrays.asList(4, null, null, 5, null, null, 8, null, null),
                Arrays.asList(null, 5, 6, 8, null, 2, 7, 4, null),
                Arrays.asList(null, null, 2, null, null, 9, null, null, 6),
                Arrays.asList(null, 2, null, null, 6, null, 9, 3, null),
                Arrays.asList(null, null, 7, 9, 4, null, null, 1, 5),
                Arrays.asList(8, null, null, 1, null, null, null, null, 7)
        ));

        assertFalse(board.isSolved());
    }

    @Test
    public void testEmptyBoard() {
        Board board = new Board(Arrays.asList(
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList
        ));

        assertFalse(board.isSolved());
    }

    @Test
    public void testValidBoard() {
        Board board = new Board(Arrays.asList(
                Arrays.asList(8, 2, 7, 1, 5, 4, 3, 9, 6),
                Arrays.asList(9, 6, 5, 3, 2, 7, 1, 4, 8),
                Arrays.asList(3, 4, 1, 6, 8, 9, 7, 5, 2),
                Arrays.asList(5, 9, 3, 4, 6, 8, 2, 7, 1),
                Arrays.asList(4, 7, 2, 5, 1, 3, 6, 8, 9),
                Arrays.asList(6, 1, 8, 9, 7, 2, 4, 3, 5),
                Arrays.asList(7, 8, 6, 2, 3, 5, 9, 1, 4),
                Arrays.asList(1, 5, 4, 7, 9, 6, 8, 2, 3),
                Arrays.asList(2, 3, 9, 8, 4, 1, 5, 6, 7)
        ));

        assertTrue(board.isSolved());
    }

    @Test
    public void testinValidBoard() {
        Board board = new Board(Arrays.asList(
                Arrays.asList(8, 2, 7, 1, 5, 4, 3, 9, 6),
                Arrays.asList(9, 6, 5, 3, 2, 7, 1, 4, 8),
                Arrays.asList(3, 4, 1, 6, 8, 9, 7, 5, 2),
                Arrays.asList(5, 9, 3, 4, 6, 8, 2, 7, 1),
                Arrays.asList(4, 7, 2, 5, 1, 3, 6, 8, 9),
                Arrays.asList(6, 1, 8, 9, 7, 2, 4, 3, 5),
                Arrays.asList(7, 8, 6, 2, 3, 5, 9, 1, 4),
                Arrays.asList(1, 5, 4, 7, 9, 6, 8, 2, 3),
                Arrays.asList(2, 3, 9, 8, 4, 1, 5, 6, 9)
        ));

        assertFalse(board.isSolved());
    }
}
