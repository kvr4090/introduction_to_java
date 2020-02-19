package tasks.harbour;

import java.util.concurrent.Semaphore;

/*
 * Задание 4. Многопоточность. Порт . Корабли заходят в порт для
 * разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент
 * в порту и на корабле, должно быть неотрицательным и не превышающим заданную
 * грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
 * У одного причала может стоять один корабль. Корабль может загружаться у причала
 * или разгружаться.
 */

public class Port {
    Storage storage = new Storage();
    Semaphore semaphore = new Semaphore(3);

    public void work() throws InterruptedException {
        while (true) {
            Thread.sleep(300);
            new Dock("Причал 1", semaphore, storage).start();
            Thread.sleep(300);
            new Dock("Причал 2", semaphore, storage).start();
            Thread.sleep(300);
            new Dock("Причал 3", semaphore, storage).start();
        }
    }
}
