package by.epam.string.stringandstringbuilder;

public class Task_5_SymbolRepeat {

    /*
     *  Подсчитать, сколько раз среди символов
     *  заданной строки встречается буква “а”.
     */

    public static void main(String[] args) {

        String st1 = "a banana";
        String st2 = "a";

        letterOccursTimes(st1, st2);
    }

    static void letterOccursTimes(String st1, String st2) {
        char ch1 = 'a';
        int count = 0;
        for (int i = 0; i < st1.length(); i++) {
            if (st1.charAt(i) == ch1) {
                count++;
            }
        }
        System.out.println("Letter: '" + st2 + "' occurs " + count + " times in the text: '" + st1 + "'");
    }
}

