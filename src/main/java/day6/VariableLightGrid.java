package day6;

import java.util.function.Function;

public class VariableLightGrid extends LightGrid {

    VariableLightGrid(int width, int height) {
        super(width, height);
    }

    @Override
    protected Function<Integer, Integer> onFunction() {
        return brightness -> brightness + 1;
    }

    @Override
    protected Function<Integer, Integer> offFunction() {
        return brightness -> Math.max(brightness - 1, 0);
    }

    @Override
    protected Function<Integer, Integer> toggleFunction() {
        return brightness -> brightness + 2;
    }

}
