package by.tc.task01.entity;

import java.util.Map;
import java.util.Objects;

public class TabletPC implements Appliance {

    private int batteryCapacity;
    private int displayInches;
    private int memoryROM;
    private int flashMemoryCapacity;
    private String color;
    private String[] properties;

    public TabletPC(String[] props) {
        this.batteryCapacity = Integer.parseInt(props[2]);
        this.displayInches = Integer.parseInt(props[4]);
        this.memoryROM = Integer.parseInt(props[6]);
        this.flashMemoryCapacity = Integer.parseInt(props[8]);
        this.color = props[10];
        properties = props;
    }

    public String[] getProperties() {
        return properties;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public int getMemoryROM() {
        return memoryROM;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabletPC tabletPC = (TabletPC) o;
        return batteryCapacity == tabletPC.batteryCapacity &&
                displayInches == tabletPC.displayInches &&
                memoryROM == tabletPC.memoryROM &&
                flashMemoryCapacity == tabletPC.flashMemoryCapacity &&
                Objects.equals(color, tabletPC.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, displayInches, memoryROM, flashMemoryCapacity, color);
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryROM=" + memoryROM +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }
}
