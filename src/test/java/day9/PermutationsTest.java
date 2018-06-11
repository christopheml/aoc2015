package day9;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

class PermutationsTest {

    @Test
    void singleElement() {
        List<List<String>> permutations = Permutations.compute(new HashSet<>(singletonList("A")));
        assertThat(permutations.get(0)).containsOnly("A");
    }

    @Test
    void twoElements() {
        List<List<String>> permutations = Permutations.compute(new HashSet<>(asList("A", "B")));
        assertThat(permutations).containsExactlyInAnyOrder(asList("A", "B"), asList("B", "A"));
    }

    @Test
    void threeElements() {
        List<List<String>> permutations = Permutations.compute(new HashSet<>(asList("A", "B", "C")));
        assertThat(permutations).containsExactlyInAnyOrder(
                asList("A", "B", "C"),
                asList("A", "C", "B"),
                asList("B", "A", "C"),
                asList("B", "C", "A"),
                asList("C", "A", "B"),
                asList("C", "B", "A")
        );
    }

}