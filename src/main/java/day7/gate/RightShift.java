package day7.gate;

public class RightShift extends UnaryGate {

    public RightShift(short shiftValue, String inputWire, String outputWire) {
        super(value -> (short) (value >> shiftValue), inputWire, outputWire);
    }

}
