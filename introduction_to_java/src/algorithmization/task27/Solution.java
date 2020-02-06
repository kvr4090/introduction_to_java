package algorithmization.task27;

/*
 * Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
 * один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
 * дополнительный массив.
 */

public class Solution {

    public Object[] uniteArrays(Object [] arrayFirst, Object[] arraySecond, int k ) {
        Object [] result = new Object[arrayFirst.length + arraySecond.length];

        System.arraycopy(arrayFirst, 0, result, 0, k + 1);
        System.arraycopy(arraySecond, 0, result, k + 1, arraySecond.length);
        System.arraycopy(arrayFirst,k + 1, result, k + 1 + arraySecond.length, arrayFirst.length - (k + 1));

        return result;
    }
}
