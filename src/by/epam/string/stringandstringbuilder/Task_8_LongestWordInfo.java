package by.epam.string.stringandstringbuilder;

public class Task_8_LongestWordInfo {

    /*
     *  Вводится строка слов, разделенных пробелами.
     *  Найти самое длинное слово и вывести его на экран.
     *  Случай, когда самых длинных слов может быть несколько, не обрабатывать.
     */

    public static void main(String[] args) {

        String st1 = "Time to learn java";
        // String st2 = "Time to kick java";
        String st3 = findTheLongestWord(st1);
        boolean compare;

        st3 = findTheLongestWord(st1);
        compare = compareLengthOfWords(st3, st1);

        printResult(compare, st3);
    }

    public static String findTheLongestWord(String st1) {
        int count = 0;
        int index = 0;
        String[] st3 = st1.split(" ");
        for (int i = 0; i < st3.length; i++) {
            if (count < st3[i].length()) {
                count = st3[i].length();
                index = i;
            }
        }
        return (st3[index]);
    }

    public static Boolean compareLengthOfWords(String st3, String st1) {
        String[] st = st1.split(" ");
        int count = 0;
        for (String s : st) {
            if (s.length() == st3.length()) {
                count++;
            }
        }
        return count <= 1;
    }

    public static void printResult(boolean b, String st3) {
        if (b) {
            System.out.println(st3 + "   (I mean Java of course)");
        } else {
            System.out.println("Code FAILED, because \"Time to kick java\" expression is redundant ");
        }
    }
}
