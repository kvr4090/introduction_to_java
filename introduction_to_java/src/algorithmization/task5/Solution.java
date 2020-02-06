package algorithmization.task5;

/* Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i. */

public class Solution {

    public void numbersToScreen(int[] array, int i) {
        for (int j = 0; j < array.length; j++) {
            if (array[j] > j) {
                System.out.print(array[j] + " ");
            }
        }
    }
}
