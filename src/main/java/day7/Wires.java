package day7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Wires {

    private final Map<String, Short> wires = new HashMap<>();

    public Short read(String wireName) {
        if (isInteger(wireName)) {
            return Short.valueOf(wireName);
        }
        return wires.get(wireName);
    }

    public void write(String wireName, Short value) {
        wires.put(wireName, value);
    }

    @Override
    public String toString() {
        return "[" + wires.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .map(e -> e.getKey() + ":" + (e.getValue() & 0xffff))
                .collect(Collectors.joining(", ")) + "]";
    }

    Integer readUnsigned(String wireName) {
        var value = read(wireName);
        return value == null ? null : value & 0xffff;
    }

    private static boolean isInteger(String s) {
        try (Scanner sc = new Scanner(s.trim())) {
            if (!sc.hasNextInt(10)) {
                return false;
            }
            sc.nextInt(10);
            return !sc.hasNext();
        }
    }

}
