package classes.task10;

import java.util.Date;

/*
 * Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */

public class Solution {
    Airline[] airlines;

    public Solution(Airline[] airlines) {
        this.airlines = airlines;
    }

    public void toScreenFlightListGivenDestination(String destination) {
        for (Airline airline : airlines) {
            if (airline.getDestination().equals(destination)) {
                System.out.println(airline.toString());
            }
        }
    }

    public void toScreenListFlightDayWeek(String dayWeek) {
        for (Airline airline : airlines) {
            if (airline.getDayWeek().equals(dayWeek)) {
                System.out.println(airline.toString());
            }
        }
    }

    public void toScreenListFlightDayWeekAfterTimeDeparture(String week_day, Date time) {
        for (Airline airline : airlines) {
            if (airline.getDayWeek().equals(week_day) && airline.getTimeDeparture().after(time)) {
                System.out.println(airline.toString());
            }
        }
    }
}
