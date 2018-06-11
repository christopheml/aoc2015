package day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordValidatorTest {

    @ParameterizedTest
    @CsvSource({"aacee, true", "aaiee, false", "aalee, false", "aaoee, false"})
    void should_not_contain_confusing_letters(String password, boolean isValid) {
        assertThat(PasswordValidator.isValid(password.toCharArray())).isEqualTo(isValid);
    }

    @ParameterizedTest
    @CsvSource({"abbceffg, true", "aaabcddd, true", "abbcegjk, false", "abcedfgg, false", "aaabcdef, false"})
    void should_contain_two_non_overlapping_pairs(String password, boolean isValid) {
        assertThat(PasswordValidator.isValid(password.toCharArray())).isEqualTo(isValid);
    }

}
