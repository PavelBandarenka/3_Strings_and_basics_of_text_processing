package by.epam.string.stringandstringbuilder;

public class Task_10_SentenceIdentifier {

    /*
     *  Строка X состоит из нескольких предложений,
     *  каждое из которых кончается точкой,
     *  восклицательным или вопросительным знаком.
     *  Определить количество предложений в строке X.
     */

    public static void main(String[] args) {

        String X = "Privet! Kak dela? Dela dela dela.";
        int countSentences;

        countSentences = countSentencesQuantity(X);

        System.out.println("Sentences : " + countSentences);
    }

    public static int countSentencesQuantity(String X) {
        String[] st1 = X.split("[.!?]");
        return st1.length;
    }
}
