package day7.gate;

import day7.Wires;

public class AssignmentGate implements Gate {

    private final String outputWire;

    private final Short value;

    public AssignmentGate(String outputWire, Short value) {
        this.outputWire = outputWire;
        this.value = value;
    }

    @Override
    public boolean update(Wires wires) {
        if (wires.read(outputWire) == null) {
            wires.write(outputWire, value);
        }
        return true;
    }

}
