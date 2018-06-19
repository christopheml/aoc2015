package day18;

public class FaultyCorners implements GridInvariant {

    @Override
    public int apply(int x, int y, int[][] grid) {
        if (isCorner(x, y, grid)) {
            return 1;
        }
        return grid[x][y];
    }

    private boolean isCorner(int x, int y, int[][] grid) {
        int corner = grid.length - 1;
        return (x == 0 && y ==0) || (x == 0 && y == corner) || (x == corner && y == 0) || (x == corner && y == corner);
    }

}
