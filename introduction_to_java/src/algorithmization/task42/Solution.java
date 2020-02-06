package algorithmization.task42;

/*
 * Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
 * Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
 * массива с номерами от k до m.
 */

public class Solution {

    public int calculateSumElements(int[] arrayD, int k, int m) {
        int result = 0;

        for (int i = k; i <= m; i++) {
            result += arrayD[i];
        }
        return result;
    }
}
