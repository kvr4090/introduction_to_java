package algorithmization.task44;

/*
 * Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
 * являются цифры числа N.
 */

public class Solution {

    public int[] numberToDigit(int n) {
        int count = 0;
        int temp = n;

        while (n > 0) {
            n = n / 10;
            count ++;
        }

        n = temp;
        int[] array = new int[count];
        int i = count - 1;

        while (n > 0) {
            array[i] = n % 10;
            n = n / 10;
            i --;
        }
        return array;
    }
}