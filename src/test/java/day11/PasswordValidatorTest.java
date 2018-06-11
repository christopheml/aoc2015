package day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordValidatorTest {

    @ParameterizedTest
    @CsvSource({"ace, true", "aie, false", "ale, false", "aoe, false"})
    void should_not_contain_confusing_letters(String password, boolean isValid) {
        assertThat(PasswordValidator.isValid(password.toCharArray())).isEqualTo(isValid);
    }

}
