package algorithmization.task40;

/* Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми. */

public class Solution {

    private boolean isPrime(int x) {
        int temp;

        if (x < 2) {
            return false;
        }

        for (int i = 2; i <= x / 2; i++) {
            temp = x % i;

            if (temp == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeTrio(int a, int b, int c) {
        return (isPrime(a) && isPrime(b) && isPrime(c));
    }
}
