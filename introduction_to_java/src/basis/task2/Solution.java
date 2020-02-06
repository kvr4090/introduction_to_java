package basis.task2;

/* вычислить значение выражения по формуле (все переменные принимают действительные значения) */

public class Solution {

    public double returnValue(double a, double b, double c) {
        if (a == 0) {
            System.out.println("Деление на ноль.");
        }

        return  (b + Math.sqrt(b * b + 4 * a * c)) / (2 * a) + a * a * a * c + (1 /(b * b));
    }
}