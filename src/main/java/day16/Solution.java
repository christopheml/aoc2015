package day16;

import common.PuzzleInput;

public class Solution {

    public static void main(String... args) {
        part1();
        part2();
    }

    private static void part2() {
        Sue realSue = PuzzleInput.read("/day16.txt").stream()
                .map(Sue::parse)
                .filter(sue -> sue.checkAttribute("children", 3))
                .filter(sue -> sue.checkAttribute("cats", 7))
                .filter(sue -> sue.checkAttribute("samoyeds", 2))
                .filter(sue -> sue.checkAttribute("pomeranians", 3))
                .filter(sue -> sue.checkAttribute("akitas", 0))
                .filter(sue -> sue.checkAttribute("vizslas", 0))
                .filter(sue -> sue.checkAttribute("goldfish", 5))
                .filter(sue -> sue.checkAttribute("trees", 3))
                .filter(sue -> sue.checkAttribute("cars", 2))
                .filter(sue -> sue.checkAttribute("perfumes", 1))
                .findFirst()
                .orElseThrow();
        System.out.println("The Sue that really got the gift is " + realSue.getName());
    }

    private static void part1() {
        Sue realSue = PuzzleInput.read("/day16.txt").stream()
                .map(Sue::parse)
                .filter(sue -> sue.hasAttribute("children", 3))
                .filter(sue -> sue.hasAttribute("cats", 7))
                .filter(sue -> sue.hasAttribute("samoyeds", 2))
                .filter(sue -> sue.hasAttribute("pomeranians", 3))
                .filter(sue -> sue.hasAttribute("akitas", 0))
                .filter(sue -> sue.hasAttribute("vizslas", 0))
                .filter(sue -> sue.hasAttribute("goldfish", 5))
                .filter(sue -> sue.hasAttribute("trees", 3))
                .filter(sue -> sue.hasAttribute("cars", 2))
                .filter(sue -> sue.hasAttribute("perfumes", 1))
                .findFirst()
                .orElseThrow();
        System.out.println("The Sue that got the gift is " + realSue.getName());
    }

}
