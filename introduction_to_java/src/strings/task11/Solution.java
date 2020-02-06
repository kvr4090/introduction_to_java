package strings.task11;

/* Из заданной строки получить новую, повторив каждый символ дважды */

public class Solution {

    public String dualString(String string) {

        for (char c : string.toCharArray()) {
            string = string.replaceAll(Character.toString(c), Character.toString(c).concat(Character.toString(c)));
        }
        return string;
    }
}
