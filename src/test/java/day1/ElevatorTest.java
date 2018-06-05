package day1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ElevatorTest {

    @DisplayName("Elevator acceptance test")
    @ParameterizedTest(name = "{0} is floor {1}")
    @CsvSource({
            "(()), 0",
            "()(), 0",
            "(((, 3",
            "(()(()(, 3",
            "))(((((, 3",
            "()), -1",
            "))(, -1",
            "))), -3",
            ")())()), -3"
    })
    void acceptance_test(String input, int expectedFloor) {
        Elevator elevator = new Elevator(input);
        assertThat(elevator.floor()).isEqualTo(expectedFloor);
    }

}