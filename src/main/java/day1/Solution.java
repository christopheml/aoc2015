package day1;

import common.PuzzleInput;

public class Solution {

    public static void main(String... args) {
        String input = PuzzleInput.read("/day1.txt").toString();
        Elevator elevator = new Elevator(input);
        System.out.println("Final floor is " + elevator.floor());
    }

}
