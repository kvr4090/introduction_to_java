package basis.task6;

/*
 * Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
 * принадлежит закрашенной области, и false в противном случае
 */

public class Solution {

    public void isBelong(double x, double y) {
        if ((-4 <= x) && (x <= 4) && (y <= 0) && (y>= -3)) {
            System.out.println("true");

        } else {
            if ((-2 <= x) && (x <= 2) && (y <= 4) && (y >= -3)) {
                System.out.println("true");

            } else {
                System.out.println("false");
            }
        }
    }
}
