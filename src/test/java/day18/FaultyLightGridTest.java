package day18;

import java.util.List;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class FaultyLightGridTest {

    @Test
    void acceptance_test() {
        List<String> initialState = asList("##.#.#",
                                      "...##.",
                                      "#....#",
                                      "..#...",
                                      "#.#..#",
                                      "####.#");

        LightGrid grid = new LightGrid(6, initialState, new FaultyCorners());
        for (int step = 0; step < 5; step++) {
            grid = grid.update();
        }

        assertThat(grid.countLightsOn()).isEqualTo(17);
    }

}
