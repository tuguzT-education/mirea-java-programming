package rtu.pract1;

public class Ball {
    private int weight;
    private String material;
    private String color;
    private int x, y;

    public Ball() {
        this.weight = 0;
        this.material = "rubber";
        this.color = "white";
    }

    public Ball(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    public Ball(int weight) {
        this.weight = weight;
        this.material = "rubber";
        this.color = "white";
    }

    public Ball(int weight, String material) {
        this.weight = weight;
        this.material = material;
        this.color = "white";
    }

    public Ball(int weight, String material, String color) {
        this.weight = weight;
        this.material = material;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String material) {
        this.color = material;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "Ball{" +
                "weight = " + weight +
                ", material = '" + material + '\'' +
                ", color = '" + color + '\'' +
                ", position = {" + x + ", " + y + "}}";
    }
}
