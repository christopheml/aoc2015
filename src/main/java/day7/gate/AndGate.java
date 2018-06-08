package day7.gate;

public class AndGate extends BinaryGate {

    public AndGate(String inputWire1, String inputWire2, String outputWire) {
        super((a, b) -> (short) (a & b), inputWire1, inputWire2, outputWire);
    }

}
