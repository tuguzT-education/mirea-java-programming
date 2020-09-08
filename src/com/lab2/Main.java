package com.lab2;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5, new Point(1, 6));
        circle.setCenter(0, 0);
        circle.setRadius(10);
        System.out.println(circle);
        System.out.println("Длина окружности: " + circle.getLength()
                + "\nДиаметр окружности: " + circle.getDiameter());
    }
}
