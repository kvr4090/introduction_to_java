package algorithmization.task4;

/* Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы */

public class Solution {

    public void swapMaxMin(double[] array) {
        int indexMax = 0;
        int indexMin = 0;
        double temp;

        for (int i = 0; i < array.length; i++) {
            if(array[indexMax] < array[i]) {
                indexMax = i;
            }

            if(array[indexMin] > array[i]) {
                indexMin = i;
            }
        }

        temp = array[indexMin];
        array[indexMin] = array[indexMax];
        array[indexMax] = temp;
    }
}