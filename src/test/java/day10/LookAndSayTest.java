package day10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LookAndSayTest {

    @DisplayName("Day 10 part 1 acceptance test")
    @ParameterizedTest(name = "{0} becomes {1}")
    @CsvSource({
            "1, 11",
            "11, 21",
            "113, 2113",
            "1111222331, 41322311"
    })
    void acceptance_test(String input, String expectedOutput) {
        assertThat(LookAndSay.process(input)).isEqualTo(expectedOutput);
    }

}
