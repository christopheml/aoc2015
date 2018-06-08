package day7.gate;

public class NotGate extends UnaryGate {

    public NotGate(String inputWire, String outputWire) {
        super(value -> (short) ~value, inputWire, outputWire);
    }

}
