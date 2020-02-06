package algorithmization.task49;

/*
 * Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
 * последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
 */

import java.util.ArrayList;

public class Solution {

    private ArrayList<Integer> numbers = new ArrayList<>();

    private void generate(int prefix, int start, int n) {

        if (n == 0) {
            char[] array = String.valueOf(prefix).toCharArray();

            if (array[0] < array[1]) {
                numbers.add(prefix);
            }
        } else {
            for (int i = start; i < 10; i++) {
                generate(10 * prefix + i, i + 1, n - 1);
            }
        }
    }

    public ArrayList<Integer> returnArrayNumbers(int n) {
        for (int i = 1; i < 9; i++) {
            generate(i,1,n - 1);
        }

        return numbers;
    }
}
