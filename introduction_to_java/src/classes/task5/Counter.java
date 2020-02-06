package classes.task5;

import java.util.Random;

/*
 * Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
 * на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
 * произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
 * позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
 */

public class Counter {
    private int minValue = 0;
    private int maxValue = 10;
    private int count;

    public Counter() {
        Random random = new Random();
        count = random.nextInt(maxValue);
    }

    public Counter(int maxValue, int minValue, int count) {
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void increase() {
        if (count == maxValue) {
            System.out.println("Максимальное значение в счётчике");
        }
        else {
            count++;
        }
    }

    public void decrease() {
        if (count == minValue) {
            System.out.println("Минимальное значение в счётчике");}
        else {
            count--;
        }
    }
}

