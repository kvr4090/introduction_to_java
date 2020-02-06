package basis.task13;

/* Вычислить значения функции на отрезке [а,b] c шагом h */

import java.util.ArrayList;

public class Solution {

    public ArrayList<Double> calculateFunction(double a, double b, double h) {
        double result;
        ArrayList<Double> values  = new ArrayList<>();

        for (double i = a; i < b; i += h) {
            if (i <= 2) {
                result = -i;
            } else {
                result = i;
            }

            values.add(result);
        }

        return values;
    }
}