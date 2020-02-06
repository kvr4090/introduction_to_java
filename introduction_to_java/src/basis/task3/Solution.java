package basis.task3;

/* вычислить значение выражения по формуле (все переменные принимают действительные значения) */

public class Solution {

    public double returnValue(double x, double y) {
        double temp = Math.cos(x) - Math.sin(y);

        if (temp == 0) {
            System.out.println("Деление на ноль.");
        }

        return ((Math.sin(x) + Math.cos(y)) / temp) * Math.tan(x * y);
    }
}