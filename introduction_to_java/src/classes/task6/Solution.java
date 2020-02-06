package classes.task6;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
 * изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
 * недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
 * заданное количество часов, минут и секунд.
 */

public class Solution {
    private Calendar calendar = new GregorianCalendar();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public Solution(int hour, int min, int sec) {
        if ((hour > 24) || (hour < 0)) {
            calendar.set(Calendar.HOUR, 12);
        } else {
            calendar.set(Calendar.HOUR, hour + 12);
        }

        if ((min > 59) || (min < 0)) {
            calendar.set(Calendar.MINUTE, 0);
        } else {
            calendar.set(Calendar.MINUTE, min);
        }

        if ((sec > 59) || (sec < 0)) {
            calendar.set(Calendar.SECOND, 0);
        } else {
            calendar.set(Calendar.SECOND, sec);
        }
    }

    public void setHour(int hour) {
        if ((hour > 24) || (hour < 0)) {
            calendar.set(Calendar.HOUR, 12);
        } else {
            calendar.set(Calendar.HOUR, hour + 12);
        }
    }

    public void setMinute(int min) {
        if ((min > 59) || (min < 0)) {
            calendar.set(Calendar.MINUTE, 0);
        } else {
            calendar.set(Calendar.MINUTE, min);
        }
    }

    public void setSecond(int sec) {
        if ((sec > 59) || (sec < 0)) {
            calendar.set(Calendar.SECOND, 0);
        } else {
            calendar.set(Calendar.SECOND, sec);
        }
    }

    public void changeTimeIncrease(int hour, int min, int sec) {
        calendar.roll(Calendar.HOUR, hour);
        calendar.roll(Calendar.MINUTE, min);
        calendar.roll(Calendar.SECOND, sec);
    }

    public void changeTimeDecrease(int hour, int min, int sec) {
        calendar.roll(Calendar.HOUR, -hour);
        calendar.roll(Calendar.MINUTE, -min);
        calendar.roll(Calendar.SECOND, -sec);
    }

    public void toScreen() {
        System.out.println(dateFormat.format(calendar.getTime()));
    }
}
