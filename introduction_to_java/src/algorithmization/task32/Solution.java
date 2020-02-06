package algorithmization.task32;

/*
 * Сортировка Шелла.
 */

public class Solution {

    public void sortShell(int[] array) {
        int h = 1;

        while (h * 3 < array.length) {
            h = h * 3 + 1;
        }

        while(h >= 1) {
            hSort(array, h);
            h = h / 3;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void hSort(int[] array, int h) {
        int length = array.length;

        for (int i = h; i < length; i++) {
            for (int j = i; j >= h; j = j - h) {
                if (array[j] < array[j - h]) {
                    swap(array, j, j - h);
                } else {
                    break;
                }
            }
        }
    }
}
