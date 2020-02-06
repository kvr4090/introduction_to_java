package algorithmization.task20;

/* Найти положительные элементы главной диагонали квадратной матрицы. */

public class Solution {

    public int[] searchPositiveElements(int[][] matrix) {
        int [] positiveElements = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] > 0) {
                positiveElements[i] = matrix[i][i];
            }
        }

        return positiveElements;
    }
}
