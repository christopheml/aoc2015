package day11;

class Password {

    private static final int CARRY = 'z' + 1;

    private final char[] letters;

    Password(String password) {
        letters = password.toCharArray();
    }

    void increment() {
        int digit = 7;
        boolean carry;
        do {
            carry = false;
            letters[digit]++;
            if (letters[digit] == CARRY) {
                carry = true;
                letters[digit] = 'a';
                digit--;
            }
        } while (carry && digit >= 0);
    }

    @Override
    public String toString() {
        return new String(letters);
    }

    boolean isValid() {
        return PasswordValidator.isValid(letters);
    }

}
