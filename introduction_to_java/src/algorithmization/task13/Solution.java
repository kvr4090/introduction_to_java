package algorithmization.task13;

/* Дана матрица. Вывести k-ю строку и p-й столбец матрицы. */

public class Solution {

    public void toScreenMatrix(int [][] matrix ,int p, int k) {

        if ((p<0) || (k < 0) || (k >= matrix.length)) {
            System.out.println("Неверные значения номера строки и(или) столбца");

        } else {
            for (int i = 0; i < matrix[k].length; i++) {
                System.out.print(matrix[k][i] + "\t");
            }

            System.out.println();

            for (int[] ints : matrix) {
                System.out.print(ints[p] + "\t");
            }
        }
    }
}
