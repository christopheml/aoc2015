package day3;

class RobotDelivery {

    private Locations regularSantaLocations = new Locations();

    private Locations robotSantaLocations = new Locations();

    RobotDelivery(String instructions) {
        for (int i = 0; i < instructions.length(); i += 2) {
            regularSantaLocations.moveTo(instructions.charAt(i));
            robotSantaLocations.moveTo(instructions.charAt(i + 1));
        }
    }

    int houseCount() {
        Locations commonLocations = regularSantaLocations.mergeWith(robotSantaLocations);
        return commonLocations.count();
    }

}
