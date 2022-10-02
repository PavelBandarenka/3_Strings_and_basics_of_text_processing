package by.epam.string.stringandstringbuilder;

public class Task_3_Palindrome {

    /*
     *  Проверить, является ли заданное слово палиндромом.
     */

    public static void main(String[] args) {

        String st1 = "live no t on evil";
        boolean b1;

        b1 = checkForPalindrome(st1);

        printResult(b1, st1);
    }

    static Boolean checkForPalindrome(String st1) {
        StringBuilder sb1 = new StringBuilder(st1);
        sb1.reverse();
        return sb1.toString().equals(st1);
    }

    static void printResult(boolean b1, String st1) {
        if (b1) {
            System.out.println(st1 + " :  Yes, it is a palindrome ");
        } else {
            System.out.println(st1 + " :  No, it is not a palindrome");
        }
    }
}
