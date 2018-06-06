package day5;

import common.PuzzleInput;

public class Solution {

    public static void main(String... args) {
        var niceCount = PuzzleInput.read("/day5.txt").stream()
                .filter(NiceConditions::isNice)
                .count();
        System.out.println(niceCount + " strings are nice");

        var superNiceCount = PuzzleInput.read("/day5.txt").stream()
                .filter(ReallyNiceConditions::isNice)
                .count();
        System.out.println(superNiceCount + " strings are really nice");
    }

}
