package day14;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

class NamedReindeerTest {

    @Test
    void acceptance_test() {
        var race = new Race(
                new NamedReindeer("Comet", 14, 10, 127),
                new NamedReindeer("Dancer", 16, 11, 162)

        );
        race.runFor(1000);
        assertThat(race.getRankings()).extracting(rank -> rank.getReindeer().getName(), Race.Rank::getPoints)
                .containsExactly(tuple("Dancer", 688), tuple("Comet", 312));
    }

}