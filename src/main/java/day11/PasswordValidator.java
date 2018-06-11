package day11;

class PasswordValidator {

    private PasswordValidator() {
    }

    static boolean isValid(char[] password) {
        return noAmbiguousCharacter(password) && twoOverlappingPairs(password) && oneStraight(password);
    }

    private static boolean noAmbiguousCharacter(char[] password) {
        for (char c : password) {
            if (c == 'l' || c == 'i' || c == 'o') {
                return false;
            }
        }
        return true;
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

    private static boolean oneStraight(char[] password) {
        for (int i = 0; i < password.length - 2; i++) {
            if (hasAscendingStraightAt(password, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasAscendingStraightAt(char[] password, int position) {
        return password[position] + 1 == password[position + 1]
                && password[position] + 2 == password[position + 2];
    }

}
