package ru.netology;

import java.util.ArrayList;
import java.util.List;

class Shop {
    final public int TOTALCARS;
    final public int BUYCOUNTS;

    final public int BUYTIMEOUT = 2000;

    ToyotaFactory toyotaFactory = new ToyotaFactory(this);
    List<Car> cars;

    Shop(int totalcars, int buycounts) {
        TOTALCARS = totalcars;
        BUYCOUNTS = buycounts;
        cars = new ArrayList<>(TOTALCARS);
    }

    public void sellCar() {
        for (int i = 0; i < BUYCOUNTS; i++) {
            toyotaFactory.sellCar();
            try {
                Thread.sleep(BUYTIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void acceptCar() {
        for (int i = 0; i < TOTALCARS; i++) {
            toyotaFactory.produceCar();
        }
    }

    List<Car> getCars() {
        return cars;
    }
}