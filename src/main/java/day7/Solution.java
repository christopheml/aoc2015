package day7;

import common.PuzzleInput;
import java.util.List;

public class Solution {

    public static void main(String... args) {
        List<String> input = PuzzleInput.read("/day7.txt").lines();
        Circuit circuit = createCircuit(input);
        Wires result1 = circuit.simulate();
        System.out.println("Wire a provides signal " + result1.readUnsigned("a"));

        Wires override = new Wires();
        override.write("b", result1.read("a"));
        Wires result2 = circuit.simulate(override);

        System.out.println("Wire a now provides signal " + result2.readUnsigned("a"));
    }

    private static Circuit createCircuit(List<String> input) {
        var builder = new CircuitBuilder();
        input.forEach(builder::append);
        return builder.getCircuit();
    }

}
