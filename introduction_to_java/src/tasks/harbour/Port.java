package tasks.harbour;

/*
 * Задание 4. Многопоточность. Порт . Корабли заходят в порт для
 * разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент
 * в порту и на корабле, должно быть неотрицательным и не превышающим заданную
 * грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
 * У одного причала может стоять один корабль. Корабль может загружаться у причала
 * или разгружаться.
 */

public class Port {
    static int capacity = 0;
    static int balance = 0;
    static int maxCapacity = 23;
    static int countLoop;

    public void work(int a) throws InterruptedException {
        countLoop = a;

        Dock dock1 = new Dock("Причал 1" );
        Dock dock2 = new Dock("Причал 2" );
        Dock dock3 = new Dock("Причал 3");

        Thread thread1 = new Thread(dock1);
        Thread thread2 = new Thread(dock2);
        Thread thread3 = new Thread(dock3);

        thread1.start();
        Thread.sleep(30);

        thread2.start();
        Thread.sleep(30);

        thread3.start();
        Thread.sleep(30);
    }
}
