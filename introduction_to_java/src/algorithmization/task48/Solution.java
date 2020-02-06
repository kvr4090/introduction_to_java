package algorithmization.task48;

/*
 * Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
 * возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
 * использовать декомпозицию.
 */

import java.util.ArrayList;

public class Solution {

    public ArrayList<Integer> returnNumbersArmstrong(int k) {
        ArrayList<Integer> numbersArmstrong = new ArrayList<>();

        for (int i = 1; i < k; i++) {
            if (isArmstrong(i)) {
                numbersArmstrong.add(i);
            }
        }
        return numbersArmstrong;
    }

    private boolean isArmstrong(int a) {
        char[] current = String.valueOf(a).toCharArray();
        int sum = 0;

        for (char c : current) {
            sum += Math.pow(Character.digit(c, 10), current.length);
        }
        return sum == a;
    }
}
