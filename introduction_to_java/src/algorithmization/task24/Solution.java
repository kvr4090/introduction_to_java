package algorithmization.task24;

/*
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
 * единиц равно номеру столбца
 */

public class Solution {

    public int[][] createMatrix(int m, int n){
        int[][] matrix = new int[m][n];
        int count;

        for (int i = 0; i <m ; i++) {
            count = 0;

            for (int j = 0; j < n; j++) {
                if (count <= i){
                    matrix[i][j] = 0;
                    count ++;

                } else {
                    matrix[i][j] = 1;
                }
            }
        }

        return matrix;
    }
}
