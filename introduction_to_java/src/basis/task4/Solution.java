package basis.task4;

/*
 * Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях).
 * Поменять местами дробную и целую части числа и вывести полученное значение числа
 */

public class Solution {

    public void swapNumbers(double temp) {
        int nnn = (int) temp;
        double ddd = (temp - nnn) * 1000;
        double result = (int) ddd + (nnn / 1000.0);

        System.out.println(result);
    }
}
