package day11;

class PasswordValidator {

    static boolean isValid(char[] password) {
        return noAmbiguousCharacter(password) && twoOverlappingPairs(password);
    }

    private static boolean twoOverlappingPairs(char[] password) {
        int firstPair = indexOfOverlappingPair(password, 0);
        if (firstPair > -1) {
            return indexOfOverlappingPair(password, firstPair + 2) > 0;
        }
        return false;
    }

    private static int indexOfOverlappingPair(char[] password, int start) {
        for (int i = start; i < password.length - 1; i++) {
            if (password[i] == password[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private static boolean noAmbiguousCharacter(char[] password) {
        for (char c : password) {
            if (c == 'l' || c == 'i' || c == 'o') {
                return false;
            }
        }
        return true;
    }

}
