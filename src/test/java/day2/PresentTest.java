package day2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PresentTest {


    @DisplayName("Day 2 part 2 acceptance test")
    @ParameterizedTest(name = "{0} needs {1} square feet of paper")
    @CsvSource({
            "2x3x4, 58",
            "1x1x10, 43",
            "4x3x2, 58",
            "1x10x1, 43"
    })
    void part1_acceptance_test(String dimensions, int expectedPaperSize) {
        Present present = Present.create(dimensions);
        assertThat(present.paperSize()).isEqualTo(expectedPaperSize);
    }

}