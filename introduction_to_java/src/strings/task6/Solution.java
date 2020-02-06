package strings.task6;

/* Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем. */

public class Solution {

    public int searchMaxCountSpaces(String string) {
        int count = 0;
        int maxCount = 0;

        for (char c : string.toCharArray()) {
            if (c == ' ') {
                count++;

                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}
