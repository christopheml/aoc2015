package day13;

import java.util.HashMap;
import java.util.Map;

class Guest {

    private final String name;

    private Map<Guest, Integer> happinessValues = new HashMap<>();

    Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    int happinessIfNextTo(Guest other) {
        return happinessValues.get(other);
    }

    void setHappinessIfNextTo(Guest other, int happiness) {
        happinessValues.put(other, happiness);
    }

}
