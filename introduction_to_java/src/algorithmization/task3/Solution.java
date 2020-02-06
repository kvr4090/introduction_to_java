package algorithmization.task3;

/*
 * Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
 * положительных и нулевых элементов.
 */

public class Solution {

    public String calculateElements(double[] array) {
        int countNegativeElements = 0;
        int countPositiveElements = 0;
        int countNullElements = 0;

        for (double d : array) {
            if (d > 0) {
                countPositiveElements++;
            }

            if (d < 0) {
                countNegativeElements++;
            }

            if (d == 0) {
                countNullElements++;
            }
        }

        return countNegativeElements + " отрицательных элементов\n" +
                countPositiveElements + " положительных элементов\n" +
                countNullElements + " нулевых элементов\n" ;
    }
}
