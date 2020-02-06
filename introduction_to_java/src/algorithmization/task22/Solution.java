package algorithmization.task22;

import java.util.Arrays;

/* Отсортировать строки матрицы по возрастанию и убыванию значений элементов. */

public class Solution {

    public void sortMatrix(int[][] matrix) {

        for (int[] value : matrix){
            Arrays.sort(value);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = - matrix[i][j];
            }
        }

        for (int[] value : matrix) {
            Arrays.sort(value);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = - matrix[i][j];
            }
        }
    }
}
