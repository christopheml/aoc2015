package day7;

import day7.gate.Gate;
import java.util.HashSet;
import java.util.Set;

class Circuit {

    private final Set<Gate> gates = new HashSet<>();

    private Wires wires = new Wires();

    void addGate(Gate gate) {
        gates.add(gate);
    }

    void addWire(String wireName, Short value) {
        wires.write(wireName, value);
    }

    Wires simulate() {
        HashSet<Gate> unsimulatedGates = new HashSet<>(this.gates);
        do {
            unsimulatedGates.removeIf(gate -> gate.update(wires));
        } while (!unsimulatedGates.isEmpty());
        return wires;
    }

    Wires simulate(Wires provided) {
        wires = provided;
        return simulate();
    }

}
