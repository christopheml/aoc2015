package day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordValidatorTest {

    @ParameterizedTest
    @CsvSource({"aabcdeff, true", "aabciee, false", "aabclee, false", "aabcoee, false"})
    void should_not_contain_confusing_letters(String password, boolean isValid) {
        assertThat(PasswordValidator.isValid(password.toCharArray())).isEqualTo(isValid);
    }

    @ParameterizedTest
    @CsvSource({"aabcdeff, true", "aaabcddd, true", "abbcdgjk, false", "abcedfgg, false", "aaabcdef, false"})
    void should_contain_two_non_overlapping_pairs(String password, boolean isValid) {
        assertThat(PasswordValidator.isValid(password.toCharArray())).isEqualTo(isValid);
    }

    @ParameterizedTest
    @CsvSource({"aabcdeff, true", "aaabcddd, true", "aabbcdef, true", "aabbdegf, false"})
    void should_contain_one_straight(String password, boolean isValid) {
        assertThat(PasswordValidator.isValid(password.toCharArray())).isEqualTo(isValid);
    }

}
