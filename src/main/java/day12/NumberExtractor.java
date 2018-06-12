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

    long sumOfAllNumbersExcludingRed(String input) {
        var withoutRed = excludeRed(input);
        return sumOfAllNumbers(withoutRed);
    }

    private String excludeRed(String input) {
        while (true) {
            int location = input.indexOf(":\"red\"");
            if (location == -1) {
                break;
            }
            int regionStart = findObjectStart(input, location);
            int regionEnd = findObjectEnd(input, regionStart);
            if (regionStart == 0) {
                input = input.substring(regionEnd + 1);
            } else {
                input = input.substring(0, regionStart - 1) + input.substring(regionEnd + 1);
            }
        }
        return input;
    }

    private int findObjectStart(String input, int location) {
        int depth = 0;
        for (int position = location; position >= 0; --position) {
            char current = input.charAt(position);
            if (current == '}') {
                depth++;
            } else if (current == '{') {
                if (depth == 0) {
                    return position;
                }
                depth--;
            }
        }
        throw new IllegalStateException();
    }

    private int findObjectEnd(String input, int regionStart) {
        int depth = 0;
        for (int position = regionStart + 1; position < input.length(); ++position) {
            char current = input.charAt(position);
            if (current == '{') {
                depth++;
            } else if (current == '}') {
                if (depth == 0) {
                    return position;
                }
                depth--;
            }
        }
        throw new IllegalStateException();
    }

}
