import board.Board;

import java.io.IOException;

public class SudokuSolver {
    private Board board;

    private SudokuSolver(String filePath) throws IOException {
        this.board = new Board(filePath);
    }

    public static void main(String [] args) throws IOException {
        SudokuSolver solver = new SudokuSolver("src/test/resources/puzzle.sdk");
        solver = solver.solve();
        System.out.println(solver.board);
    
        SudokuSolver solver2 = new SudokuSolver("src/test/resources/puzzle.ss");
        System.out.println(solver2.board);
    }
    
    public Board solve(Board board){
        if(board.isSolved()){
            return board;
        }
        
        for(Board neighbor: board.getNeighbors()){
            return solve(neighbor);
        }
        
        return null;
    }
}
