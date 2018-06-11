package day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordGeneratorTest {

    @ParameterizedTest
    @CsvSource({"abcdefgh, abcdffaa", "ghijklmn, ghjaabcc"})
    void acceptance_test(String oldPassword, String newPassword) {
        assertThat(PasswordGenerator.generateNext(oldPassword).toString()).isEqualTo(newPassword);
    }

}
