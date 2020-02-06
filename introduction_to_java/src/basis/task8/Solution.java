package basis.task8;

/* Найти max{min(a, b), min(c, d)} */

public class Solution {

    public double returnMaxValueExpression(double a, double b, double c, double d) {
        return Math.max(Math.min(a, b) , Math.min(c, d));
    }
}
