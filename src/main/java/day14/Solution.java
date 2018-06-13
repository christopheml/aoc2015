package day14;

import common.PuzzleInput;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

    private static final Pattern REINDEER_PROPERTIES  = Pattern.compile("^(\\w+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds\\.$");

    public static void main(String... args) {
        int maximumDistance = PuzzleInput.read("/day14.txt").stream()
                .map(Solution::toReindeer)
                .mapToInt(reindeer -> reindeer.simulate(2503))
                .max()
                .orElseThrow();

        System.out.println("Winner traveled for " + maximumDistance + " kilometers");

        List<NamedReindeer> reindeers = PuzzleInput.read("/day14.txt").stream()
                .map(Solution::toNamedReindeer)
                .collect(Collectors.toList());

        var race = new Race(reindeers);
        race.runFor(2503);
        int winnerPoints = race.getRankings().get(0).getPoints();

        System.out.println("Winner got " + winnerPoints + " points");
    }

    private static AnonymousReindeer toReindeer(String description) {
        Matcher matcher = REINDEER_PROPERTIES.matcher(description);
        if (matcher.matches()) {
            int speed = Integer.parseInt(matcher.group(2));
            int effortDuration = Integer.parseInt(matcher.group(3));
            int pauseDuration = Integer.parseInt(matcher.group(4));
            return new AnonymousReindeer(speed, effortDuration, pauseDuration);
        }
        throw new IllegalArgumentException(description);
    }

    private static NamedReindeer toNamedReindeer(String description) {
        Matcher matcher = REINDEER_PROPERTIES.matcher(description);
        if (matcher.matches()) {
            String name = matcher.group(1);
            int speed = Integer.parseInt(matcher.group(2));
            int effortDuration = Integer.parseInt(matcher.group(3));
            int pauseDuration = Integer.parseInt(matcher.group(4));
            return new NamedReindeer(name, speed, effortDuration, pauseDuration);
        }
        throw new IllegalArgumentException(description);
    }

}
