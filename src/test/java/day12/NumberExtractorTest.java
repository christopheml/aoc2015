package day12;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class NumberExtractorTest {

    @ParameterizedTest(name = "Sum of {0} is {1}")
    @MethodSource("part1ProvidedTestData")
    void part1AcceptanceTest(String input, long expectedSum) {
        var extractor = new NumberExtractor();
        assertThat(extractor.sumOfAllNumbers(input)).isEqualTo(expectedSum);
    }

    @ParameterizedTest(name = "Sum of {0} is {1}")
    @MethodSource("part2ProvidedTestData")
    void part2Acceptance(String input, long expectedSum) {
        var extractor = new NumberExtractor();
        assertThat(extractor.sumOfAllNumbersExcludingRed(input)).isEqualTo(expectedSum);
    }

    private static Stream<Arguments> part1ProvidedTestData() {
        return Stream.of(
                of("[1,2,3]", 6),
                of("{\"a\":2,\"b\":4}", 6),
                of("[[[3]]]", 3),
                of("{\"a\":{\"b\":4},\"c\":-1}", 3),
                of("{\"a\":[-1,1]}", 0),
                of("[-1,{\"a\":1}]", 0),
                of("[]", 0),
                of("{}", 0)
        );
    }

    private static Stream<Arguments> part2ProvidedTestData() {
        return Stream.of(
                of("[1,2,3]", 6),
                of("[1,{\"c\":\"red\",\"b\":2},3]", 4),
                of("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}", 0),
                of("[1,\"red\",5]", 6)
        );
    }

}