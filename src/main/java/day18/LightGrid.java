package day18;

import java.util.List;

class LightGrid {

    private final int[][] grid;

    private final GridInvariant invariant;

    LightGrid(int size, List<String> lines, GridInvariant invariant) {
        grid = new int[size][size];
        this.invariant = invariant;
        for (int y = 0; y < size; ++y) {
            for (int x = 0; x < size; ++x) {
                grid[x][y] = lines.get(y).charAt(x) == '#' ? 1 : 0;
                grid[x][y] = invariant.apply(x, y, grid);
            }
        }
    }

    private LightGrid(int[][] grid, GridInvariant invariant) {
        this.grid = grid;
        this.invariant = invariant;
    }

    LightGrid update() {
        int[][] updated = new int[grid.length][grid.length];
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid.length; ++x) {
                updated[x][y] = grid[x][y];
                int neighbors = countNeighbors(x, y);
                if (isAlive(x, y) && !(neighbors == 2 || neighbors == 3)) {
                    updated[x][y] = 0;
                } else if (!isAlive(x, y) && neighbors == 3) {
                    updated[x][y] = 1;
                }

                updated[x][y] = invariant.apply(x, y, updated);
            }
        }
        return new LightGrid(updated, invariant);
    }

    private boolean isAlive(int x, int y) {
        return grid[x][y] == 1;
    }

    private int countNeighbors(int x, int y) {
        return peek(x - 1, y - 1) +
                peek(x - 1, y) +
                peek(x - 1, y + 1) +
                peek(x, y - 1) +
                peek(x, y + 1) +
                peek(x + 1, y - 1) +
                peek(x + 1, y) +
                peek(x + 1, y + 1);
    }

    private int peek(int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid.length) {
            return grid[x][y];
        }
        return 0;
    }

    int countLightsOn() {
        int count = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int[] line : grid) {
                count += line[y];
            }
        }
        return count;
    }

}
