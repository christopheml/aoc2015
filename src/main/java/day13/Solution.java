package day13;

import common.PuzzleInput;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.collections4.iterators.PermutationIterator;

class Solution {

    private static final Pattern ENTRY =
            Pattern.compile("^(\\w+) would (gain|lose) (\\d+) happiness units by sitting next to (\\w+)\\.$");


    public static void main(String... args) {
        List<String> lines = PuzzleInput.read("/day13.txt").lines();

        Map<String, Guest> guests =  lines.stream()
                .map(Solution::extractName)
                .collect(Collectors.toMap(name -> name, Guest::new, (g1, g2) -> g1));

        for (String entry : lines) {
            Matcher matcher = ENTRY.matcher(entry);
            if (matcher.matches()) {
                Guest guest = guests.get(matcher.group(1));
                int sign = "gain".equals(matcher.group(2)) ? 1 : -1;
                int absoluteValue = Integer.parseInt(matcher.group(3));
                Guest other = guests.get(matcher.group(4));
                guest.setHappinessIfNextTo(other, sign * absoluteValue);
            } else {
                throw new IllegalStateException("invalid regexp");
            }
        }

        int maximumHappiness = getMaximumHappiness(guests);
        System.out.println("Maximum happiness is " + maximumHappiness);

        var myself = new Guest("Myself");
        guests.put("Myself", myself);
        guests.values().forEach(guest -> myself.setHappinessIfNextTo(guest, 0));
        guests.values().forEach(guest -> guest.setHappinessIfNextTo(myself, 0));

        int maximumHappinessWithMe = getMaximumHappiness(guests);
        System.out.println("Maximum happiness with me is " + maximumHappinessWithMe);
    }

    private static int getMaximumHappiness(Map<String, Guest> guests) {
        PermutationIterator<Guest> iterator = new PermutationIterator<>(guests.values());
        Stream<List<Guest>> candidates = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), true);
        return candidates.map(Table::new).mapToInt(Table::totalHappiness).max().orElseThrow();
    }

    private static String extractName(String description) {
        return description.substring(0, description.indexOf(' '));
    }

}
