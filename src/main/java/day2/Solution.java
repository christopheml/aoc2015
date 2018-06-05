package day2;

import common.PuzzleInput;

public class Solution {

    public static void main(String... args) {
        int totalRequiredPaperAmount = PuzzleInput.read("/day2.txt").stream()
                .map(Present::create)
                .mapToInt(Present::paperSize)
                .sum();
        System.out.println("Elves need to order " + totalRequiredPaperAmount + " square feet of paper");
    }

}
