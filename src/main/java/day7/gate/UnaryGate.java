package day7.gate;

import day7.Wires;
import java.util.function.Function;

public abstract class UnaryGate implements Gate {

    private final Function<Short, Short> calculation;
    private final String inputWire;
    private final String outputWire;

    UnaryGate(Function<Short, Short> calculation, String inputWire, String outputWire) {
        this.calculation = calculation;
        this.inputWire = inputWire;
        this.outputWire = outputWire;
    }

    @Override
    public boolean update(Wires wires) {
        var output = wires.read(outputWire);
        if (output != null) {
            return true;
        }

        var input = wires.read(inputWire);
        if (input != null) {
            wires.write(outputWire, calculation.apply(input));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + inputWire + " -> " + outputWire + '}';
    }

}
