package com.lab3;

public class Chihuahua extends Dog {
    Chihuahua() {
        super();
    }

    Chihuahua(double weight, String name, String color, char gender, int age) {
        super(weight, name, color, gender, age);
    }

    @Override
    public String getBarkSound() {
        return "Roth, roth!";
    }

    @Override
    public String getHowlSound() {
        return "Yaw, yaw!";
    }

    @Override
    public String toString() {
        return "Chihuahua{weight = " + weight + ", name = '" + name + "', age = " + age +
                ", color = '" + color + "', gender = " + gender + "}";
    }
}
