package classes.task7;

/*
 * Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
 * площади, периметра и точки пересечения медиан.
 */

public class Triangle {
    private double firstSide;
    private double secondSide;
    private double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double perimeter() {
        return firstSide + secondSide + thirdSide;
    }

    public double square() {
        double p = 0.5 * (firstSide + secondSide + thirdSide);

        return Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
    }

    public double pointCoordinatesMedianX(double x1, double x2, double x3) {
        return  (x1 + x2 + x3) / 3;

    }

    public double pointCoordinatesMedianY(double y1, double y2, double y3) {
        return  (y1 + y2 + y3) / 3;
    }
}