package tasks.harbour;

import java.util.concurrent.Semaphore;

public class Dock extends Thread {
    Storage as;
    String dockName;
    Semaphore sem;
    boolean full = false;

    public Dock(String dockName, Semaphore sem, Storage as) {
        this.dockName = dockName;
        this.sem = sem;
        this.as = as;
    }

    @Override
    public void run() {
        try {
            if (!full) {
                sem.acquire();
                System.out.println("\nНа причал " + dockName + " прибыл корабль. Количество контейнеров на складе " + as.capacity + "/" + as.maxCapacity);

                if ((as.capacity + 3) <= as.maxCapacity) {
                    System.out.println("Началась выгрузка корабля в " + dockName);

                    for (int i = 0; i < 3; i++) {
                        as.capacity++;
                    }
                    full = true;
                    System.out.println("Закончилась выгрузка корабля " + dockName + " Количество контейнеров на складе " + as.capacity + "/" + as.maxCapacity);
                } else {
                    System.out.println("Началась загрузка корабля в " + dockName);

                    for (int i = 0; i < 3; i++) {
                        as.capacity--;
                    }
                    full = true;
                    System.out.println("Закончилась загрузка корабля " + dockName + " Количество контейнеров на складе " + as.capacity + "/" + as.maxCapacity);
                }
                sleep(300);
                sem.release();
            }
        } catch (InterruptedException e) {
            System.out.println ("Что-то пошло не так!");
        }
    }
}
