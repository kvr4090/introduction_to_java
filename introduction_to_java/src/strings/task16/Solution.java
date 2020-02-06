package strings.task16;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции:
 * отсортировать абзацы по количеству предложений;
 * в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
 */

public class Solution {

    private String[] splitTextToParagraphs(String string) {
        Pattern pattern = Pattern.compile("\\t");
        return pattern.split(string,0);
    }

    private String[] splitTextToSentence(String string) {
        Pattern pattern = Pattern.compile("[.?!]");
        return pattern.split(string,0);
    }

    private String sortParagraphCountSentence (String string) {
        String result = "";
        int[] arrayCount = new int[splitTextToParagraphs(string).length];

        for (int i = 0; i < arrayCount.length; i++) {
            arrayCount[i] = splitTextToSentence(splitTextToParagraphs(string)[i]).length;
        }

        Arrays.sort(arrayCount);

        for (int value : arrayCount) {
            for (int j = 0; j < arrayCount.length; j++) {
                if (value == splitTextToSentence(splitTextToParagraphs(string)[j]).length) {
                    result = result.concat(splitTextToParagraphs(string)[j] + "\n\t");
                }
            }
        }
        return result;
    }

    private String sortOneSentenceLengthWord(String string) {
        String result = "";

        Comparator<String> comparator = Comparator.comparingInt(String::length);
        Pattern pattern = Pattern.compile("\\s");
        String[] array = pattern.split(string,0);

        Arrays.sort(array,comparator);

        for (String s : array) {
            result = result.concat(s + " ");
        }
        return result;
    }

    private String sortEachSentenceLengthWord(String text) {
        String result = "";
        String[] temp =  splitTextToParagraphs(text);

        for (String string : temp) {
            String[] a2 = splitTextToSentence(string);

            for (String s : a2) {
                result = result.concat(sortOneSentenceLengthWord(s) + ".");
            }
            result = result.concat("\n\t");
        }
        return result;
    }

    private int countSymbolString(String string, char c) {
        int count = 0;
        char[] temp = string.toCharArray();

        for (char current : temp) {
            if (current == c) {
                count ++;
            }
        }
        return count;
    }

    private String sortSentenceEntrySymbol(String string, char c) {
        String result = "";

        Comparator<String> comparator = (o1,o2) -> countSymbolString(o2, c) -  countSymbolString(o1, c);
        Pattern pattern = Pattern.compile("\\s");
        String[] array = pattern.split(string,0);

        Arrays.sort(array);
        Arrays.sort(array,comparator);

        for (String s : array) {
            result = result.concat(s + " ");
        }
        return result;
    }

    private String sortTextEntrySymbol(String text, char c) {
        String result = "";
        String[] temp =  splitTextToParagraphs(text);

        for (String string : temp) {
            String[] a2 = splitTextToSentence(string);

            for (String s : a2) {
                result = result.concat(sortSentenceEntrySymbol(s, c));
            }
            result = result.concat("\n\t");
        }
        return result;
    }

    public void run() throws IOException {
        System.out.println("Введите текст");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        System.out.println("Введите\n" +
                "1 для сортировки абзацев по количеству предложений\n" +
                "2 чтобы отсортировать предложения по длинне слов\n" +
                "3 для сортировки лексем в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.\n");

        String choice = reader.readLine();
        Pattern pattern = Pattern.compile("[1-3]");
        Matcher matcher = pattern.matcher(choice);

        if (matcher.find()) {
            int i = Integer.parseInt(choice);

            if (i == 1) {
                System.out.println(sortParagraphCountSentence(string));
            }

            if (i == 2) {
                System.out.println(sortEachSentenceLengthWord(string));
            }

            if (i == 3) {
                System.out.println("Для сортировки введите необходимый символ");
                String choice2 = reader.readLine();

                if (choice2.length() == 1) {
                    char symbol = choice2.toCharArray()[0];
                    System.out.println(sortTextEntrySymbol(string, symbol));
                } else {
                    System.out.println("Что-то не то ввели.");
                }
            }
        } else {
            System.out.println("Что-то не то ввели.");
            run();
        }
    }
}
