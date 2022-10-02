package by.epam.string.stringandstringbuilder;

public class Task_9_CaseInfo {

    /*
     *  Посчитать количество строчных (маленьких)
     *  и прописных (больших) букв в введенной строке.
     *  Учитывать только английские буквы.
     */

    public static void main(String[] args) {

        String st1 = "привет! Privet Kak dela?";
        int uppercase;
        int lowercase;

        uppercase = countUpperCaseEnglishLetters(st1);
        lowercase = countLowerCaseEnglishLetters(st1);

        printResult(lowercase, uppercase);

    }

    public static int countUpperCaseEnglishLetters(String st1) {
        int countUppercaseLetters = 0;

        for (int i = 0; i < st1.length(); i++) {
            if ((st1.charAt(i) >= 'A' && st1.charAt(i) <= 'Z')) {
                countUppercaseLetters++;
            }
        }
        return countUppercaseLetters;
    }

    public static int countLowerCaseEnglishLetters(String st1) {
        int countLowercaseLetters = 0;
        for (int i = 0; i < st1.length(); i++) {
            if ((st1.charAt(i) >= 'a' && st1.charAt(i) <= 'z')) {
                countLowercaseLetters++;
            }
        }
        return countLowercaseLetters;
    }

    public static void printResult(int lowercaseLetters, int uppercaseLetters) {
        System.out.println("Lowercase letters quantity is: " + lowercaseLetters);
        System.out.println("Uppercase letters quantity is: " + uppercaseLetters);
    }
}
