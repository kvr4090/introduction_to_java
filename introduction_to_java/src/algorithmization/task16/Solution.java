package algorithmization.task16;

/* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное) */

public class Solution {

    public int[][] createMatrix(int n) {
        int[][] matrix = new int[0][0];

        if (n % 2 == 0) {
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (((j >= i) && (j < (n - i))) || ((j <= i) && (j > (n - i - 2)))) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = 0;
                    }
                }
            }

            return matrix;

        } else {
            System.out.println("n должно быть чётным.");
        }

        return matrix;
    }
}
