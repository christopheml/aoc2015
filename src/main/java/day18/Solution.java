package day18;

import common.PuzzleInput;

class Solution {

    public static void main(String... args) {
        LightGrid grid = new LightGrid(100, PuzzleInput.read("/day18.txt").lines());
        for (int step = 0; step < 100; step++) {
            grid = grid.update();
        }
        System.out.println(grid.countLightsOn() + " lights are still on after 100 steps");
    }

}
