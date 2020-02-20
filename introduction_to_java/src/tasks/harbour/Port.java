package tasks.harbour;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * Задание 4. Многопоточность. Порт . Корабли заходят в порт для
 * разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент
 * в порту и на корабле, должно быть неотрицательным и не превышающим заданную
 * грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
 * У одного причала может стоять один корабль. Корабль может загружаться у причала
 * или разгружаться.
 */

public class Port {
    static AtomicInteger capacity = new AtomicInteger(0);
    static AtomicInteger balance = new AtomicInteger(0);
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
        thread2.start();
        thread3.start();
    }
}
