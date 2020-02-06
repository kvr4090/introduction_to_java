package algorithmization.task31;

/*
 * Сортировка вставками.
 */

public class Solution {

    public void insertionSort(int[] array){
        int length = array.length;

        for (int i = 1; i < length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] array, int value1, int value2) {
        int tmp = array[value1];
        array[value1] = array[value2];
        array[value2] = tmp;
    }
}
