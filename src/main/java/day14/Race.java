package day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

class Race {

    private final List<Rank> rankings;

    Race(NamedReindeer... deers) {
        rankings = Arrays.stream(deers).map(Rank::new).collect(toCollection(ArrayList::new));
    }

    List<Rank> getRankings() {
        rankings.sort(Comparator.comparing(Rank::getPoints).reversed());
        return rankings;
    }

    void runFor(int durationInSeconds) {
        for (int i = 0; i < durationInSeconds; i++) {
            rankings.forEach(Rank::tick);
            rankings.sort(Comparator.comparing(Rank::getDistance).reversed());
            rankings.get(0).awardPoint();
        }
    }

    static class Rank {

        private NamedReindeer reindeer;

        private int points;

        private int distance;

        private Rank(NamedReindeer reindeer) {
            this.reindeer = reindeer;
        }

        void awardPoint() {
            points++;
        }

        void tick() {
            distance += reindeer.tick();
        }

        NamedReindeer getReindeer() {
            return reindeer;
        }

        int getPoints() {
            return points;
        }

        private int getDistance() {
            return distance;
        }

    }

}
