package day14;

import common.PuzzleInput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    private static final Pattern REINDEER_PROPERTIES  = Pattern.compile("^\\D*(\\d+)\\D*(\\d+)\\D*(\\d+)\\D*$");

    public static void main(String... args) {
        int maximumDistance = PuzzleInput.read("/day14.txt").stream()
                .map(Solution::toReindeer)
                .mapToInt(reindeer -> reindeer.simulate(2503))
                .max()
                .orElseThrow();

        System.out.println("Winner traveled for " + maximumDistance + " kilometers");

    }

    private static Reindeer toReindeer(String description) {
        Matcher matcher = REINDEER_PROPERTIES.matcher(description);
        if (matcher.matches()) {
            int speed = Integer.parseInt(matcher.group(1));
            int effortDuration = Integer.parseInt(matcher.group(2));
            int pauseDuration = Integer.parseInt(matcher.group(3));
            return new Reindeer(speed, effortDuration, pauseDuration);
        }
        throw new IllegalArgumentException(description);
    }

}
