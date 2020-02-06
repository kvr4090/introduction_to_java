package algorithmization.task7;

/* Даны действительные числа а1,а1....а2n, найти max(а1+а2n,a2+a2n-1....) */

public class Solution {

    public double calculateMax(double[] array) {
        double maxValue = Double.MIN_VALUE ;

        for (int i = 0; i < array.length; i++) {
            if((array[i] + array.length - i) > maxValue) {
                maxValue = array[i] + array.length - i;
            }
        }

        return maxValue;
    }
}
