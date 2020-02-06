package algorithmization.task51;

/*
 * Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
 * действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
 */

public class Solution {

    private int sumNumber(int a) {
        int sum = 0;
        char[] array = String.valueOf(a).toCharArray();

        for (char c : array) {
            sum += Character.digit(c, 10);
        }
        return sum;
    }

    public int countOperations(int n) {
        int count = 0;

        while (n > 0) {
            n -= sumNumber(n);
            count++;
        }
        return count;
    }
}
