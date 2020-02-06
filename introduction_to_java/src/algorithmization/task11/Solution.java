package algorithmization.task11;

/* Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего. */

public class Solution {

    public void toScreenMatrixColumn(int[][] matrix) {
        int heightMatrix = matrix.length;
        int widthMatrix = matrix[0].length;

        for (int[] value : matrix) {
            for (int j = 1; j < widthMatrix; j += 2) {
                if (matrix[0][j] < matrix[heightMatrix - 1][j]) {
                    System.out.print(value[j] + "\t");
                }
            }

            System.out.println();
        }
    }
}