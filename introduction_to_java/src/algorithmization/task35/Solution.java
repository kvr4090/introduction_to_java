package algorithmization.task35;

/*
 * Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
 * натуральных чисел.
 */

public class Solution {

    public int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public int lowestCommonMultiple(int a, int b) {
        return (a * b) / greatestCommonDivisor(a, b);
    }
}
