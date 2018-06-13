package day15;

public class Solution {

    public static void main(String... args) {
        System.out.println("Total score of highest-scoring cookie is " + Recipe.highScore(false));
        System.out.println("Total score of highest-scoring 500-calories cookie is " + Recipe.highScore(true));
    }

}
