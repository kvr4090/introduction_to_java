package algorithmization.task29;

/*
 * Сортировка выбором.
 */

public class Solution {

    public void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n; i ++) {
            int minIndex = min(array, i, n - 1);
            swap(array, i, minIndex);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int min(int[] array, int begin, int end) {
        int minVal = array[begin];
        int minIndex = begin;

        for (int i = begin + 1; i <= end; i++) {
            if (array[i] < minVal) {
                minVal = array[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}