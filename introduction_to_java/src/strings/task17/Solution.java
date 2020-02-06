package strings.task17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
 * тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
 */

public class Solution {

    static void parser(String text) {
        String temp;

        Pattern patternContentString = Pattern.compile("(.+)");
        Matcher matcherContentString = patternContentString.matcher(text);

        while ( matcherContentString.find()) {
            temp = matcherContentString.group(1);

            Pattern patternContentNode = Pattern.compile(">(.+)<");
            Matcher matcherContentNode = patternContentNode.matcher(temp);

            Pattern patternContentTeg = Pattern.compile("<note (.+)>");
            Matcher matcherContentTeg = patternContentTeg.matcher(temp);

            Pattern patternNoBodyTeg = Pattern.compile("<(.+)/>");
            Matcher matcherNoBodyTeg = patternNoBodyTeg.matcher(temp);

            Pattern patternOpenTeg = Pattern.compile("(<[^/]+?>)");
            Matcher matcherOpenTeg = patternOpenTeg.matcher(temp);

            Pattern patternCloseTeg = Pattern.compile("(</.+>)");
            Matcher matcherCloseTeg = patternCloseTeg.matcher(temp);

            if (matcherOpenTeg.find()) {
                System.out.println(matcherOpenTeg.group(1) + "\t открывающий тег");
            }

            if (matcherContentTeg.find()) {
                System.out.println(matcherContentTeg.group(1) + "\t содержимое тега");
            }

            if (matcherContentNode.find()) {
                System.out.println(matcherContentNode.group(1) + "\t содержимое узла");
            }

            if (matcherCloseTeg.find()) {
                System.out.println(matcherCloseTeg.group(1) + "\t закрывающий тег");
            }

            if (matcherNoBodyTeg.find()) {
                System.out.println(matcherNoBodyTeg.group(0) + "\t тег без тела ");
            }
        }
    }

    public static void main(String[] args) {
        String s = "<notes> \n" +
                "<note id = \"1\"> \n" +
                "<to>Вася</to> \n" +
                "<from>Света</from> \n" +
                "<heading>Напоминание</heading> \n" +
                "<body>Позвони мне завтра!</body> \n" +
                "</note> \n" +
                "<note id = \"2\"> \n" +
                "<to>Петя</to> \n" +
                "<from>Маша</from> \n" +
                "<heading>Важное напоминание</heading> \n" +
                "<body/> \n" +
                "</note> \n" +
                "</notes>";
        parser(s);
    }
}