package algorithmization.task35;

/*
 * Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
 * натуральных чисел.
 */

public class Solution {

    public int greatestCommonDivisor(int a, int b) {
        int n = 1;

        if (a > b) {
            for (int i = b; i > 1 ; i--) {
                if ((a % i == 0) && (b % i == 0)) {
                    n = i;
                    break;
                }
            }
        } else {
            for (int i = a; i > 1 ; i--) {
                if ((a % i == 0) && (b % i == 0)) {
                    n = i;
                    break;
                }
            }
        }
        return n;
    }

    public int lowestCommonMultiple(int a, int b) {
        return (a * b) / greatestCommonDivisor(a, b);
    }
}
