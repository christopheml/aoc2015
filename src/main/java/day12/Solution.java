package day12;

import common.PuzzleInput;

class Solution {

    public static void main(String... args) {
        var input = PuzzleInput.read("/day12.txt").toString();
        var numberExtractor = new NumberExtractor();
        System.out.println("Sum of all numbers is " + numberExtractor.sumOfAllNumbers(input));
        System.out.println("Sum of all numbers excluding red is " + numberExtractor.sumOfAllNumbersExcludingRed(input));
    }

}
