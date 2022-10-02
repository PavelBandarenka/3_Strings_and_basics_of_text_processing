package by.epam.string.stringtochar;

import java.util.Arrays;

public class Task_3_DigitExtractor {

    /*
     *  В строке найти количество цифр.
     */

    public static void main(String[] args) {

        String st1 = "1q2w3e2";
        char[] ch1;
        int count;

        ch1 = st1.toCharArray();
        count = 0;

        System.out.println(Arrays.toString(ch1));

        for (char c : ch1) {
            for (int j = 0; j < 10; j++) {
                int temp = c - '0';
                if (temp == j) {
                    count++;
                }
            }
        }
        System.out.println("There are " + count + " digits per line ");
    }
}