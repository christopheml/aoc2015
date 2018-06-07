package day6;

import java.util.function.Function;

class LightGrid {

    private final boolean[][] lights;

    LightGrid(int width, int height) {
        lights = new boolean[width][height];
    }

    void on(int startX, int startY, int endX, int endY) {
        walk(startX, startY, endX, endY, state -> true);
    }

    void off(int startX, int startY, int endX, int endY) {
        walk(startX, startY, endX, endY, state -> false);
    }

    void toggle(int startX, int startY, int endX, int endY) {
        walk(startX, startY, endX, endY, state -> !state);
    }

    private void walk(int startX, int startY, int endX, int endY, Function<Boolean, Boolean> operation) {
        for (int x = startX; x <= endX; ++x) {
            for (int y = startY; y <= endY; ++y) {
                lights[x][y] = operation.apply(lights[x][y]);
            }
        }
    }

    int litCount() {
        int count = 0;
        for (boolean[] rows : lights) {
            for (boolean light : rows) {
                if (light) {
                    count++;
                }
            }
        }
        return count;
    }

}
