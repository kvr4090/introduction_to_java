package algorithmization.task47;

/*
 * Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
 * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
 * решения задачи использовать декомпозицию.
 */

public class Solution {

    private boolean isSimple(int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void twins(int n) {
        for (int i = n; i < (2 * n); i++) {
            if (isSimple(i) && isSimple(i + 2)) {
                System.out.println(i + "," + (i + 2));
            }
        }
    }
}