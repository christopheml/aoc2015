package day7;

import java.util.List;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class CircuitTest {

    private static final List<String> TEST_CIRCUIT =  asList(
            "123 -> x",
            "456 -> y",
            "x AND y -> d",
            "x OR y -> e",
            "x LSHIFT 2 -> f",
            "y RSHIFT 2 -> g",
            "NOT x -> h",
            "NOT y -> i"
    );

    @Test
    void acceptance_test() {
        var builder = new CircuitBuilder();
        for (String definition : TEST_CIRCUIT) {
            builder.append(definition);
        }
        Circuit circuit = builder.getCircuit();
        Wires simulated = circuit.simulate();
        assertThat(simulated.readUnsigned("d")).isEqualTo(72);
        assertThat(simulated.readUnsigned("e")).isEqualTo(507);
        assertThat(simulated.readUnsigned("f")).isEqualTo(492);
        assertThat(simulated.readUnsigned("g")).isEqualTo(114);
        assertThat(simulated.readUnsigned("h")).isEqualTo(65412);
        assertThat(simulated.readUnsigned("i")).isEqualTo(65079);
        assertThat(simulated.readUnsigned("x")).isEqualTo(123);
        assertThat(simulated.readUnsigned("y")).isEqualTo(456);
    }

}