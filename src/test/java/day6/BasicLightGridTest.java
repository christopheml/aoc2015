package day6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BasicLightGridTest {

    @Test
    void lights_on() {
        BasicLightGrid grid = new BasicLightGrid(10, 10);
        grid.on(0, 0, 9, 9);
        assertThat(grid.litCount()).isEqualTo(100);
    }

    @Test
    void lights_off() {
        BasicLightGrid grid = new BasicLightGrid(10, 10);
        grid.on(0, 0, 9, 9);
        grid.off(1, 0, 9, 9);
        assertThat(grid.litCount()).isEqualTo(10);
    }

    @Test
    void lights_toggle() {
        BasicLightGrid grid = new BasicLightGrid(10, 10);
        grid.on(0, 0, 1, 1);
        grid.toggle(0, 1, 1, 2);
        assertThat(grid.litCount()).isEqualTo(4);
    }

}
