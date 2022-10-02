package by.epam.string.stringtochar;

public class Task_2_SequenceDetector {
    /*
         Замените в строке все вхождения 'word' на 'letter'.
        */
    public static void main(String[] args) {

        String st1 = "hello word and world big Word one more word";
        String target = "word";
        String replaceWith = "letter";

        st1 = replaceWords(st1, target, replaceWith);
        System.out.println(st1);
    }

    static int addElementsInArrayQuantity(char[] target, char[] replaceWith) {
        int temp;
        if ((replaceWith.length - target.length) > 0) {
            temp = Math.abs(replaceWith.length - target.length);
        } else {
            temp = replaceWith.length;
        }
        return temp;
    }

    static char[] charArrayDeclaration(String st1) {
        return st1.toCharArray();
    }

    static char[] appendToCharArray(char[] ch1, int i) {
        char[] ch2 = new char[ch1.length + i];
        System.arraycopy(ch1, 0, ch2, 0, ch1.length);
        return ch2;
    }

    static char[] insertElementsInCharArray(char[] ch1, int addElements, int k) {
        for (int j = 0; j < addElements; j++) {
            if (ch1.length - 1 - k >= 0) System.arraycopy(ch1, k, ch1, k + 1, ch1.length - 1 - k);
        }
        return ch1;

    }

    static String replaceWords(String st1, String target, String replaceWith) {
        char[] ch1 = charArrayDeclaration(st1);
        char[] ch2 = charArrayDeclaration(target);
        char[] ch3 = charArrayDeclaration(replaceWith);
        char[] ch4 = charArrayDeclaration(st1);
        int addElements = addElementsInArrayQuantity(ch2, ch3);
        int count = 0;
        for (int i = 0; i < ch1.length; i++) {
            if (ch2[0] == ch1[i]) {
                for (int j = 0; j < ch2.length; j++) {
                    if (ch2[j] == ch1[i + j]) {
                        count++;
                        if (count == ch2.length) {
                            ch4 = insertElementsInCharArray(appendToCharArray(ch4, addElements), addElements, i);
                            count = 0;
                            System.arraycopy(ch3, 0, ch4, i, ch3.length);
                            ch1 = ch4;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }
        return String.valueOf(ch1);
    }
}


