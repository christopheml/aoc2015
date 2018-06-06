package day4;

public class Solution {

    public static void main(String... args) {
        part1();
        part2();
    }

    private static void part1() {
        AdventCoinMiner miner = new AdventCoinMiner(AdventCoinMiner.FIVE_LEADING_ZEROES);
        int result = miner.compute("bgvyzdsv");
        System.out.println("Number for bgvyzdsv (five leading zeroes) is " + result);
    }

    private static void part2() {
        AdventCoinMiner miner = new AdventCoinMiner(AdventCoinMiner.SIX_LEADING_ZEROES);
        int result = miner.compute("bgvyzdsv");
        System.out.println("Number for bgvyzdsv (six leading zeroes) is " + result);
    }

}
