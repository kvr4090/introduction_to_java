package algorithmization.task23;

/* Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов. */

public class Solution {

    public void sortMatrix(int[][] matrix) {

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = j + 1; k < matrix.length; k++) {
                    if (matrix[j][i] > matrix[k][i]) {

                        int temp1 = matrix[j][i];
                        matrix[j][i] = matrix[k][i];
                        matrix[k][i] = temp1;
                    }
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = j + 1; k < matrix.length; k++) {
                    if (matrix[j][i] < matrix[k][i]) {

                        int temp1 = matrix[j][i];
                        matrix[j][i] = matrix[k][i];
                        matrix[k][i] = temp1;
                    }
                }
            }
        }
    }
}
