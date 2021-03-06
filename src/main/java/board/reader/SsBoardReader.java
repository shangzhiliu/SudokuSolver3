package board.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SsBoardReader implements BoardReader {
    public List<List<Integer>> parseBoard(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        return Files.lines(path).filter(value -> !value.equals("-----------")).map(s -> s.chars().filter(value -> value != '|').mapToObj(value -> {
            if (value == '.') {
                return null;
            } else {
                return Character.getNumericValue(value);
            }
        }).collect(Collectors.toList())).collect(Collectors.toList());
    }
}
