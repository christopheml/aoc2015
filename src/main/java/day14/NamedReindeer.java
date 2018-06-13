package day14;

public class NamedReindeer extends AnonymousReindeer {

    private final String name;
    private boolean flying;
    private int currentSequenceDuration;

    NamedReindeer(String name, int speed, int effortDuration, int pauseDuration) {
        super(speed, effortDuration, pauseDuration);
        this.name = name;
        flying = true;
        currentSequenceDuration = effortDuration;
    }

    int tick() {
        if (currentSequenceDuration == 0) {
            flying = !flying;
            currentSequenceDuration = flying ? effortDuration : pauseDuration;
        }
        currentSequenceDuration--;
        return flying ? speed : 0;
    }

    public String getName() {
        return name;
    }
}
