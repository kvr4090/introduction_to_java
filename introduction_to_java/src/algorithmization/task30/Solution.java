package algorithmization.task30;

/*
 * Сортировка обменами.
 */

public class Solution {

    public void exchangeSort(int [] array) {
        int exchangeCount = 0;
        boolean temp = true;

        while (temp) {
            temp = false;

            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    exchangeCount ++;
                    temp = true;
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