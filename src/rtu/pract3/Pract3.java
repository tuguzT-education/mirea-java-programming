package rtu.pract3;

public class Pract3 {
    public static void main(String[] args) {
        Shape shape = new Circle(4.56);
        System.out.println("Circle area is " + shape.getArea());
        System.out.println("Circle perimeter is " + shape.getPerimeter());

        Circle circle = (Circle) shape;
        circle.setRadius(10);
        System.out.println("Circle radius is " + circle.getRadius());

        shape = new Square(10);
        shape.setFilled(false);
        shape.setColor("black");
        System.out.println(shape);
    }
}
