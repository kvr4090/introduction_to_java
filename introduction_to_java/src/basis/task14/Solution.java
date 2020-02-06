package basis.task14;

/* Найти сумму квадратов первых ста чисел. (1->100) */

public class Solution {

    public int calculateSum() {
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i * i;
        }

        return sum;
    }
}
