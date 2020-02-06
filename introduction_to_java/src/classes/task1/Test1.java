package classes.task1;

/*
 * Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
 * переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
 * наибольшее значение из этих двух переменных.
 */

public class Test1 {
    private double a;
    private double b;

    public void toScreen() {
        System.out.println("a = " + a + ", b = " + b);
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    private double returnSum() {
        return a + b;
    }

    private double returnMax() {
        return Math.max(a, b);
    }
}
