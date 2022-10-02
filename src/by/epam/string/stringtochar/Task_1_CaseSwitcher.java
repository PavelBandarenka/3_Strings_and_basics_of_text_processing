package by.epam.string.stringtochar;

import java.util.Arrays;

public class Task_1_CaseSwitcher {

    public static void main(String[] args) {

        /*
         *  Дан массив названий переменных в camelCase.
         *  Преобразовать названия в snake_case.
         */

        String[] st1 = new String[]{"snakeCase", "camelCase", "SomeCaseSUPER"};
        String[] st2 = replaceSymbols(st1);

        System.out.println(Arrays.toString(st2));
    }

    static char[] makeTempArrayForLowerCaseMarking(String st1) {
        st1 = st1.toLowerCase();
        return st1.toCharArray();
    }

    static char[] makeTempArrayForUpperCaseMarking(String st1) {
        return st1.toCharArray();
    }

    static char[] appendToCharArray(char[] ch1, int i) {
        char[] ch2 = new char[ch1.length + i];
        System.arraycopy(ch1, 0, ch2, 0, ch1.length);
        return ch2;
    }

    static int checkForCaseConformity(String st1) {
        char[] ch1 = makeTempArrayForLowerCaseMarking(st1);
        char[] ch2 = makeTempArrayForUpperCaseMarking(st1);
        int count = 0;
        for (int i = 0; i < st1.length(); i++) {
            if (ch1[i] != ch2[i]) {
                count++;
            }
        }
        return count;
    }

    static char[] makeCharArray(String st1) {
        char[] ch1 = makeTempArrayForUpperCaseMarking(st1);
        int i = checkForCaseConformity(st1);
        ch1 = appendToCharArray(ch1, i);
        return ch1;
    }

    static String[] replaceSymbols(String[] st1) {
        char[] ch1;
        char[] ch2;
        for (int i = 0; i < st1.length; i++) {
            ch1 = makeCharArray(st1[i]);
            ch2 = new char[ch1.length];
            int temp = 0;
            for (int j = 0; j < st1[i].length(); j++) {
                if (Character.isUpperCase(ch1[j])) {
                    ch1[j] = Character.toLowerCase(ch1[j]);
                    ch2[temp + 1] = ch1[j];
                    ch2[temp] = '_';
                    temp = temp + 2;
                } else {
                    ch2[temp] = ch1[j];
                    temp++;
                }
            }
            st1[i] = Arrays.toString(ch2);
        }
        return st1;
    }
}
