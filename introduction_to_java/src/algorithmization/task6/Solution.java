package algorithmization.task6;

/*
 * Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
 * являются простыми числами.
 */

public class Solution {

    public double calculateSum(double[] array) {
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (isPrime(i)) {
                sum += array[i];
            }
        }

        return sum;
    }

    private boolean isPrime(int x) {
        int temp;

        if (x < 2) {
            return false;
        }

        for (int i = 2; i < x; i++) {
            temp = x % i;

            if (temp == 0) {
                return false;
            }
        }

        return true;
    }
}