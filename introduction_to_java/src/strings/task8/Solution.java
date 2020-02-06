package strings.task8;

/* Проверить, является ли заданное слово палиндромом. */

public class Solution {

    public boolean isPalindrome(String word){
        StringBuffer buffer = new StringBuffer(word);
        buffer.reverse();
        String temp = new String(buffer);
        return word.equals(temp);
    }
}
