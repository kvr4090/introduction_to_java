package strings.task9;

/* С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт” */

public class Solution {

    public String concatenationWord(String word) {
        String result = "";

        result = result.concat(Character.toString(word.charAt(7)));
        result = result.concat(Character.toString(word.charAt(3)));
        result = result.concat(Character.toString(word.charAt(4)));
        result = result.concat(Character.toString(word.charAt(7)));

        return result;
    }
}
