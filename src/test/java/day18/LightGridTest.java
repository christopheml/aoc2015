package day18;

import java.util.List;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LightGridTest {

    @Test
    void acceptanceTest() {
        List<String> initialState = asList(".#.#.#",
                                      "...##.",
                                      "#....#",
                                      "..#...",
                                      "#.#..#",
                                      "####..");
        LightGrid grid = new LightGrid(6, initialState);
        for (int i = 0; i < 4; i++) {
            grid = grid.update();
        }

        assertThat(grid.countLightsOn()).isEqualTo(4);
    }

}
