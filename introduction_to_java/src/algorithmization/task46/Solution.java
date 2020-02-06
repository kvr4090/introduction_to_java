package algorithmization.task46;

/*
 * Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
 * являются числа, сумма цифр которых равна К и которые не большее N.
 */

import java.util.ArrayList;

public class Solution {

    public ArrayList<Integer> returnArray(int k, int n) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (countDigits(i) == k) {
                array.add(i);
            }
        }
        return array;
    }

    private int countDigits(int number) {
        int count = 0;
        char[] sing = String.valueOf(number).toCharArray();

        for (char c : sing) {
            count += Integer.parseInt(Character.toString(c));
        }
        return count;
    }
}
