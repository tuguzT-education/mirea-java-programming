package rtu.pract15_16.items;

public class Drink extends Item implements Alcohol {
    private static final double MIN_VOLUME = 0.03;

    protected final double cost, alcoholByVolume;
    protected final String name, description;
    private final DrinkType type;

    public Drink (double cost, String name, String description, double alcoholByVolume, DrinkType type) {
        if (cost < 0)
            throw new IllegalArgumentException("Cost must bot be less than zero");
        if (alcoholByVolume < 0)
            throw new IllegalArgumentException("Alcohol volume must not be less than zero");
        if (description.isBlank())
            throw new IllegalArgumentException("Description must not be blank");
        this.cost = cost;
        this.description = description;
        this.name = name;
        this.alcoholByVolume = alcoholByVolume;
        this.type = type;
    }

    public Drink (String name, String description, double alcoholByVolume, DrinkType type) {
        if (alcoholByVolume < 0)
            throw new IllegalArgumentException("Alcohol volume must not be less than zero");
        if (description.isBlank())
            throw new IllegalArgumentException("Description must not be blank");
        cost = 0;
        this.description = description;
        this.name = name;
        this.alcoholByVolume = alcoholByVolume;
        this.type = type;
    }

    public double getCost () {
        return cost;
    }

    public boolean isAlcoholicDrink () {
        return alcoholByVolume >= MIN_VOLUME;
    }

    public double getAlcoholByVolume () {
        return alcoholByVolume;
    }

    public String getName () {
        return name;
    }

    public String getDescription () {
        return description;
    }

    public DrinkType getType () {
        return type;
    }

    public enum DrinkType {
        BEER,
        WINE,
        VODKA,
        BRANDY,
        CHAMPAGNE,
        WHISKEY,
        TEQUILA,
        RUM,
        VERMOUTH,
        LIQUOR,
        JAGERMEISTER,
        JUICE,
        COFFEE,
        GREEN_TEA,
        BLACK_TEA,
        MILK,
        WATER,
        SODA
    }

    public String toString() {
        return "\n\t\tDrink:\n\tCost is " + cost + ", name is '" + name +
                "', description is '" + description + "', alcohol volume is " +
                alcoholByVolume + ", type is " + type;
    }
}