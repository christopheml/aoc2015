package day14;

class Reindeer {

    private final int speed;
    private final int effortDuration;
    private final int pauseDuration;

    Reindeer(int speed, int effortDuration, int pauseDuration) {
        this.speed = speed;
        this.effortDuration = effortDuration;
        this.pauseDuration = pauseDuration;
    }

    int simulate(int durationInSeconds) {
        int distance = 0;

        while (durationInSeconds > 0) {
            // Flying
            if (durationInSeconds > effortDuration) {
                durationInSeconds -= effortDuration;
                distance += effortDuration * speed;
            } else {
                distance += durationInSeconds * speed;
                return distance;
            }

            // Pausing
            if (durationInSeconds > pauseDuration) {
                durationInSeconds -= pauseDuration;
            } else {
                return distance;
            }
        }

        return distance;
    }

}
