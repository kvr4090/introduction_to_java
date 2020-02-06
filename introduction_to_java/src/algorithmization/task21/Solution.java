package algorithmization.task21;

import java.util.Random;

/*
 * Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
 * которых число 5 встречается три и более раз.
 */

public class Solution {

    public void createMatrix() {
        int count;
        int[][] matrix = new int[10][20];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                matrix[i][j] = random.nextInt(15);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("Номера строк: ");

        for (int i = 0; i < 10; i++) {
            count = 0;

            for (int j = 0; j < 20; j++) {
                if (matrix[i][j] == 5){
                    count++;
                }
            }

            if (count >= 3) {
                System.out.print(i + 1 + "\t");
            }
        }
    }
}
