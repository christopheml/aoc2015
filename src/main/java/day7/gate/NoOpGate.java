package day7.gate;

public class NoOpGate extends UnaryGate {

    public NoOpGate(String inputWire, String outputWire) {
        super(value -> value, inputWire, outputWire);
    }

}
