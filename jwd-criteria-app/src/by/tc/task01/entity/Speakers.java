package by.tc.task01.entity;

import java.util.Map;
import java.util.Objects;

public class Speakers implements Appliance {

    private int powerConsumption;
    private int numOfSpeakers;
    private String frequencyRange;
    private int cordLength;
    private String[] properties;

    public Speakers(String[] props) {
        this.powerConsumption = Integer.parseInt(props[2]);
        this.numOfSpeakers = Integer.parseInt(props[4]);
        this.frequencyRange = props[6];
        this.cordLength = Integer.parseInt(props[8]);
        properties = props;
    }

    public String[] getProperties() {
        return properties;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getNumOfSpeakers() {
        return numOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Speakers speakers = (Speakers) o;

        return powerConsumption == speakers.powerConsumption &&
                numOfSpeakers == speakers.numOfSpeakers &&
                cordLength == speakers.cordLength &&
                Objects.equals(frequencyRange, speakers.frequencyRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, numOfSpeakers, frequencyRange, cordLength);
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numOfSpeakers=" + numOfSpeakers +
                ", frequencyRange='" + frequencyRange + '\'' +
                ", cordLength=" + cordLength +
                '}';
    }
}
