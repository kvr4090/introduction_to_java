package classes.task4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/*
 * Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
 * номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
 * назначения должны быть упорядочены по времени отправления.
 */

public class Train {
    private String destination;
    private int numberTrain;
    private Date time;

    public Train(String destination, int numberTrain, Date time) {
        this.destination = destination;
        this.numberTrain = numberTrain;
        this.time = time;
    }

    public Train[] sortTrainsNumbers(Train[] trains) {
        Comparator<Train> comparatorNumberTrain = Comparator.comparingInt(o -> o.numberTrain);
        Arrays.sort(trains, comparatorNumberTrain);
        return trains;
    }

    public void trainToScreen(Train[] trains) {
        for (Train train : trains) {
            System.out.println(train.time + "\t" + train.numberTrain + "\t" + train.destination);
        }
    }

    public void userSearchNumberTrain(Train[] trains, int numberTrain) {
        int temp = 0;

        for (Train train : trains) {
            if (train.numberTrain == numberTrain) {
                System.out.println(train.time + "\t" + train.numberTrain + "\t" + train.destination);
            } else {
                temp++;
            }
        }

        if (temp == trains.length) {
            System.out.println("Заданного поезда не существует.");
        }
    }

    public Train[] sortDestination(Train[] trains) {
        Comparator<Train> comparatorTime = Comparator.comparing(o -> o.time);
        Comparator<Train> comparatorDestination = Comparator.comparing(o -> o.destination);
        Arrays.sort(trains, comparatorTime);
        Arrays.sort(trains, comparatorDestination);
        return trains;
    }

    public static void main(String[] args) {

        Train [] trains = new Train[5];

        trains[0] = new Train("Питер",87, new Date(12141678) );
        trains[1] = new Train("Минск",35, new Date(12041678) );
        trains[2] = new Train("Москва",56, new Date(12191678) );
        trains[3] = new Train("Минск",62, new Date(12133678) );
        trains[4] = new Train("Питер",79, new Date(12741678) );
    }
}
