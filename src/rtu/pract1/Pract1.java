package rtu.pract1;

public class Pract1 {
    public static void main(String[] args) {
        Ball ball1 = new Ball(1, "rubber", "green");
        Ball ball2 = new Ball(2, 3);
        ball1.setWeight(3);
        ball2.setX(ball1.getY());
        System.out.println(ball2);
        String string = ball1.getColor().toUpperCase();
        System.out.println(string + " " + ball1.getWeight());
    }
}
