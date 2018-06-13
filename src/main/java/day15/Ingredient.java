package day15;

public enum Ingredient {

    SPRINKLES(2, 0, -2, 0, 3),
    BUTTERSCOTCH(0, 5, -3, 0, 3),
    CHOCOLATE(0, 0, 5, -1, 8),
    CANDY(0, -1, 0, 5, 8);

    private final int capacity;
    private final int durability;
    private final int flavor;
    private final int texture;
    private final int calories;

    Ingredient(int capacity, int durability, int flavor, int texture, int calories) {
        this.capacity = capacity;
        this.durability = durability;
        this.flavor = flavor;
        this.texture = texture;
        this.calories = calories;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getDurability() {
        return durability;
    }

    public int getFlavor() {
        return flavor;
    }

    public int getTexture() {
        return texture;
    }

    public int getCalories() {
        return calories;
    }

}
