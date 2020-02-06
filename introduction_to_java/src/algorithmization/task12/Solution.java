package algorithmization.task12;

/* Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали. */

public class Solution {

    public void toScreenDiagonalMatrix(int [][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + "\t");
        }

        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][matrix.length - 1 - i] + "\t");
        }
    }
}
