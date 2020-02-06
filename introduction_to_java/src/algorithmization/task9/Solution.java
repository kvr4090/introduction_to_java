package algorithmization.task9;

/*
 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
 * чисел несколько, то определить наименьшее из них.
 */

public class Solution {

    public int searchMin(int[] array) {
        int[] arrayMin = new int[array.length];
        int max = 2;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int value : array) {
                if (array[i] == value) {
                    arrayMin[i]++;

                    if (arrayMin[i] > max) {
                        max = arrayMin[i];
                    }
                }
            }
        }

        for (int i = 0; i < arrayMin.length; i++) {
            if ((arrayMin[i] == max) && (array[i]< min)) {
                min = array[i];
            }
        }

        return min;
    }
}