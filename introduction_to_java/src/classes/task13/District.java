package classes.task13;

public class District {
    private double area;
    private Region[] regions;
    private Town districtCenter;

    public District(Region[] regions, Town districtCenter) {
        this.regions = regions;
        this.districtCenter = districtCenter;
    }

    public double getArea() {
        for (Region region : regions) {
            area += region.getArea();
        }
        return area;
    }

    public Town getDistrictCenter() {
        return districtCenter;
    }
}
