package rtu.lab4;

public class Lab4 {
    public static void main(String[] args) {
        Priceable priceable = new Car(100, "Rolls Royce", 5000000);
        System.out.println(priceable.getPrice());

        priceable = new Carrot(10, true, 0.234);
        System.out.println(priceable.getPrice());
    }
}
