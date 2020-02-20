package tasks.harbour;

public class Dock implements Runnable {
    private String dockName;

    public Dock(String dockName) {
        this.dockName = dockName;
    }

    @Override
    public void run() {

        for (int i = 0; i < Port.countLoop; i++) {
            work();
        }
    }

    private void work () {
        System.out.println("\nНа причал " + dockName + " прибыл корабль. Количество контейнеров на складе " +
                Port.capacity + "/" + Port.maxCapacity);
        
        try {
            if ((Port.balance + 3) <= Port.maxCapacity) {
                unloadingShip();
            } else {
                loadingShip();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void unloadingShip() throws InterruptedException {
        System.out.println("Началась выгрузка корабля в " + dockName);
        Port.balance += 3;

        for (int i = 0; i < 3; i++) {
            Port.capacity++;
            System.out.println("Склад: " + Port.capacity + "/" + Port.maxCapacity);
            Thread.sleep(500);
        }
        System.out.println("Закончилась выгрузка корабля " + dockName + " Количество контейнеров на складе " +
                Port.capacity + "/" + Port.maxCapacity + "\nКорабль уплывает.");
        Thread.sleep(300);
    }

    private void loadingShip() throws InterruptedException {
        System.out.println("Началась загрузка корабля в " + dockName);
        Port.balance -= 3;

        for (int i = 0; i < 3; i++) {
            Port.capacity--;
            System.out.println("Склад: " + Port.capacity + "/" + Port.maxCapacity);
            Thread.sleep(500);
        }
        System.out.println("Закончилась загрузка корабля " + dockName + " Количество контейнеров на складе " +
                Port.capacity + "/" + Port.maxCapacity + "\nКорабль уплывает.");
        Thread.sleep(300);
    }
}
