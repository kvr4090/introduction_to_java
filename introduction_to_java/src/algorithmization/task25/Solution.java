package algorithmization.task25;

/* Найдите наибольший элемент матрицы и заменить все нечетные элементы на него. */

public class Solution {

    public void swapElements(int [][] matrix){
        int max = matrix[0][0];

        for (int[] value : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (value[j] > max) {
                    max = value[j];
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(j % 2 != 0) {
                    matrix[i][j] = max;
                }
            }
        }
    }
}
