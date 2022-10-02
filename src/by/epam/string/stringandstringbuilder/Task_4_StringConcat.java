package by.epam.string.stringandstringbuilder;

public class Task_4_StringConcat {

    /*
     *  С помощью функции копирования и операции конкатенации
     *  составить из частей слова “информатика” слово “торт”.
     */
    public static void main(String[] args) {

        String st1 = "информатика";
        char[] ch1 = {'т', 'о', 'р', 'т'};
        String st2 = "";

        makeUpAWord(st1, ch1, st2);
    }

    static void makeUpAWord(String st1, char[] ch1, String st2) {
        for (char c : ch1) {
            for (int i = 0; i < st1.length(); i++) {
                if (st1.charAt(i) == c) {
                    st2 = st2.concat(String.valueOf(c));
                }
            }
        }
        System.out.println(st2);
    }
}
