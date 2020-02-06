package algorithmization.task43;

/*
 * Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
 * если угол между сторонами длиной X и Y— прямой.
 */

public class Solution {

    private double squareTriangleGeron(double a, double b, double c) {
        double p = 0.5 * (a + b + c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double squareQuadrilateral(double x, double y, double z, double t) {
        double c = Math.sqrt(x * x + y * y);
        double square = 0.5 * x * y + squareTriangleGeron(z, t, c);

        if ((x == y) && (y == z) && (z == t)) {
            square = x * y;
        }
        return square;
    }
}
