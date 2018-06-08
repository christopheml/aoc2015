package day7.gate;

public class LeftShiftGate extends UnaryGate {

    public LeftShiftGate(short shiftValue, String inputWire, String outputWire) {
        super(value -> (short) (value << shiftValue), inputWire, outputWire);
    }

}
