package classes.task2;

/*
 * Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
 * конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра класса.
 */

public class Test2 {
    private double a;
    private double b;

    public Test2(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Test2() {
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
