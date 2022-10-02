package by.epam.string.regexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_XmlAnalyseUtil {
    /*
        Дана строка, содержащая следующий текст (xml-документ):
     <notes>
       <note id = "1">
         <to>Вася</to>
         <from>Света</from>
         <heading>Напоминание</heading>
         <body>Позвони мне завтра!</body>
      </note>
      <note id = "2">
        <to>Петя</to>
        <from>Маша</from>
        <heading>Важное напоминание</heading>
        <body/>
      </note>
    </notes>
    Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
    тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
    нельзя.
         */
    public static void main(String[] args) {

        String st = "<notes>\n" +
                "   <note id = \"1\">\n" +
                "     <to>Вася</to>\n" +
                "     <from>Света</from>\n" +
                "     <heading>Напоминание</heading>\n" +
                "     <body>Позвони мне завтра!</body>\n" +
                "  </note>\n" +
                "  <note id = \"2\">\n" +
                "    <to>Петя</to>\n" +
                "    <from>Маша</from>\n" +
                "    <heading>Важное напоминание</heading>\n" +
                "    <body/>\n" +
                "  </note>\n" +
                "</notes>";


        String rootStart = "^<(\\w+)>";
        String rootEnd = "</(\\w+)>\\z";
        String childElement = " +<(\\w+)>([\\p{IsCyrillic}]+.+)</\\w+>";
        String childEmptyElement = " +</(\\w+)>| +<(\\w+)/>";
        String attribute = " +<(\\w+)\\s+(\\w+)[\\s=\\s\"]+(.+)\">";
        String xmlLength = ".+>";

        analyzeXml(st, rootStart, rootEnd, childElement, childEmptyElement, attribute, xmlLength);

    }

    private static void analyzeXml(String st, String rootStart, String rootEnd, String childElement, String childEmptyElement, String attribute, String xmlLength) {
        int linesInTextQuantity = findXmlLinesQuantity(st, xmlLength);
        String lineContent = "";
        int linesCounter = 0;

        while (linesCounter < linesInTextQuantity) {
            lineContent = goLineByLine(st, xmlLength, linesCounter);
            if (lineContent.matches(rootStart)) {
                System.out.println(findRootTag(lineContent, rootStart));
                linesCounter++;
            }
            if (lineContent.matches(childElement)) {
                System.out.println(findChildTag(lineContent, childElement));
                linesCounter++;
            }
            if (lineContent.matches(rootEnd)) {
                System.out.println(findRootTag(lineContent, rootEnd));
                linesCounter++;
            }
            if (lineContent.matches(childEmptyElement)) {
                System.out.println(findEmptyTag(lineContent, childEmptyElement));
                linesCounter++;
            }
            if (lineContent.matches(attribute)) {
                System.out.println(findAttributeTag(lineContent, attribute));
                linesCounter++;
            }
        }
    }

    public static String goLineByLine(String st, String regex, int number) {
        Pattern element = Pattern.compile(regex);
        Matcher elementM = element.matcher(st);
        String tmp = "";
        for (int i = 0; i <= number; i++) {
            if (elementM.find()) {
                tmp = elementM.group();
            }
        }
        return tmp;
    }

    public static String findChildTag(String st, String regex) {
        Pattern element = Pattern.compile(regex);
        Matcher elementM = element.matcher(st);
        String tmp = "";
        if (elementM.find()) {
            tmp = elementM.group() + "  - Child tag. Name - " + elementM.group(1) + "; Content - " + elementM.group(2);
        } else {
            tmp = "no elements";
        }
        return tmp;
    }

    public static String findAttributeTag(String st, String regex) {
        Pattern element = Pattern.compile(regex);
        Matcher elementM = element.matcher(st);
        String tmp = "";
        if (elementM.find()) {
            tmp = elementM.group() + "  - Child tag. Name - " + elementM.group(1) + "; Attribute name - " + elementM.group(2) + "; Attribute value - " + elementM.group(3);
        } else {
            tmp = "no elements";
        }
        return tmp;
    }

    public static String findRootTag(String st, String regex) {
        Pattern element = Pattern.compile(regex);
        Matcher elementM = element.matcher(st);
        String tmp = "";
        if (elementM.find()) {
            tmp = elementM.group() + "  - Root tag. Name - " + elementM.group(1);
        } else {
            tmp = "no elements";
        }
        return tmp;
    }

    public static String findEmptyTag(String st, String regex) {
        Pattern element = Pattern.compile(regex);
        Matcher elementM = element.matcher(st);
        String tmp = "";
        if (elementM.find()) {
            if (elementM.group(1) != null) {
                tmp = elementM.group() + "  - Child empty tag. Name - " + elementM.group(1);
            }
            if (elementM.group(1) == null) {
                tmp = elementM.group() + "  - Child empty tag. Name - " + elementM.group(2);
            }
        } else {
            tmp = "no elements";
        }
        return tmp;
    }

    public static int findXmlLinesQuantity(String st, String regex) {
        Pattern element = Pattern.compile(regex);
        Matcher elementM = element.matcher(st);
        int count = 0;
        while (elementM.find()) {
            count++;
        }
        return count;
    }
}