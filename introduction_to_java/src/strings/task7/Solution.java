package strings.task7;

/* В строке вставить после каждого символа 'a' символ 'b'. */

public class Solution {

    public String changeSymbol(String a) {
        return a.replaceAll("a", "ab");
    }
}
