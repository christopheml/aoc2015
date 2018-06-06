package day5;

import java.util.regex.Pattern;

class ReallyNiceConditions {

    private static final Pattern REPEATED_PAIR = Pattern.compile("(\\w{2}).*\\1");

    private static final Pattern ENCLOSING_PAIR = Pattern.compile("(\\w)\\w\\1");

    static boolean hasRepeatedPair(String word) {
        return REPEATED_PAIR.matcher(word).find();
    }

    static boolean hasEnclosingPair(String word) {
        return ENCLOSING_PAIR.matcher(word).find();
    }

    static boolean isNice(String word) {
        return hasRepeatedPair(word) && hasEnclosingPair(word);
    }

}
