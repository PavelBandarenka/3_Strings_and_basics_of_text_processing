package by.epam.string.stringtochar;

import java.util.Arrays;

public class Task_5_StringTrimmer {

    /*
     *   Удалить в строке все лишние пробелы,
     *   то есть серии подряд идущих пробелов заменить на одиночные пробелы.
     *   Крайние пробелы в строке удалить.
     */

    public static void main(String[] args) {

        String st1 = "    6  56  6   ";
        char [] temp;
        char [] ch1;

        temp = st1.toCharArray();
        System.out.println(Arrays.toString(temp));
        ch1 = calculateChars(st1);
        st1 = Arrays.toString(ch1);
        System.out.println(st1);

    }

    static char [] calculateChars (String st1){
        char [] ch1 = st1.toCharArray();
        int count = 0;
        for (int i=0;i< ch1.length; i++){
            if (Character.isSpaceChar(ch1[i])) {
                if (count > 0) {
                    ch1 = shiftToLeft(ch1, i); i--;
                }count++;
            }else count = 0;
        }return ch1;
    }
    static char [] shiftToLeft (char [] ch1, int temp) {
        for (int i = temp; i < ch1.length - 1; i++) {
            ch1[i] = ch1[i + 1];
        }
        char[] ch2 = Arrays.copyOf(ch1, ch1.length - 1);
        return ch2;
    }
}
