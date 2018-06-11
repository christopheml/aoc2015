package day11;

class PasswordValidator {

    static boolean isValid(char[] password) {
        return containsNoAmbiguousCharacter(password);
    }

    private static boolean containsNoAmbiguousCharacter(char[] password) {
        for (char c : password) {
            if (c == 'l' || c == 'i' || c == 'o') {
                return false;
            }
        }
        return true;
    }

}
