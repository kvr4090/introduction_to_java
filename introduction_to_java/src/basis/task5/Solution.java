package basis.task5;

/*
 * Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
 * Вывести данное значение длительности в часах, минутах и секундах в следующей форме ННч ММмин SSс.
 */

public class Solution {

    public void printValue(int time) {

        if (time < 0) {
            System.out.println("Заданное число отрицательное, задайте натуральное число.");

        } else {
            int h = time / 3600;
            int m = (time - (h * 3600)) / 60;
            int s = time - h * 3600 - m * 60;

            System.out.println(h + "ч " + m + "мин " + s + "с");
        }
    }
}