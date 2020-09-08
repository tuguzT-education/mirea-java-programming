package rtu.lab2;

public class Circle {
    private Point center;
    private double radius;

    public Circle(double radius, Point center) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(double radius) {
        this.center = new Point();
        this.radius = radius;
    }

    public Circle() {
        this.center = new Point();
        this.radius = 0;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setCenter(double x, double y) {
        this.center = new Point(x, y);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getLength() {
        return 2 * Math.PI * radius;
    }

    public double getDiameter() {
        return radius * 2;
    }

    public String toString() {
        return "Circle{center = " + center + ", radius = " + radius + '}';
    }
}
