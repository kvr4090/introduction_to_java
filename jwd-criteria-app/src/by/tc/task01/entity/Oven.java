package by.tc.task01.entity;

import java.util.Arrays;
import java.util.Objects;

public class Oven implements Appliance {

    private int powerConsumption;
    private int weight;
    private int capacity;
    private int depth;
    private double height;
    private double width;
    private String[] properties;

    public Oven(String[] props) {
        this.powerConsumption = Integer.parseInt(props[2]);
        this.weight = Integer.parseInt(props[4]);
        this.capacity = Integer.parseInt(props[6]);
        this.depth = Integer.parseInt(props[8]);
        this.height = Double.parseDouble(props[10]);
        this.width = Double.parseDouble(props[12]);
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

    public int getCapacity() {
        return capacity;
    }

    public int getDepth() {
        return depth;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
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

        Oven oven = (Oven) o;

        return powerConsumption == oven.powerConsumption &&
                weight == oven.weight &&
                capacity == oven.capacity &&
                depth == oven.depth &&
                Double.compare(oven.height, height) == 0 &&
                Double.compare(oven.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, capacity, depth, height, width);
    }

    @Override
    public String toString() {
        return "Oven{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", capacity=" + capacity +
                ", depth=" + depth +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
