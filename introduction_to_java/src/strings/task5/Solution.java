package strings.task5;

/*
 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
 */

public class Solution {

    public String deleteExtraSpace(String string) {
        String b = string.replaceAll("\\s+", " ");
        return b.trim();
    }
}
