package day18;

import common.PuzzleInput;
import java.util.List;

class Solution {

    public static void main(String... args) {
        List<String> input = PuzzleInput.read("/day18.txt").lines();

        LightGrid grid = new LightGrid(100, input, new WorkingLights());
        LightGrid faultyGrid = new LightGrid(100, input, new FaultyCorners());
        for (int step = 0; step < 100; step++) {
            grid = grid.update();
            faultyGrid = faultyGrid.update();
        }
        System.out.println(grid.countLightsOn() + " lights are still on after 100 steps with normal grid");
        System.out.println(faultyGrid.countLightsOn() + " lights are still on after 100 steps with faulty grid");
    }

}
