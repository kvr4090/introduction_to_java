package strings.task3;

/* В строке найти количество цифр */

public class Solution {

    public int returnCountDigit(String string) {
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
