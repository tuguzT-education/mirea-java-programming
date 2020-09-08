package rtu.lab3;

public class Lab3 {
    public static void main(String[] args) {
        Dog dog = new Dingo(10, "Elisabeth", "orange", 'F', 5);
        System.out.println(dog + " barks: " + dog.getBarkSound());

        dog = new Chihuahua();
        dog.setAge(3);
        dog.setWeight(2);
        System.out.println(dog + " howls: " + dog.getHowlSound());
    }
}
