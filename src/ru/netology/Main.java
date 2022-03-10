package ru.netology;

public class Main {

    public static void main(String[] args) {
        final Shop shop = new Shop(10, 3);
        new Thread(null, shop::sellCar, "Покупатель 1").start();
        new Thread(null, shop::sellCar, "Покупатель 2").start();
        new Thread(null, shop::sellCar, "Покупатель 3").start();
        new Thread(null, shop::acceptCar, "Toyota").start();
    }
}
