package day3;

import common.PuzzleInput;

public class Solution {

    public static void main(String... args) {
        String instructions = PuzzleInput.read("/day3.txt").toString();
        Delivery delivery = new Delivery(instructions);
        System.out.println(delivery.houseCount() + " houses received at least one present");
    }

}
