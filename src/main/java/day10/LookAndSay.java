package day10;

class LookAndSay {

    private LookAndSay() {
    }

    static String process(String number) {
        char previous;
        char current = 0;
        int repeated = 0;

        var result = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            previous = current;
            current = number.charAt(i);
            if (i > 0 && current != previous) {
                result.append(repeated).append(previous);
                repeated = 1;
            } else {
                repeated++;
            }
        }

        if (repeated > 0) {
            result.append(repeated).append(current);
        }

        return result.toString();
    }

}
