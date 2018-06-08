package day7.gate;

public class OrGate extends BinaryGate {

    public OrGate(String inputWire1, String inputWire2, String outputWire) {
        super((a, b) -> (short) (a | b), inputWire1, inputWire2, outputWire);
    }

}
