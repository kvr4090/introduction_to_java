package classes.task12;

/*
 * Создать объект класса Автомобиль, используя классы Колесо,
 * Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 */

public class Car {
    private String make;
    private Engine engine;
    private double gasCount;
    private Wheel wheel;

    public Car(String make, Engine engine, Wheel wheel) {
        this.engine = engine;
        this.wheel = wheel;
        this.make = make;
    }

    public void move() {
        if (engine != null) {
            engine.work();
            wheel.spin();
        }
    }

    public void getGas(double gas) {
        gasCount += gas;
    }

    public void changeWheel(Wheel newWheel) {
        wheel = newWheel;
    }

    private void toScreen() {
        System.out.println(make);
    }

    public static void main(String[] args) {
        Car julia = new Car("Alfa Romeo",new Engine(600),new Wheel(4));
        julia.toScreen();
    }
}