package oop.task5;

public class Packing {
    private String color;
    private String type;
    private double maxWeight;
    private double maxVolume;
    private String material;

    public Packing(String color, String type, String material, double maxWeight, double maxVolume) {
            this.color = color;
            this.type = type;
            this.material = material;
            this.maxWeight = maxWeight;
            this.maxVolume = maxVolume;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public String getMaterial() {
        return material;
    }
}