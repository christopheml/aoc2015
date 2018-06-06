package day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DeliveryTest {

    @DisplayName("Day 3 part 1 acceptance test")
    @ParameterizedTest(name = "{0} delivers presents to {1} houses")
    @CsvSource({
            ">, 2",
            "^>v<, 4",
            "^v^v^v^v^v, 2"
    })
    void part1_acceptance_test(String instructions, int expectedHouseCount) {
        var delivery = new Delivery(instructions);
        assertThat(delivery.houseCount()).isEqualTo(expectedHouseCount);
    }

}