package by.tc.task01.entity;

import java.util.Objects;

public class Refrigerator implements Appliance {

    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private double overallCapacity;
    private int height;
    private int width;
    private String[] properties;

    public Refrigerator(String[] props) {
        this.powerConsumption = Integer.parseInt(props[2]);
        this.weight = Integer.parseInt(props[4]);
        this.freezerCapacity = Integer.parseInt(props[6]);
        this.overallCapacity = Double.parseDouble(props[8]);
        this.height = Integer.parseInt(props[10]);
        this.width = Integer.parseInt(props[12]);
        properties = props;
    }

    public String[] getProperties() {
        return properties;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Refrigerator that = (Refrigerator) o;

        return powerConsumption == that.powerConsumption &&
                weight == that.weight &&
                freezerCapacity == that.freezerCapacity &&
                Double.compare(that.overallCapacity, overallCapacity) == 0 &&
                height == that.height &&
                width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", overallCapacity=" + overallCapacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
