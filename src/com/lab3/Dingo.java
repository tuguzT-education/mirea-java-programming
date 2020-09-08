package com.lab3;

public class Dingo extends Dog {
    Dingo() {
        super();
    }

    Dingo(double weight, String name, String color, char gender, int age) {
        super(weight, name, color, gender, age);
    }

    @Override
    public String getBarkSound() {
        return "Rauph!";
    }

    @Override
    public String getHowlSound() {
        return "Howl...";
    }

    @Override
    public String toString() {
        return "Dingo{weight = " + weight + ", name = '" + name + "', age = " + age +
                ", color = '" + color + "', gender = " + gender + "}";
    }
}
