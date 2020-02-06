package algorithmization.task39;

import java.util.Arrays;

/*
 * Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
 * которое меньше максимального элемента массива, но больше всех других элементов).
 */

public class Solution {

    public void preMaxElement(double[] array) {
        Arrays.sort(array);

        for (int i = array.length-1; i > 0; i--) {
            if(array[i] < array[array.length - 1]) {
                System.out.print(array[i]);
                break;
            }
        }
    }
}
