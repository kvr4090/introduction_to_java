package algorithmization.task17;

/*
 * Сформировать квадратную матрицу порядка N по правилу:
 * и подсчитать количество положительных элементов в ней.
 */

public class Solution {

    public int calculatePositiveElements(int n) {
        double[][] matrix = new double[n][n];
        int countPositiveElement = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.sin((1.0 * i * i - j * j) / n);

                if (matrix[i][j] > 0) {
                    countPositiveElement ++;
                }
            }
        }

        return countPositiveElement;
    }
}
