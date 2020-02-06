package basis.task9;

/* Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой */

public class Solution {

    public void isPointsOnLine (double x1, double y1, double x2, double y2, double x3, double y3) {
        if ((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3) == 0) {
            System.out.println("точки расположены на одной прямой");

        } else {
            System.out.println("точки не расположены на одной прямой");
        }
    }

    public boolean isPointsOnLine2 (double x1, double y1, double x2, double y2, double x3, double y3) {
        return (x1 - x2) * (y1 - y3) == (x1 - x3) * (y1 - y2);
    }
}
