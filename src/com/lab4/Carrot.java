package com.lab4;

public class Carrot implements Priceable {
    private double price;
    private boolean fresh;
    private double mass;

    public Carrot(double price, boolean fresh, double mass) {
        this.price = price;
        this.fresh = fresh;
        this.mass = mass;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Carrot{price = " + price + ", fresh = " + fresh
                + ", mass = " + mass + "}";
    }
}
