package algorithmization.task38;

/*
 * На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
 * из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
 */

public class Solution {

    private double lengthBetweenPoints(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }

    public double[] returnPositionMaxLength(double[] array) {
        double md = lengthBetweenPoints(array[0],array[1],array[2],array[3]);
        double[] result = new double[4];

        for (int i = 0; i < array.length - 1; i += 2) {
            for (int j = i; j < array.length - 1; j += 2) {
                if (lengthBetweenPoints(array[i], array[i + 1], array[j], array[j + 1]) > md) {

                    md = lengthBetweenPoints(array[i], array[i + 1], array[j], array[j + 1]);
                    result[0] = array[i];
                    result[1] = array[i + 1];
                    result[2] = array[j];
                    result[3] = array[j + 1];
                }
            }
        }
        return result;
    }
}
