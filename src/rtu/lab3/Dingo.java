package rtu.lab3;

public class Dingo extends Dog {
    Dingo() {
        super();
    }

    Dingo(double weight, String name, String color, char gender, int age) {
        super(weight, name, color, gender, age);
    }

    public String getBarkSound() {
        return "Rauph!";
    }

    public String getHowlSound() {
        return "Howl...";
    }

    public String toString() {
        return "Dingo{weight = " + weight + ", name = '" + name + "', age = " + age +
                ", color = '" + color + "', gender = " + gender + "}";
    }
}
