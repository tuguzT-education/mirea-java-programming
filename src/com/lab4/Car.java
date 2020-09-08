package com.lab4;

public class Car implements Priceable {
    private double speed;
    private String name;
    private double price;

    public Car(double speed, String name, double price) {
        this.speed = speed;
        this.name = name;
        this.price = price;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{speed = " + speed + ", name = '" + name
                + "', price = " + price + "}";
    }
}
