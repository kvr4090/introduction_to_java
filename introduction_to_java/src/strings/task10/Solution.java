package strings.task10;

/* Подсчитать, сколько раз среди символов заданной строки встречается буква “а”. */

public class Solution {

    public int countLetterA(String string) {
        int count = 0;

        for (char c : string.toCharArray()) {
            if (c =='a') {
                count ++;
            }
        }
        return count;
    }
}
