package day7.gate;

import day7.Wires;
import java.util.function.BiFunction;

public abstract class BinaryGate implements Gate {

    private final BiFunction<Short, Short, Short> calculation;

    private final String inputWire1;

    private final String inputWire2;

    private final String outputWire;

    BinaryGate(BiFunction<Short, Short, Short> calculation, String inputWire1, String inputWire2, String outputWire) {
        this.calculation = calculation;
        this.inputWire1 = inputWire1;
        this.inputWire2 = inputWire2;
        this.outputWire = outputWire;
    }

    @Override
    public boolean update(Wires wires) {
        Short output = wires.read(outputWire);
        if (output != null) {
            return true;
        }

        Short input1 = wires.read(inputWire1);
        Short input2 = wires.read(inputWire2);
        if (input1 != null && input2 != null) {
            wires.write(outputWire, calculation.apply(input1, input2));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + inputWire1 + ", " + inputWire2 + " -> " + outputWire + '}';
    }
}
