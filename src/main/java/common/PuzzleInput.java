package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PuzzleInput implements AutoCloseable {

    private final BufferedReader reader;

    public static PuzzleInput read(String path) {
        return new PuzzleInput(path);
    }

    private PuzzleInput(String path) {
        reader = new BufferedReader(new InputStreamReader(PuzzleInput.class.getResourceAsStream(path)));
    }

    public Stream<String> stream() {
        return reader.lines();
    }

    public List<String> lines() {
        return reader.lines().collect(Collectors.toList());
    }

    public String toString() {
        return reader.lines().collect(Collectors.joining("\n"));
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }

}
