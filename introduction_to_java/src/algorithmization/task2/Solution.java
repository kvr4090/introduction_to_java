package algorithmization.task2;

/*
 * Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
 * числом. Подсчитать количество замен.
 */

public class Solution {

    public int calculateCountChange(double[] sequence, double z) {
        int counter = 0;

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] > z) {
                sequence[i] = z;
                counter++;
            }
        }

        return counter;
    }
}