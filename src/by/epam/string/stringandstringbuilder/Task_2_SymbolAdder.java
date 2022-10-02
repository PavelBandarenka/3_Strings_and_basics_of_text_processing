package by.epam.string.stringandstringbuilder;

public class Task_2_SymbolAdder {

    /*
     *  В строке вставить после каждого символа 'a' символ 'b'.
     */

    public static void main(String[] args) {

        String st1 = "la-la land";
        String st2 = "a";
        String st3 = "b";

        System.out.println(insertLetterInString(st1, st2, st3));
    }

    static String insertLetterInString(String st1, String st2, String st3) {
        StringBuilder sb1 = new StringBuilder(st1);
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) == st2.charAt(0)) {
                sb1.insert(i + 1, st3);
            }
        }
        return sb1.toString();
    }
}
