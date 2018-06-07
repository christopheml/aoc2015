package day6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LightGridTest {

    @Test
    void lights_on() {
        LightGrid grid = new LightGrid(10, 10);
        grid.on(0, 0, 9, 9);
        assertThat(grid.litCount()).isEqualTo(100);
    }

    @Test
    void lights_off() {
        LightGrid grid = new LightGrid(10, 10);
        grid.on(0, 0, 9, 9);
        grid.off(1, 0, 9, 9);
        assertThat(grid.litCount()).isEqualTo(10);
    }

    @Test
    void lights_toggle() {
        LightGrid grid = new LightGrid(10, 10);
        grid.on(0, 0, 1, 1);
        grid.toggle(0, 1, 1, 2);
        assertThat(grid.litCount()).isEqualTo(4);
    }

}
