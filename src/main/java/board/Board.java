package board;

import board.reader.BoardReader;
import board.reader.BoardReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
    private final List<List<Integer>> board;

    public Board(String filePath) throws IOException {
        BoardReader reader = BoardReaderFactory.getReader(filePath);
        this.board = reader.parseBoard(filePath);
    }

    Board(List<List<Integer>> board) {
        this.board = new ArrayList<>();

        for (int i = 0; i < board.size(); i++) {
            this.board.add(new ArrayList<>());
            for (int j = 0; j < board.get(i).size(); j++) {
                this.board.get(i).add(board.get(i).get(j));
            }
        }
    }

    List<List<Integer>> getBoard() {
        return board;
    }

    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for (List<Integer> row : this.board) {
            StringBuilder rowString = new StringBuilder();
            for (Integer item : row) {
                if (item == null) {
                    rowString.append('.');
                } else {
                    rowString.append(item.toString());
                }
            }

            boardString.append(rowString);
            boardString.append("\n");
        }

        return boardString.toString();
    }

    private int getNumBlanks() {
        int blanks = 0;
        for (List<Integer> row : this.board) {
            for (Integer cell : row) {
                if (cell == null) {
                    blanks++;
                }
            }
        }

        return blanks;
    }

    boolean isValid() {
        for (List<Integer> row : board) {
            for (Integer cell : row) {
                if (cell != null && (cell < 1 || cell > 9)) {
                    return false;
                }
            }
        }

        Set<Integer> rowConstraint = new HashSet<>();
        Set<Integer> colConstraint = new HashSet<>();
        for (int i = 0; i < this.board.size(); i++) {
            for (int j = 0; j < this.board.get(i).size(); j++) {
                Integer value = this.board.get(i).get(j);
                if (rowConstraint.contains(value)) {
                    return false;
                }

                if (value != null) {
                    rowConstraint.add(value);
                }

                value = this.board.get(j).get(i);
                if (colConstraint.contains(value)) {
                    return false;
                }

                if (value != null) {
                    colConstraint.add(value);
                }
            }

            rowConstraint.clear();
            colConstraint.clear();
        }

        Set<Integer> gridConstraint = new HashSet<>();
        for (int i = 0; i < this.board.size(); i = i + 3) {
            for (int j = 0; j < this.board.get(i).size(); j = j + 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        Integer value = this.board.get(i + k).get(j + l);
                        if (gridConstraint.contains(value)) {
                            return false;
                        }
                        if (value != null) {
                            gridConstraint.add(value);
                        }
                    }
                }
                gridConstraint.clear();
            }

        }

        return true;
    }

    boolean isSolved() {
        return isValid() && getNumBlanks() == 0;
    }
}
