package algorithmization.task36;

/* Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел */

public class Solution {

    private int searchMin(int a1, int a2, int a3, int a4) {
        return (Math.min(Math.min(a1, a2), Math.min(a3, a4)));
    }

    public int greatestCommonDivisor(int a1, int a2, int a3, int a4) {
        int gcd = 1;

        for (int i = searchMin(a1, a2, a3, a4); i > 0; i--) {
            if ((a1 % i == 0) && (a2 % i == 0) && (a3 % i == 0) && (a4 % i == 0)) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }
}
