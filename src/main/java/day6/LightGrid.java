package day6;

import java.util.function.Function;

public abstract class LightGrid {

    private final int[][] lights;

    LightGrid(int width, int height) {
        lights = new int[width][height];
    }

    final void on(int startX, int startY, int endX, int endY) {
        walk(startX, startY, endX, endY, onFunction());
    }

    final void off(int startX, int startY, int endX, int endY) {
        walk(startX, startY, endX, endY, offFunction());
    }

    final void toggle(int startX, int startY, int endX, int endY) {
        walk(startX, startY, endX, endY, toggleFunction());
    }

    protected abstract Function<Integer, Integer> onFunction();

    protected abstract Function<Integer, Integer> offFunction();

    protected abstract Function<Integer, Integer> toggleFunction();

    private void walk(int startX, int startY, int endX, int endY, Function<Integer, Integer> operation) {
        for (int x = startX; x <= endX; ++x) {
            for (int y = startY; y <= endY; ++y) {
                lights[x][y] = operation.apply(lights[x][y]);
            }
        }
    }

    final int litCount() {
        int count = 0;
        for (int[] rows : lights) {
            for (int light : rows) {
                count += light;
            }
        }
        return count;
    }
}
