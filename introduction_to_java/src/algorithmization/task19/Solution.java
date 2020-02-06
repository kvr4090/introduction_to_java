package algorithmization.task19;

/*
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
 * столбец содержит максимальную сумму.
 */

public class Solution {

    public int searchColumnMaxSum(int[][] matrix) {
        int columnIndex = 0;
        int maxSum = 0;
        int currentSum;

        for (int i = 0; i < matrix[0].length; i++) {
            currentSum = 0;

            for (int[] value : matrix) {
                currentSum += value[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                columnIndex = i;
            }
        }

        return columnIndex;
    }
}
