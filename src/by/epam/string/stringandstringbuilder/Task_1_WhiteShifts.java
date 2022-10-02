package by.epam.string.stringandstringbuilder;

import java.util.Arrays;

public class Task_1_WhiteShifts {

    /*
     *  Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
     */

    public static void main(String[] args) {

        String st1 = "q       qwerty q qwq   wq  w";
        String st2 = " ";

        printStringArrayLookLike(st1);
        checkForSequence(st1, st2);

    }

    static void checkForSequence(String st1, String st2) {
        String st3 = st2;
        for (int i = 0; i < st1.length(); i++) {
            if (st1.contains(st3)) {
                st3 = increaseWhiteShiftSequence(st2, st3);
            }
        }
        System.out.println("Max white shift sequence has " + (st3.length() - 1) + " chars");
    }

    static String increaseWhiteShiftSequence(String st2, String st3) {
        return st3 + st2;
    }

    static void printStringArrayLookLike(String st1) {
        char[] ch1 = st1.toCharArray();
        System.out.println(Arrays.toString(ch1));
    }
}
