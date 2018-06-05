package day1;

class Elevator {

    private int floor;

    Elevator(String commands) {
        for (int i = 0; i < commands.length(); ++i) {
            if (commands.charAt(i) == '(') {
                floor++;
            } else if (commands.charAt(i) == ')') {
                floor--;
            }
        }
    }

    int floor() {
        return floor;
    }

}
