package com.lab3;

public abstract class Dog {
    protected double weight;
    protected String name;
    protected int age;
    protected final String color;
    protected final char gender;

    Dog() {
        this.weight = 0;
        this.name = "Charlie";
        this.color = "white";
        this.gender = 'M';
        this.age = 0;
    }

    Dog(double weight, String name, String color, char gender, int age) {
        this.weight = weight;
        this.name = name;
        this.color = color;
        this.gender = gender;
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract String getBarkSound();

    public abstract String getHowlSound();

    public abstract String toString();
}
