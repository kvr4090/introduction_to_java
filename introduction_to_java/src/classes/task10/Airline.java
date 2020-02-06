package classes.task10;

import java.util.Date;

/*
 * Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Destination, flight number, aircraft type, departure time, days of the week
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */

public class Airline {
    private String destination;
    private int numberFlight;
    private String typeAircraft;
    private Date timeDeparture;
    private String dayWeek;

    public Airline(String destination, int numberFlight, String typeAircraft, Date timeDeparture, String dayWeek) {
        this.destination = destination;
        this.numberFlight = numberFlight;
        this.typeAircraft = typeAircraft;
        this.timeDeparture = timeDeparture;
        this.dayWeek = dayWeek;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberFlight() {
        return numberFlight;
    }

    public void setNumberFlight(int numberFlight) {
        this.numberFlight = numberFlight;
    }

    public String getTypeAircraft() {
        return typeAircraft;
    }

    public void setTypeAircraft(String typeAircraft) {
        this.typeAircraft = typeAircraft;
    }

    public Date getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(Date timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String dayWeek) {
        this.dayWeek = dayWeek;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", numberFlight=" + numberFlight +
                ", typeAircraft='" + typeAircraft + '\'' +
                ", timeDeparture=" + timeDeparture +
                ", dayWeek='" + dayWeek + '\'' +
                '}';
    }
}
