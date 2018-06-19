package day18;

public class WorkingLights implements GridInvariant {

    @Override
    public int apply(int x, int y, int[][] grid) {
        return grid[x][y];
    }

}
