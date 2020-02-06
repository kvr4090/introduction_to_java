package strings.task4;

// В строке найти количество чисел

public class Solution {

    public int returnCountNumbers(String string) {
        int count = 0;
        char temp = ' ';

        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                count ++;

                if (Character.isDigit(temp)) {
                    count--;
                }
            }
            temp = c;
        }
        return count;
    }
}