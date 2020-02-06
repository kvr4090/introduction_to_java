package algorithmization.task26;

/*
 * Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,...,2n
 * так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между собой. Построить такой квадрат.
 */

public class Solution {

    public int[][] returnMagicSquare(int n) {
        if ( n > 0) {
            if (n % 2 == 0) {
                return evenN(n);
            } else {
                return oddN(n);
            }
        } else {
            System.out.println("Проверьте значение N");
            return  new int[0][0];
        }
    }

    private int[][] oddN(int n) {
        int[][] magicSquare = new int[n][n];
        int number = 1;
        int row = 0;
        int column = n / 2;
        int currentRow;
        int currentCol;

        while (number <= n * n) {
            magicSquare[row][column] = number;
            number ++;
            currentRow = row;
            currentCol = column;
            row -= 1;
            column += 1;

            if (row == -1) {
                row = n - 1;
            }

            if (column == n) {
                column = 0;
            }

            if (magicSquare[row][column] != 0) {
                row = currentRow + 1;
                column = currentCol;

                if (row == -1) {
                    row = n - 1;
                }
            }
        }

        return magicSquare;
    }

    private int[][] evenN(int n) {
        int[][] squareMagic = new int[n][n];
        fill(squareMagic);
        reverse1(squareMagic);
        reverse2(squareMagic);
        return squareMagic;
    }

    private void fill(int[][] matrix) {
        int k = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = k;
                k++;
            }
        }
    }

    private void reverse1(int[][] matrix) {
        int t;

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                if (i == j) {
                    t = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                    matrix[matrix.length - 1 - i][matrix.length - 1 - j] = t;
                }
            }
        }
    }

    private void reverse2(int[][] matrix) {
        int t;

        for (int i = 0, j = matrix.length - 1 - i; i <= (matrix.length / 2) - 1; ++i, --j) {
            t = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = t;
        }
    }
}
