package by.tc.task01.entity;

import java.util.Map;
import java.util.Objects;

public class Laptop implements Appliance {

    private double batteryCapacity;
    private String oc;
    private int memoryRom;
    private int systemMemory;
    private double cpu;
    private int displayInches;
    private String[] properties;

    public Laptop(String[] props) {
        this.batteryCapacity = Double.parseDouble(props[2]);
        this.oc = props[4];
        this.memoryRom = Integer.parseInt(props[6]);
        this.systemMemory = Integer.parseInt(props[8]);
        this.cpu = Double.parseDouble(props[10]);
        this.displayInches = Integer.parseInt(props[12]);
        properties = props;
    }

    public String[] getProperties() {
        return properties;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getOc() {
        return oc;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public int getDisplayInches() {
        return displayInches;
    }



    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, oc, memoryRom, systemMemory, cpu, displayInches);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Laptop laptop = (Laptop) obj;

        return Double.compare(laptop.batteryCapacity, batteryCapacity) == 0 &&
                memoryRom == laptop.memoryRom &&
                systemMemory == laptop.systemMemory &&
                Double.compare(laptop.cpu, cpu) == 0 &&
                displayInches == laptop.displayInches &&
                Objects.equals(oc, laptop.oc);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", OC='" + oc + '\'' +
                ", memoryROM=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", cpu=" + cpu +
                ", displayInches=" + displayInches +
                '}';
    }
}
