package strings.task12;

import java.util.HashSet;
import java.util.Set;

/*
 * Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
 * def", то должно быть выведено "abcdef".
 */

public class Solution {

    public String editString(String string) {
        Set<Character> set = new HashSet<>();
        String b = "";

        for (char c : string.toCharArray()) {
            if ((!set.contains(c)) && (c != ' ')) {
                set.add(c);
                b = b.concat(Character.toString(c));
            }
        }
        return b;
    }
}
