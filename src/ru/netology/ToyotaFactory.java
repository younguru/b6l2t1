package ru.netology;

class ToyotaFactory {
    private Shop shop;
    final private int CARPRODUCETIME = 3000;
    final private int BUYWAITTIME = 1000;

    public ToyotaFactory(Shop shop) {
        this.shop = shop;
    }

    public synchronized void produceCar() {
        try {
            wait(CARPRODUCETIME);
            shop.getCars().add(new Car());
            System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (shop.getCars().size() == 0) {
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(BUYWAITTIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        shop.getCars().remove(0);
    }
}