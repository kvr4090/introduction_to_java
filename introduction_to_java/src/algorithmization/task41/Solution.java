package algorithmization.task41;

/* Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9. */

public class Solution {

    private int calcFactorialNumber(int a) {
        int result = 1;

        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    public int calcFactorial() {
        int result = 0;

        for (int i = 1; i < 9; i += 2) {
            result += calcFactorialNumber(i);
        }
        return result;
    }
}
