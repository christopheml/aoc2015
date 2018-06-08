package day8;

class EscapedString {

    private final String code;

    EscapedString(String code) {
        this.code = code;
    }

    int overhead() {
        return codeLength() - contentLength();
    }

    int codeLength() {
        return code.length();
    }

    int contentLength() {
        int contentLength = 0;
        int skippedCharacters = 0;

        // Ignoring the enclosing quotes that are in first and last position
        for (int i = 1; i < code.length() - 1; i++) {
            if (skippedCharacters > 0) {
                skippedCharacters--;
                continue;
            }
            contentLength++;

            char current = code.charAt(i);
            if (current == '\\') {
                char escaped = code.charAt(i + 1);
                skippedCharacters = escaped == 'x' ? 3 : 1;
            }
        }
        return contentLength;
    }

    int encodedLength() {
        // Initial size is current code size + additional enclosing quotes
        int encodedLength = code.length() + 2;
        for (int i = 0; i < code.length(); i++) {
            char current = code.charAt(i);
            if (current == '\\' || current == '"') {
                encodedLength++;
            }
        }
        return encodedLength;
    }

    int encodedOverhead() {
        return encodedLength() - codeLength();
    }

}
