package day13;

import java.util.List;

class Table {

    private final List<Guest> guests;

    private final int size;

    Table(List<Guest> guests) {
        this.guests = guests;
        size = guests.size();
    }

    int totalHappiness() {
        int happiness = 0;
        for (int i = 0; i < size; i++) {
            happiness += guests.get(i).happinessIfNextTo(guests.get(index(i - 1)));
            happiness += guests.get(i).happinessIfNextTo(guests.get(index(i + 1)));
        }
        return happiness;
    }

    private int index(int index) {
        return (index + size) % size;
    }

}
