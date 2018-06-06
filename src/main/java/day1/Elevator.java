package day1;

class Elevator {

    private int floor;

    private int firstBasementEntry;

    Elevator(String commands) {
        for (int i = 0; i < commands.length(); ++i) {
            if (commands.charAt(i) == '(') {
                floor++;
            } else if (commands.charAt(i) == ')') {
                floor--;
                if (floor < 0 && firstBasementEntry == 0) {
                    firstBasementEntry = i + 1;
                }
            }
        }
    }

    int floor() {
        return floor;
    }

    public int firstBasementEntry() {
        return firstBasementEntry;
    }

}
