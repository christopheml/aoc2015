package day12;

import java.util.regex.Pattern;

class NumberExtractor {

    private static final Pattern NUMBERS = Pattern.compile("(-?\\d+)");

    long sumOfAllNumbers(String input) {
        var matcher = NUMBERS.matcher(input);
        long sum = 0;
        while(matcher.find()) {
            sum += Long.parseLong(matcher.group(1));
        }
        return sum;
    }

}
