package day8;

import common.PuzzleInput;

public class Solution {

    public static void main(String... args) {
        int overhead = PuzzleInput.read("/day8.txt").stream()
                .map(EscapedString::new)
                .mapToInt(EscapedString::overhead)
                .sum();
        System.out.println("Total overhead is " + overhead);

        int encodingOverhead = PuzzleInput.read("/day8.txt").stream()
                .map(EscapedString::new)
                .mapToInt(EscapedString::encodedOverhead)
                .sum();
        System.out.println("Total encoding overhead is " + encodingOverhead);
    }

}
