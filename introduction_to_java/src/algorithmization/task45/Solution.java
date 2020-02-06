package algorithmization.task45;

// Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.

public class Solution {

    public double returnMaxCountDigits(double a, double b) {
        boolean n = String.valueOf(a).toCharArray().length > String.valueOf(b).toCharArray().length;
        return (n ? a : b);
    }
}
