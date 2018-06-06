package day2;

import common.PuzzleInput;

class Solution {

    private static class Supplies {

        int paperSize;

        int ribbonLength;

        void add(Present present) {
            paperSize += present.paperSize();
            ribbonLength += present.ribbonLength();
        }

        Supplies merge(Supplies other) {
            paperSize += other.paperSize;
            ribbonLength += other.ribbonLength;
            return this;
        }

    }

    public static void main(String... args) {
        var supplies = PuzzleInput.read("/day2.txt").stream()
                .map(Present::create)
                .collect(Supplies::new, Supplies::add, Supplies::merge);
        System.out.println("Elves need to order " + supplies.paperSize + " square feet of paper");
        System.out.println("Elves need to order " + supplies.ribbonLength + " feet of ribbon");
    }

}
