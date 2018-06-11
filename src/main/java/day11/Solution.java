package day11;

public class Solution {

    public static void main(String... args) {
        var nextPassword = PasswordGenerator.generateNext("hepxcrrq");
        System.out.println("Next password is " + nextPassword);

        nextPassword = PasswordGenerator.generateNext(nextPassword.toString());
        System.out.println("Next password after that is " + nextPassword);
    }

}
