package day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AdventCoinMinerTest {

    @DisplayName("Day 4 part 1 acceptance test")
    @ParameterizedTest(name = "Number for {0} is {1}")
    @CsvSource({
            "abcdef, 609043",
            "pqrstuv, 1048970"
    })
    void part1_acceptance_test(String secretKey, int expectedNumber) {
        AdventCoinMiner miner = new AdventCoinMiner(AdventCoinMiner.FIVE_LEADING_ZEROES);
        assertThat(miner.compute(secretKey)).isEqualTo(expectedNumber);
    }

}
