package day6;

import java.util.function.Function;

class BasicLightGrid extends LightGrid {

    BasicLightGrid(int width, int height) {
        super(width, height);
    }

    protected Function<Integer, Integer> onFunction() {
        return state -> 1;
    }

    protected Function<Integer, Integer> offFunction() {
        return state -> 0;
    }

    protected Function<Integer, Integer> toggleFunction() {
        return state -> 1 - state;
    }

}
