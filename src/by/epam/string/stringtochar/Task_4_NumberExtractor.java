package by.epam.string.stringtochar;

import java.util.Arrays;

public class Task_4_NumberExtractor {

    /*
     *  В строке найти количество чисел.
     */

    public static void main(String[] args) {

        String st1 = "_1__23_11_9986_4_4_67__8888";
        char[] ch1;
        int count;

        ch1 = st1.toCharArray();
        count = 0;

        System.out.println(Arrays.toString(ch1));

        boolean sequence = true;
        for (char c : ch1) {
            if (Character.isDigit(c)) {
                if (sequence) {
                    count++;
                }
                sequence = false;
            } else {
                sequence = true;
            }

        }
        System.out.println(count);
    }
}
