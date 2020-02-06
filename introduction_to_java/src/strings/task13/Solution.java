package strings.task13;

/*
 * Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
 * длинных слов может быть несколько, не обрабатывать.
 */

public class Solution {

    private String searchMaxLengthWord(String string) {
        int count = 0;
        int maxCount = 0;
        String word = "";
        String maxWord = "";

        for (char c : string.toCharArray()) {
            if (c != ' ') {
                count ++;
                word = word.concat(Character.toString(c));

                if (maxCount < count) {
                    maxCount = count;
                    maxWord = word;
                }
            } else {
                count = 0;
                word = "";
            }
        }
        return maxWord;
    }

    public void returnMaxLengthWord(String string) {
        int maxLength = searchMaxLengthWord(string).length();
        int count = 0;
        int checkCount = 0;

        for (char c : string.toCharArray()) {
            if (c != ' ') {
                count++;

                if (count == maxLength) {
                    checkCount++;
                }
            } else {
                count = 0;
            }
        }

        if (checkCount < 2) {
            System.out.print(searchMaxLengthWord(string));
        }
    }
}
