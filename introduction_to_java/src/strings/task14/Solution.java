package strings.task14;

/* Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские буквы. */

public class Solution {

    public void countLetters(String string) {
        char[] alphabet = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
        int countSmall = 0;
        int countBig = 0;

        for (char c : string.toCharArray()) {
            for (char value : alphabet) {
                if (c == value) {
                    countSmall++;
                }

                if (c == Character.toUpperCase(value)) {
                    countBig ++;
                }
            }
        }
        System.out.println("строчных " + countSmall + ", заглавных " + countBig);
    }
}
