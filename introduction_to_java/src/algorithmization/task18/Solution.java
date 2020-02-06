package algorithmization.task18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
 * на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
 * пользователь с клавиатуры.(0 -> n)
 */

public class Solution {
    private int columnFirst;
    private int columnSecond;

    public void swapMatrixColumn (int[][] matrix) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        columnFirst = Integer.parseInt(reader.readLine());
        columnSecond = Integer.parseInt(reader.readLine());

        if ((columnFirst >= 0) && (columnSecond >= 0)) {
            swap(matrix);
        } else {
            System.out.println("Отрицательное значение номера столбца. Задайте другое. ");
        }
    }

    private void swap(int[][] matrix) {
        int temp;

        for (int i = 0; i < matrix.length; i++) {
            temp = matrix[i][columnFirst];
            matrix[i][columnFirst] = matrix[i][columnSecond];
            matrix[i][columnSecond] = temp;
        }
    }
}
