package day5;

import java.util.regex.Pattern;

class NiceConditions {

    private static final Pattern THREE_VOWELS = Pattern.compile("[aeiou].*[aeiou].*[aeiou]");

    private static final Pattern REPEATED_LETTER = Pattern.compile("(\\w)\\1");

    private static final Pattern FORBIDDEN_PARTS = Pattern.compile("ab|cd|pq|xy");

    static boolean isNice(String word) {
        return hasThreeVowels(word) && hasOneRepeatedLetter(word) && !hasForbiddenPart(word);
    }

    static boolean hasThreeVowels(String word) {
        return THREE_VOWELS.matcher(word).find();
    }

    static boolean hasOneRepeatedLetter(String word) {
        return REPEATED_LETTER.matcher(word).find();
    }

    static boolean hasForbiddenPart(String word) {
        return FORBIDDEN_PARTS.matcher(word).find();
    }
}
