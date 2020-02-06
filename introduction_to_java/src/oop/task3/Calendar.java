package oop.task3;

import java.util.ArrayList;
import java.util.Date;

/*
 * Создать класс Календарь с внутренним классом, с помощью объектов
 * которого можно хранить информацию о выходных и праздничных днях.
 */

public class Calendar {
    private ArrayList<RestDay> days;

    public ArrayList<RestDay> getDays() {
        return days;
    }

    public void addDay(Date currentDate, String notice, boolean isDayRest) {
        days = new ArrayList<>();

        if (isDayRest) {
            days.add(new RestDay(currentDate, notice));
        }
    }

    private class RestDay {
        Date date;
        String info;

        public RestDay(Date date, String info) {
            this.date = date;
            this.info = info;
        }
    }
}
