package board;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardValidityTests {
    private static final List<Integer> nullList = new ArrayList<>(
            Arrays.asList(null, null, null, null, null, null, null, null, null)
    );

    @Test
    public void testValidBoard() {
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

        assertTrue(board.isValid());
    }

    @Test
    public void testSmallValueConstraint() {
        Board board = new Board(Arrays.asList(
                Arrays.asList(-10, null, null, null, null, null, null, null, null),
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList
        ));

        assertFalse(board.isValid());
    }

    @Test
    public void testLargeValueConstraint() {
        Board board = new Board(Arrays.asList(
                Arrays.asList(10, null, null, null, null, null, null, null, null),
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList
        ));

        assertFalse(board.isValid());
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

        assertTrue(board.isValid());
    }

    @Test
    public void testGridConstraintFailure() {
        Board board = new Board(Arrays.asList(
                Arrays.asList(6, null, null, null, null, 7, null, null, 1),
                Arrays.asList(9, 6, null, null, 8, 4, 5, null, null),
                Arrays.asList(null, 7, 8, null, 5, null, null, 9, null),
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList
        ));

        assertFalse(board.isValid());
    }

    @Test
    public void testRowConstraintFailure() {
        Board board = new Board(Arrays.asList(
                Arrays.asList(1, null, null, null, null, 7, null, null, 1),
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList,
                nullList
        ));

        assertFalse(board.isValid());
    }

    @Test
    public void testColumnConstraintFailure() {
        Board board = new Board(Arrays.asList(
                Arrays.asList(8, null, null, null, null, 7, null, null, 1),
                Arrays.asList(9, 6, null, null, 8, 4, 5, null, null),
                Arrays.asList(null, 7, 8, null, 5, null, null, 9, null),
                Arrays.asList(4, null, null, 5, null, null, 8, null, null),
                Arrays.asList(null, 5, 6, 8, null, 2, 7, 4, null),
                Arrays.asList(null, null, 2, null, null, 9, null, null, 6),
                Arrays.asList(null, 2, null, null, 6, null, 9, 3, null),
                Arrays.asList(null, null, 7, 9, 4, null, null, 1, 5),
                Arrays.asList(8, null, null, 1, null, null, null, null, 7)
        ));

        assertFalse(board.isValid());
    }
}
