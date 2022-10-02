package by.epam.string.stringandstringbuilder;

public class Task_6_StringDuplicate {

    /*
     *  Из заданной строки получить новую, повторив каждый символ дважды.
     */

    public static void main(String[] args) {
        String st1 = "Hello how are you?";
        int repeatTimes;

        repeatTimes = 2;

        System.out.println(st1);

        writeNewText(st1, repeatTimes);

    }

    static void writeNewText(String st1, int repeatSymbolsTimes) {
        StringBuilder sb1 = new StringBuilder();
        int count = 0;
        for (int i = 0; i < st1.length(); ) {
            sb1.append(st1.charAt(i));
            count++;
            if (count == repeatSymbolsTimes) {
                i++;
                count = 0;
            }
        }
        System.out.println(sb1);
    }
}