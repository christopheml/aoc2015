package day14;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReindeerTest {

    @Test
    void acceptance_test() {
        var comet = new Reindeer(14, 10, 127);
        var dancer = new Reindeer(16, 11, 162);
        var cometDistance = comet.simulate(1000);
        var dancerDistance = dancer.simulate(1000);
        assertThat(cometDistance).isEqualTo(1120);
        assertThat(dancerDistance).isEqualTo(1056);
    }

}
