package day7;

import day7.gate.AndGate;
import day7.gate.AssignmentGate;
import day7.gate.LeftShiftGate;
import day7.gate.NoOpGate;
import day7.gate.NotGate;
import day7.gate.OrGate;
import day7.gate.RightShift;
import java.util.Scanner;

class CircuitBuilder {

    private final Circuit circuit;

    CircuitBuilder() {
        circuit = new Circuit();
    }

    void append(String definition) {
        String[] parts = definition.split(" ");

        if (parts[0].equals("NOT")) {
            circuit.addGate(new NotGate(parts[1], parts[3]));
        } else if (parts[1].equals("AND")) {
            circuit.addGate(new AndGate(parts[0], parts[2], parts[4]));
        } else if (parts[1].equals("OR")) {
            circuit.addGate(new OrGate(parts[0], parts[2], parts[4]));
        } else if (parts[1].equals("LSHIFT")) {
            short shiftValue = Short.parseShort(parts[2]);
            circuit.addGate(new LeftShiftGate(shiftValue, parts[0], parts[4]));
        } else if (parts[1].equals("RSHIFT")) {
            short shiftValue = Short.parseShort(parts[2]);
            circuit.addGate(new RightShift(shiftValue, parts[0], parts[4]));
        } else if (parts.length == 3) {
            if (isInteger(parts[0])) {
                Short value = Short.parseShort(parts[0]);
                circuit.addGate(new AssignmentGate(parts[2], value));
            } else {
                circuit.addGate(new NoOpGate(parts[0], parts[2]));
            }
        } else {
            throw new IllegalStateException("Unknown gate " + definition);
        }

    }

    Circuit getCircuit() {
        return circuit;
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
