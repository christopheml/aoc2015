package day5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ReallyNiceConditionsTest {

    @DisplayName("Presence of a repeated non-overlapping pair")
    @ParameterizedTest(name = "{0} is {1}")
    @CsvSource({
            "xyxy, true",
            "aabcdefgaa, true",
            "aaa, false",
            "abcd, false"
    })
    void repeated_pair(String word, boolean expected) {
        assertThat(ReallyNiceConditions.hasRepeatedPair(word)).isEqualTo(expected);
    }

    @DisplayName("Presence of an enclosing pair")
    @ParameterizedTest(name = "{0} is {1}")
    @CsvSource({
            "xyx, true",
            "abcdefeghi, true",
            "aaa, true",
            "abba, false"
    })
    void one_letter_twice_in_a_row(String word, boolean expected) {
        assertThat(ReallyNiceConditions.hasEnclosingPair(word)).isEqualTo(expected);
    }

    @DisplayName("Day 5 part 2 acceptance test")
    @ParameterizedTest(name = "{0} is nice ? {1}")
    @CsvSource({
            "qjhvhtzxzqqjkmpb, true",
            "xxyxx, true",
            "uurcxstgmygtbstg, false",
            "ieodomkazucvgmuy, false"
    })
    void isNice(String word, boolean isNice) {
        assertThat(ReallyNiceConditions.isNice(word)).isEqualTo(isNice);
    }


}