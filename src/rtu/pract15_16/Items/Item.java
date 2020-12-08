package rtu.pract15_16.items;

public abstract class Item implements Comparable<Item> {
    public abstract double getCost();
    public abstract String getName ();
    public abstract String getDescription ();

    public int compareTo (Item item) {
        double result = Double.compare(item.getCost(), getCost());
        return (result != 0)
                ? (int)result
                : getDescription().compareTo(item.getDescription());
    }
}