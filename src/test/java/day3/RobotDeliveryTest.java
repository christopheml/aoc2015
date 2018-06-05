package day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RobotDeliveryTest {

    @DisplayName("Day 3 part 2 acceptance test")
    @ParameterizedTest(name = "{0} delivers presents to {1} houses")
    @CsvSource({
            "^>, 3",
            "^>v<, 3",
            "^v^v^v^v^v, 11"
    })
    void part2_acceptance_test(String instructions, int expectedHouseCount) {
        RobotDelivery delivery = new RobotDelivery(instructions);
        assertThat(delivery.houseCount()).isEqualTo(expectedHouseCount);
    }

}