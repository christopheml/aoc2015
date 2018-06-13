package day14;

class AnonymousReindeer {

    final int speed;
    final int effortDuration;
    final int pauseDuration;

    AnonymousReindeer(int speed, int effortDuration, int pauseDuration) {
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
