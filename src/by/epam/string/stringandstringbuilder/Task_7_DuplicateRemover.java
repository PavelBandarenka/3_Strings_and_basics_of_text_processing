package by.epam.string.stringandstringbuilder;

public class Task_7_DuplicateRemover {

    /*
     *  Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
     *  Например, если было введено "abc cde def", то должно быть выведено "abcdef".
     */

    public static void main(String[] args) {

        String st1 = "abc cde def";

        System.out.println("Original text: " + st1);

        st1 = removeDuplicateElements(st1);
        st1 = deleteWhiteShifts(st1);
        System.out.println("Final text: " + st1);
    }

    public static String removeDuplicateElements(String st1) {
        StringBuilder sb1 = new StringBuilder(st1);
        String st2 = " ";
        for (int i = 0; i < st1.length() - 1; i++) {
            for (int j = i + 1; j < st1.length(); j++) {
                if (st1.charAt(i) == st1.charAt(j)) {
                    sb1.replace(j, j + 1, st2);
                }
            }
        }
        return sb1.toString();
    }

    public static String deleteWhiteShifts(String st1) {
        st1 = st1.replaceAll("\\s", "");
        return st1;
    }
}
