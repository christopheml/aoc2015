package day10;

public class Solution {

    public static void main(String... args) {
        String number = "1321131112";
        for (int i = 0; i < 40; i++) {
            number = LookAndSay.process(number);
        }
        System.out.println("Result after 40 iterations is " + number.length());
    }

}
