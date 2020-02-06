package strings.task15;

/*
 * Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
 * знаком. Определить количество предложений в строке X.
 */

public class Solution {

    public int countSentence(String s) {
        char a1 = '.';
        char a2 = '!';
        char a3 = '?';
        int count = 0;

        for ( char c : s.toCharArray()) {
            if (c == a1 || c == a2 || c == a3) {
                count ++;
            }
        }
        return count;
    }
}
