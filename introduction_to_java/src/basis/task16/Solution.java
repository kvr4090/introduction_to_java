package basis.task16;

/*
 * Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
 * заданному е. Общий член ряда имеет вид:   a =  1/2^n + 1/3^n
 */

public class Solution {

    public double calculateSum(double e) {
        double sum = 0;
        double member;

        for (int i = 1; i <= 53; i++) {
            member = (1 / Math.pow(2, i)) + (1 / Math.pow(3, i));

            if (e <= Math.abs(member)) {
                sum += member;
            }
        }

        return sum;
    }
}
