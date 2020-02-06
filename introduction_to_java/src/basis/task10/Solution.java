package basis.task10;

// Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через отверстие.

public class Solution {
    private double a;
    private double b;
    private double x;
    private double y;
    private double z;

    public Solution(double a, double b, double x, double y, double z) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void returnAnswer() {
        if ((a > 0) && (b > 0) && (x > 0) && (y > 0) && (z > 0)) {
            identifyPermeabilityBrick();
        } else {
            System.out.println("Заданные размеры не корректны. Задайте другие.");
        }
    }

    private void identifyPermeabilityBrick() {
        double max = (Math.max(Math.max(x, y), z));

        if (max < a || max < b) {
            System.out.println("кирпич пройдёт");
        } else {
            if (goThroughHole(x, max)) {
                System.out.println("кирпич пройдёт");
            } else {
                if (goThroughHole(y, max)) {
                    System.out.println("кирпич пройдёт");
                } else {
                    if (goThroughHole(z, max)) {
                        System.out.println("кирпич пройдёт");
                    } else {
                        System.out.println("кирпич не пройдёт");
                    }
                }
            }
        }
    }

    private double calculateSqrFunction (double g) {
        return Math.sqrt((g * g) / 2 );
    }

    private boolean goThroughHole (double c, double maxi) {
        double f = Math.sqrt(Math.pow(a - calculateSqrFunction(c), 2) + Math.pow(b - calculateSqrFunction(c), 2));

        return maxi <= f;
    }
}
