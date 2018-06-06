package day5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NiceConditionsTest {


    @DisplayName("Presence of three vowels")
    @ParameterizedTest(name = "{0} is {1}")
    @CsvSource({
            "aei, true",
            "xazegov, true",
            "aeiouaeiouaeiou, true",
            "dvszwmarrgswjxmb, false"
    })
    void three_vowels(String word, boolean expected) {
        assertThat(NiceConditions.hasThreeVowels(word)).isEqualTo(expected);
    }

    @DisplayName("Presence of a repeated letter")
    @ParameterizedTest(name = "{0} is {1}")
    @CsvSource({
            "xx, true",
            "abcdde, true",
            "aabbccdd, true",
            "jchzalrnumimnmhp, false"
    })
    void one_letter_twice_in_a_row(String word, boolean expected) {
        assertThat(NiceConditions.hasOneRepeatedLetter(word)).isEqualTo(expected);
    }

    @DisplayName("Presence of a forbidden part")
    @ParameterizedTest(name = "{0} is {1}")
    @CsvSource({
            "aie, false",
            "abcdde, true",
            "aeiouaeiouaeiou, false",
            "haegwjzuvuyypxyu, true"
    })
    void forbidden_parts(String word, boolean expected) {
        assertThat(NiceConditions.hasForbiddenPart(word)).isEqualTo(expected);
    }

    @DisplayName("Part 1 acceptance test")
    @ParameterizedTest(name = "{0} is nice ? {1}")
    @CsvSource({
            "ugknbfddgicrmopn, true",
            "aaa, true",
            "jchzalrnumimnmhp, false",
            "haegwjzuvuyypxyu, false",
            "dvszwmarrgswjxmb, false"
    })
    void isNice(String word, boolean isNice) {
        assertThat(NiceConditions.isNice(word)).isEqualTo(isNice);
    }

}
