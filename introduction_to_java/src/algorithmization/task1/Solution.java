package algorithmization.task1;

/* В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К */

public class Solution {

    public int calculateSum(int[] array, int k) {
        int sum = 0;

        for (int value : array) {
            if (value % k == 0) {
                sum += value;
            }
        }

        return sum;
    }
}
