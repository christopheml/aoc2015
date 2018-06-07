package day6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VariableLightGridTest {

    @Test
    void lights_on() {
        VariableLightGrid grid = new VariableLightGrid(10, 10);
        grid.on(0, 0, 0, 0);
        grid.on(0, 0, 0, 0);
        assertThat(grid.litCount()).isEqualTo(2);
    }

    @Test
    void lights_off() {
        VariableLightGrid grid = new VariableLightGrid(10, 10);
        grid.on(0, 0, 0, 0);
        grid.off(0, 0, 0, 0);
        grid.off(0, 0, 0, 0);
        assertThat(grid.litCount()).isEqualTo(0);
    }

    @Test
    void lights_toggle() {
        VariableLightGrid grid = new VariableLightGrid(10, 10);
        grid.toggle(0, 0, 0, 0);
        assertThat(grid.litCount()).isEqualTo(2);
    }

}
