package day3;

class Delivery {

    private final Locations locations = new Locations();

    Delivery(String instructions) {
        for (int i = 0; i < instructions.length(); i++) {
            locations.moveTo(instructions.charAt(i));
        }
    }

    int houseCount() {
        return locations.count();
    }

}
