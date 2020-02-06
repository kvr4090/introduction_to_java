package basis.task7;

/*
 * Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да,
 * то будет ли он прямоугольным.
 */

public class Solution {

    public void isCoexistTriangle(double a, double b) {

        if ((a+b) >= 180 || a == 0 || b == 0 || a < 0 || b < 0) {
            System.out.println("треугольник не существует");

        } else {
            if (180 - a - b == 90 || a == 90 || b == 90 ) {
                System.out.println("треугольник существует, он прямоугольный");

            } else {
                System.out.println("треугольник существует");
            }
        }
    }
}

