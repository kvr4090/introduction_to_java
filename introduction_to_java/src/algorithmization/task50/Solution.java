package algorithmization.task50;

import java.math.BigInteger;

/*
 * Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
 */

public class Solution {

    public void getAnswer(int n) {
        System.out.println(sumOdd(n) + " - сумма нечётных чисел.");
        System.out.println(countDigit(sumOdd(n)) + " - количество чётных цифр в сумме");
    }

    private int sizeNumber(int n) {
        int k = 1;

        for (int i = 1; i < n; i++) {
            k *= 10;
        }
        return  k;
    }

    private BigInteger sumOdd(int n) {
        BigInteger sum = BigInteger.valueOf(0);

        for (int i = sizeNumber(n); i < sizeNumber(n + 1); i++) {
            if (i % 2 != 0) {
                sum = sum.add(BigInteger.valueOf(i));
            }
        }
        return sum;
    }

    private int countDigit(BigInteger n) {
        char[] array = String.valueOf(n).toCharArray();
        int count = 0;

        for (char c : array) {
            if (c % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
