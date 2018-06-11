package day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordTest {

    @ParameterizedTest
    @CsvSource({"abcdefgh, abcdefgi", "yzzzzzzz, zaaaaaaa", "zzzzzzzz, aaaaaaaa"})
    void increment(String original, String incremented) {
        var password = new Password(original);
        password.increment();
        assertThat(password.toString()).isEqualTo(incremented);
    }

}
