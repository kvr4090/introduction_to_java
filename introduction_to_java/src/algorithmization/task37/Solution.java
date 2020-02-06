package algorithmization.task37;

/* Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника. */

public class Solution {

    public double returnAreaHexagon(int side) {
        return 6 * (Math.sqrt(3) / 4) * Math.pow(side, 2);
    }
}
