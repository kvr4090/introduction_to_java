package oop.task5;

public class Candy {
    private String name;
    private double weight;
    private double volume;

    public Candy(String nameCandy, double weight, double volume) {
            this.name = nameCandy;
            this.weight = weight;
            this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }
}
