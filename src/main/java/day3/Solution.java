package day3;

import common.PuzzleInput;

class Solution {

    public static void main(String... args) {
        var instructions = PuzzleInput.read("/day3.txt").toString();

        var delivery = new Delivery(instructions);
        System.out.println(delivery.houseCount() + " houses received at least one present");

        var robotDelivery = new RobotDelivery(instructions);
        System.out.println(robotDelivery.houseCount() + " houses received at least one present next year");
    }

}
