package day11;

class PasswordGenerator {

    private PasswordGenerator() {
    }

    static Password generateNext(String oldPassword) {
        var password = new Password(oldPassword);
        do {
            password.increment();
        } while (!password.isValid());
        return password;
    }

}
