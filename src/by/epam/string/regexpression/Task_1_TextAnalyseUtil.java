package by.epam.string.regexpression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_1_TextAnalyseUtil {

    /*
     *  Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
     *  операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
     *  отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
     *  алфавиту.
     */


    public static void main(String[] args) {
        String text = """
                     Привет! Я живу на Марсе. В квадрате мемнония есть город Пла. Там моя резиденция.\s
                Прилетайте в гости. Как? На космическом корабле.\s
                Всех вас жду с нпениетерем.\s
                     Привет !Я живу на Марсе.В квадрате мемнония есть город Пла.Там моя резиденция.\s
                Прилетайте в гости.Как ? На космическом корабле.\s
                Всех вас жду с нпениетерем.\s """;

        Pattern par = Pattern.compile(" {4}.+\s");
        Pattern sent = Pattern.compile("[^\n !.?][a-zа-яА-Я0-9 ,-]*[^\n\s]*");
        Pattern word = Pattern.compile("[^\s\n!.?]*[a-zа-яА-Я0-9,-]*[^\s\n!.?]");
        Matcher matchPar = par.matcher(text);
        Matcher matchSen = sent.matcher(text);
        Matcher matchWor = word.matcher(text);
        ArrayList<Object> temp1 = new ArrayList<>();

        while (matchPar.find()) {
            matchSen.region(matchPar.start(), matchPar.end());
            int count = 0;
            while (matchSen.find()) {
                count++;
            }
            temp1.add(count);
            temp1.add(matchPar.group());
        }
        String st1 = "";
        for (int i = 1; i < 4; i++) {
            st1 = st1.concat(String.valueOf(temp1.get(temp1.indexOf(i) + 1))) + "\n";
        }
        temp1.clear();
        matchSen.reset();
        matchPar.reset();
        System.out.println(st1);

        StringBuilder sb1 = new StringBuilder(text);
        StringBuilder sb2 = new StringBuilder();

        ArrayList<String> temp2 = new ArrayList<>();
        while (matchSen.find()) {
            matchWor.region(matchSen.start(), matchSen.end());
            while (matchWor.find()) {
                temp2.add(matchWor.group());
            }
            temp2.sort(Comparator.comparing(String::length));
            for (String s : temp2) {
                sb2.append(s).append(" ");
            }
            sb2.deleteCharAt(sb2.length() - 1);
            temp2.clear();
            sb1.replace(matchSen.start(), matchSen.end() - 1, sb2.toString());
            sb2.setLength(0);
        }
        System.out.println(sb1.toString());
        System.out.println();

        matchSen.reset();
        matchPar.reset();
        matchWor.reset();
        char ch = 'а';
        int chCount1 = 0;
        int chCount2;
        StringBuilder sb3 = new StringBuilder(text);
        StringBuilder sb4 = new StringBuilder();
        ArrayList<String> temp3 = new ArrayList<>();
        while (matchSen.find()) {
            matchWor.region(matchSen.start(), matchSen.end());
            while (matchWor.find()) {
                temp3.add(matchWor.group());
            }
            temp3.sort(String.CASE_INSENSITIVE_ORDER);
            String[] st2 = new String[temp3.size()];
            for (int i = 0; i < temp3.size(); i++) {
                st2[i] = temp3.get(i);
            }
            int index;
            String dt;
            for (int i = 0; i < st2.length; i++) {
                chCount2 = 0;
                index = 0;
                for (int j = i; j < st2.length; j++) {
                    for (int l = 0; l < st2[j].length(); l++) {
                        if (st2[j].charAt(l) == ch) {
                            chCount1++;
                        }
                    }
                    if (chCount2 < chCount1) {
                        chCount2 = chCount1;
                        index = j;
                    }
                    chCount1 = 0;
                }
                if (index > 0) {
                    dt = st2[index];
                    if (index - i >= 0) {
                        System.arraycopy(st2, i, st2, i + 1, index - i);
                    }
                    st2[i] = dt;
                }
            }
            for (String s : st2) {
                sb4.append(s).append(" ");
            }
            sb4.deleteCharAt(sb4.length() - 1);
            temp3.clear();
            sb3.replace(matchSen.start(), matchSen.end() - 1, sb4.toString());
            sb4.setLength(0);
        }
        System.out.println(sb3.toString());
    }
}