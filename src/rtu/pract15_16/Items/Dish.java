package rtu.pract15_16.items;

public class Dish extends Item {
    private final boolean isHot, isVegetarian;
    protected final String name, description;
    protected final double cost;
    private final DishType type;

    public Dish (double cost, String name, String description, boolean isHot, boolean isVegetarian, DishType type) {
        if (cost < 0)
            throw new IllegalArgumentException("Cost must not be less than zero");
        if (description.isBlank())
            throw new IllegalArgumentException("Description must not be blank");
        this.cost = cost;
        this.description = description;
        this.name = name;
        this.isHot = isHot;
        this.isVegetarian = isVegetarian;
        this.type = type;
    }

    public Dish (String name, String description, boolean isHot, boolean isVegetarian, DishType type) {
        if (description.isBlank())
            throw new IllegalArgumentException("Description must not be blank");
        cost = 0;
        this.description = description;
        this.name = name;
        this.isHot = isHot;
        this.isVegetarian = isVegetarian;
        this.type = type;
    }

    public boolean isHot () {
        return isHot;
    }

    public boolean isVegetarian () {
        return isVegetarian;
    }

    public String getName () {
        return name;
    }

    public String getDescription () {
        return description;
    }

    public double getCost () {
        return cost;
    }

    public DishType getType () {
        return type;
    }

    public enum DishType {
        SALAD,
        SOUP,
        PORRIDGE,
        DESSERT,
        GARNISH,
        MEAT,
        FISH,
        VEGETABLE,
        FRUIT,
        MASH,
        SUSHI,
        PASTA
    }

    public String toString() {
        return "\n\t\tDish:\n\tCost is " + cost + ", name is '" + name +
                "', description is '" + description + "', " +
                (isVegetarian ? "" : "not ") + "vegetarian, " +
                (isHot ? "" : "not ") + "hot" + ", type is " + type;
    }
}