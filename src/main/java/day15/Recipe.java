package day15;

import static java.lang.Math.max;

public class Recipe {

    public static int highScore() {
        int highScore = 0;
        for (int sprinkleAmount = 0; sprinkleAmount <= 100; ++sprinkleAmount) {
            for (int butterscotchAmount = 0; sprinkleAmount + butterscotchAmount <= 100; ++butterscotchAmount) {
                for (int chocolateAmount = 0; sprinkleAmount + butterscotchAmount + chocolateAmount <= 100; ++chocolateAmount) {
                    for (int candyAmount = 0; sprinkleAmount + butterscotchAmount + chocolateAmount + candyAmount <= 100; ++candyAmount) {
                        int score = score(sprinkleAmount, butterscotchAmount, chocolateAmount, candyAmount);
                        if (score > highScore) {
                            highScore = score;
                        }
                    }
                }
            }
        }
        return highScore;
    }

    public static int score(int sprinkleAmount, int butterscotchAmount, int chocolateAmount, int candyAmount) {
        int capacity =
                Ingredient.SPRINKLES.getCapacity(sprinkleAmount) +
                Ingredient.BUTTERSCOTCH.getCapacity(butterscotchAmount) +
                Ingredient.CHOCOLATE.getCapacity(chocolateAmount) +
                Ingredient.CANDY.getCapacity(candyAmount);

        int durability =
                Ingredient.SPRINKLES.getDurability(sprinkleAmount) +
                        Ingredient.BUTTERSCOTCH.getDurability(butterscotchAmount) +
                        Ingredient.CHOCOLATE.getDurability(chocolateAmount) +
                        Ingredient.CANDY.getDurability(candyAmount);

        int flavor =
                Ingredient.SPRINKLES.getFlavor(sprinkleAmount) +
                        Ingredient.BUTTERSCOTCH.getFlavor(butterscotchAmount) +
                        Ingredient.CHOCOLATE.getFlavor(chocolateAmount) +
                        Ingredient.CANDY.getFlavor(candyAmount);

        int texture =
                Ingredient.SPRINKLES.getTexture(sprinkleAmount) +
                        Ingredient.BUTTERSCOTCH.getTexture(butterscotchAmount) +
                        Ingredient.CHOCOLATE.getTexture(chocolateAmount) +
                        Ingredient.CANDY.getTexture(candyAmount);

        return max(0, capacity) * max(0, durability) * max(0, flavor) * max(0, texture);
    }

}
