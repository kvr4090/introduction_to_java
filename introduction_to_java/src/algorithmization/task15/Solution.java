package algorithmization.task15;

/* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное): */

public class Solution {

    public int[][] createMatrix(int n) {
        int[][] matrix = new int[0][0];
        int m = n;

        if (n % 2 == 0) {
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = i + 1;
                }
                m --;
            }

            return matrix;
        } else {
            System.out.println("n должно быть чётным.");
        }

        return matrix;
    }
}
